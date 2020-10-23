package spl.demo.model;

import java.util.List;

public class Entities {
	private String value; 
	//private String[] synonymns;
	List<String> synonymns;

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
//	public String[] getSynonymns() {
//		return synonymns;
//	}
//
//	public void setSynonymns(String[] synonymns) {
//		this.synonymns = synonymns;
//	}
	 public List<String> getSynonymns() {
	        return synonymns;
	    }

	    public void setSynonymns(List<String> synonymns) {
	        this.synonymns = synonymns;
	    }
	
}
