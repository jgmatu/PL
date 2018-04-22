package com.urjc.master.semv;

public class Command {

	private String id;
	private Type tipo;

	public Command(String id, Type tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Type dameTipo() {
		return this.tipo;
	}

	public void insertaTipo(Type tipo) {
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

	public Type getTipo() {
		return tipo;
	}

	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}	
}