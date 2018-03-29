package com.urjc.master.semv;

import java.util.ArrayList;
import java.util.List;

public class Lid {
	
	private List<String> idList;
	
	public Lid() {
		 idList = new ArrayList<>();
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

}