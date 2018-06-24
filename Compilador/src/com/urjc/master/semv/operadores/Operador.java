package com.urjc.master.semv.operadores;

public class Operador {

	private String operador;
	
	
	public Operador (String op) {
		this.operador = op;
	}
	
	@Override
	public String toString() {
		return this.operador;
	}
}
