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

		// Add training phrases or feature options
		inputs.add("\n\t\"I want to know the type of " +name+" that is available\"");
		inputs.add("\n\t\""+name+"\"");
		inputs.add("\n\t\"See available " +name+"\"");
		inputs.add("\n\t\"what " +name+" type is available\"");

		intents.setInputs(inputs);

		// added
		List<String> inputsYes = new ArrayList<String>();
		// Add training phrases for or yes confirmation
		inputsYes.add("\n\t\"yes, I want " +name+"\"");
		inputsYes.add("\n\t\""+name+"\"");
		inputsYes.add("\n\t\"yes\"");
		inputsYes.add("\n\t\"yes, what " + name + " is available\"" );
		inputsYes.add("\n\t\"yes I do\"");

		intents.setInputs(inputsYes);

		List<String> inputsNo = new ArrayList<String>();
		// Add training phrases for or no selection
		inputsNo.add("\n\t\"Thanks, I do not want " +name+"\"");
		inputsNo.add("\n\t\"Thanks, but no\"");
		inputsNo.add("\n\t\"no\"");
		inputsNo.add("\n\t\"nah,I´m good\"");

		intents.setInputs(inputsNo);

		//	Add	Parameters

		Parameters parameters = new Parameters(feature, name, "isList", "required", "prompts");  
		List<String> paramss = new ArrayList<String>(); 
		// paramss.add("parameters: \n"+ pName +": "+ "entity " +name +", " + "required" +", "+ "prompts"+" [\"What type of " +name+"?\"]");
		paramss.add("parameters: \n"+ name+"_type: "+ "entity " +name.toLowerCase() +", " + "isList" +", " + "required" +", "+ "prompts"+" [\"What type of " +name+"?\"];");       
		parameters.setParamss(paramss);

		// Feature select phrases
		for(Feature ft: feature) {
			selectfeature.add("\n\t(\""+ft+"\")["+name+"_type]");
			selectfeature.add("\n\t\"I want\" "+"(\""+ft+"\")["+name+"_type]");
			selectfeature.add("\n\t\"I´ll go with\" "+"(\""+ft+"\")["+name+"_type]");
			selectfeature.add("\n\t\"Give me\" "+"(\""+ft+"\")["+name+"_type]");

		}

		String result = "\n";
		if (mandatory == null) {
			result += "Select_" +name+"_yes: \n ";
			result += "inputs {"+inputsYes.toString().substring(1, inputsYes.toString().length() - 1)+" \n} " + "\n";
			result += "Select_" +name+"_no: \n ";
			result += "inputs {"+inputsNo.toString().substring(1, inputsNo.toString().length() - 1)+" \n} " + "\n";

		}

		result += name+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" \n} " + "\n";

		//String result = name+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" } " + "\n";
		result += "Select_" +name+": \n ";
		result += "inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" \n} "+" \n ";
		result += "\n"+ paramss.toString().substring(1, paramss.toString().length() - 1);

		return result;

	}
}
