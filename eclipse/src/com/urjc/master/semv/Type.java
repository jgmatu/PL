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
	
 	public boolean isReturn() {
		return this.sentence == EnumSentence.RETURN;
	}
}
