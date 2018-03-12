package airCompany.Planes;

import airCompany.AirCompany;
import org.apache.log4j.Logger;

interface IPlane
{
    String getName();
    String getNameOfOwner();
    int getLongOfVoyage();
    int getCountOfPlaces();
    int getCountOfFuel();


}

public class Plane extends AirCompany implements IPlane {

    private static final Logger LOG    =    Logger.getLogger(AirCompany.class);

    private String name;
    private String nameStandart="Самолет ";
    private static int countOfObjects;
    private String nameOfOwner=super.getNameOfCompany();
    private String nameOfOwnerStandart=super.getNameStandart();
    private int longOfVoyage;
    private int countOfPlaces;
    private int countOfFuel;

    public String getName() {
        return name;
    }



    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public int getLongOfVoyage() {
        return longOfVoyage;
    }

    public int getCountOfPlaces() {
        return countOfPlaces;
    }

    public int getCountOfFuel() {
        return countOfFuel;
    }

    public Plane(String name, String nameOfOwner,int longOfVoyage,int countOfFuel) {
        Plane.countOfObjects++;
        LOG.info("Объект "+this.getClass()+ " создан!");
        this.name = name;

        this.nameOfOwner=nameOfOwner;
        this.longOfVoyage=longOfVoyage;
        this.countOfFuel=countOfFuel;

    }

    public Plane() {
        Plane.countOfObjects++;
        LOG.info("Объект "+this.getClass()+ " создан!");
        this.name=this.nameStandart+Plane.countOfObjects;

        this.nameOfOwner=this.nameOfOwnerStandart+Plane.countOfObjects;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name='" + name + '\'' +
                '}';
    }
}
