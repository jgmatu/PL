package com.urjc.master.semv.commands;

import com.urjc.master.semv.types.Type;

public class Parametro extends Command {
	
	public Parametro(String id, Type type) {
		super(id, type);
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
		if (!(o instanceof Parametro)) {
			return false;
		}
		Parametro p = (Parametro) o;
		return this.getId().equals(p.getId());
	}
}
