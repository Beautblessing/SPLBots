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

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;

@XmlRootElement(name = "feature")
@XmlAccessorType(XmlAccessType.FIELD)

public class Feature {
	//added
    //	Add	Entity
   // Entities entities = new Entities();
   // List<String> synonymns = new ArrayList<String>();	
    ArrayList<String> synonyms=new ArrayList<String>();
    String listSynonymns;
	
	//
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
	      
	        
	        
	        
	        //Feature 
	        //feat.setName(name);
	        /////
	        //	Add	Entity
//	        Entities entities = new Entities();
//	        List<String> synonymns = new ArrayList<String>();

	        
//	        entities.setValue(name);
//	        Scanner scanner = new Scanner(System.in);
//	        System.out.println("Enter 3 synonymns for " + name);
//	       
//	        for(int i=0;i<3;i++)
//	        {
//	         String syn =scanner.nextLine();
//	         synonymns.add(syn);
//	         
//	        
//	        }
	       // printEntity();
	       // System.out.println( "entities: \n Simple entity " +name+":\n inputs in en{\""+name+"\" synonymns "+listSynonymns+"}");
	        //System.out.println("\n inputs in en{\""+name+"\" synonymns "+listSynonymns+"}");
	        
	        //return "\n  "+name+": inputs {"+inputs+" }\n entities: \n Simple entity " +name+":\n inputs in en{\""+name+"\" synonymns "+listSynonymns+"}";
	        //return "\n  "+name+": \n inputs {"+Arrays.toString(inputs.toArray()).replace("[", "").replace("]", "")+" }\n entities: \n Simple entity " +name+":\n inputs in en{\""+name+"\" synonymns "+listSynonymns+"}";
	       // return "\n  "+name+": \n inputs {"+Arrays.toString(inputs.toArray()).replace("[", "").replace("]", "")+" }\n }";
		 	String result = name;
	        return result;  
	    }
	    

	    public void printEntity() {
	    	  System.setProperty("wordnet.database.dir", "/Users/usuario/Documents/eclipse4/SPLBotDemoXX/src/dict");
	    		WordNetDatabase wordNetDatabase = WordNetDatabase.getFileInstance();

//	    		ArrayList<String> synonyms=new ArrayList<String>();
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
	    		       //System.out.println(list);
	    		     }else {
	    		    	 listSynonymns= name;
	    		     }
//	    				  
	    		
	    }
	    
//	    public static void callEntity() {  
//	    	System.out.println("\n inputs in en{\""+name+"\" synonymns "+listSynonymns+"}");
//		  }
}
