package com.project.model;

public class DropdownSingleInfos {

	private String name;
	private String value;
	
	public DropdownSingleInfos(String name, String value){
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	public String toString(){
		return "[ name:" + name + ", value:"+value+" ]\n";
	}
}
