package Models;

import java.util.ArrayList;

public class Clicks {
    private int clickNo; // number of clicks
    private double totalCost; // total cost of clicks

    private ArrayList<Click> clicks = new ArrayList<>();

    public Clicks(String clickLog) {
        // Reads the csv
        Reader clickReader = new Reader(clickLog);
        clickReader.getLine(); // removing first line

        // Reading line-by-line
        while (clickReader.fileIsReady()){
            String[] log = clickReader.getLine().split(",");

            // counting total clicks
            clickNo++;

            // converting to appropriate type
            long id = Long.parseLong(log[1]);

            // adding cost of impression to totalCost
            double clickCost = Double.parseDouble(log[2]);
            totalCost += clickCost;

            // creates new impression
            Click click = new Click(log[0], // date
                                     id, // user id
                                     clickCost); // click cost
            clicks.add(click);
        }
    }

    /*
    // Calculates difference between time (in form of string)
    public int timeDifference(String entryDate, String exitDate){

        String entryTime = exitDate.split(" ")[1];


        String exitTime = exitDate.split(" ")[1];
        return 0;
    }
    */

    public int getClickNo() {
        return clickNo;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public ArrayList<Click> getClicks() {
        return clicks;
    }
}
