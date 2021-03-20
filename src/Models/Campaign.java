package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Campaign {
    private final Map<Long, User> users = new HashMap<>(); // list of unique users
    private final ArrayList<ImpressionEntry> impressionLog; // list of impressions
    private final ArrayList<ClickEntry> clickLog; // list of clicks
    private final ArrayList<ServerEntry> serverLog; // list of successful and unsuccessful conversions

    public Campaign(String impressionFile, String clickFile, String serverFile) {
        // log construction
        ArrayList<ImpressionEntry> impressionLog = new ArrayList<>();
        ArrayList<ClickEntry> clickLog = new ArrayList<>();
        ArrayList<ServerEntry> serverLog = new ArrayList<>();

        // reads the impression log file
        Reader impressionReader = new Reader(impressionFile); // file reader
        impressionReader.getLine(); // ignore first line

        // reading the file
        while (impressionReader.fileIsReady()) {
            String[] log = impressionReader.getLine().split(",");

            // extracting the user data from an impression log
            User user = new User(Long.parseLong(log[1]), // id
                    log[2], // gender
                    log[3], // age
                    log[4]);  // income

            // extracting the impression data an impression log
            ImpressionEntry impression = new ImpressionEntry(user.getUserId(),
                    parseDate(log[0]), // date
                    log[5], // context
                    Double.parseDouble(log[6])); // impression cost

            users.put(user.getUserId(), user);
            impressionLog.add(impression);
        }

        // reads the click log file
        Reader clickReader = new Reader(clickFile); // file reader
        clickReader.getLine(); // ignore first line

        // reading the file
        while (clickReader.fileIsReady()){
            String[] log = clickReader.getLine().split(",");

            // extracting the user data an click log
            User user = getUser(Long.parseLong(log[1]));

            // extracting the click data a click log
            ClickEntry click = new ClickEntry(user.getUserId(),
                    parseDate(log[0]), // date
                    Double.parseDouble(log[2])); // click cost

            clickLog.add(click);
        }

        // reads the server log file
        Reader serverReader = new Reader(serverFile); // file reader
        serverReader.getLine(); // ignore first line

        // Reading the file
        while (serverReader.fileIsReady()) {
            String[] log = serverReader.getLine().split(",");

            // extracting the user data an server log
            User user = getUser(Long.parseLong(log[1]));

            // extracting the server data a server log
            ServerEntry server = new ServerEntry(user.getUserId(),
                    parseDate(log[0]), // entry date
                    parseDate(log[2]), // exit date
                    Integer.parseInt(log[3]), // pages viewed
                    log[4].equalsIgnoreCase("Yes")); // conversion

            serverLog.add(server);
        }

        this.impressionLog = impressionLog;
        this.clickLog = clickLog;
        this.serverLog = serverLog;
    }

    // converts string to date, catches n/a end dates
    public LocalDateTime parseDate(String date) {
        if (date.equals("n/a")) {
            return null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(date, formatter);
        }
    }

    // gets a user
    public User getUser(long id) {
        return users.getOrDefault(id, null);
    }

    public MetricCalculator createMetrics() {
        return new MetricCalculator(impressionLog, clickLog, serverLog);
    }

    public ChartCalculator createCharts() {
        return new ChartCalculator(impressionLog, clickLog, serverLog);
    }
}
