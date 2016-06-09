package com.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.DropdownInfos;
import com.project.model.FormData;
import com.project.model.Search;
import com.project.service.Service;

@Controller
public class MyController {
	
	@Autowired
	private Service service;

	@RequestMapping(value="index",
			method = RequestMethod.GET)
	public String metodo(){
		return "index";
	}
	
	@RequestMapping(value="index",
			method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> metodo2(@RequestBody FormData formData){
		System.out.println(formData.getContinent());
		
		return service.metodoService(formData.getContinent());
	}
	
	@RequestMapping(value="continentList",
			method=RequestMethod.GET)
	@ResponseBody
	public DropdownInfos dropdownContinentController(){
		System.out.println("DropdownInfos");
		
		return service.dropdownContinentService();
	}
	
	@RequestMapping(value="capitals",
			method=RequestMethod.GET)
	@ResponseBody
	public Search listAllCapitalsController(){
		
		return service.listAllCapitalsService();
	}
}
