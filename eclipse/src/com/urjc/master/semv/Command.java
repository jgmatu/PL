package com.urjc.master.semv;

import com.urjc.master.semv.APITS.EnumType;

public class Command {

	private String id;
	private EnumType tipo;

	public Command(String id, EnumType tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public EnumType dameTipo() {
		return this.tipo;
	}

	public void insertaTipo(EnumType tipo) {
		this.tipo = tipo;
	}

	public boolean compTipos(Command c) {
		return this.tipo == c.dameTipo();
	}

	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();

		format.append("\n\tId : " + this.id + ", type : " + this.tipo + "\n");
		return format.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnumType getTipo() {
		return tipo;
	}

	public void setTipo(EnumType tipo) {
		this.tipo = tipo;
	}	
}