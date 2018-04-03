package airCompany;

import airCompany.Planes.Plane;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class DispatcherTest {

    Dispatcher dis=Dispatcher.createDispatcher();
    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("Тестрование метода начато");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("Тестрование метода завершено");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("Тест класса Диспетчер след. мы находимся в классе Аиркомпани");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("Тест класса Диспетчер Завершен ");
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Начинаем тестирование");

    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("Завершаем тестирование");

    }
    @Test
    public void testCreateDispatcher() throws Exception {


        Dispatcher ds1=Dispatcher.createDispatcher();
        Assert.assertEquals(ds1,dis);

    }

    @Test
    public void testSortByLong() throws Exception {
        Plane[] planes = new Plane[5];//коллекция
        planes[0] = new Plane("Plane 1", "me", 12, 123);
        planes[1] = new Plane("Plane 2", "me", 123, 13);
        planes[2] = new Plane("Plane 3", "me", 2, 12);
        planes[3] = new Plane("Plane 4", "me", 1, 1);
        planes[4] = new Plane("Plane 5", "me", 100, 123);
        for(int i=0;i<5;i++)
        {
            Assert.assertNotEquals(planes[i].getLongOfVoyage(),0,"Тест на длину полета не пройден");

        }

    }

    @Test(timeOut = 1000)
    public void testSearchFuel() throws Exception {
        Plane[] planes1 = new Plane[5];//коллекция
        planes1[0] = new Plane("Plane 1", "me", 12, 123);
        planes1[1] = new Plane("Plane 2", "me", 123, 13);
        planes1[2] = new Plane("Plane 3", "me", 2, 12);
        planes1[3] = new Plane("Plane 4", "me", 1, 1);
        planes1[4] = new Plane("Plane 5", "me", 100, 123);
        for(int i=0;i<5;i++)
        {
            Assert.assertNotEquals(planes1[i].getCountOfFuel(),0,"Тест на кол-во топлива не пройден");

        }
    }
}