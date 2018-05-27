package com.urjc.master.semv;

import java.util.ArrayList;
import java.util.List;

public class TupleTypes {

	private List<Type> types;
	
	public TupleTypes() {
		this.types = new ArrayList<>();
	}
	
	public void insert(Type type) {
		this.types.add(type);
	}
	
	public List<Type> getTupleTypes() {
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
				System.err.println("Incompatible types between arguments and parementers " + 
									" defined on the function... numb of argument : " + i);
				success = false;
			}
		}
		return success;
	}
		
	public int size() {
		return this.types.size();
	}
}
