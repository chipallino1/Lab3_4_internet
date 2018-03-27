package airCompany.Planes;

import airCompany.AirCompany;
import org.apache.log4j.Logger;

import java.io.*;

interface IPlane
{
    String getName();
    String getNameOfOwner();
    int getLongOfVoyage();
    int getCountOfPlaces();
    int getCountOfFuel();


}

public class Plane extends AirCompany implements IPlane,Serializable {

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


    public static void Serializable(Plane plane) throws IOException {
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("planes.xml"));
        objectOutputStream.writeObject(plane);

    }
    public static  void SerializableArr(Plane[] planes) throws IOException {
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("planesArr.json"));
        objectOutputStream.writeObject(planes);

    }
    public static  void Deserializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("planes.xml"));
        Plane plane=(Plane)objectInputStream.readObject();
        System.out.println("Name: "+plane.getName()+" CountOfPlaces: "+plane.getCountOfPlaces()+" CountOfLong: "+plane.getLongOfVoyage());

    }
    public static  void DeserializableArr() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("planesArr.json"));
        Plane[] plane=(Plane[])objectInputStream.readObject();
        for(int i=0;i<plane.length;i++)
        System.out.println("Name: "+plane[i].getName()+" CountOfPlaces: "+plane[i].getCountOfPlaces()+" CountOfLong: "+plane[i].getLongOfVoyage());

    }
}

