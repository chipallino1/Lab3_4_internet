package Parsers;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class saxParsers extends DefaultHandler {

    XMLReader xmlReader;
    public saxParsers()
    {
        super();
    }
    public void CreateXMLReader() throws SAXException {
        xmlReader= XMLReaderFactory.createXMLReader();
    }
    public void SetHandlers()
    {
        saxParsers saxPars=new saxParsers();
        xmlReader.setContentHandler(saxPars);
        xmlReader.setErrorHandler(saxPars);
    }
    public void Parse(String path) throws IOException, SAXException {
        FileReader fileReader=new FileReader(path);

        xmlReader.parse(new InputSource(fileReader));
        System.out.println("GOOD parsing using SAXParser!");
    }
    public void startDocument(String uri, String name, String qName, Attributes atts)
    {
        if("".equals(uri))
            System.out.println("Start element: "+qName);
        else
            System.out.println("Start element: { "+uri+" } "+name);


    }
    public void endDocument(String uri, String name, String qName)
    {
        if("".equals(uri))
            System.out.println("End element: "+qName);
        else
            System.out.println("End element: { "+uri+" } "+name);

    }
   /* public void characters (char ch[], int start, int length)
    {
        System.out.print("Characters:    \"");
        for (int i = start; i < start + length; i++) {
            switch (ch[i]) {
                case '\\':
                    System.out.print("\\\\");
                    break;
                case '"':
                    System.out.print("\\\"");
                    break;
                case '\n':
                    System.out.print("\\n");
                    break;
                case '\r':
                    System.out.print("\\r");
                    break;
                case '\t':
                    System.out.print("\\t");
                    break;
                default:
                    System.out.print(ch[i]);
                    break;
            }
        }
        System.out.print("\"\n");
    }
*/

}
