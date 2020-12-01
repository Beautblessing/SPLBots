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
//	static ArrayList<String> selectfeature= new ArrayList<>();

	@XmlElement(name="feature")
	private Feature[] feature;

	@XmlAttribute
	private String name;


	@XmlAttribute
	private String mandatory;
	
	

	// added
	@XmlElement(name="alt")
	private Alt[] alt;
	//
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
		public Alt[] getAlt ()
		{
			return alt;
		}

		public void setAnd (Alt[] alt)
		{
			this.alt = alt;
		}
		//

	@Override
	public String toString()
	{
		// Add Intents
		Intents intents = new Intents();
		List<String> inputs = new ArrayList<String>(); 
		ArrayList<String> selectfeature= new ArrayList<>();


		// Add training phrases for alt options
		inputs.add("\n\t\"I want to know the type of " +name+" that is available\"");
		inputs.add("\n\t\""+name+"\"");
		inputs.add("\n\t\"See available " +name+"\"");
		inputs.add("\n\t\"what " +name+" type is available\"");

		intents.setInputs(inputs);


		List<String> inputsYes = new ArrayList<String>();
		// Add training phrases for selection confirmation
		inputsYes.add("\n\t\"yes, I want " +name+"\"");
		inputsYes.add("\n\t\"yes\"");
		inputsYes.add("\n\t\"yes, what " + name + " is available\"" );
		inputsYes.add("\n\t\"yes I do\"");

		intents.setInputs(inputsYes);

		List<String> inputsNo = new ArrayList<String>();
		// Add training phrases for no feature selection
		inputsNo.add("\n\t\"Thanks, I do not want " +name+"\"");
		inputsNo.add("\n\t\"Thanks, but no\"");
		inputsNo.add("\n\t\"no\"");
		inputsNo.add("\n\t\"nah,I´m good\"");

		intents.setInputs(inputsNo);

		//	Add	Parameters

		ParametersAlt parameters = new ParametersAlt(feature, name, "required", "prompts");  
		List<String> paramss = new ArrayList<String>(); 
		paramss.add("parameters: \n"+ name+"_type: "+ "entity " +name.toLowerCase() +", " + "required" +", "+ "prompts"+" [\"What type of " +name+"?\"];");       
		parameters.setParamss(paramss);

		// Feature select phrases
		for(Feature ft: feature){

			selectfeature.add("\n\t(\""+ft+"\")["+name+"_type]");
			selectfeature.add("\n\t\"I want\" "+"(\""+ft+"\")["+name+"_type]");
			selectfeature.add("\n\t\"I´ll go with\" "+"(\""+ft+"\")["+name+"_type]");
			selectfeature.add("\n\t\"Give me\" "+"(\""+ft+"\")["+name+"_type]");
	
		}
		
		//**Entity**//
		Ent ent = new Ent();
		List<String> inputsEnt = new ArrayList<String>();

		// Add training phrases in the arraylist
		inputsEnt.add("Simple entity \"" +name+"\":");

		ent.setInputs(inputsEnt);
		entityName = inputsEnt.toString().substring(1, inputsEnt.toString().length() - 1) + "\n";

		String result = "\n"+name+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" \n} " + "\n";
		result += "Select_" +name+": \n ";
		result += "inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" "
				+ "\n} "+" \n ";
		result += "\n"+ paramss.toString().substring(1, paramss.toString().length() - 1) +"\n ";

		if (mandatory == null) {
			result += "Select_" +name+"_yes: \n ";
			result += "inputs {"+inputsYes.toString().substring(1, inputsYes.toString().length() - 1)+" \n} " + "\n";
			result += "Select_" +name+"_no: \n ";
			result += "inputs {"+inputsNo.toString().substring(1, inputsNo.toString().length() - 1)+" \n} " + "\n";

		}
		
		
		///added
		if(alt!= null) { 

			//added
//			for(Alt altF: alt) {
//
//				selectfeature.add("\n\t(\""+altF+"\")["+name+"_type]");
//				selectfeature.add("\n\t\"I want\" "+"(\""+altF+"\")["+name+"_type]");
//				selectfeature.add("\n\t\"I´ll go with\" "+"(\""+altF+"\")["+name+"_type]");
//				selectfeature.add("\n\t\"Give me\" "+"(\""+altF+"\")["+name+"_type]");
//
//			}
			///////////
			String s=(s=Arrays.toString(alt)).substring(1,s.length()-1); 
			result += s
					
					+" \n ";}
		////////

		return result;

	}

}
