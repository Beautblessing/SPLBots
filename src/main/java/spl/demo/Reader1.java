package spl.demo;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

public class Reader1 {

	public static void main(String[] args) throws ParserConfigurationException,
    SAXException, IOException {

DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder loader = factory.newDocumentBuilder();
Document document = loader.parse("/Users/usuario/Documents/eclipse4/FMDemoRead/src/p1.xml");

DocumentTraversal trav = (DocumentTraversal) document;

MyFilter filter = new MyFilter();

NodeIterator it = trav.createNodeIterator(document.getDocumentElement(),
        NodeFilter.SHOW_ELEMENT, filter, true);

for (Node node = it.nextNode(); node != null;
        node = it.nextNode()) {

    String name = node.getNodeName();
    String text = node.getTextContent().trim().replaceAll("\\s+", " ");
   
    if (node.hasAttributes()) {
        // get attributes names and values
        NamedNodeMap nodeMap = node.getAttributes();
        for (int i = 0; i < nodeMap.getLength(); i++)
        {
            Node tempNode = nodeMap.item(i);
            System.out.println("Feature : " + tempNode.getNodeName()+ "; Value  " + tempNode.getNodeValue());
        }
     }
     
      //System.out.printf("%d %s%n", c, name);
      System.out.printf(" Node: %s%n %s%n", name, text);
    
    
   // System.out.printf("%s: %s%n", name, text);
}
}

static class MyFilter implements NodeFilter {

//@Override
public short acceptNode(Node thisNode) {
    if (thisNode.getNodeType() == Node.ELEMENT_NODE) {

        Element e = (Element) thisNode;
        String nodeName = e.getNodeName();

        if ("featureModel".equals(nodeName) || "struct".equals(nodeName) || "and".equals(nodeName) || "alt".equals(nodeName) || "or".equals(nodeName)|| "feature".equals(nodeName)) {
            return NodeFilter.FILTER_ACCEPT;
                   
            
        }
    }

    return NodeFilter.FILTER_REJECT;
}
}
}
