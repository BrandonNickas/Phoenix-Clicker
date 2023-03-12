package Main;
/*
* ************************************************************************************************************
* Component to make the counter that will hold the amount of phoenixes the group has
*
* Component Name: Counter
* Programmer: Brandon Nickas
* Version: 1.0
* ************************************************************************************************************
*/
public class Counter {
    private long counter;
    private long perSecond;

    //The constructor requires no inputs as we just want a hidden variable that is set to 0
    Counter() {
        counter = 0;
    }

    //This allows for amounts to be added ot the counter
    public long addCounter(int added) {
        counter = counter + added;
        return counter;
    }

    //Gets the value on the counter
    public long getCounter() {
        return counter;
    }

    //Sets the value of the counter
    public long setCounter(long number) {
        counter = number;
        return counter;
    }

    //This finds how much the counter goes up each second
    public void perSecond(int ITS, int ITP, int DM, int SE) {
        perSecond = ITS + ITP + DM + SE;
        counter += perSecond;
    }

}
