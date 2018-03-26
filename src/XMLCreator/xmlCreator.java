package XMLCreator;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.StyleSheet;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import airCompany.Planes.Plane;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class xmlCreator {
    private Document document;
    DOMSource source;
    StreamResult result;
    Transformer transformer = TransformerFactory.newInstance()
            .newTransformer();
    public xmlCreator() throws ParserConfigurationException, TransformerConfigurationException {

            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element planes = document.createElement("Planes");
            document.appendChild(planes);

            Element plane = document.createElement("Plane");
            planes.appendChild(plane);
            plane.setTextContent("1");




        }
    public xmlCreator(Plane[] planesSource) throws ParserConfigurationException, TransformerConfigurationException {

        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element planes = document.createElement("Planes");
        document.appendChild(planes);

        for(int i=0;i<planesSource.length;i++) {
            Element plane = document.createElement("Plane");
            planes.appendChild(plane);
            plane.setTextContent(planesSource[i].getName());

            Element nameOfOwner=document.createElement("NameOfOwner");
            plane.appendChild(nameOfOwner);
            nameOfOwner.setTextContent(planesSource[i].getNameOfOwner());

            Element countOfPlaces=document.createElement("CountOfPlaces");
            plane.appendChild(countOfPlaces);
            countOfPlaces.setTextContent(String.valueOf(planesSource[i].getCountOfPlaces()));

            Element countOfLong=document.createElement("CountOfLong");
            plane.appendChild(countOfLong);
            countOfLong.setTextContent(String.valueOf(planesSource[i].getLongOfVoyage()));

            Element countOfFuel=document.createElement("CountOfFuel");
            plane.appendChild(countOfFuel);
            countOfFuel.setTextContent(String.valueOf(planesSource[i].getCountOfFuel()));


        }



    }
        public void outPutXML() throws TransformerException {
            source = new DOMSource(document);
            result = new StreamResult(
                    new File("D:\\Универ\\Учеб\\2 курс\\2 сем\\cтпи\\Lab05_internet\\files\\Planes.xml"));


            transformer.transform(source, result);


        }
        public void outPutConsole() throws TransformerException {
            source = new DOMSource(document);
            result = new StreamResult(System.out);


            transformer.transform(source, result);


        }
        public void outPutHTML() throws TransformerException {
            source = new DOMSource( document);
            result = new StreamResult(
                    new File("D:\\Универ\\Учеб\\2 курс\\2 сем\\cтпи\\Lab05_internet\\files\\Planes.html"));

            transformer.transform(source,result );
        }

            public static boolean validateXMLByXSD(String xml, String xsd) throws SAXException, IOException {
            try {
                //xml.trim().replace("^([\\W]+)<","<");

              //  FileInputStream fileReader=new FileInputStream(xml);
              //  byte[] buffer = new byte[fileReader.available()];
// считаем файл в буфер
               // fileReader.read(buffer, 0, fileReader.available());

              //  System.out.println("Содержимое файла:");
              //  for(int i=0; i<buffer.length;i++){

               //     System.out.print((char)buffer[i]);
              //  }
               // System.out.println();
              //  String xmlString=new String (buffer);
              // xmlString= xmlString.replaceAll("^([\\W]+)<","<");


               // xmlString=xmlString.trim().replace("^([\\W]+)<","<");
               // System.out.println(xmlString);


               // StringReader s= new StringReader(xmlString);
                //File xsdFile=new File(xsd);
                //File xmlFile=new File();

                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                        .newSchema(new File(xsd))
                        .newValidator()
                        .validate(new StreamSource(new File(xml)));
            } catch (Exception e) {
                System.out.println("error "+e.getMessage());

                return false;
            }
            return true;
        }

        }




