package com.urjc.master.semv;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.urjc.master.semv.APITS.EnumType;

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
		return this.addEntry(var.getId(), var);		
	}
		
	private boolean addEntry(String id, Command command) {
		boolean success = !this.existId(id);		
		if (success) {
			this.ambito.put(id, command);			
		} else {
			this.printErrorAlreadyExists(command);
			this.putError(command);
		}
		return success;
	}
	
	private void putError(Command command) {
		command.setId(ERROR_PREFIX + command.getId());
		this.ambito.put(command.getId(), command);		
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
		this.ambito.remove(err.getId());
	}
	
	private void printErrorAlreadyExists(Command command) {
		System.err.println("The " + command.getClass().getSimpleName() + " " + command.getId() + " already exist\n");
	}

	public Command buscaId(String id) {
		if (this.ambito.containsKey((id))) {
			return this.ambito.get(id);			
		} 
		if (this.hasFather()) {
			return this.father.buscaId(id);				
		}		
		return null;
	}
	
	public boolean hasFather(){
		return this.father != null;
	}
	
	public boolean existId(String id) {
		boolean exist = this.ambito.containsKey(id);
		if(!exist && this.hasFather()) {
			return this.father.existId(id);			
		}
		return exist;
	}
	
	// ExpTipo -> TBAS || TBAS x TBAS x TBAS || TBAS x TBAS -> TBAS
	public Ambito getFather(){
		return this.father;
	}

	public boolean insertaTipo(String id, EnumType tipo) {
		boolean exit = this.ambito.containsKey(id);
		if(exit){
			this.ambito.get(id).setTipo(tipo);
		}
		return exit;
	}
	
	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();
				
		format.append("Ambito...\n");
		for (Entry<String, Command> entry : this.ambito.entrySet()) {
			Command cmd = entry.getValue();
		
			switch(cmd.getClass().getSimpleName()){
				case "Function": format.append("Defined funcion... " + cmd.toString() + "\n"); break;
				case "Variable": format.append("Defined variable : " + cmd.toString() + "\n"); break;
			}
			/*
			if (cmd instanceof Function) {
				Function fun = (Function) cmd;
				format.append("Defined funcion... " + fun.toString() + "\n");
			}
			
			if (cmd instanceof Variable) {
				Variable var = (Variable) cmd;
				format.append("Defined variable : " + var.toString() + "\n");
			}*/
		}
		
		if (this.father != null) {
			format.append("\nWe have Father ");
			format.append(this.father.toString());			
		} else {
			format.append("................... END AMBITO .......................\n");			
		}
		return format.toString();
	}
	
	public TupleTypes buscaIdsType(Lid lid) {
		TupleTypes types = new TupleTypes();
		
		for (String id : lid.getList()) {
			types.insert(id, dameTipo(id));
		}
		return types;
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
		if (this.hasFather()) {
			return this.father.dameTipo(id);
		}
		return EnumType.ERROR;
	}

}
