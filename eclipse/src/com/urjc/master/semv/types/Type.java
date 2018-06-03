package com.urjc.master.semv.types;

import com.urjc.master.semv.enums.EnumSentence;
import com.urjc.master.semv.enums.EnumType;

public class Type {
	
	private EnumType type;
	private EnumSentence sentence;
	private int line;
	
	public Type() {
		this.type = EnumType.ERROR;
	}
	
	public Type(EnumType type, int line) {
		this.type = type;
		this.line = line;
	}
	
	public int getLine() {
		return this.line;
	}
	
	public boolean isError() {
		return this.type == EnumType.ERROR;
	}
	
	public void setError() {
		this.type = EnumType.ERROR;
	}
	
	public void setVoid() {
		this.type = EnumType.VOID;
	}
	
	public void setReturn() {
		this.sentence = EnumSentence.RETURN;
	}
	
 	public boolean isReturn() {
		return this.sentence == EnumSentence.RETURN;
	}
 	
 	public boolean isVoid() {
 		return this.type == EnumType.VOID;
 	}
 	
 	@Override
 	public boolean equals(Object o) {
 		if (o == this) {
 			return true;
 		}
 		if (!(o instanceof Type)) {
 			return false;
 		}
 		Type t = (Type) o;
 		return t.type == this.type;
 	}
 	
 	@Override
 	public String toString() {
 		switch(this.type) {
 		case INT:
 			return String.format("%s\n", "INT");
 		case FLOAT:
 			return String.format("%s\n", "FLOAT");
 		case VOID:
 			return String.format("%s\n", "VOID"); 			
 		case ERROR:
 			return String.format("%s\n", "ERROR");
 		default:
 			return String.format("%s\n", "Undefined");
 		}
 	}
}
