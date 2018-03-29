package com.urjc.master.semv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.urjc.master.semv.APITS.EnumType;
import com.urjc.master.semv.Commands;

public class Function extends Commands {

	private List<Variable> parametros;
	private Ambito ambito;

	public Function(String id, Ambito father) {
		super(id, EnumType.ERROR);
		this.ambito = new Ambito(father);
		this.parametros = new ArrayList<>();
	}

	public boolean insertarSingleParametro(String id, EnumType tipo) {
		Variable v = new Variable(id, tipo);
		boolean success = !parametros.contains(v);

		if (success) {
			this.parametros.add(v);
			this.ambito.insertaId(id, tipo, APITS.EnumCommands.VARIABLE);
		}
		return success;
	}

	public boolean insertarParametros(ListParams list) {
		boolean success = true;

		for (Entry<String, EnumType> entry : list.getParametros().entrySet()) {
			success = insertarSingleParametro(entry.getKey(), entry.getValue()) && success;
		}
		return success;
	}

	public Ambito getAmbito() {
		return this.ambito;
	}
	
	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();

		format.append(String.format("Function : %s return %s\n", this.id, this.getStringType(this.tipo)));
		format.append("Parameters... \n");
		for (Variable var : this.parametros) {
			format.append(String.format("\n\tParameter : %s\n", var.toString()));
		}
		return format.toString();
	}
}
