package spl.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
    	// Add Intents
    	Intents intents = new Intents();
        List<String> inputs = new ArrayList<String>();

        // Add training phrases in the arraylist
        inputs.add("I want to know the type of " +name+" that is available");
        inputs.add(name);
        inputs.add("See available " +name);
        inputs.add("what " +name+" type is available");
        
        intents.setInputs(inputs);
        
        
        //	Add	Entity
        Entities entities = new Entities();
        // List<String> synonyms = new ArrayList<String>();

        
//        entities.setValue(name);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter synonymns for " + name);
//       
//
//         String syn =scanner.nextLine();
//         synonyms.add(syn);
        
    	
    	//return "Alt [ name = "+name+", mandatory = "+mandatory+", feature = "+ Arrays.toString(feature)+"]";
    	return "Alt [ "+name+": inputs {"+inputs+" } mandatory = "+mandatory+" \n "+ Arrays.toString(feature)+"]";
    
    
    }
}
