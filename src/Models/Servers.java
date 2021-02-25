package Models;

import java.util.ArrayList;

public class Servers {
    private int bounceNo; // number of bounces
    private int conversionNo; // number of conversions

    private ArrayList<Server> servers; // i hate this and the class naming but cant think of anything better

    public Servers(String serverLog) {
        // Reads the csv
        Reader serverReader = new Reader(serverLog);
        serverReader.getLine(); // removing first line

        // Reading line-by-line
        while (serverReader.fileIsReady()){
            String[] log = serverReader.getLine().split(",");

            // counting total conversions
            boolean conversion = false;
            if (log[4].equals("Yes")) {
                conversionNo++;
                conversion = true;
            }

            // converting to appropriate types
            int id = Integer.parseInt(log[1]);
            int pages = Integer.parseInt(log[3]);

            // creates new impression
            Server server = new Server(log[0], // entry date
                                        id, // user id
                                        log[2], // exit date
                                        pages, // pages visited
                                        conversion); // conversion
            servers.add(server);
        }
    }
}
