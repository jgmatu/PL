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
		for (int i = 0; i < this.types.size() && success; ++i) {
			Type type_arg = this.types.get(i);
			Type type_parm = types.types.get(i);

			if (!type_arg.equals(type_parm)) {
				success = false;
			}
		}
		return success;
	}	
	
	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();
		
		format.append("(");
		for (int i =  this.types.size() - 1; i >= 0; --i) {
			format.append(this.types.get(i).toString());
			if (i != 0) {
				format.append(" , ");
			}
		}
		format.append(")\n");
		return format.toString();
	}
}
