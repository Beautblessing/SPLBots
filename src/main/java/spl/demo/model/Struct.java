package spl.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;


@XmlRootElement(name = "struct")
@XmlSeeAlso({And.class,Feature.class})
@XmlAccessorType(XmlAccessType.FIELD)

public class Struct {
	static ArrayList<String> ent= new ArrayList<>();
	
	// @XmlElementWrapper(name="and")
	@XmlElement(name="and")
	private And and[];
	
	//added
	@XmlElement(name="feature")
	private Feature[] feature;
	

    public And[] getAnd ()
    {
        return and;
    }

    public void setAnd (And[] and)
    {
        this.and = and;
    }
    
    //added
    public Feature[] getFeature ()
    {
        return feature;
    }

    public void setFeature (Feature[] feature)
    {
        this.feature = feature;
    }

    //

	@XmlElement(name="entity")
	private Entity entity[];

    public Entity[] getEntity ()
    {
        return entity;
    }

    public void setEntity (Entity[] entity)
    {
        this.entity = entity;
    }
    String st;
    String ap;
   
    @Override
    public String toString()
    { 
    	//return Arrays.toString(and).toString().substring(1, and.toString().length() - 1);
    	
    	////////
    	StringBuilder sb = new StringBuilder();
    	StringBuilder sb1 = new StringBuilder();
    	for(Object a : and)
    	{
    		sb.append(a.toString());
    		sb.append("\t");
    		 st = sb.toString();
    	}
    	
    	//added
//    	for(Feature ft: feature) {
//    		sb1.append(ft.toString());
//    		sb1.append("\t");
//    		 ap = sb1.toString();
//    	}   
//    		ent.add("(\""+ft+"\")");
//     	 	ent.add("\"I want "+"(\""+ft+"\")");
//     	 	ent.add("\"I´ll go with "+"(\""+ft+"\")");
//     	 	ent.add("\"Give me "+"(\""+ft+"\")");
  	 	
           	 	
        Alt a = new Alt();
        //System.out.println(a.entityName);
    	
    	//////////////**
    	
//    	for(Alt al: alt) {
//    		ent.add("Simple entity " +al+":\n");
//    	
//    		   
//    	}
    		
    	
    	//////////////**
        return sb.toString()+"\n" ;
    	
        
       // return sb.toString()+ "\n entities:\n"+a.entityName+ "\n actions:\n"+"\n flows:\n" ;
    	//return st.toString().substring(1, st.toString().length()-1);
    	/////////
    	//return Arrays.toString(and);
    	//return "\n"+ Arrays.toString(and).replace("[", "").replace("]", "");
    	
    }
    
    
}
