package spl.demo.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;


@XmlRootElement(name = "struct")
@XmlSeeAlso({And.class})
@XmlAccessorType(XmlAccessType.FIELD)

public class Struct {
	
	// @XmlElementWrapper(name="and")
	@XmlElement(name="and")
	private And and[];

    public And[] getAnd ()
    {
        return and;
    }

    public void setAnd (And[] and)
    {
        this.and = and;
    }

    @Override
    public String toString()
    {
    	
        return "Struct \n [and = "+ Arrays.toString(and) +"]";
    }
    
    
}
