package airCompany;

interface Fly
{
    void letFly();
}

public class PilotIL implements Fly{

    public void letFly() {
    System.out.println("IL is flying!");
    }
}
