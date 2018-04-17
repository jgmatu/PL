package com.urjc.master.semv;

import java.util.ArrayList;
import java.util.List;

import com.urjc.master.semv.APITS.EnumType;

public class Lid {
	
	private List<String> idList;
	private EnumType tipo;
	private boolean success;
	
	public Lid() {
		 idList = new ArrayList<>();
		 this.tipo = EnumType.ERROR;
	}
	
	public List<String> getList() {
		return this.idList;
	}

	public void setList(List<String> list) {
		this.idList = list;
	}
	
	public void add(String a){
		this.idList.add(a);
	}

	public void insertaTipo(EnumType tipo) {
		this.tipo = tipo;
	}
	
	public EnumType dameTipo() {
		return this.tipo;
	}
	
}