package com.urjc.master.semv.types;

import java.util.ArrayList;
import java.util.List;

public class TupleTypes {

	private List<Type> types;

	public TupleTypes() {
		this.types = new ArrayList<>();
	}

	public void insert(Type type) {
		if (type != null) {
			this.types.add(type);			
		}
	}

	public List<Type> getTupleTypes() {
		return this.types;
	}

	public boolean compare(TupleTypes types) {
		if (this.types.size() > types.types.size()) {
			System.err.println("Too many arguments...");
			return false;
		}

		if (this.types.size() < types.types.size()) {
			System.err.println("Too few arguments...");
			return false;
		}
		boolean success = true;
		final int size = this.types.size();
		
		for (int i = 0; i < size && success; ++i) {
			Type type_arg = this.types.get(i);
			Type type_parm = types.types.get(i);

			if (!type_arg.equals(type_parm)) {
				success = false;
			}
		}
		if (!success) {
			System.err.println("The function is bas used : " + usage(types));
		}
		return success;
	}
	
	private String usage (TupleTypes types) {
		StringBuffer format = new StringBuffer();
		
		
		return format.toString();
	}
	
	
	@Override
	public String toString() {
		return "";
	}
}
