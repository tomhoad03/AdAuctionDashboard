package Models;

import metricCalculator.MetricCalculator;

public class Metrics {

    /**
    Number of impressions: length of impression log
     Number of clicks: length of click log
     Number of uniques: length of impression log after removing duplicates
     Number of Bounces: filter by bounce time(server log's exit date - entry date)
     Number of Conversions: server log's conversion
     Total Cost: add all of impression cost

     CTR: number of clicks / number of impressionCPA: total cost / number of conversions
     CPC: total cost / number of clicks
     CPM: total cost*1000 / number of impressions
     Bounce rate: number of bounces / number of clicks
     */

    public static void main(String[] args){


        /*
        MetricCalculator myCalculator = new MetricCalculator();
        myCalculator.clickCounter();
        myCalculator.readServerLogs();
        myCalculator.uniqueNo = myCalculator.readImpressionLogs().size();

        float ctr = (float) myCalculator.clickNo / (float) myCalculator.impressionNo;
        double cpa = myCalculator.totalCost / myCalculator.conversionNo;
        double cpc = myCalculator.totalCost / myCalculator.clickNo;
        double cpm = myCalculator.totalCost*1000 / myCalculator.impressionNo;
        double br = (float) myCalculator.bounceNo / (float) myCalculator.clickNo;

        System.out.println("Number of impressions: "+Integer.toString(myCalculator.impressionNo));
        System.out.println("Number of clicks: "+Integer.toString(myCalculator.clickNo));
        System.out.println("Number of uniques: "+Integer.toString(myCalculator.uniqueNo));
        System.out.println("Number of bounces: "+Integer.toString(myCalculator.bounceNo));
        System.out.println("Number of conversions: "+Integer.toString(myCalculator.conversionNo));
        System.out.println("Total cost: "+Double.toString(myCalculator.totalCost));
        System.out.println("CTR: "+ ctr); // Don't know why its giving 0?
        System.out.println("CPA: "+ Double.toString(cpa));
        System.out.println("CPC: " + Double.toString(cpc));
        System.out.println("CPM: " + Double.toString(cpm));
        System.out.println("Bounce Rate: "+ Double.toString(br));
         */

    }
}
