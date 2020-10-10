package spl.demo.model;


import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "comments")

@XmlAccessorType(XmlAccessType.FIELD)
public class Comments {
	@XmlElement(name="c")
	private String[] c;

    public String[] getC ()
    {
        return c;
    }

    public void setC (String[] c)
    {
        this.c = c;
    }

    @Override
    public String toString()
    {
        return "Comments [c = "+ Arrays.toString(c) +"]";
    }
}
