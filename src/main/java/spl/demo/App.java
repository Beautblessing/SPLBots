package spl.demo;

import spl.demo.model. *;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;
public class App {
	static File file = new File("/Users/usuario/Documents/eclipse4/SPLBotDemos/src/p1.xml");
	static XPath xp;
	static NodeList nlist;
	static ArrayList<String> greetinputs= new ArrayList<>();
	static ArrayList<String> helpinputs= new ArrayList<>();
	static ArrayList<String> helpyesinputs= new ArrayList<>();
	static ArrayList<String> helpnoinputs= new ArrayList<>();
    
	static ArrayList<String> greetresponse= new ArrayList<>();
	static ArrayList<String> helpresponse= new ArrayList<>();
	static ArrayList<String> helpyesresponse= new ArrayList<>();
	static ArrayList<String> helpnoresponse= new ArrayList<>();
 
	static ArrayList<String> synonyms=new ArrayList<String>();
	static String listSynonymns;
	//static String listTypes; 
	static String name, listTypes;
	
	
	
	    
	public static void main(String args[]) throws JAXBException, XPathException{
        //File file = new File("/Users/usuario/Documents/eclipse4/SPLBotDemoXX/src/p1.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(FeatureModel.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        FeatureModel featureModel = (FeatureModel) jaxbUnmarshaller.unmarshal(file);
        
        printBotName();
        System.out.println(featureModel);  
        System.out.println("entities:");
        printEntity();
        printAction();
        printflow();
        
        
    }
    //method to print Bot name and language
    public static void printBotName() throws XPathExpressionException{ 
   	 try {
   		
   	 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
   	 DocumentBuilder loader = factory.newDocumentBuilder();
   	 Document document = loader.parse(file);
   	 xp = XPathFactory.newInstance().newXPath();
   	 
   	 //check structure
     nlist = (NodeList)xp.compile("//and").evaluate(document, XPathConstants.NODESET);
     System.out.println("Chatbot " +xp.compile("./@name").evaluate(nlist.item(0))+"Bot language: en \n\n intents:");
     
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
	 greetinputs.add("\"Howdy\"");
	 greetinputs.add("\"Hi\"");
	 greetinputs.add("\"Hello\"");
	 greetinputs.add("\"Hey\"");
	 greetinputs.add("\"Heya\"");
	 greetinputs.add("\"hey there\"");
	 greetinputs.add("\"good morning\"");
	 greetinputs.add("\"good afternoon\"");
	 greetinputs.add("\"good evening\"");
      
	 System.out.println("Greeting: \n inputs {"+greetinputs.toString().substring(1, greetinputs.toString().length() - 1)+" } " );
    
 } 
    
    public static void HelpIntent() {
 	 	//standard help
    	 helpinputs.add("\"Can you help me\"");
    	 helpinputs.add("\"I need help\"");
    	 helpinputs.add("\"what can I do\"");
    	 helpinputs.add("\"what can you do\"");
       
 	 System.out.println("Help: \n inputs {"+helpinputs.toString().substring(1, helpinputs.toString().length() - 1)+" } " );
     
  } 
    public static void HelpYesIntent() {
 	 	//standard help
    	 helpyesinputs.add("\"I need help with selecting a configuration\"");
    	 helpyesinputs.add("\"Yes\"");
    	 helpyesinputs.add("\"yes I want to select a configuration\"");
    	 helpyesinputs.add("\"yes I would like to choose a configuration\"");
    	 helpyesinputs.add("\"ys what features do you have\"");
    	 helpyesinputs.add("\"yes what features are available\"");
    	 helpyesinputs.add("\"yes I´d love to\"");
    	 helpyesinputs.add("\"why not\"");
    	 helpyesinputs.add("\"yes I do\"");
       
 	 System.out.println("Help_yes: \n inputs {"+helpyesinputs.toString().substring(1, helpyesinputs.toString().length() - 1)+" } " );
     
  } 
    public static void HelpNoIntent() {
 	 	//standard help
    	 helpnoinputs.add("\"Thanks, but no\"");
    	 helpnoinputs.add("\"No\"");
    	 helpnoinputs.add("\"nah,I´m good\"");
    	 helpnoinputs.add("\"not at all\"");
    	 helpnoinputs.add("\"never\"");
    	 helpnoinputs.add("\"no way\"");
    	 
    	 
 	 System.out.println("Help_no: \n inputs {"+helpnoinputs.toString().substring(1, helpnoinputs.toString().length() - 1)+" } " );
      	
  } 
  
    
    //**************actions********************//
		 public static void GreetingResponse() {
		 	//standard greeting
		 greetresponse.add("\"Hello there! I am here to help you with configuring your software product line. Would you like to proceed?\"");
		 greetresponse.add("\"Hi, welcome to SPLBot! Would you like to select a configuration?\"");
		 greetresponse.add("\"Hi, welcome to SPLBot! Do you need help?\"");
		 greetresponse.add("\"Hi, welcome to SPLBot! What can I help you with?\"");
		 
	
	      
		 System.out.println("text response GreetingResponse: \n inputs {\n"+greetresponse.toString().substring(1, greetresponse.toString().length() - 1)+" \n} " );
	    
	 } 
	    
	    public static void HelpResponse() {
	 	 	//standard help
	    	 helpresponse.add("\"yes, I can help you with configuring your software product line. Would you like to proceed?\"");
	    	 helpresponse.add("\"I can help you with configuring your software product line. Would you like to proceed?\"");
	    	
	       
	 	 System.out.println("text response HelpResponse: \n inputs {\n"+helpresponse.toString().substring(1, helpresponse.toString().length() - 1)+" \n} " );
	     
	  } 
	   
	    public static void HelpNoResponse() {
	 	 	//standard help
	    	 helpnoresponse.add("\"Thank you for using SPLBot!\"");
	    	
	 	 System.out.println("text response Help_noResponse: \n inputs {\n"+helpnoresponse.toString().substring(1, helpnoresponse.toString().length() - 1)+" \n} " );
	
	  }
    
    
   
    //method to print Bot name and language
    public static void printEntity() throws XPathExpressionException{ 
   	 try {
   		
   	 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
   	 DocumentBuilder loader = factory.newDocumentBuilder();
   	 Document document = loader.parse(file);
   	 xp = XPathFactory.newInstance().newXPath();
   	 
   	 
   	 //check structure
     nlist = (NodeList)xp.compile("//alt").evaluate(document, XPathConstants.NODESET);
     NodeList flistAlt = (NodeList)xp.compile(".//alt/feature").evaluate(document, XPathConstants.NODESET);
     NodeList flistOr = (NodeList)xp.compile(".//or//feature").evaluate(document, XPathConstants.NODESET);  
     
     for (int i = 0; i < nlist.getLength(); i++) {
     System.out.println("Simple entity \"" +xp.compile("./@name").evaluate(nlist.item(i))+"\":\n inputs in en{ ");
     for (int j = 0; j < flistAlt.getLength(); j++) {
   	
    	 name = xp.compile("./@name").evaluate(flistAlt.item(j)); 
    	 printSynonymn();
    	 System.out.println("\""+name+"\" synonymns "+listSynonymns );
    			
		//System.out.println("\""+name+"\" synonymns ");
			
			}
     System.out.println("\n}");	
     }
     nlist = (NodeList)xp.compile("//or").evaluate(document, XPathConstants.NODESET);
     for (int i = 0; i < nlist.getLength(); i++) {
     System.out.println("Simple entity \"" +xp.compile("./@name").evaluate(nlist.item(i))+"\":\n inputs in en{ ");
    
     
     for (int j = 0; j < flistOr.getLength(); j++) {
			name = xp.compile("./@name").evaluate(flistOr.item(j));
			 printSynonymn();
				System.out.println("\""+name+"\" synonymns "  +listSynonymns);
	
			}
    
     System.out.println("\n}");
     }
     
    }catch(Exception ex) {
   	 System.out.println(ex.getMessage());
    }
	
   	 
    } 
   
//    public static NodeList getNodeList(Document doc, String expr) {
//        try {
//            XPathExpression pathExpr = xp.compile(expr);
//            return (NodeList) pathExpr.evaluate(doc, XPathConstants.NODESET);
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    
  //extracts the String value for the given expression
//    private static String getValue(Node n, String expr) {
//        try {
//            XPathExpression pathExpr = xp.compile(expr);
//            return (String) pathExpr.evaluate(n,
//                    XPathConstants.STRING);
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    //action
    public static void printAction() throws XPathExpressionException {
    	System.out.println("actions:");
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
     nlist = (NodeList)xp.compile("//and//alt").evaluate(document, XPathConstants.NODESET);
     NodeList flistAlt = (NodeList)xp.compile("//alt//feature").evaluate(document, XPathConstants.NODESET);
     NodeList flistOr = (NodeList)xp.compile("//or//feature").evaluate(document, XPathConstants.NODESET);
     
     System.out.println("text response Help_yesResponse: \n inputs {\n \""+"Great! To begin, enter "  +xp.compile("./@name").evaluate(nlist.item(0))+"\"\n } ");

     for (int i = 0; i < nlist.getLength(); i++) {
     System.out.println("text response "+xp.compile("./@name").evaluate(nlist.item(i))+"Type: \n inputs {\n \""+"What type of "  +xp.compile("./@name").evaluate(nlist.item(i))+"? You can only choose one of ");
    
     
     for (int j = 0; j < flistAlt.getLength(); j++) {
    	 listTypes = xp.compile("./@name").evaluate(flistAlt.item(j));
     	System.out.print(listTypes.toString() + " ");
			}
     System.out.println("\"\n}");
     System.out.println("text response Select"+xp.compile("./@name").evaluate(nlist.item(i))+"Response: \n inputs {\n \""+"You have selected the feature: \"" +"\n [\""+ "Select_" +xp.compile("./@name").evaluate(nlist.item(i))+"."+xp.compile("./@name").evaluate(nlist.item(i))+" _type\"]");
     System.out.println("\n}");
     }
     
  
     nlist = (NodeList)xp.compile("//or").evaluate(document, XPathConstants.NODESET);
     for (int i = 0; i < nlist.getLength(); i++) {
    	 System.out.println("text response "+xp.compile("./@name").evaluate(nlist.item(i))+"Type: \n inputs {\n \""+"What type of "  +xp.compile("./@name").evaluate(nlist.item(i))+"? You can choose or more of the following");
         
     
     for (int j = 0; j < flistOr.getLength(); j++) {
		
    	 listTypes = xp.compile("./@name").evaluate(flistOr.item(j));
      	System.out.print(listTypes.toString() + " ");
 			}
      System.out.println("\"\n}");
      
      System.out.println("text response Select"+xp.compile("./@name").evaluate(nlist.item(i))+"Response: \n inputs {\n \""+"You have selected the feature: \"" +"\n [\""+ "Select_" +xp.compile("./@name").evaluate(nlist.item(i))+"."+xp.compile("./@name").evaluate(nlist.item(i))+" _type\"]");
      System.out.println("\n}");
     }
   
    }catch(Exception ex) {
   	 System.out.println(ex.getMessage());
    }
	
    }  
    //
    
