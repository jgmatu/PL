package com.urjc.master.semv;

import java.util.ArrayList;
import java.util.List;

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

	public boolean insertarParametro(String id, EnumType tipo) {
		Variable v = new Variable(id, tipo);
		boolean success = !parametros.contains(v);
		
		if (success) {
			this.parametros.add(v);			
		}
		return success;
	}

}
