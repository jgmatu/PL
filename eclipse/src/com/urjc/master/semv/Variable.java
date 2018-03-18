package com.urjc.master.semv;

import com.urjc.master.semv.APITS.EnumType;

public class Variable extends Commands {

	public Variable(String id, EnumType tipo) {
		super(id, tipo);
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
		return this.id.equals(v.id);
	}
}