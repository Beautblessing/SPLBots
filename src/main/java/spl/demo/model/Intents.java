package spl.demo.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

public class Intents {
	//@XmlAttribute
	//private String name;
	
	@XmlAttribute
	//private String inputs;
	List<String> inputs;
	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getInputs() {
//		return inputs;
//	}
//	public void setInputs(String inputs) {
//		this.inputs = inputs;
//	}
	 public List<String> getInputs() {
	        return inputs;
	    }

	    public void setInputs(List<String> inputs) {
	        this.inputs = inputs;
	    }

	
	
//	 @Override
//	    public String toString()
//	    {
//	       
//	        return "Intents = "+name+", displayName = "+displayName+" ";
//	        
//	    }
	
}
