package spl.demo;

import spl.demo.model. *;
import org.xtext.botGenerator.generator.BotPlatformStandAlone;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;
public class App {
	static File file = new File("/Users/usuario/Documents/eclipse4/SPLBots/src/p1.xml");
	static XPath xp;
	static NodeList nlist, AList, andFeat, sNode, sNodeAnd, sNodeAndFeat, sNodeAlt, sNodeOr, aNode, bNode;
	static NodeList flist, optionalFeat, mandatoryFeat, andMandFeat, andOptFeat, mandatoryAlt, optionalAlt, optAltFeat, manAltFeat, mandatoryOr, optionalOr, altFeat, orFeat, altFeatNxt, orFeatNxt, altNxt, orNxt, optionalAndFeat, mandatoryAndFeat;

	static ArrayList<String> greetinputs= new ArrayList<>();
	static ArrayList<String> helpinputs= new ArrayList<>();
	static ArrayList<String> helpyesinputs= new ArrayList<>();
	static ArrayList<String> helpnoinputs= new ArrayList<>();

	static ArrayList<String> greetresponse= new ArrayList<>();
	static ArrayList<String> helpresponse= new ArrayList<>();
	static ArrayList<String> helpyesresponse= new ArrayList<>();
	static ArrayList<String> helpnoresponse= new ArrayList<>();

	static ArrayList<String> usergreeting= new ArrayList<>();
	static ArrayList<String> userhelp= new ArrayList<>();
	static String listSynonymns;
	static String name, listTypes, names, nameNav;



