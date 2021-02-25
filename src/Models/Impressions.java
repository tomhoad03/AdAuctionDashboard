package Models;

import java.util.ArrayList;

public class Impressions {
    private int impressionNo; // total impressions
    private int uniquesNo; // total uniques
    private double totalCost; // total impression cost

    private ArrayList<Impression> impressions = new ArrayList<>();

    public Impressions(String impressionLog) {
        // Reads the csv
        Reader impressionReader = new Reader(impressionLog);
        impressionReader.getLine(); // removing first line

        ArrayList<Long> uniqueIds = new ArrayList<>();
        int count;

        // Reading line-by-line
        while (impressionReader.fileIsReady()){
            String[] log = impressionReader.getLine().split(",");

            // counting total impressions
            impressionNo++;

            // counting unique impressions
            long id = Long.parseLong(log[1]);
            if (!uniqueIds.contains(id)) {
                uniquesNo++;
                uniqueIds.add(id);
            }

            // adding cost of impression to totalCost
            double impressionCost = Double.parseDouble(log[6]);
            totalCost += impressionCost;

            // creates new impression
            Impression impression = new Impression(log[0], // date
                                                    id, // user id
                                                    log[2], // gender
                                                    log[3], // age
                                                    log[4], // income
                                                    log[5], // context
                                                    impressionCost); // impression cost
            impressions.add(impression);
        }
    }

    public int getImpressionNo() {
        return impressionNo;
    }

    public int getUniquesNo() {
        return uniquesNo;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public ArrayList<Impression> getImpressions() {
        return impressions;
    }
}