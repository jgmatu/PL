package com.urjc.master.semv;

import java.util.HashMap;
import java.util.Map.Entry;

public class ListParams {

	private HashMap<String, Type> parametros;

	public ListParams() {
		this.parametros = new HashMap<String, Type>();
	}
	
	public void insertar(String id, Type tipo) {
		boolean success = !this.parametros.containsKey(id);
		
		if (success) {
			this.parametros.put(id, tipo);
		} else {
			System.err.println("The parameter : " + id + " already exist...");
		}
	}
	
	public HashMap<String, Type> getParametros(){
		return this.parametros;
	}
	
	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();

		for (Entry<String, Type> pair : parametros.entrySet()) {
			format.append("\n\tParam : " + pair.getKey() + "\n");
		}		
		return format.toString();
	}
}
