package Main;

/*
 * ************************************************************************************************************
 * Component to make the generator and all of its functions
 *
 * Component Name: Generator
 * Programmer: Brandon Nickas
 * Version: 1.0
 * ************************************************************************************************************
 */

public class Generator {

    //Generator Variables
    private String genName;
    private int genValue;
    private double genMulti;
    private int genTotal;
    private int genAmount;
    private int genCost;
    private int genBCost;

    //Upgrade Variables
    private String[] serText = new String[4];
    private int[] serCost = new int[4];
    private int serPlace;

    public int serLength = 4;

    //Constructors
    Generator(String gName, int value, int gCost, String text[], int uCost[]) {
        genName = gName;
        genValue = value;
        genBCost = gCost;
        genCost = gCost;

        for (int i = 0; i < serLength; i++) {
            serText[i] = text[i];
            serCost[i] = uCost[i];
        }
        serPlace = 0;
    }

    //Generator Functions
    //This function is called when loading the game as some values require math to be done to be correct
    public void update() {
        genCost = (int) (genBCost * Math.pow(1.2, genAmount));
        genMulti = (serPlace + 1) * 1.5;
        genTotal = (int) ((genValue * genMulti + 1) * genAmount);
    }

    //Gets generators name
    public String getGenName() {
        return genName;
    }

    //Gets the total phoenix per second the generators makes
    public int getGenTotal() {
        genTotal = (int) ((genValue * genMulti + 1) * genAmount);
        return genTotal;
    }

    //Gets the generators current cost
    public int getGenCost() {
        return genCost;
    }

    //Gets the amount of generators the user owns
    public int getGenAmount() {
        return genAmount;
    }

    //Sets the amount of generators the user has
    public void setGenAmount(int amount) {
        genAmount = amount;
    }

    //This function occurs when the user has enough phoenixes to buy a generator. This will add it to their inventory as well as inc the cost of the next purchase
    public long buyGen(long counter) {
        if (counter >= genCost) {
            genAmount += 1;
            counter -= genCost;
            genCost = (int) (genBCost * Math.pow(1.2, genAmount));
        }
        return counter;
    }

    //Upgrades Functions
    //Gets the upgrade series place
    public int getSerPlace() {
        return serPlace;
    }

    //Sets the upgrade series place
    public void setSerPlace(int place) {
        serPlace = place;
    }

    //Get the text associated with one place in an upgrade series
    public String getSerText() {
        return serText[serPlace];
    }

    //Gets the cost of one place in the series
    public int getSerCost() {
        return serCost[serPlace];
    }

    //Variable was used to see if a user is at the end of an upgrade series. The game then shows  the upgrade as purchased
    boolean isDone = false;

    //This buys an upgrade when a user has enough phoenixes. It makes sure the users money is only taken once
    public long serBuy(long counter) {
        if (serPlace == 3 && counter >= serCost[serPlace]) {
            counter -= serCost[serPlace];
            isDone = true;
        } else if (counter >= serCost[serPlace]) {
            counter -= serCost[serPlace];
            serPlace += 1;
            genMulti = (serPlace + 1) * 1.5;
        }
        return counter;
    }
}