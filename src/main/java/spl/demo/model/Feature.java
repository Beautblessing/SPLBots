package spl.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "feature")
@XmlAccessorType(XmlAccessType.FIELD)

public class Feature {
	
	@XmlAttribute
	 private String name;

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
	        inputs.add(name);
	        inputs.add("I want " +name);
	        inputs.add("I´d like ");
	        inputs.add("I´ll go with ");
	        inputs.add("Give me");
	        
	        
	        
	        intents.setInputs(inputs);
	        
	        
	        //	Add	Entity
	        Entities entities = new Entities();
	        List<String> synonyms = new ArrayList<String>();

	        
	        entities.setValue(name);
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter 3 synonymns for " + name);
	       
	        for(int i=0;i<3;i++)
	        {
	         String syn =scanner.nextLine();
	         synonyms.add(syn);
	        
	        }
	        
	        return "\n  "+name+": inputs {"+inputs+" }";
	    }
}
