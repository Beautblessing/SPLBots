package spl.demo.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "var")

@XmlAccessorType(XmlAccessType.FIELD)
public class Var {
	private String[] var;

    public String[] getVar ()
    {
        return var;
    }

    public void setVar (String[] var)
    {
        this.var = var;
    }

    @Override
    public String toString()
    {
        return "Var [var = "+var+"]";
    }
}
