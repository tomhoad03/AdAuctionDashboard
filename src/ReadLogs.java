import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadLogs {
    public static void main(String [] args) {
        try {
            // Read the files
            File impressionLog = new File("./src/csv/impression_log.csv");
            File clickLog = new File("./src/csv/click_log.csv");
            File serverLog = new File("./src/csv/server_log.csv");

            readImpressionLog(impressionLog);
            readClickLog(clickLog);
            readServerLog(serverLog);

        // File not found
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void readImpressionLog(File impressionLog) throws FileNotFoundException {
        // Declares impression log reader, ignores the first line (not data)
        Scanner impressionReader = new Scanner(impressionLog);
        impressionReader.nextLine();

        // Reads the file line-by-line
        while (impressionReader.hasNextLine()) {
            String nextLine = impressionReader.nextLine();
            String [] splitLine = nextLine.split(",");

            // Prints contents
            System.out.println("Date: " + splitLine [0] +
                                ", ID: " + splitLine [1] +
                                ", Gender: " + splitLine [2] +
                                ", Age: " + splitLine [3] +
                                ", Income: " + splitLine [4] +
                                ", Context: " + splitLine [5] +
                                ", Impression Cost: " + splitLine [6]);
        }
    }

    public static void readClickLog(File clickLog) throws FileNotFoundException {
        // Declares click log reader, ignores the first line (not data)
        Scanner clickReader = new Scanner(clickLog);
        clickReader.nextLine();

        // Reads the file line-by-line
        while (clickReader.hasNextLine()) {
            String nextLine = clickReader.nextLine();
            String [] splitLine = nextLine.split(",");

            // Prints contents
            System.out.println("Date: " + splitLine [0] +
                                ", ID: " + splitLine [1] +
                                ", Click Cost: " + splitLine [2]);
        }
    }

    public static void readServerLog(File serverLog) throws FileNotFoundException {

    }
}

/*
Notes from observation:
1. Some impression logs have a corresponding click log
2. Every click log has a corresponding server log
3. Users may appear more than once in the impressions, clicks and server logs
4. Some users will "bounce" at the server - failure to interact
 */