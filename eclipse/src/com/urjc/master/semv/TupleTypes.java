package com.urjc.master.semv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.urjc.master.semv.APITS.EnumType;

public class TupleTypes {

	private List<EnumType> types;
	
	public TupleTypes() {
		this.types = new ArrayList<>();
	}
	
	public void insert(EnumType type) {
		this.types.add(type);
	}
	
	public List<EnumType> getTupleTypes() {
		return this.types;
	}

	public boolean compare(TupleTypes types) {
		if (this.size() > types.size()) {
			System.err.println("Too many arguments...");
			return false;
		}
		if (this.size() < types.size()){
			System.err.println("Too few arguments...");
			return false;			
		}
		boolean success = true;
		for (int i = 0; i < this.types.size(); ++i) {
			if (types.types.get(i) != this.types.get(i)) {
				System.err.println("Incompatible types between arguments and parementers"
						+ " defined on the function.. argument : " + i);
				success = false;
			}
		}
		return success;
	}
	
	public int size() {
		return this.types.size();
	}
}
