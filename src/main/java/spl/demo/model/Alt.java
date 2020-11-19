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
	static ArrayList<String> selectfeature= new ArrayList<>();
	//String entityName;
	//added
//	 @XmlElement(name="alt")
//	  private Alt[] alt;
	//
	
	@XmlElement(name="feature")
	private Feature[] feature;
	
	@XmlAttribute
    private String name;

   
	@XmlAttribute
    private String mandatory;
	public static String entityName;

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
   
    
    
    // added
//    public Alt[] getAlt ()
//    {
//        return alt;
//    }
//
//    public void setAlt (Alt[] alt)
//    {
//        this.alt = alt;
//    }
	//
    
    
//    Intents intents = new Intents();
//    static List<String> inputs = new ArrayList<String>();

    
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
        
        
        List<String> inputsYes = new ArrayList<String>();
        // Add training phrases
        inputsYes.add("yes, I want " +name);
        inputsYes.add("yes");
        inputsYes.add("yes, what " + name + " is available " );
        inputsYes.add("yes I do ");
        
        intents.setInputs(inputsYes);
        
        List<String> inputsNo = new ArrayList<String>();
        // Add training phrases
        inputsNo.add("Thanks, I do not want " +name);
        inputsNo.add("Thanks, but no ");
        inputsNo.add("no");
        inputsNo.add("nah,I´m good");
        
        
        intents.setInputs(inputsNo);
        //	Add	Parameters
        
       Parameters parameters = new Parameters(feature, name, "required", "prompts");  
        List<String> paramss = new ArrayList<String>(); 
       // paramss.add("parameters: \n"+ pName +": "+ "entity " +name +", " + "required" +", "+ "prompts"+" [\"What type of " +name+"?\"]");
        paramss.add("parameters: \n"+ name+"_type: "+ "entity " +name +", " + "required" +", "+ "prompts"+" [\"What type of " +name+"?\"]");       
        parameters.setParamss(paramss);
        
       // Feature select phrases
    	for(Feature ft: feature) {
          
          selectfeature.add("(\""+ft+"\")["+name+"_type]");
     	 	selectfeature.add("\"I want "+"(\""+ft+"\")["+name+"_type]");
     	 	selectfeature.add("\"I´ll go with "+"(\""+ft+"\")["+name+"_type]");
     	 	selectfeature.add("\"Give me "+"(\""+ft+"\")["+name+"_type]");
  	 	
     	 	
      }
    	 //**Entity**//
        Ent ent = new Ent();
   	    List<String> inputsEnt = new ArrayList<String>();
   	   
        // Add training phrases in the arraylist
        inputsEnt.add("Simple entity \"" +name+"\":");
        
        ent.setInputs(inputsEnt);
        entityName = inputsEnt.toString().substring(1, inputsEnt.toString().length() - 1) + "\n";
        

    	//System.out.println(selectfeature.toString().substring(1, selectfeature.toString().length() - 1));
        
    	String result = name+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" } " + "\n";
        result += "Select_" +name+": \n ";
        result += "inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" } "+" \n ";
        result += "\n"+ paramss.toString().substring(1, paramss.toString().length() - 1) +"\n ";
        //result += inputsEnt.toString().substring(1, inputsEnt.toString().length() - 1) + "\n";
        
        if (mandatory == null) {
        	result += "Select_" +name+"_yes: \n ";
        	result += "inputs {"+inputsYes.toString().substring(1, inputsYes.toString().length() - 1)+" } " + "\n";
        	result += "Select_" +name+"_no: \n ";
        	result += "inputs {"+inputsNo.toString().substring(1, inputsNo.toString().length() - 1)+" } " + "\n";
        	
        }

//    	 return "\n  "+name+": \n inputs {"+inputs
//    			 +" } \n "+ " \n Select_" +name+": \n inputs {\n"+selectfeature+" } "
//    			          +"\n\n"+ paramss+"\n";
//    			           	
//    	
    	
        return result;
    	
    	
    	
    	
    	
    	
    	
    	//standard select
//   	 	selectfeature.add("(\""+pName+"\")["+name+"_type]");
//   	 	selectfeature.add("\"I want "+"(\""+pName+"\")["+name+"_type]");
//   	 	selectfeature.add("(\"I´ll go with "+"(\""+pName+"\")["+name+"_type]");
//   	 	selectfeature.add("\"Give me "+"(\""+pName+"\")["+name+"_type]");
//	 	
   	 	//System.out.println(selectfeature.toString().substring(1, selectfeature.toString().length() - 1));
   	 	

        
       // return "\n  "+name+": \n inputs {"+Arrays.toString(inputs.toArray()).replace("[", "").replace("]", "")+" } mandatory = "+mandatory+" \n "+ Arrays.toString(feature)+" \n "+paramss+"\n Simple entity " +name+":";
        //return "\n  "+name+": \n inputs {"+Arrays.toString(inputs.toArray()).replace("[", "").replace("]", "")+" } \n "+ Arrays.toString(feature)+" \n "+paramss+"\n Simple entity " +name+":";
       
//        return "\n  "+name+": \n inputs {"+Arrays.toString(inputs.toArray()).replace("[", "").replace("]", "")+" } \n "+ Arrays.toString(feature)+" \n Select_" +name+": \n inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" } "
//        +"\n"+ paramss+"\n Simple entity " +name+":";
//      
    	
    	//        return "\n  "+name+": \n inputs {"+Arrays.toString(inputs.toArray()).replace("[", "").replace("]", "")+" } \n "+ " \n Select_" +name+": \n inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" } "
//        +"\n"+ paramss+"\n";
//        
//    	 return "\n  "+name+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)
//+" } \n "+ " \n Select_" +name+": \n inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" } "
//         +"\n\n"+ paramss+"\n";
//         
//       
    	 
    	 
//    	 return "\n  "+name+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)
//    			 +" } \n "+ " \n Select_" +name+": \n inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" } "
//    			          +"\n"+ paramss+"\n";
//    			          
    }
    
    
    
//    
//    public static void SelectIntent() {
// 	 	//standard select
//    	 selectfeature.add("\"Can you help me\"");
//    	 selectfeature.add("\"I need help\"");
//    	 selectfeature.add("\"what can I do\"");
//    	 selectfeature.add("\"what can you do\"");
//       
// 	 System.out.println("Select_" +name+": \n inputs {"+Arrays.toString(helpinputs.toArray()).replace("[", "").replace("]", "")+" } " );
//     
//  } 
    //add training phrases
//    public static void printIntent() {
//   	 
//        inputs.add("I want to know the type of " +name+" that is available");
//        inputs.add(name);
//        inputs.add("See available " +name);
//        inputs.add("what " +name+" type is available");
//         
//         //set Inputs
//         intents.setInputs(inputs); 
//    }
    
//    public static void printEnt() {
//    	 //**Entity**//
//        Ent ent = new Ent();
//   	    List<String> inputsEnt = new ArrayList<String>();
//   	   
//        // Add training phrases in the arraylist
//        inputsEnt.add("Simple entity \"" +name+"\":");
//        
//        ent.setInputs(inputsEnt);
//        entityName = inputsEnt.toString().substring(1, inputsEnt.toString().length() - 1) + "\n";
//        
//    }
}
