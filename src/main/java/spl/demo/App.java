package spl.demo;

import spl.demo.model. *;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
public class App {

    public static void main(String args[]) throws JAXBException{
        File file = new File("/Users/usuario/Documents/eclipse4/FMDemoReader/src/p1.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(FeatureModel.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        FeatureModel featureModel = (FeatureModel) jaxbUnmarshaller.unmarshal(file);
        
     
        System.out.println(featureModel);


    }
}  