package com.urjc.master.semv;

import com.urjc.master.semv.APITS.EnumType;

public class Commands {

	protected String id;
	protected EnumType tipo;

	public Commands(String id, EnumType tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public EnumType dameTipo() {
		return this.tipo;
	}

	public void insertaTipo(EnumType tipo) {
		this.tipo = tipo;
	}

	public boolean compTipos(Commands c) {
		return this.tipo == c.dameTipo();
	}

	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();

		format.append(String.format("\n\tId : %s, type : %s\n", this.id, getStringType(this.tipo)));
		return format.toString();
	}

	protected String getStringType(EnumType type) {
		switch (type) {
		case FLOAT:
			return "FLOAT";
		case INT:
			return "INT";
		case VOID:
			return "VOID";
		case ERROR:
			return "ERROR";
		default:
			return "";
		}
	}
}