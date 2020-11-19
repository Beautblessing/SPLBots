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
	static ArrayList<String> selectfeature= new ArrayList<>();
	
	@XmlElement(name="feature")
	private Feature[] feature;
	
	//added
	@XmlAttribute
    private String mandatory;
	
	
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
    
    //added
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
    	// Added
    	Intents intents = new Intents();
        List<String> inputs = new ArrayList<String>();

        // Add training phrases in the arraylist
        inputs.add("I want to know the type of " +name+" that is available");
        inputs.add(name);
        inputs.add("See available " +name);
        inputs.add("what " +name+" type is available");     
        
        intents.setInputs(inputs);
        
        // added
        List<String> inputsYes = new ArrayList<String>();
        // Add training phrases in the arraylist
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
        
       // Parameters parameters = new Parameters(feature, name, "required", "prompts");  
         List<String> paramss = new ArrayList<String>(); 
        // paramss.add("parameters: \n"+ pName +": "+ "entity " +name +", " + "required" +", "+ "prompts"+" [\"What type of " +name+"?\"]");
         paramss.add("parameters: \n"+ name+"_type: "+ "entity " +name +", " + "required" +", "+ "prompts"+" [\"What type of " +name+"?\"]");       
       //  parameters.setParamss(paramss);
         
        // Feature select phrases
     	for(Feature ft: feature) {
           
           selectfeature.add("(\""+ft+"\")["+name+"_type]");
      	 	selectfeature.add("\"I want "+"(\""+ft+"\")["+name+"_type]");
      	 	selectfeature.add("(\"I´ll go with "+"(\""+ft+"\")["+name+"_type]");
      	 	selectfeature.add("\"Give me "+"(\""+ft+"\")["+name+"_type]");
      	 	
   	 	
      	 	//System.out.println(selectfeature);
       }
     	
     	String result = "\n";
     	if (mandatory == null) {
        	result += "Select_" +name+"_yes: \n ";
        	result += "inputs {"+inputsYes.toString().substring(1, inputsYes.toString().length() - 1)+" } " + "\n";
        	result += "Select_" +name+"_no: \n ";
        	result += "inputs {"+inputsNo.toString().substring(1, inputsNo.toString().length() - 1)+" } " + "\n";
        
        }
     	result += name+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" } " + "\n";
        
     	//String result = name+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" } " + "\n";
        result += "Select_" +name+": \n ";
        result += "inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" } "+" \n ";
        result += "\n"+ paramss.toString().substring(1, paramss.toString().length() - 1) +"\n ";
        
//        if (mandatory == null) {
//        	result += "Select_" +name+"_yes: \n ";
//        	result += "inputs {"+inputsYes.toString().substring(1, inputsYes.toString().length() - 1)+" } " + "\n";
//        	result += "Select_" +name+"_no: \n ";
//        	result += "inputs {"+inputsNo.toString().substring(1, inputsNo.toString().length() - 1)+" } " + "\n";
//        
//        }

        
     	//return "\n "+name+": \n inputs {"+Arrays.toString(inputs.toArray()).replace("[", "").replace("]", "")+" } "+ Arrays.toString(feature) +"";
//     	 return "\n  "+name+": \n inputs {"+Arrays.toString(inputs.toArray()).replace("[", "").replace("]", "")+" } \n "+ " \n Select_" +name+": \n inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" } "
//         +"\n"+ paramss+"\n ";
//        
        return result;
     	
	//        return "Or [ "+name+": "+inputs+" + Arrays.toString(feature) +"]""
        
    }
}
