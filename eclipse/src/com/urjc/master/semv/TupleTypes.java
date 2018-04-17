package com.urjc.master.semv;

import java.util.HashMap;
import java.util.Map;

import com.urjc.master.semv.APITS.EnumType;

public class TupleTypes {

	private Map<String, EnumType> types;
	
	public TupleTypes() {
		this.types = new HashMap<>();
	}
	
	public void insert(String id, EnumType type) {
		this.types.put(id, type);
	}
	
	public Map<String, EnumType> getTupleTypes() {
		return this.types;
	}

	public boolean compare(TupleTypes types) {
		return false;
	}
}
