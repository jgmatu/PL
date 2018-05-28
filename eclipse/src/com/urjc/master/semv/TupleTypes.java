package com.urjc.master.semv;

import java.util.List;
import java.util.Stack;

public class TupleTypes {

	private Stack<Type> types;

	public TupleTypes() {
		this.types = new Stack<>();
	}

	public void insert(Type type) {
		if (type != null) {
			this.types.push(type);			
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
		
		for (int i = 0; i < size; ++i) {
			Type type_arg = this.types.pop();
			Type type_parm = types.types.pop();

			if (!type_arg.equals(type_parm)) {
				System.err.println("Incompatible types between arguments and parementers "
						+ " defined on the function... numb of argument : " + i);
				success = false;
			}
		}
		return success;
	}
	
	@Override
	public String toString() {
		return "";
	}
}
