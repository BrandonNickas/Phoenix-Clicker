package Main;

/*
 * ************************************************************************************************************
 * Component to make the "Click" button and all of its functionality
 *
 * Component Name: ClickButton
 * Programmer: Brandon Nickas
 * Version: 1.0
 * ************************************************************************************************************
 */

public class ClickButton {

    //Button Variables
    private int btnValue = 1;
    private int btnMulti;
    private int btnTotal;

    //Upgrade Variables
    private String[] serText = new String[4];
    private int[] serCost = new int[4];
    private int serPlace;

    public int serLength = 4;

    //Constructor
    ClickButton(String text[], int uCost[]) {
        btnMulti = 1;

        for (int i = 0; i < serLength; i++) {
            serText[i] = text[i];
            serCost[i] = uCost[i];
        }
        serPlace = 0;
    }

    //Button Functions
    //Get the total value of each button click
    public int getBtnTotal() {
        btnTotal = btnValue * btnMulti;
        return btnTotal;
    }

    //Upgrade Functions
    //Gets the place in the series the user is currently at
    public int getSerPlace() {
        return serPlace;
    }

    //Gets the text of the current upgrade
    public String getSerText() {
        return serText[serPlace];
    }

    //Get the cost of the current upgrade
    public int getSerCost() {
        return serCost[serPlace];
    }

    //Used to identify if all upgrades have been purchased
    boolean isDone = false;

    //Buys the upgrade if the user have enough phoenixes
    public long serBuy(long counter) {
        if (serPlace == 3 && counter >= serCost[serPlace]) {
            counter -= serCost[serPlace];
            isDone = true;
        } else if (counter >= serCost[serPlace]) {
            counter -= serCost[serPlace];
            serPlace += 1;
            btnMulti = (serPlace + 1) * 2;
        }
        return counter;
    }

    //Used by the load feature to do some quick math.
    public void update() {
        btnMulti = (serPlace + 1) * 2;
    }

    //Sets the current place in the upgrade series
    public void setSerPlace(int place) {
        serPlace = place;
    }
}