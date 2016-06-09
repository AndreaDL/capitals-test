package com.project.model;

import java.util.List;

public class DropdownInfos {

	private boolean success;
	private List<DropdownSingleInfos> results;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<DropdownSingleInfos> getResults() {
		return results;
	}
	public void setResults(List<DropdownSingleInfos> results) {
		this.results = results;
	}
	
	public String toString(){
		String s = "";
		for(DropdownSingleInfos dsi : results)
			s += dsi;
		return s;
	}

}
