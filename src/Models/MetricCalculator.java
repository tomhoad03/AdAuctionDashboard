package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MetricCalculator {
    // Already calculated
    private int impressionsNo; // number of impressions
    private int uniquesNo; // number of unique impressions
    private int clicksNo; // number of clicks
    private int bounceNo; // number of bounces
    private int conversionsNo; // number of conversions
    private double totalImpressionCost; // total impression cost
    private double totalClickCost; // total click cost

    // To be calculated
    private int CTR; // number of clicks / number of impressions
    private int CPA; // total impressions cost / number of conversions
    private int CPC; // total impression cost / number of clicks
    private int CPM; // (total impressions cost * 1000) / number of impressions
    private int bounceRate; // number of bounces / number of clicks
    int bounceTime = 10; // bounce time, input by user

    // OOP for logs
    private Impressions impressions;
    private Clicks clicks;
    private Server server;

    public MetricCalculator() {
        // Files
        String impressionLog = "src/Logs/impression_log.csv";
        String clickLog = "src/Logs/click_log.csv";
        String serverLog = "src/Logs/server_log.csv";

        // Classes for files
        this.impressions = new Impressions(impressionLog);
        this.clicks = new Clicks(clickLog);
        this.server = new Server(serverLog);

        this.impressionsNo = impressions.getImpressionNo();
        this.uniquesNo = impressions.getUniquesNo();
        this.clicksNo = clicks.getClickNo();
        this.bounceNo = server.getBounceNo();
        this.conversionsNo = server.getConversionNo();
        this.totalImpressionCost = impressions.getTotalCost();
        this.totalClickCost = clicks.getTotalCost();
    }

    public static void main(String[] args){
        MetricCalculator calculator = new MetricCalculator();

        // Calculation of metrics
        double ctr = (float) calculator.clicksNo / (float) calculator.impressionsNo;
        double cpa = calculator.totalImpressionCost / calculator.conversionsNo;
        double cpc = calculator.totalImpressionCost / calculator.clicksNo;
        double cpm = (calculator.totalImpressionCost * 1000) / calculator.impressionsNo;
        double br = (float) calculator.bounceNo / (float) calculator.clicksNo;

        // Printing of metrics
        System.out.println("Number of impressions: " + calculator.impressionsNo);
        System.out.println("Number of clicks: " + calculator.clicksNo);
        System.out.println("Number of uniques: " + calculator.uniquesNo);
        System.out.println("Number of bounces: " + calculator.bounceNo);
        System.out.println("Number of conversions: " + calculator.conversionsNo);
        System.out.println("Total cost: " + calculator.totalImpressionCost);
        System.out.println("CTR: " + ctr);
        System.out.println("CPA: " + cpa);
        System.out.println("CPC: " + cpc);
        System.out.println("CPM: " + cpm);
        System.out.println("Bounce Rate: " + br);
    }
}
