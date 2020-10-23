package spl.demo.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main2 {
  public static void main(String[] args) {

	  ObjectMapper mapper = new ObjectMapper();
      Intents intents = newIntents();

      try {
          mapper.writeValue(new File("intents.json"), intents);
          String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(intents);
          System.out.println(jsonString);
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
	  
	  
	  
	
  private static Intents newIntents() {
  
	  
	Intents intents = new Intents();
    List<String> inputs = new ArrayList<String>();

    // Add training phrases in the arraylist
    inputs.add("Howdy");
    inputs.add("Hello");
    inputs.add("Hey");
    inputs.add("Heya");
    inputs.add("hey there");
    inputs.add("good morning");
    inputs.add("good afternoon");
    inputs.add("good evening");
    
    
    intents.setInputs(inputs);
    
    return intents;
    
  } 
}