    public static void printflow() throws XPathExpressionException {
    	System.out.println("flows:");
    }
    public static String printSynonymn() {
  	  System.setProperty("wordnet.database.dir", "/Users/usuario/Documents/eclipse4/SPLBotDemoXX/src/dict");
  		WordNetDatabase wordNetDatabase = WordNetDatabase.getFileInstance();

//  		ArrayList<String> synonyms=new ArrayList<String>();
  		  //String wordForm = "drive";
  		  String wordForm = name;
  		  Synset[] synsets1 = wordNetDatabase.getSynsets(wordForm);
  		  if (synsets1.length > 0) {
  		       for (int i = 0; i < synsets1.length; i++) {
  		    String[] wordForms = synsets1[i].getWordForms();
  		    for (int j = 0; j < wordForms.length; j++) {
  		           if(!synonyms.contains(wordForms[j])){
  		        synonyms.add(wordForms[j]); }
  		           
  		                }
  		    
  		           }
  		       //System.out.println(synonyms);
  		       listSynonymns = Arrays.toString(synonyms.toArray()).replace("[", "").replace("]", "");
  		       //System.out.println(listSynonymns);
  		  
  		     }else {
  		    	 listSynonymns= name;
  		    	 
  		     }
//  				  
  		
  		  //System.out.println(listSynonymns);
		return listSynonymns;
  		  
  		  
  		 
  }
}  