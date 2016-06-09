package com.project;

import java.util.ArrayList;
import java.util.List;

import com.project.dao.Dao;
import com.project.model.FormData;
import com.project.service.Service;

public class Test {
	
	public static void main(String[] args){
		List<String> listaContinenti = new ArrayList<String>();
		
		listaContinenti.add("Europe");
		listaContinenti.add("Oceania");
		
		FormData formData = new FormData();
		//formData.setContinent(listaContinenti);
		
		Dao dao = new Dao();
	}

}
