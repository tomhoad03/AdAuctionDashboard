package Models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ChartCalculator extends Calculator {
    public ChartCalculator(ImpressionLog impressionLog, ClickLog clickLog, ServerLog serverLog) {
        super(impressionLog, clickLog, serverLog);
    }

    /**
    my next approach will be to try results in multiple groups depending on time granularity
    the first step will be to produce of start and end date pairs where each item follows on from the last
    eg. (Jan-March, April-June, July-Sep, etc.)
    **/

    // gets all the impressions data points sorted into the intervals produced
    public ArrayList<MetricCalculator> createIntervals(LocalDateTime startDate, LocalDateTime endDate) {
        // creates a list of dates separated by a constant interval
        ArrayList<LocalDateTime> dates = new ArrayList<>();
        dates.add(startDate);

        // calculates time difference (temporarily in days)
        long days = ChronoUnit.DAYS.between(startDate, endDate);

        // gets dates at every interval
        for (long i=1; i<=days+1; i++) {
            dates.add(startDate.plusDays(i));
        }

        ArrayList<MetricCalculator> intervalCalculators = new ArrayList<>(); // list of calculators for log entries in each interval
        ArrayList<ImpressionLog> intervalImpressionLogs = new ArrayList<>(); // list of impression logs in each interval
        ArrayList<ClickLog> intervalClickLogs = new ArrayList<>(); // list of click logs in each interval
        ArrayList<ServerLog> intervalServerLogs = new ArrayList<>(); // list of server logs in each interval

        // current interval logs
        ImpressionLog currentImpressionLog = new ImpressionLog(new ArrayList<>());
        ClickLog currentClickLog = new ClickLog(new ArrayList<>());
        ServerLog currentServerLog = new ServerLog(new ArrayList<>());

        LocalDateTime lastDate = dates.get(1); // last date of interval
        int count = 1;

        // Creates a list of impression logs for each interval
        for (Impression impression : getImpressionLog().getImpressionsList()) {
            if (!impression.date.isBefore(lastDate)) { // if its the first log in a new interval
                // completes the current interval log
                currentImpressionLog.setDates();
                intervalImpressionLogs.add(currentImpressionLog);

                // resets the current interval log
                currentImpressionLog = new ImpressionLog(new ArrayList<>());
                currentImpressionLog.getImpressionsList().add(impression);

                count++;
                lastDate = dates.get(count);
            }
            currentImpressionLog.getImpressionsList().add(impression); // adds the log entry to the current interval log
        }

        // resets the date
        lastDate = dates.get(1); // last date of interval
        count = 1;

        // Creates a list of click logs for each interval
        for (Click click : getClickLog().getClicksList()) {
            if (!click.date.isBefore(lastDate)) { // if its the first log in a new interval
                // completes the current interval log
                currentClickLog.setDates();
                intervalClickLogs.add(currentClickLog);

                // resets the current interval log
                currentClickLog = new ClickLog(new ArrayList<>());
                currentClickLog.getClicksList().add(click);

                count++;
                lastDate = dates.get(count);
            }
            currentClickLog.getClicksList().add(click); // adds the log entry to the current interval log
        }

        // resets the date
        lastDate = dates.get(1); // last date of interval
        count = 1;

        // Creates a list of server logs for each interval
        for (Server server : getServerLog().getServerList()) {
            if (!server.entryDate.isBefore(lastDate)) { // if its the first log in a new interval
                // completes the current interval log
                currentServerLog.setDates();
                intervalServerLogs.add(currentServerLog);

                // resets the current interval log
                currentServerLog = new ServerLog(new ArrayList<>());
                currentServerLog.getServerList().add(server);

                count++;
                lastDate = dates.get(count);
            }
            currentServerLog.getServerList().add(server); // adds the log entry to the current interval log
        }

        if (intervalImpressionLogs.size() == intervalClickLogs.size() && intervalImpressionLogs.size() == intervalServerLogs.size()) {
            for (int i=0; i < intervalImpressionLogs.size(); i++) {
                intervalCalculators.add(new MetricCalculator(intervalImpressionLogs.get(i), intervalClickLogs.get(i), intervalServerLogs.get(i)));
            }
        } else {
            System.out.println("Error!");
        }

        return intervalCalculators;
    }
}
