package airCompany;

import airCompany.Planes.Boing;
import airCompany.Planes.IL;
import org.apache.log4j.Logger;

interface IAirCompany
{
    String getNameOfCompany();
    String getNameStandart();

}



public class AirCompany implements IAirCompany {

    private static final Logger LOG    =    Logger.getLogger(AirCompany.class);

    private String nameOfCompany;
    private static int countOfObjects;
    private String nameStandart="Авиакомпания ";

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public String getNameStandart()
    {

        return nameStandart;
    }

    public AirCompany(String name) {
        LOG.info("Объект "+this.getClass()+ " создан!");
        this.nameOfCompany = name;
    }

    public AirCompany() {
        LOG.info("Объект "+this.getClass()+ " создан!");
        this.nameOfCompany=this.nameStandart+AirCompany.countOfObjects;
    }




   public class BoingFactory
   {
       public Boing create()
       {
           LOG.info("Объект "+"BoingFactory"+ " создан!");
           return new Boing();
       }
       public PilotBoing addPilot()
       {
           LOG.info("Объект "+"PilotBoing"+ " создан!");
           return new PilotBoing();
       }
   }
   public class ILFactory
   {
       public IL create()
       {
           LOG.info("Объект "+"ILFactory"+ " создан!");
           return new IL();
       }
       public PilotIL addPilot()
       {
           LOG.info("Объект "+"PilotIL"+ " создан!");
           return new PilotIL();
       }
   }
}
