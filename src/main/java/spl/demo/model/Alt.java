package spl.demo.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "alt")
@XmlSeeAlso({Feature.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Alt {
	@XmlElement(name="feature")
	private Feature[] feature;
	
	@XmlAttribute
    private String name;

   
	@XmlAttribute
    private String mandatory;

    public Feature[] getFeature ()
    {
        return feature;
    }

    public void setFeature (Feature[] feature)
    {
        this.feature = feature;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    
    public String getMandatory ()
    {
        return mandatory;
    }

    public void setMandatory (String mandatory)
    {
        this.mandatory = mandatory;
    }

    @Override
    public String toString()
    {
    	//return "Alt [ name = "+name+", mandatory = "+mandatory+", feature = "+ Arrays.toString(feature)+"]";
    	return "Alt [ name = "+name+", mandatory = "+mandatory+" \n "+ Arrays.toString(feature)+"]";
    
    
    }
}
