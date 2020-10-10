package spl.demo.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "rule")
@XmlSeeAlso({Imp.class, Not.class, Disj.class, Var.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Rule {
	@XmlElement(name="imp")
	private Imp imp;

    public Imp getImp ()
    {
        return imp;
    }

    public void setImp (Imp imp)
    {
        this.imp = imp;
    }
    
    //added
    
    @XmlElement(name="var")
	private Var[] var;
	 
	@XmlElement(name="not")
	private Not not;

	@XmlElement(name="disj")
    private Disj disj;
	
	
	
	public Var[] getVar ()
    {
        return var;
    }

public void setVar (Var[] var)
    {
        this.var = var;
    }

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
    
    
    
    //

    @Override
    public String toString()
    {
        return "Rule [imp = "+imp+"]";
    }
}
