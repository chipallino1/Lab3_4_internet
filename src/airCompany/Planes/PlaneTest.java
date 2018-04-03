package airCompany.Planes;


import airCompany.Planes.Plane;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;



public class PlaneTest {

  //  public static Plane plane;

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("Начало метода...");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("Конец метода...");
        System.out.println();
    }

    @Test

    public void testSerializable() throws Exception {
        Plane pl1=new Plane();
        Plane pl=new Plane("Самолет 1");

        Assert.assertEquals(pl.getName(),pl1.getName());


    }

    @Test
    public void testSerializableArr() throws Exception {
        Plane[] planes=new Plane[5];
        Plane[] planes1=new Plane[5];

        Assert.assertEquals(planes.length,planes1.length);
    }

    @Test
    public void testDeserializable() throws Exception {
        Plane pl1=new Plane();
        Plane pl=new Plane("Самолет 1");

        Assert.assertEquals(pl.getName(),pl1.getName());
    }

    @Test
    public void testDeserializableArr() throws Exception {
        Plane pl1=new Plane();
        Plane pl=new Plane("Самолет 1");

        Assert.assertEquals(pl.getName(),pl1.getName());
    }
}