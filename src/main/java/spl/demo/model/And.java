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


@XmlRootElement(name = "and")


@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Or.class, Alt.class, Feature.class, Entity.class})
public class And {
	
	@XmlAttribute
    private String name;
	
	@XmlAttribute
    private String _abstract;
	
	@XmlAttribute
    private String mandatory;
	

	@XmlElement(name="feature")
	private Feature[] feature;
	 
	@XmlElement(name="or")
	private Or or;

	@XmlElement(name="alt")
    private Alt alt;
	
	
	//added
	
    private Entity entity;
	
	//
	
	// added
    @XmlElement(name="and")
    private And[] and;
	
	public String getName ()
	    {
	        return name;
	    }

	public void setName (String name)
	    {
	        this.name = name;
	    }
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

    //added
    
    public Entity getEntity ()
    {
        return entity;
    }

    public void setEntity (Entity entity)
    {
        this.entity = entity;
    }
    
    // added
    public And[] getAnd ()
    {
        return and;
    }

    public void setAnd (And[] and)
    {
        this.and = and;
    }
	//
    
    public String getAbstract ()
    {
        return _abstract;
    }

    public void setAbstract (String _abstract)
    {
        this._abstract = _abstract;
    }

    public String getMandatory ()
    {
        return mandatory;
    }

    public void setMandatory (String mandatory)
    {
        this.mandatory = mandatory;
    }


    static Intents intents = new Intents();
    static List<String> inputs = new ArrayList<String>();
    static List<String> greetinputs = new ArrayList<String>();
 
    
    @Override
    public String toString()
    {     
    	
//        printIntent();
    	// Add Intents    	    
        // Add training phrases in the arraylist
    	inputs.add("\"What are the support features for " +name +"\"");
  	  	inputs.add("\"What feature is supported by " +name +"\"");
  	  	inputs.add("\"What is the support feature for " +name +"\"");

        intents.setInputs(inputs);
     
       //String result = name+": \n inputs {"+Arrays.toString(inputs.toArray()).replace("[", "").replace("]", "")+" } " + "\n";
        
        String result = name+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" } " + "\n";
        if(feature!= null) {result += Arrays.toString(feature)+" \n ";}
        if(and!= null) {result += Arrays.toString(and)+" \n ";}
        if(alt!= null) { result += alt+" \n ";}
        if(or!= null) {result += or+" \n ";}
//        result += entity+" \n ";
        
  
       // return name+": \n inputs {"+Arrays.toString(inputs.toArray()).replace("[", "").replace("]", "")+" } abstract = "+_abstract+", mandatory = "+mandatory+" "+ Arrays.toString(feature)+" \n "+ Arrays.toString(and)+" \n "+alt+" \n "+or+"\n"+entity+"";
        return result;
        //return name+": \n inputs {"+Arrays.toString(inputs.toArray()).replace("[", "").replace("]", "")+" } "+ Arrays.toString(feature)+" \n "+ Arrays.toString(and)+" \n "+alt+" \n "+or+"\n"+entity+"";
        
    }
    
 

 //add training phrases
 public static void printIntent() {
	 	//standard help
//	  inputs.add("\"What are the support features for" +name +"\"");
//	  inputs.add("\"What feature is supported by" +name +"\"");
//	  inputs.add("\"What is the support feature for" +name +"\"");
//      inputs.add("\"yes I want to select a configuration\"");
//      inputs.add("\"yes I would like to choose a configuration\"");
//      inputs.add("\"ys what features do you have\"");
//      inputs.add("\"yes what features are available\"");
//      inputs.add("\"yes I´d love to\"");
//      inputs.add("\"why not\"");
//      inputs.add("\"yes I do\"");
      
      //set Inputs
    //  intents.setInputs(inputs); 
    
 }
 //add training phrases
	
}
