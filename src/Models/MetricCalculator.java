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
    private Servers servers;

    public MetricCalculator() {
        // Files
        String impressionLog = "src/Logs/impression_log.csv";
        String clickLog = "src/Logs/click_log.csv";
        String serverLog = "src/Logs/server_log.csv";

        // Classes for files
        this.impressions = new Impressions(impressionLog);
        this.clicks = new Clicks(clickLog);
        this.servers = new Servers(serverLog);

        this.impressionsNo = impressions.getImpressionNo();
        this.uniquesNo = impressions.getUniquesNo();
        this.clicksNo = clicks.getClickNo();
        this.bounceNo = 0;
        this.conversionsNo = servers.getConversionNo();
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

        System.out.println("Number of impressions: "+Integer.toString(calculator.impressionsNo));
        System.out.println("Number of clicks: "+Integer.toString(calculator.clicksNo));
        System.out.println("Number of uniques: "+Integer.toString(calculator.uniquesNo));
        System.out.println("Number of bounces: "+Integer.toString(calculator.bounceNo));
        System.out.println("Number of conversions: "+Integer.toString(calculator.conversionsNo));
        System.out.println("Total cost: "+Double.toString(calculator.totalImpressionCost));
        System.out.println("CTR: "+ ctr); // Don't know why its giving 0?
        System.out.println("CPA: "+ Double.toString(cpa));
        System.out.println("CPC: " + Double.toString(cpc));
        System.out.println("CPM: " + Double.toString(cpm));
        System.out.println("Bounce Rate: "+ Double.toString(br));
    }
}
