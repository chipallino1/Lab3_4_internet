package Parsers;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class domParser {


    public domParser(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory f=DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder=f.newDocumentBuilder();
        org.w3c.dom.Document doc=builder.parse(new File(path));
        NodeList elements=doc.getElementsByTagName("CountOfLong");
        System.out.println("GOOD parsing using DOM!\n\tCount of long of first item: "+elements.item(0).getTextContent());
    }


}
