package spl.demo.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Entities {
	@XmlAttribute
	private String name;
	
	private EInputs[] inputs;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EInputs[] getInputs() {
		return inputs;
	}
	public void setInputs(EInputs[] inputs) {
		this.inputs = inputs;
	}
	

	
}
