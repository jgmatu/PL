package com.urjc.master.semv.commands;

import com.urjc.master.semv.types.Type;

public abstract class Command {

	private String id;
	private Type tipo;

	public Command(String id, Type tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Type tipo() {
		return this.tipo;
	}

	public void insertarTipo(Type tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return this.id;
	}

	public Type getTipo() {
		return this.tipo;
	}
	
	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();

		format.append("\n\tId : " + this.id + ", type : " + this.tipo + "\n");
		return format.toString();
	}
}