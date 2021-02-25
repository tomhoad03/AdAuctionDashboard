package Models;

import java.io.*;

public class Reader {

    /**
    Number of impressions: people who saw the ad
    Number of clicks: people who clicked the ad
    Number of uniques: unique people who saw the ad
    Number of Bounces: number of people who clicked away after a while
    Number of Conversions: clicks then acts on ad
    Total Cost:
    CTR: Click through rate, clicks per impression
    CPA: Cost per aquisition
    CPC: Cost per click
    CPM: Cost per thousand impressions
    Bounce rate
    */

    public Reader(String fileName) {
        configuration = new File(fileName);
        this.fileName = fileName;
        try {
            reader = new BufferedReader(new FileReader(configuration));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    File configuration;
    BufferedReader reader;
    String fileName;

    public String getLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean fileIsReady() {
        try {

            if (configuration == null || reader == null) {
                return false;
            } else return reader.ready();
        } catch (IOException e) {
            return false;
        }
    }
}

