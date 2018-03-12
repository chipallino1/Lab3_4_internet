package airCompany;

import airCompany.Planes.Plane;
import org.apache.log4j.Logger;

import  java.util.Scanner;

interface IDispatcher{

    void sortByLong(Plane[] planes);
    void searchFuel(Plane[] planes);

}

public class Dispatcher implements IDispatcher{

    private static final Logger LOG    =    Logger.getLogger(Dispatcher.class);

    private String name;
    public static int count;

    public static Dispatcher createDispatcher()
    {
        if(count==0)
        {
            count++;
            LOG.info("Объект "+"Dispatcher"+ " создан!");
            return new Dispatcher();
        }
        else
            System.out.println("Second creating is wrong!");
        return null;
    }

    public void sortByLong(Plane[] planes)
    {
        Plane plane=new Plane();

        for(int j=0;j<planes.length;j++) {

            for (int i = j+1; i < planes.length; i++) {
                if (planes[j].getLongOfVoyage() < planes[i].getLongOfVoyage()) {
                    plane = planes[j];
                    planes[j] = planes[i];
                    planes[i] = plane;

                }

            }
        }
        System.out.println("Сортировка произведена.");


    }
    public void searchFuel(Plane[] planes)
    {
        Scanner in =new Scanner(System.in);
        int count=0;
        System.out.println("Введите диапазон сжигания топилива: ");
        System.out.print("от: ");
        int from=in.nextInt();
        System.out.print("до: ");
        int to=in.nextInt();
        for(int i=0;i<planes.length;i++)
        {
            if(planes[i].getCountOfFuel()>=from && planes[i].getCountOfFuel()<=to) {
                System.out.println(planes[i].getCountOfFuel());
                count++;
            }


        }
        if(count==0)
            System.out.println("По вашим параметрам ничего не надено.");



    }

    private Dispatcher()
    {

    }
    protected Dispatcher clone()
    {
        System.out.println("По вашим параметрам ничего не надено.");
        return null;
    }



}
