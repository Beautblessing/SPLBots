package spl.demo.model;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "feature")
@XmlAccessorType(XmlAccessType.FIELD)

public class Feature {

	//
	@XmlAttribute
	private String name;

	public String getName ()
	{
		return name;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{

		String result = name;

		return result;  
	}

}
