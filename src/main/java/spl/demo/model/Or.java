package spl.demo.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "or")
@XmlSeeAlso({Feature.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Or {
	
	@XmlElement(name="feature")
	private Feature[] feature;
	
	@XmlAttribute
    private String name;

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

    @Override
    public String toString()
    {
       // return "Or [ name = "+name+", feature = "+ Arrays.toString(feature) +"]";
        return "Or [ name = "+name+" \n "+ Arrays.toString(feature) +"]";
        
    }
}
