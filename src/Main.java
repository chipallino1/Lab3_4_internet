import airCompany.PilotBoing;
import airCompany.PilotIL;
import airCompany.Planes.Boing;
import airCompany.Planes.IL;
import airCompany.Planes.Plane;
import airCompany.AirCompany;
import  airCompany.Dispatcher;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Document;

import XMLCreator.xmlCreator;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {

    static
    {
        new DOMConfigurator().doConfigure("log/log4j.xml",LogManager.getLoggerRepository());
    }
    private static final Logger  LOG    =    Logger.getLogger(Main.class);

    public static void main(String[] args) {

        try {

            LOG.debug("Программа началась");
            AirCompany.BoingFactory boingFactory = new AirCompany().new BoingFactory();
            Boing boing = boingFactory.create();
            PilotBoing pilotBoing = boingFactory.addPilot();


            boing.getDiscription();
            pilotBoing.letFly();
            AirCompany.ILFactory ilFactory = new AirCompany().new ILFactory();
            IL il = ilFactory.create();
            PilotIL pilotIL = ilFactory.addPilot();

            il.getDiscription();
            pilotIL.letFly();

            Plane[] planes = new Plane[5];
            planes[0] = new Plane("Plane 1", "me", 12, 123);
            planes[1] = new Plane("Plane 2", "me", 123, 13);
            planes[2] = new Plane("Plane 3", "me", 2, 12);
            planes[3] = new Plane("Plane 4", "me", 1, 1);
            planes[4] = new Plane("Plane 5", "me", 100, 123);

            Dispatcher dispatcher = Dispatcher.createDispatcher();
            dispatcher.searchFuel(planes);
            dispatcher.sortByLong(planes);

            for (int i = 0; i < planes.length; i++) {
                System.out.println(planes[i].getLongOfVoyage() + " " + planes[i].getName());
            }

            xmlCreator xmlCreation=new xmlCreator(planes);
            //xmlCreation.outPutConsole();
            xmlCreation.outPutXML();
            //xmlCreation.outPutHTML();

            /*String xml="<?xml version=\"1.0\" encoding=\"UTF-16\"?>\n" +
                    "<Planes>\n" +
                    "    <Plane>Plane1</Plane>\n" +
                    "</Planes>";*/
           boolean valid= xmlCreation.validateXMLByXSD("D:\\Универ\\Учеб\\2 курс\\2 сем\\cтпи\\Lab05_internet\\files\\Planes.xml", "D:\\Универ\\Учеб\\2 курс\\2 сем\\cтпи\\Lab05_internet\\files\\Planes.xsd");
           if(valid)
               System.out.println("GOOD parsing using XSD!");
           else
               System.out.println("ERROR!");
           LOG.debug("Программа завершилась!");

        }
        catch (Exception ex)
        {

            LOG.fatal("Ошибка!");
            System.out.println("Ошибка! "+ex.getMessage());
        }


    }
}
