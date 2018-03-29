package com.urjc.master.semv;

public class Body {
	
	private String idLexema;
	private LISTPARAM list;
	
	public Body(String idLexema, LISTPARAM list) {
		System.out.println("TRACE...");	

		this.idLexema = idLexema;
		this.list = list;
	}
	
	public Body getBody() {
		System.out.println("TRACE...");	

		return new Body(idLexema, list);
	}
}
