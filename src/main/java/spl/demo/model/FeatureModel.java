package spl.demo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "featureModel")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Struct.class})


public class FeatureModel {
	
	 @XmlElement(name="struct")
	 private Struct struct;

	 @XmlElement(name="comments")
	 private Comments comments;
	 
	 @XmlElement(name="constraints")
	 private Constraints constraints;
	 

	    public Struct getStruct ()
	    {
	        return struct;
	    }

	    public void setStruct (Struct struct)
	    {
	        this.struct = struct;
	    }

	    
	    public Comments getComments ()
	    {
	        return comments;
	    }

	    public void setComments (Comments comments)
	    {
	        this.comments = comments;
	    }

	    public Constraints getConstraints ()
	    {
	        return constraints;
	    }

	    public void setConstraints (Constraints constraints)
	    {
	        this.constraints = constraints;
	    }
	   
	    @Override
	    public String toString()
	    {
	       // return "FeatureModel \n  [struct = "+struct+", comments = "+comments+", constraints = "+constraints+"]";
	        return "FeatureModel \n "+struct+" \n comments = "+comments+" \n constraints = "+constraints+"";
	  	  
	    }
	    
	    
}
