package com.urjc.master.semv;

import java.util.HashMap;
import java.util.Map.Entry;

public class Ambito implements APITS {

	private HashMap<String, Commands> ambito;
	private Ambito father;

	public Ambito() {
		this.ambito = new HashMap<String, Commands>();
		this.father = null;
	}

	public Ambito(Ambito father) {
		this.ambito = new HashMap<String, Commands>();
		this.father = father;
	}

	public boolean insertaIdFunction(String idLexema) {
		return this.addEntryAmbito(idLexema, new Function(idLexema, this));
	}
	
	public boolean insertaId(String idLexema, EnumType tipo ,EnumCommands cmd) {
		switch (cmd) {
		
			case PARAMETERS:				
				
				// buscar el id en la funcion y agregarle el parametro
				Function function = (Function) this.buscaId(idLexema);
				return function.insertarSingleParametro(idLexema, tipo); 
				
			case VARIABLE:
				return this.addEntryAmbito(idLexema, new Variable(idLexema, tipo));
		
			default:
				// error
				return false;
		}
	}
	
	private boolean addEntryAmbito(String id, Commands commands) {
		boolean success = !this.ambito.containsKey(id);
		
		if (success) {
			this.ambito.put(id, commands);						
		}
		return success;
	}

	public Commands buscaId(String id) {
		if (this.ambito.containsKey((id))) {
			return this.ambito.get(id);			
		} else {
			if (this.father != null) {
				return this.father.buscaId(id);				
			}
			return null;
		}
	}

	public boolean insertaTipo(String id, EnumType tipo) {
		Commands cmd = this.ambito.get(id);
		cmd.tipo = tipo;
		return true;
	}
	
	// ExpTipo -> TBAS || TBAS x TBAS x TBAS || TBAS x TBAS -> TBAS
	public Ambito getFather(){
		return this.father;
	}
	
	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();
		
		
		format.append("Father...\n");
		if (this.father != null) {
			format.append(this.father.toString());			
		}
		
		format.append("Ambito....\n");
		for (Entry<String, Commands> pair : this.ambito.entrySet()) {
			Commands cmd = pair.getValue();
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
		return this.ambito.get(id).dameTipo();
	}
}