	public static void main(String args[]) throws JAXBException, XPathException, ParserConfigurationException, SAXException, IOException, FileNotFoundException{
		try
		{
		if (file.exists()){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder loader = factory.newDocumentBuilder();
		Document document = loader.parse(file);
		xp = XPathFactory.newInstance().newXPath();
		//check structure
		nlist = (NodeList)xp.compile("//and").evaluate(document, XPathConstants.NODESET);
		String fileName = xp.compile("./@name").evaluate(nlist.item(0)).replaceAll(" ", "");     
		// Creating a File object that represents the disk file. 
		String outName = fileName+"Bot.bot"; 
		PrintStream outFile = new PrintStream(new File(fileName+"Bot.bot")); 

		// Assign o to output stream 
		System.setOut(outFile); 
		
		JAXBContext jaxbContext = JAXBContext.newInstance(FeatureModel.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		FeatureModel featureModel = (FeatureModel) jaxbUnmarshaller.unmarshal(file);

		printBotName();
		System.out.println(featureModel);  
		System.out.println("entities:");
		printEntity();
		printAction();
		printflow();
		
		
		//pass file to Bot generator
		BotPlatformStandAlone generator = BotPlatformStandAlone.getBotPlatformStandAlone();
		generator.runGenerator("/Users/usuario/Documents/eclipse4/SPLBots/"+outName, "src-gen");
//		
		
		}
		}
	catch (Exception ex)
	{
		System.out.println(ex.getMessage());
	}
	}
	//print Bot name and language
	public static void printBotName() throws XPathExpressionException{ 
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder loader = factory.newDocumentBuilder();
			Document document = loader.parse(file);
			xp = XPathFactory.newInstance().newXPath();

			//check structure
			nlist = (NodeList)xp.compile("//and").evaluate(document, XPathConstants.NODESET);
			String bName = xp.compile("./@name").evaluate(nlist.item(0)).replaceAll(" ", "");
			System.out.println("Chatbot " +bName+"Bot language: en \n\n intents:");
			GreetingIntent();
			HelpIntent();
			HelpYesIntent();
			HelpNoIntent();


		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}   
	public static void GreetingIntent() {
		//standard greeting
		greetinputs.add("\n\t\"Howdy\"");
		greetinputs.add("\n\t\"Hi\"");
		greetinputs.add("\n\t\"Hello\"");
		greetinputs.add("\n\t\"Hey\"");
		greetinputs.add("\n\t\"Heya\"");
		greetinputs.add("\n\t\"hey there\"");
		greetinputs.add("\n\t\"good morning\"");
		greetinputs.add("\n\t\"good afternoon\"");
		greetinputs.add("\n\t\"good evening\"");

		System.out.println("Greeting: \n inputs {"+greetinputs.toString().substring(1, greetinputs.toString().length() - 1)+" \n} " );

	} 

	public static void HelpIntent() {
		//standard help
		helpinputs.add("\n\t\"Can you help me\"");
		helpinputs.add("\n\t\"I need help\"");
		helpinputs.add("\n\t\"what can I do\"");
		helpinputs.add("\n\t\"what can you do\"");

		System.out.println("Help: \n inputs {"+helpinputs.toString().substring(1, helpinputs.toString().length() - 1)+" \n} " );

	} 
	public static void HelpYesIntent() {
		//standard help confirmation
		helpyesinputs.add("\n\t\"I need help with selecting a configuration\"");
		helpyesinputs.add("\n\t\"Yes\"");
		helpyesinputs.add("\n\t\"yes I want to select a configuration\"");
		helpyesinputs.add("\n\t\"yes I would like to choose a configuration\"");
		helpyesinputs.add("\n\t\"ys what features do you have\"");
		helpyesinputs.add("\n\t\"yes what features are available\"");
		helpyesinputs.add("\n\t\"yes I´d love to\"");
		helpyesinputs.add("\n\t\"why not\"");
		helpyesinputs.add("\n\t\"yes I do\"");

		System.out.println("Help_yes: \n inputs {"+helpyesinputs.toString().substring(1, helpyesinputs.toString().length() - 1)+" \n} " );

	} 
	public static void HelpNoIntent() {
		//standard help
		helpnoinputs.add("\n\t\"Thanks, but no\"");
		helpnoinputs.add("\n\t\"No\"");
		helpnoinputs.add("\n\t\"nah,I´m good\"");
		helpnoinputs.add("\n\t\"not at all\"");
		helpnoinputs.add("\n\t\"never\"");
		helpnoinputs.add("\n\t\"no way\"");


		System.out.println("Help_no: \n inputs {"+helpnoinputs.toString().substring(1, helpnoinputs.toString().length() - 1)+" \n} " );

	} 


	//**************actions********************//
	public static void GreetingResponse() {
		//standard greeting
		greetresponse.add("\n\t\"Hello there! I am here to help you with configuring your software product line. Would you like to proceed?\"");
		greetresponse.add("\n\t\"Hi, welcome to SPLBot! Would you like to select a configuration?\"");
		greetresponse.add("\n\t\"Hi, welcome to SPLBot! Do you need help?\"");
		greetresponse.add("\n\t\"Hi, welcome to SPLBot! What can I help you with?\"");

		System.out.println("text response GreetingResponse: \n inputs {\n"+greetresponse.toString().substring(1, greetresponse.toString().length() - 1)+" \n} " );

	} 

	public static void HelpResponse() {
		//standard help
		helpresponse.add("\n\t\"yes, I can help you with configuring your software product line. Would you like to proceed?\"");
		helpresponse.add("\n\t\"I can help you with configuring your software product line. Would you like to proceed?\"");

		System.out.println("text response HelpResponse: \n inputs {\n"+helpresponse.toString().substring(1, helpresponse.toString().length() - 1)+" \n} " );

	} 

	public static void HelpNoResponse() {
		//standard help
		helpnoresponse.add("\n\t\"Thank you for using SPLBot!\"");

		System.out.println("text response Help_noResponse: \n inputs {\n"+helpnoresponse.toString().substring(1, helpnoresponse.toString().length() - 1)+" \n} " );

	}    

	//**************flows********************//
	public static void UserGreeting() {
		//greeting flow
		usergreeting.add("- user Greeting => chatbot GreetingResponse{ \n"
				+ "=> user Help_yes => chatbot Help_yesResponse;\n"
				+ "=> user Help_no => chatbot Help_noResponse;\n"
				+ "\n};");

		System.out.println(usergreeting.toString().substring(1, usergreeting.toString().length() - 1)+" \n " );

	} 

	public static void UserHelp() {
		// help flow
		userhelp.add("- user Help => chatbot HelpResponse{ \n"
				+ "=> user Help_yes => chatbot Help_yesResponse;\n"
				+ "=> user Help_no => chatbot Help_noResponse;\n"
				+ "\n};");

		System.out.println(userhelp.toString().substring(1, userhelp.toString().length() - 1)+" \n " );

	}
	
	//**************flows********************//
//		public static void nodeNav() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder loader = factory.newDocumentBuilder();
//			Document document = loader.parse(file);
//			xp = XPathFactory.newInstance().newXPath();
//			NodeList nextCall = (NodeList)xp.compile("/featureModel/struct/and/feature|/featureModel/struct/and//and/feature|/featureModel/struct/and//and|/featureModel/struct/and//alt|/featureModel/struct/and//or").evaluate(document, XPathConstants.NODESET);     
//			for (int nav = 0; nav < nextCall.getLength(); nav++) {
//
//				nameNav = xp.compile("./@name").evaluate(nextCall.item(nav));
//				if(name!=nameNav) {
//					System.out.println("\t\" Would you like "  +nameNav+"? If yes, enter " + nameNav+"\"");
//				}
//			}	
//
//		} 

	//**************Entity********************//
	public static void printEntity() throws XPathExpressionException{ 
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder loader = factory.newDocumentBuilder();
			Document document = loader.parse(file);
			xp = XPathFactory.newInstance().newXPath();

			//check structure
			nlist = (NodeList)xp.compile(".//alt").evaluate(document, XPathConstants.NODESET);
			NodeList flistAlt = (NodeList)xp.compile(".//alt//feature").evaluate(document, XPathConstants.NODESET);
			NodeList flistOr = (NodeList)xp.compile(".//or//feature").evaluate(document, XPathConstants.NODESET);  

			//*************************************************************//
			//first Alt level
			altFeat = (NodeList)xp.compile("/featureModel/struct/and/alt/feature").evaluate(document, XPathConstants.NODESET);     
			orFeat = (NodeList)xp.compile("/featureModel/struct/and/or/feature").evaluate(document, XPathConstants.NODESET);     

			//other levels Alt Feature
			altFeatNxt = (NodeList)xp.compile("/featureModel/struct/and/alt//alt/feature").evaluate(document, XPathConstants.NODESET);     
			orFeatNxt = (NodeList)xp.compile("/featureModel/struct/and/or//or/feature").evaluate(document, XPathConstants.NODESET);     


			//other levels Alt 
			altNxt = (NodeList)xp.compile("/featureModel/struct/and/alt//alt").evaluate(document, XPathConstants.NODESET);     
			orNxt = (NodeList)xp.compile("/featureModel/struct/and/or//or").evaluate(document, XPathConstants.NODESET);     

			//*************************************************************//

			//Alt next level
			nlist = (NodeList)xp.compile("/featureModel/struct/and/alt//alt").evaluate(document, XPathConstants.NODESET);

			for (int i = 0; i < nlist.getLength(); i++) {
				
				//System.out.println("Simple entity \"" +xp.compile("./@name").evaluate(nlist.item(i))+"\":\n inputs in en{ ");
				name = xp.compile("./@name").evaluate(nlist.item(i));
				System.out.println("Simple entity \"" +name.toLowerCase()+"\":\n inputs in en{ ");
				
				//child of alt
				for (int j = 0; j < altFeatNxt.getLength(); j++) {

					name = xp.compile("./@name").evaluate(altFeatNxt.item(j)); 

					System.out.println("\""+name+"\" synonyms \"" +printSynonymn()+"\"");

				}
				System.out.println("\n}");	
			}

			//Alt first child
			nlist = (NodeList)xp.compile("/featureModel/struct/and/alt").evaluate(document, XPathConstants.NODESET);
			flist = (NodeList)xp.compile("/featureModel/struct/and/alt/feature|/featureModel/struct/and/alt/alt|/featureModel/struct/and/alt/or|/featureModel/struct/and/alt/and").evaluate(document, XPathConstants.NODESET);

			for (int i = 0; i < nlist.getLength(); i++) {	 
				name = xp.compile("./@name").evaluate(nlist.item(i));
			System.out.println("Simple entity \"" +name.toLowerCase()+"\":\n inputs in en{ ");
			for (int j = 0; j < flist.getLength(); j++) {

				name = xp.compile("./@name").evaluate(flist.item(j)); 

				System.out.println("\""+name+"\" synonyms \""+printSynonymn()+"\"");

			}
			System.out.println("\n}");	
			}

			//or
			nlist = (NodeList)xp.compile("//or").evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nlist.getLength(); i++) {
				name = xp.compile("./@name").evaluate(nlist.item(i));
				System.out.println("Simple entity \"" +name.toLowerCase()+"\":\n inputs in en{ ");


				for (int j = 0; j < flistOr.getLength(); j++) {
					name = xp.compile("./@name").evaluate(flistOr.item(j));

					System.out.println("\""+name+"\" synonyms \"" +printSynonymn()+"\"");

				}

				System.out.println("\n}");
			}

			//**************and********************//
			//and
			andFeat = (NodeList)xp.compile("/featureModel/struct/and/feature|/featureModel/struct/and//and/feature").evaluate(document, XPathConstants.NODESET);     
			for (int i = 0; i < andFeat.getLength(); i++) {

				name = xp.compile("./@name").evaluate(andFeat.item(i));
				System.out.println("Simple entity \"" +name.toLowerCase()+"\":\n inputs in en{ ");

				System.out.println("\""+name+"\" synonyms \""  +printSynonymn()+"\"");

				System.out.println("\n}");

			}  

		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}


	} 

	//action
	public static void printAction() throws XPathExpressionException {
		System.out.println("\n actions:");
		GreetingResponse();
		HelpResponse();
		//HelpYesResponse();
		HelpNoResponse();
		actionFeatures();
	} 

	//action
	public static void actionFeatures() throws XPathExpressionException{ 
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder loader = factory.newDocumentBuilder();
			Document document = loader.parse(file);
			xp = XPathFactory.newInstance().newXPath();

			//check structure
			AList = (NodeList)xp.compile("//and//alt|//and//or|//and/feature").evaluate(document, XPathConstants.NODESET);
			sNode = (NodeList)xp.compile("/featureModel/struct/and/alt|/featureModel/struct/and/or|/featureModel/struct/and/feature|/featureModel/struct/and/and").evaluate(document, XPathConstants.NODESET);
			aNode = (NodeList)xp.compile("/featureModel/struct/and/feature").evaluate(document, XPathConstants.NODESET);
			bNode = (NodeList)xp.compile("/featureModel/struct/and/and").evaluate(document, XPathConstants.NODESET);


			sNodeAnd = (NodeList)xp.compile("/featureModel/struct/and/alt|/featureModel/struct/and/or|/featureModel/struct/and/feature").evaluate(document, XPathConstants.NODESET);
			sNodeAndFeat = (NodeList)xp.compile("/featureModel/struct/and/alt|/featureModel/struct/and/or|/featureModel/struct/and/feature").evaluate(document, XPathConstants.NODESET);
			sNodeAlt = (NodeList)xp.compile("/featureModel/struct/and/alt|/featureModel/struct/and/or|/featureModel/struct/and/feature").evaluate(document, XPathConstants.NODESET);
			sNodeOr = (NodeList)xp.compile("/featureModel/struct/and/alt|/featureModel/struct/and/or|/featureModel/struct/and/feature").evaluate(document, XPathConstants.NODESET);

			//*************************************************************//
			//first Alt level
			altFeat = (NodeList)xp.compile("/featureModel/struct/and/alt/feature").evaluate(document, XPathConstants.NODESET);     
			orFeat = (NodeList)xp.compile("/featureModel/struct/and/or/feature").evaluate(document, XPathConstants.NODESET);     

			//other levels Alt Feature
			altFeatNxt = (NodeList)xp.compile("/featureModel/struct/and/alt//alt/feature").evaluate(document, XPathConstants.NODESET);     
			orFeatNxt = (NodeList)xp.compile("/featureModel/struct/and/or//or/feature").evaluate(document, XPathConstants.NODESET);     


			//other levels Alt 
			altNxt = (NodeList)xp.compile("/featureModel/struct/and/alt//alt").evaluate(document, XPathConstants.NODESET);     
			orNxt = (NodeList)xp.compile("/featureModel/struct/and/or//or").evaluate(document, XPathConstants.NODESET);     

			//*************************************************************//


			nlist = (NodeList)xp.compile("//and//alt").evaluate(document, XPathConstants.NODESET);
			NodeList flistAlt = (NodeList)xp.compile("//alt//feature").evaluate(document, XPathConstants.NODESET);
			NodeList flistOr = (NodeList)xp.compile("//or//feature").evaluate(document, XPathConstants.NODESET);
			//start
			System.out.println("text response Help_yesResponse: \n inputs {\n \""+"Great! To begin, enter "  +xp.compile("./@name").evaluate(sNode.item(0))+"\"\n } ");

			

			//the first level Optional feature under fist and
			optionalFeat = (NodeList)xp.compile("/featureModel/struct/and/feature[not(contains(@mandatory, 'true'))]").evaluate(document, XPathConstants.NODESET);     
			mandatoryFeat = (NodeList)xp.compile("/featureModel/struct/and/feature[@mandatory='true']").evaluate(document, XPathConstants.NODESET);     

			for (int i = 0; i < optionalFeat.getLength(); i++) {

				name = xp.compile("./@name").evaluate(optionalFeat.item(i));
				System.out.println("text response "+name+"Prompt: \n inputs {\n \""+"Would you like "  +name+"? If yes, enter " + name + " to select\"");
				System.out.println("\n}");

				//selection response
				System.out.println("text response "+name+"Response: \n inputs {\n \""+"You have selected the feature: \"" +"\n [\""+ "Select_" +name+"."+name+"_type\"]");
				//*************************************************************//
				//next node
//				NodeList nextCall = (NodeList)xp.compile("/featureModel/struct/and/feature|/featureModel/struct/and//and/feature|/featureModel/struct/and//and|/featureModel/struct/and//alt|/featureModel/struct/and//or").evaluate(document, XPathConstants.NODESET);     
//				for (int nav = 0; nav < nextCall.getLength(); nav++) {
//	
//					nameNav = xp.compile("./@name").evaluate(nextCall.item(nav));
//					if(name!=nameNav) {
//						System.out.println("\t\" Would you like "  +nameNav+"? If yes, enter " + nameNav+"\"");
//					}
//				}
				
				//nodeNav();

				//*************************************************************//
				//*******************added nav
//				if(nameNav==name) {
//				if(nav < nextCall.getLength()-1) {System.out.print("do you want "+ xp.compile("./@name").evaluate(nextCall.item(nav+1)));}
//				else {
//					System.out.println("you are done with your configuration");
//				}
//				}
				System.out.println("\n}");

			}
			//the first level Mandatory feature under fist and	  
			for (int k = 0; k < mandatoryFeat.getLength(); k++) {
				name = xp.compile("./@name").evaluate(mandatoryFeat.item(k));
				System.out.println("text response "+name+"Prompt: \n inputs {\n \""+"enter " + name + " to select\"");
				System.out.println("\n}");

				//selection response
				System.out.println("text response "+name+"Response: \n inputs {\n \""+"You have selected the feature: \"" +"\n [\""+ "Select_" +name+"."+name+"_type\"]");
				//*************************************************************//
				//next node
//				NodeList nextCall = (NodeList)xp.compile("/featureModel/struct/and/feature|/featureModel/struct/and//and/feature|/featureModel/struct/and//and|/featureModel/struct/and//alt|/featureModel/struct/and//or").evaluate(document, XPathConstants.NODESET);     
//				for (int nav = 0; nav < nextCall.getLength(); nav++) {
//	
//					nameNav = xp.compile("./@name").evaluate(nextCall.item(nav));
//					if(name!=nameNav) {
//						System.out.println("\t\" Would you like "  +nameNav+"? If yes, enter " + nameNav+"\"");
//					}
//				}
				
				//nodeNav();

				//*************************************************************//
				//*******************added nav
//				if(nameNav==name) {
//				if(nav < nextCall.getLength()-1) {System.out.print("do you want "+ xp.compile("./@name").evaluate(nextCall.item(nav+1)));}
//				else {
//					System.out.println("you are done with your configuration");
//				}
//				}
				
				System.out.println("\n}");

			}

			//other level features under and other than the first level parent node
			nlist = (NodeList)xp.compile("/featureModel/struct/and//and/feature/..").evaluate(document, XPathConstants.NODESET);     
			andOptFeat = (NodeList)xp.compile("/featureModel/struct/and//and[not(contains(@mandatory, 'true'))]/feature/..").evaluate(document, XPathConstants.NODESET);     
			andMandFeat = (NodeList)xp.compile("/featureModel/struct/and//and[@mandatory='true']/feature/..").evaluate(document, XPathConstants.NODESET);     

			//optioal And
			for (int j = 0; j < andOptFeat.getLength(); j++) {
				name = xp.compile("./@name").evaluate(andOptFeat.item(j));
				System.out.println("text response "+name+"Prompt: \n inputs {\n \""+"Would you like "+name+"? If yes, enter " + name + " to see available feature(s) to select\"");  
				System.out.println("\n}");

			}	


			//Mandatory And

			for (int i = 0; i < andMandFeat.getLength(); i++) {
				name = xp.compile("./@name").evaluate(andMandFeat.item(i));
				System.out.println("text response "+name+"Prompt: \n inputs {\n \""+"Enter " + name + " to see the available feature(s) to select\"");  
				System.out.println("\n}");

			}	 
			//***********************************************************************************// 

			//the other level Optional feature under and
			optionalAndFeat = (NodeList)xp.compile("/featureModel/struct/and//and/feature[not(contains(@mandatory, 'true'))]").evaluate(document, XPathConstants.NODESET);     
			mandatoryAndFeat = (NodeList)xp.compile("/featureModel/struct/and//and/feature[@mandatory='true']").evaluate(document, XPathConstants.NODESET);     

			for (int i = 0; i < optionalAndFeat.getLength(); i++) {

				name = xp.compile("./@name").evaluate(optionalAndFeat.item(i));
				System.out.println("text response "+name+"Prompt: \n inputs {\n \""+"Would you like "  +name+"? If yes, enter " + name + " to select\"");
				System.out.println("\n}");
				//added
				//selection response
				System.out.println("text response "+name+"Response: \n inputs {\n \""+"You have selected the feature: \"" +"\n [\""+ "Select_" +name+"."+name+"_type\"]");
				//*************************************************************//
				//next node
//				NodeList nextCall = (NodeList)xp.compile("/featureModel/struct/and/feature|/featureModel/struct/and//and/feature|/featureModel/struct/and//and|/featureModel/struct/and//alt|/featureModel/struct/and//or").evaluate(document, XPathConstants.NODESET);     
//				for (int nav = 0; nav < nextCall.getLength(); nav++) {
//	
//					nameNav = xp.compile("./@name").evaluate(nextCall.item(nav));
//					if(name!=nameNav) {
//						System.out.println("\t\" Would you like "  +nameNav+"? If yes, enter " + nameNav+"\"");
//					}
//				}
				
				//nodeNav();

				//*************************************************************//
				System.out.println("\n}");

			}
			//the first level Mandatory feature under fist and	  
			for (int k = 0; k < mandatoryAndFeat.getLength(); k++) {
				name = xp.compile("./@name").evaluate(mandatoryAndFeat.item(k));	 	 

				System.out.println("text response "+name+"Prompt: \n inputs {\n \""+"enter " + name + " to select\"");
				System.out.println("\n}");

				//selection response
				System.out.println("text response "+name+"Response: \n inputs {\n \""+"You have selected the feature: \"" +"\n [\""+ "Select_" +name+"."+name+"_type\"]");
				//*************************************************************//
				//next node
				NodeList nextCall = (NodeList)xp.compile("/featureModel/struct/and/feature|/featureModel/struct/and//and/feature|/featureModel/struct/and//and|/featureModel/struct/and//alt|/featureModel/struct/and//or").evaluate(document, XPathConstants.NODESET);     
				for (int nav = 0; nav < nextCall.getLength(); nav++) {
	
					nameNav = xp.compile("./@name").evaluate(nextCall.item(nav));
					if(name!=nameNav) {
						System.out.println("\t\" Would you like "  +nameNav+"? If yes, enter " + nameNav+"\"");
					}
				}
				
				//nodeNav();

				//*************************************************************//
				System.out.println("\n}");
			} 

			//***********************************************************************************// 



			//*************************************************************//
			//Alternative level1 
			optionalAlt = (NodeList)xp.compile("/featureModel/struct/and//alt[not(contains(@mandatory, 'true'))]").evaluate(document, XPathConstants.NODESET);     
			mandatoryAlt = (NodeList)xp.compile("/featureModel/struct/and//alt[@mandatory='true']").evaluate(document, XPathConstants.NODESET);     

			for (int i = 0; i < optionalAlt.getLength(); i++) {

				name = xp.compile("./@name").evaluate(optionalAlt.item(i));
				System.out.println("text response "+name+"Prompt: \n inputs {\n \""+"Would you like "  +name+"? If yes, enter " + name + " to see available features\"");
				System.out.println("\n}");
				//selection response
				System.out.println("text response "+name+"Response: \n inputs {\n \""+"You have selected the feature: \"" +"\n [\""+ "Select_" +name+"."+name+"_type\"]");
				System.out.println("\n}");
				
				//*************************************************************//
				//next node
				NodeList nextCall = (NodeList)xp.compile("/featureModel/struct/and/feature|/featureModel/struct/and//and/feature|/featureModel/struct/and//and|/featureModel/struct/and//alt|/featureModel/struct/and//or").evaluate(document, XPathConstants.NODESET);     
				for (int nav = 0; nav < nextCall.getLength(); nav++) {
	
					nameNav = xp.compile("./@name").evaluate(nextCall.item(nav));
					if(name!=nameNav) {
						System.out.println("\t\" Would you like "  +nameNav+"? If yes, enter " + nameNav+"\"");
					}
				}
				
				//nodeNav();

				//*************************************************************//
			}
			//the first level Mandatory feature under fist and	  
			for (int k = 0; k < mandatoryAlt.getLength(); k++) {
				name = xp.compile("./@name").evaluate(mandatoryAlt.item(k));
				System.out.println("text response "+name+"Prompt: \n inputs {\n \""+"enter " + name + " to see available feature(s) to select\"");
				System.out.println("\n}");
				//selection response
				System.out.println("text response "+name+"Response: \n inputs {\n \""+"You have selected the feature: \"" +"\n [\""+ "Select_" +name+"."+name+"_type\"]");

				//*************************************************************//
				//next node
//				NodeList nextCall = (NodeList)xp.compile("/featureModel/struct/and/feature|/featureModel/struct/and//and/feature|/featureModel/struct/and//and|/featureModel/struct/and//alt|/featureModel/struct/and//or").evaluate(document, XPathConstants.NODESET);     
//				for (int nav = 0; nav < nextCall.getLength(); nav++) {
//	
//					nameNav = xp.compile("./@name").evaluate(nextCall.item(nav));
//					if(name!=nameNav) {
//						System.out.println("\t\" Would you like "  +nameNav+"? If yes, enter " + nameNav+"\"");
//					}
//				}
				
				//nodeNav();

				//*************************************************************//
				System.out.println("\n}");
				
				
				
			}
			//*************************************************************//
			//Or  level 1     

			optionalOr = (NodeList)xp.compile("/featureModel/struct/and//or[not(contains(@mandatory, 'true'))]").evaluate(document, XPathConstants.NODESET);     
			mandatoryOr = (NodeList)xp.compile("/featureModel/struct/and//or[@mandatory='true']").evaluate(document, XPathConstants.NODESET);     

			for (int i = 0; i < optionalOr.getLength(); i++) {

				name = xp.compile("./@name").evaluate(optionalOr.item(i));
				System.out.println("text response "+name+"Prompt: \n inputs {\n \""+"Would you like "  +name+"? If yes, enter " + name + " to select\"");
				System.out.println("\n}");

				System.out.println("text response "+name+"Response: \n inputs {\n \""+"You have selected the feature: \"" +"\n [\""+ "Select_" +name+"."+name+"_type\"]");
				//*************************************************************//
				//next node
//				NodeList nextCall = (NodeList)xp.compile("/featureModel/struct/and/feature|/featureModel/struct/and//and/feature|/featureModel/struct/and//and|/featureModel/struct/and//alt|/featureModel/struct/and//or").evaluate(document, XPathConstants.NODESET);     
//				for (int nav = 0; nav < nextCall.getLength(); nav++) {
//	
//					nameNav = xp.compile("./@name").evaluate(nextCall.item(nav));
//					if(name!=nameNav) {
//						
//						System.out.println("\t\" Would you like "  +nameNav+"? If yes, enter " + nameNav+"\"");
//					
//					}
//				}
				
				//nodeNav();

				//*************************************************************//
				System.out.println("\n}");
			}
			//the first level Mandatory feature under fist and	  
			for (int k = 0; k < mandatoryOr.getLength(); k++) {
				name = xp.compile("./@name").evaluate(mandatoryOr.item(k));
				System.out.println("text response "+name+"Prompt: \n inputs {\n \""+"enter " + name + " to select\"");
				System.out.println("\n}");

				System.out.println("text response "+name+"Response: \n inputs {\n \""+"You have selected the feature: \"" +"\n [\""+ "Select_" +name+"."+name+"_type\"]");
				//*************************************************************//
				//next node
//				NodeList nextCall = (NodeList)xp.compile("/featureModel/struct/and/feature|/featureModel/struct/and//and/feature|/featureModel/struct/and//and|/featureModel/struct/and//alt|/featureModel/struct/and//or").evaluate(document, XPathConstants.NODESET);     
//				for (int nav = 0; nav < nextCall.getLength(); nav++) {
//	
//					nameNav = xp.compile("./@name").evaluate(nextCall.item(nav));
//					if(name!=nameNav) {
//						System.out.println("\t\" Would you like "  +nameNav+"? If yes, enter " + nameNav+"\"");
//					}
//				}
				
				//nodeNav();

				//*************************************************************//
				System.out.println("\n}");
			}

			
			
			
			//*************************************************************//

			//Display alt and or options

			//Alt next level
			nlist = (NodeList)xp.compile("/featureModel/struct/and/alt//alt").evaluate(document, XPathConstants.NODESET);

			for (int i = 0; i < nlist.getLength(); i++) {
				System.out.println("text response " +xp.compile("./@name").evaluate(nlist.item(i))+"Type:\n inputs{ ");
				System.out.println("\"You can only select one of the following features:");
				//child of alt
				for (int j = 0; j < altFeatNxt.getLength(); j++) {

					name = xp.compile("./@name").evaluate(altFeatNxt.item(j)); 
					System.out.print(name);
					if(j != altFeatNxt.getLength()-1){System.out.print(", ");}
					

				}
				System.out.print("\"");
				System.out.println("\n}");	
			}

			//Alt first child
			nlist = (NodeList)xp.compile("/featureModel/struct/and/alt").evaluate(document, XPathConstants.NODESET);
			flist = (NodeList)xp.compile("/featureModel/struct/and/alt/feature|/featureModel/struct/and/alt/alt|/featureModel/struct/and/alt/or|/featureModel/struct/and/alt/and").evaluate(document, XPathConstants.NODESET);

			for (int i = 0; i < nlist.getLength(); i++) {
				System.out.println("text response " +xp.compile("./@name").evaluate(nlist.item(i))+"Type:\n inputs{ ");
				System.out.println("\"You can only choose one feature from these list of features:");

				for (int j = 0; j < flist.getLength(); j++) {

					name = xp.compile("./@name").evaluate(flist.item(j)); 

					System.out.print(name);

					if(j != flist.getLength()-1){System.out.print(", ");}
				}
				System.out.print("\"");
				System.out.println("\n}");	
			}

			//or
			nlist = (NodeList)xp.compile("//or").evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nlist.getLength(); i++) {
				System.out.println("text response " +xp.compile("./@name").evaluate(nlist.item(i))+"Type:\n inputs{ ");
				System.out.println("\"You can choose one or more of the following features:");

				for (int j = 0; j < flistOr.getLength(); j++) {
					name = xp.compile("./@name").evaluate(flistOr.item(j));

					System.out.print(name);
					if(j != flistOr.getLength()-1) {System.out.print(", ");}

				}
				System.out.print("\"");
				System.out.println("\n}");

			}
			//*************************************************************//
			
