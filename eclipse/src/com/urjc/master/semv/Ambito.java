package com.urjc.master.semv;

import java.util.HashMap;
import java.util.Map.Entry;

public class Ambito implements APITS {

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
		return this.addEntryAmbito(idLexema, new Function(idLexema, this));
	}
	
	public boolean insertaIdVariable(Variable var) {
		return this.addEntryAmbito(var.id, var);		
	}
		
	private boolean addEntryAmbito(String id, Command commands) {
		boolean success = !this.ambito.containsKey(id);
		
		if (success) {
			this.ambito.put(id, commands);						
		} else {
			System.err.println("The id is defined and not is possible insert in this ambito...");
		}
		return success;
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
		
		
		if (this.father != null) {
			format.append("\nWe have Father ");
			format.append(this.father.toString());			
		}
		
		format.append("Ambito...\n");
		for (Entry<String, Command> pair : this.ambito.entrySet()) {
			Command cmd = pair.getValue();
		
			if (cmd instanceof Function) {
				Function fun = (Function) cmd;
				format.append(String.format("Defined funcion... %s\n", fun.toString()));
			}
			
			if (cmd instanceof Variable) {
				Variable var = (Variable) cmd;
				format.append(String.format("Defined variable : %s\n", var.toString()));
			}
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
