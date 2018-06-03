package com.urjc.master.semv.commands;

import com.urjc.master.semv.types.Type;

public class Variable extends Command {

	public Variable(String id, Type tipo) {
		super(id, tipo);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Variable)) {
			return false;
		}
		Variable v = (Variable) o;
		return this.getId().equals(v.getId());
	}
}