//		}//end for nav
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}  
	//flow

	public static void printflow() throws XPathExpressionException {
		System.out.println("flows:");
		UserGreeting();
		UserHelp();
		printfFlows();

	}


	//method to print Bot name and language
	public static void printfFlows() throws XPathExpressionException{ 

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder loader = factory.newDocumentBuilder();
			Document document = loader.parse(file);
			xp = XPathFactory.newInstance().newXPath();


			/////////////////////////// ************************//////////////////////
			String expr = null; // Used to hold the XPath expressions
			String exprM = null;
			String exprO = null;
			// Get a list of the nodes to traverse mode: from left to right
			// The following expression gets a set of nodes that have a name attribute,
			// then sets the flow value of each node using the name attribute.

			//*************************************************************//

			expr = "/featureModel/struct/and/feature[@name]/@name|/featureModel/struct/and//and/feature[@name]/@name";
			NodeList resultNodeList = (NodeList) xp.compile(expr)
					.evaluate(document, XPathConstants.NODESET);
			if (resultNodeList != null) {
				int nodeCount = resultNodeList.getLength();
				//System.out.println("2. There are " + nodeCount + " nodes:");
				for (int i = 0; i < nodeCount; i++) { 
					Node listNode = resultNodeList.item(i); 
					String name = listNode.getNodeValue();
					// System.out.println(name); 
					System.out.println("- user " +name+"  => chatbot "+name+"Type{ \n"
							+ "\t=> user \"Select_"+name+"\" => chatbot "+name+"Response;" 

		            		  + "\n};");

				}
			}

			//*************************************************************//

			expr = "/featureModel/struct/and//and[@name]/@name|/featureModel/struct/and//alt[@name]/@name|/featureModel/struct/and//or[@name]/@name";

			resultNodeList = (NodeList) xp.compile(expr)
					.evaluate(document, XPathConstants.NODESET);
			if (resultNodeList != null) {
				int nodeCount = resultNodeList.getLength();
				//System.out.println("2. There are " + nodeCount + " nodes:");
				for (int i = 0; i < nodeCount; i++) { 
					Node listNode = resultNodeList.item(i); 
					String name = listNode.getNodeValue();
					// System.out.println(name); 
					System.out.println("- user " +name+"  => chatbot "+name+"Type{ \n"
							+ "\t=> user \"Select_"+name+"\" => chatbot "+name+"Response;" 

		            		  + "\n};");

				}
			}


			//*************************************************************//

			NodeList  exprN = (NodeList)xp.compile("/featureModel/struct/and//and[not(contains(@mandatory, 'true'))]|/featureModel/struct/and//alt[not(contains(@mandatory, 'true'))]|/featureModel/struct/and//or[not(contains(@mandatory, 'true'))]").evaluate(document, XPathConstants.NODESET);

			for (int i = 0; i < exprN.getLength(); i++) {

				name = xp.compile("./@name").evaluate(exprN.item(i));
				System.out.println("- user Select_" +name+"_yes  => chatbot "+name+"Type{ \n"
						+ "\t=> user \"Select_"+name+"\" => chatbot "+name+"Response;" 

		            		  + "\n};");
			}

			//*************************************************************//
// todo how to call the next node
//			NodeList nextCall = (NodeList)xp.compile("/featureModel/struct/and/feature|/featureModel/struct/and//and/feature|/featureModel/struct/and//and|/featureModel/struct/and//alt|/featureModel/struct/and//or").evaluate(document, XPathConstants.NODESET);     
//
//			for (int i = 0; i < nextCall.getLength(); i++) {
//
//				name = xp.compile("./@name").evaluate(nextCall.item(i));
//				System.out.println("\n Next "+ name);
//				if(i < nextCall.getLength()-1) {System.out.print("do you want "+ xp.compile("./@name").evaluate(nextCall.item(i+1)));}
//				else {
//					System.out.println("you are done with your configuration");
//				}
//			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}


	}    


	public static String printSynonymn() {
		System.setProperty("wordnet.database.dir", "/Users/usuario/Documents/eclipse4/SPLBotDemoXX/src/dict");
		WordNetDatabase wordNetDatabase = WordNetDatabase.getFileInstance();
		ArrayList<String> synonyms=new ArrayList<String>();
		String wordForm = name;
		Synset[] synsets1 = wordNetDatabase.getSynsets(wordForm);
		if (synsets1.length > 0) {
			for (int i = 0; i < synsets1.length; i++) {
				String[] wordForms = synsets1[i].getWordForms();
				for (int j = 0; j < wordForms.length; j++) {
					if(!synonyms.contains(wordForms[j])){
						synonyms.add(wordForms[j]); 
					}

				}

			}
			//System.out.println(synonyms);
			listSynonymns = Arrays.toString(synonyms.toArray()).replace("[", "").replace("]", "").replace(",", "\", \"");
			//System.out.println(listSynonymns);

		}else {
			listSynonymns= name;

		}

		return listSynonymns;



	}
}  