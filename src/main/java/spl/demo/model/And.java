package spl.demo.model;

import java.lang.reflect.Array;
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
	//added
	//	static ArrayList<String> selectfeature= new ArrayList<>();


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

	@Override
	public String toString()
	{    
		List<String> inputs = new ArrayList<String>();
		//Add training phrases
		inputs.add("\n\t\"What are the support features for " +name +"\"");
		inputs.add("\n\t\"What feature is supported by " +name +"\"");
		inputs.add("\n\t\"What is the support feature for " +name +"\"");

		intents.setInputs(inputs);

		String result = "\n";

		result += name+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" \n} ";

		if(feature!= null) {
			for(int i=0; i< feature.length; i++){

				List<String> selectFeature = new ArrayList<String>();

				// Add training phrases for selection confirmation
				selectFeature.add("\n\t(\""+feature[i]+"\")["+feature[i]+"_type]");
				selectFeature.add("\n\t\"I want\" "+"(\""+feature[i]+"\")["+feature[i]+"_type]");
				selectFeature.add("\n\t\"I´ll go with\" "+"(\""+feature[i]+"\")["+feature[i]+"_type]");
				selectFeature.add("\n\t\"Give me\" "+"(\""+feature[i]+"\")["+feature[i]+"_type]");

				intents.setInputs(selectFeature);

				List<String> inputsYes = new ArrayList<String>();
				// Add training phrases for selection confirmation
				inputsYes.add("\n\t\"yes, I want " +feature[i]+"\"");
				inputsYes.add("\n\t\"yes\"");
				inputsYes.add("\n\t\"yes I do\"");

				intents.setInputs(inputsYes);


				List<String> inputsNo = new ArrayList<String>();
				// Add training phrases for no feature selection
				inputsNo.add("\n\t\"Thanks, I do not want " +feature[i]+"\"");
				inputsNo.add("\n\t\"Thanks, but no\"");
				inputsNo.add("\n\t\"no\"");
				inputsNo.add("\n\t\"nah,I´m good\"");

				intents.setInputs(inputsNo);
				
				//added
//				Add	Parameters

				ParametersAlt parameters = new ParametersAlt(feature, name, "required", "prompts");  
				List<String> paramss = new ArrayList<String>(); 
				paramss.add("parameters: \n"+ feature[i]+"_type: "+ "entity " +feature[i].toString().toLowerCase() +", " + "required" +", "+ "prompts"+" [\"enter " +feature[i]+"?\"];");       
				parameters.setParamss(paramss);


				result += "\n"+feature[i]+": \n inputs {\n\t";
				result += selectFeature.toString().substring(1, selectFeature.toString().length() - 1)+" \n} " + "\n";


				result += "Select_" +feature[i]+"_yes: \n ";
				result += "inputs {"+inputsYes.toString().substring(1, inputsYes.toString().length() - 1)+" \n} " + "\n";
				result += "Select_" +feature[i]+"_no: \n ";
				result += "inputs {"+inputsNo.toString().substring(1, inputsNo.toString().length() - 1)+" \n} " + "\n";
				result += "\n"+ paramss.toString().substring(1, paramss.toString().length() - 1) +"\n ";

			}

		}

		if(and!= null) { 
			String s=(s=Arrays.toString(and)).substring(1,s.length()-1); 
			result += s
					+" \n ";}

		//		if(and!= null) { result += Arrays.toString(and).replace(',', ' ') //remove the commas
		//			    .replace("[", "")  //remove the right bracket
		//			    .replace("]", "")  //remove the left bracket
		//			    .trim()
		//		+" \n ";}
		if(alt!= null) { result += alt+" \n ";}
		if(or!= null) {result += or+" \n ";}
		return result;

	}



}
