package spl.demo.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "not")
@XmlSeeAlso({Var.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Not {
	@XmlElement(name="var")
	private String var;

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
        return "Not [var = "+var+"]";
    }
}
