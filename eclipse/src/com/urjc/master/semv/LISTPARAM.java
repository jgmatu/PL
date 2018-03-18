package com.urjc.master.semv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.urjc.master.semv.APITS.EnumType;

public class LISTPARAM {

	private HashMap<EnumType, List<String>> parametros;

	public LISTPARAM() {
		this.parametros = new HashMap<EnumType, List<String>>();
	}
	
	private void insertar(String id, EnumType tipo) {
		if (this.parametros.containsKey(tipo)) {
			this.parametros.get(tipo).add(id);
		} else {
			ArrayList<String> ids = new ArrayList<String>();
			ids.add(id);
			this.parametros.put(tipo,ids);
		}
	}
	
	public HashMap<EnumType, List<String>> getParametros(){
		return this.parametros;
	}
}
