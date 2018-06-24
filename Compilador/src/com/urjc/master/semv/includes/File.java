package com.urjc.master.semv.includes;

public class File {
	
	private String name;

	public File(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name;
	}
}
