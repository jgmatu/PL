package com.urjc.master.semv;

import java.util.HashMap;

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

	public boolean insertaId(String idLexema, EnumType tipo, EnumCommands cmd) {
		switch (cmd) {
			case FUNCTION:
				// aqui el tipo se supone que es el devuelto.
				return this.addEntryAmbito(idLexema, new Function(idLexema, tipo, this));
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

	public boolean insertaTipo(Commands commands, EnumType tipo) {
		commands.setTipo(tipo);
		return true;
	}

	public EnumType dameTipo(Commands commands) {
		return commands.getTipo();
	}

	// LOS QUe SigueN estan MAL
	public boolean tiposComp(EnumType tipo1, EnumType tipo2) {
		return true;
	}
	
	// ExpTipo -> TBAS || TBAS x TBAS x TBAS || TBAS x TBAS -> TBAS

	public Ambito getFather(){
		return this.father;
	}
}
