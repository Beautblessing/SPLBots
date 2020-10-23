package spl.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    	// Added
    	Intents intents = new Intents();
        List<String> inputs = new ArrayList<String>();

        // Add training phrases in the arraylist
        inputs.add("I want to know the type of " +name+" that is available");
        inputs.add(name);
        inputs.add("See available " +name);
        inputs.add("what " +name+" type is available");
        
        
        
        intents.setInputs(inputs);
        
        // 
    	
        return "Or [ "+name+": inputs {"+inputs+" } feature = "+ Arrays.toString(feature) +"]";
//        return "Or [ "+name+": "+inputs+" + Arrays.toString(feature) +"]""
        
    }
}
