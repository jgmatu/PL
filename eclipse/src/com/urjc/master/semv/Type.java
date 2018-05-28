package com.urjc.master.semv;


public class Type {
	
	private EnumType type;
	private EnumSentence sentence;
	
	public Type() {
		this.type = EnumType.ERROR;
	}
	
	public Type(EnumType type) {
		this.type = type;
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
