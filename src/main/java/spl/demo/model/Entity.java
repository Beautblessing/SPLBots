package spl.demo.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Or.class, Alt.class, Feature.class})
public class Entity {
	@XmlAttribute
	private String name;
	
	private EInputs[] inputs;
	
	//added
	
	@XmlElement(name="feature")
	private Feature[] feature;
	 
	@XmlElement(name="or")
	private Or or;

	@XmlElement(name="alt")
    private Alt alt;
	
	
	public Feature[] getFeature ()
    {
        return feature;
    }

public void setFeature (Feature[] feature)
    {
        this.feature = feature;
    }

public Or getOr ()
{
    return or;
}

public void setOr (Or or)
{
    this.or = or;
}

public Alt getAlt ()
{
    return alt;
}

public void setAlt (Alt alt)
{
    this.alt = alt;
}


	//
	
	
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
	

	
	@Override
    public String toString()
    {       
        
       //return "entities: \n Simple entity " +name+": inputs in en{"+name+" } feature = "+ Arrays.toString(feature)+"\n alt = "+alt+" \n or = "+or+"";
       return "entities: \n Simple entity ";

      // return "entities: \n Simple entity " +name+": inputs in en{"+name+" } feature = "+ Arrays.toString(feature)+"\n alt = "+alt+" \n or = "+or+"";

    }
 
}
