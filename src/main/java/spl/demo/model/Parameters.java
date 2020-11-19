package spl.demo.model;


import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

public class Parameters {
	
	@XmlAttribute
    private Feature[] feature;
	
	@XmlAttribute
    private String eName;
	
	@XmlAttribute
    private String required;
	
	@XmlAttribute
    private String prompts;
	
	//private String[] parameters;
	
	List<String> paramss;
	
	public List<String> getParamss() {
        return paramss;
    }

    public void setParamss(List<String> paramss) {
        this.paramss = paramss;
    }
    
    
	List<Parameters> params;
	
	public List<Parameters> getParams() {
        return params;
    }

    public void setParams(List<Parameters> params) {
        this.params = params;
    }
	
	 public Parameters(Feature[] feature, String eName, String required, String prompts) {
		 
//		 this.pName = pNamee;
		 this.feature = feature;
		 this.eName = eName;
		 this.required = required;
		 this.prompts = prompts;
	    }

	
	public String getEName ()
    {
        return eName;
    }

	public void setEName (String eName)
    {
        this.eName = eName;
    }
	
    public String getRequired ()
    {
        return required;
    }

    public void setRequired (String required)
    {
        this.required = required;
    }

    public String getPrompts ()
    {
        return prompts;
    }

    public void setPrompts (String prompts)
    {
        this.prompts = prompts;
    }
	public Feature[] getFeature() {
		return feature;
	}

	public void setFeature(Feature[] feature) {
		this.feature = feature;
	}

}
