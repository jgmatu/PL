package com.urjc.master.semv;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ambito implements APITS {

	public static String ERROR_PREFIX = "0func_err";
	
	private Ambito father;
	private HashMap<String, Command> ambito;

	public Ambito() {
		this.ambito = new HashMap<String, Command>();
		this.father = null;
	}

	public Ambito(Ambito father) {
		this.ambito = new HashMap<String, Command>();
		this.father = father;
	}

	public boolean insertaIdFunction(String idLexema) {
		return this.addEntry(idLexema, new Function(idLexema, this));
	}
	
	public boolean insertaIdVariable(Variable var) {
		return this.addEntry(var.id, var);		
	}
		
	private boolean addEntry(String id, Command command) {
		boolean success = !this.existId(id);
		
		if (success) {
			this.ambito.put(id, command);						
		} else {
			printError(command);
			putError(command);
		}
		return success;
	}
	
	private void putError(Command command) {
		command.id = ERROR_PREFIX + command.id;
		this.ambito.put(command.id, command);		
	}
	
	public Command buscaError() {
		for (Map.Entry<String, Command> entry : this.ambito.entrySet()) {
			if (entry.getKey().contains(ERROR_PREFIX)) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	public void deleteError(Command err) {
		this.ambito.remove(err.id);
	}
	
	private void printError(Command command) {
		if (command instanceof Function) {
			System.err.println(String.format("The function %s already exist\n", command.id));
		}
		if (command instanceof Variable) {
			System.err.println(String.format("The variable %s already exist\n", command.id));
		}
	}

	public Command buscaId(String id) {
		if (this.ambito.containsKey((id))) {
			return this.ambito.get(id);			
		} else {
			if (this.father != null) {
				return this.father.buscaId(id);				
			}
			return null;
		}
	}
	
	public boolean existId(String id) {
		if (this.father != null) {
			return this.father.existId(id) || this.ambito.containsKey(id);
		}
		return this.ambito.containsKey(id);
	}
	
	// ExpTipo -> TBAS || TBAS x TBAS x TBAS || TBAS x TBAS -> TBAS
	public Ambito getFather(){
		return this.father;
	}

	public boolean insertaTipo(String id, EnumType tipo) {
		Command cmd = this.ambito.get(id);
		
		if (cmd != null) {
			cmd.tipo = tipo;			
		}
		return cmd != null;
	}
	
	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();
				
		format.append("Ambito...\n");
		for (Entry<String, Command> entry : this.ambito.entrySet()) {
			Command cmd = entry.getValue();
		
			if (cmd instanceof Function) {
				Function fun = (Function) cmd;
				format.append(String.format("Defined funcion... %s\n", fun.toString()));
			}
			
			if (cmd instanceof Variable) {
				Variable var = (Variable) cmd;
				format.append(String.format("Defined variable : %s\n", var.toString()));
			}
		}
		
		if (this.father != null) {
			format.append("\nWe have Father ");
			format.append(this.father.toString());			
		} else {
			format.append("................... END AMBITO .......................\n");			
		}
		return format.toString();
	}

	@Override
	public boolean tiposComp(EnumType tipo1, EnumType tipo2) {
		return tipo1 == tipo2;
	}

	@Override
	public EnumType dameTipo(String id) {
		if (this.ambito.containsKey(id)) {
			return this.ambito.get(id).dameTipo();
		}
		if (this.father != null) {
			return this.father.dameTipo(id);
		}
		return EnumType.ERROR;
	}

}
