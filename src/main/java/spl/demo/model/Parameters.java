package spl.demo.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Parameters {
	
	@XmlAttribute
    private String name;
	
	@XmlAttribute
    private String required;
	
	@XmlAttribute
    private String prompts;
	
	private String[] parameters;
	
	public String getName ()
    {
        return name;
    }

	public void setName (String name)
    {
        this.name = name;
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
	public String[] getParameters() {
		return parameters;
	}

	public void setParameters(String[] parameters) {
		this.parameters = parameters;
	}
	
	 @Override
	    public String toString()
	    {
	        return "parameters: \n entity "+name+", "+required+", prompts ["+prompts+"]";
	    }
}
