package spl.demo.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "imp")
@XmlSeeAlso({Not.class, Disj.class, Var.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Imp {
	@XmlElement(name="not")
	private Not not;
	
	@XmlElement(name="var")
	private String var;
	
	@XmlElement(name="disj")
	private Disj disj;
	
	public Not getNot ()
    {
        return not;
    }

    public void setNot (Not not)
    {
        this.not = not;
    }
    
    public Disj getDisj ()
    {
        return disj;
    }

    public void setDisj (Disj disj)
    {
        this.disj = disj;
    }

    public String getVar ()
    {
        return var;
    }

    public void setVar (String var)
    {
        this.var = var;
    }

   
    @Override
    public String toString()
    {
        return "Imp [not = "+not+", disj = "+disj+", var = "+var+"]";
    }
}
