package spl.demo.model;


import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "constraints")
@XmlSeeAlso({Rule.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Constraints {
	@XmlElement(name="rule")
	private Rule[] rule;

    public Rule[] getRule ()
    {
        return rule;
    }

    public void setRule (Rule[] rule)
    {
        this.rule = rule;
    }
    

    @Override
    public String toString()
    {
        return "Constraints [rule = "+ Arrays.toString(rule) +"]";
    }
}
