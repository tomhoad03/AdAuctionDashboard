import java.io.File;
import java.util.Scanner;

public class ReadClicks {
    public static void main(String[] args) {
        try {
            File clickLog = new File("csv/click_log.csv");
            Scanner clickReader = new Scanner(clickLog);
            while (clickReader.hasNextLine()) {
                System.out.println(clickReader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
