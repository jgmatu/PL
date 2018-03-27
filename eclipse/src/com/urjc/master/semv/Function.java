package com.urjc.master.semv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.urjc.master.semv.APITS.EnumType;
import com.urjc.master.semv.Commands;

public class Function extends Commands {

	private List<Variable> parametros;
	private Ambito ambito;

	public Function(String id, EnumType tipo, Ambito father) {
		super(id, tipo);
		this.ambito = new Ambito(father);
		this.parametros = new ArrayList<>();
	}

	public boolean insertarSingleParametro(String id, EnumType tipo) {
		Variable v = new Variable(id, tipo);
		boolean success = !parametros.contains(v);
		
		if (success) {
			this.parametros.add(v);			
		}
		return success;
	}
	
	public boolean insertarListParametros(List<String> ids, EnumType tipo) {
		boolean success = true;
		for (String id : ids) {
			success = this.insertarSingleParametro(id, tipo) && success;
		}
		return success;
	}
	
	public boolean insertarParametros(LISTPARAM list) {
		boolean success = true;
		for (Map.Entry<EnumType, List<String>> entry : list.getParametros().entrySet()) {
		    EnumType tipo = entry.getKey();
		    List<String> ids = entry.getValue();
		    success = insertarListParametros(ids, tipo) && success;
		}
		return success;
	}
	
	public Ambito getAmbito(){
		return this.ambito;
	}
}
