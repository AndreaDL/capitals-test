package com.project.model;

import java.util.List;

public class FormData{

	private List<String> continent;
	
	public FormData(){
		System.out.println("Inside FormData constructor");
	}

	public List<String> getContinent() {
		return continent;
	}

	public void setContinent(List<String> continent) {
		this.continent = continent;
	}
	
}
