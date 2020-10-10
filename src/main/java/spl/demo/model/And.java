package spl.demo.model;


import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "and")


@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Or.class, Alt.class, Feature.class})
public class And {
	
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

    @Override
    public String toString()
    {
        //return "And [or = "+ or+", name = "+name+", alt = "+alt+", mandatory = "+mandatory+"]";
    
        //return "And Root = "+name+", mandatory = "+mandatory+", feature = "+ Arrays.toString(feature)+" [alt = "+alt+", or = "+ or+"]";
        
       // return "And Root = "+name+", abstract = "+_abstract+", mandatory = "+mandatory+", feature = "+ Arrays.toString(feature)+", and = "+ Arrays.toString(and)+" [alt = "+alt+", or = "+ or+"]";
    	return "And = "+name+", abstract = "+_abstract+", mandatory = "+mandatory+" feature = "+ Arrays.toString(feature)+", \n and = "+ Arrays.toString(and)+" \n alt = "+alt+" \n or = "+or+"";

    }
    	
}
