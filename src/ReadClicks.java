import java.io.File;
import java.util.Scanner;

public class ReadClicks {
    public static void main(String [] args) {
        try {
            // Finds the csv file giving information about clicks
            File clickLog = new File("./src/csv/click_log.csv");
            Scanner clickReader = new Scanner(clickLog);

            // Ignores the first line (not data)
            clickReader.nextLine();

            // Reads the csv file line-by-line
            while (clickReader.hasNextLine()) {
                String nextLine = clickReader.nextLine();
                String [] splitLine = nextLine.split(",");

                System.out.println("Date: " + splitLine [0] + ", ID: " + splitLine [1] + ", Click Cost: " + splitLine [2]);
            }
        // File not found
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

/*
Notes from observation:
1. Some impression logs have a corresponding click log
2. Every click log has a corresponding server log
3. Users may appear more than once in the impressions, clicks and server logs
4. Some users will "bounce" at the server - failure to interact
 */