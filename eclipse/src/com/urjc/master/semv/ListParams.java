package com.urjc.master.semv;

import java.util.HashMap;
import java.util.Map.Entry;

import com.urjc.master.semv.APITS.EnumType;

public class ListParams {

	private HashMap<String, EnumType> parametros;

	public ListParams() {
		this.parametros = new HashMap<String, EnumType>();
	}
	
	public void insertar(String id, EnumType tipo) {
		boolean success = !this.parametros.containsKey(id);
		
		if (success) {
			this.parametros.put(id, tipo);
		} else {
			System.err.println(String.format("The parameter : %s already exist...", id));
		}
	}
	
	public HashMap<String, EnumType> getParametros(){
		return this.parametros;
	}
	
	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();

		for (Entry<String, EnumType> pair : parametros.entrySet()) {
			format.append(String.format("\n\tParam : %s\n", pair.getKey()));
		}		
		return format.toString();
	}
}
