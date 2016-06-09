package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.Dao;
import com.project.model.DropdownInfos;
import com.project.model.DropdownSingleInfos;
import com.project.model.Search;
import com.project.model.SearchObject;

@Component
public class Service {

	@Autowired
	private Dao dao;
	
	public Map<String, String> metodoService(List<String> continent){
		
		return dao.metodo(continent);
	}
	
	public DropdownInfos dropdownContinentService(){
		
		DropdownInfos allContinents = new DropdownInfos();
		List<DropdownSingleInfos> list = new ArrayList<>();
		List<String> allContinentList = dao.listAllContinent();
		
		allContinents.setSuccess(true);
		for(String s : allContinentList)
			list.add(new DropdownSingleInfos(s,s));
	
		allContinents.setResults(list);
		
		return allContinents;
	}
	
	public Search listAllCapitalsService(){
		
		Search search = new Search();
		
		List<String> capitals = dao.listAllCapitals();
		List<SearchObject> searchObjectList = new ArrayList<>();
		for(String c : capitals)
			searchObjectList.add(new SearchObject(c));
		
		search.setResults(searchObjectList);
		
		return search;
	}
}
