package airCompany.Planes;

interface GetDiscription
{
    void getDiscription();
}

public class Boing implements GetDiscription{
    public void getDiscription()
    {
        System.out.println("Boing!");
    }
}
