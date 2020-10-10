package spl.demo.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAttribute;

public class Intent {
	@XmlAttribute
	private String name;
	
	private Inputs[] inputs;
	
	private Parameters[] parameters;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Inputs[] getInputs() {
		return inputs;
	}
	public void setInputs(Inputs[] inputs) {
		this.inputs = inputs;
	}
	
	public Parameters[] getParameters() {
		return parameters;
	}
	public void setParameters(Parameters[] parameters) {
		this.parameters = parameters;
	}
		
	
//	 @Override
//	    public String toString()
//	    {
//	       
//	        return "intents: "+name+" inputs{ "+ Arrays.toString(inputs)+"} \n "parameters: "+parameters+" 
//	        
//	    }
	
}
