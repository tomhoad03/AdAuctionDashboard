package Models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ChartCalculator {
    private final Impressions impressions;
    private final Clicks clicks;
    private final Servers servers;

    /**
    my next approach will be to try results in multiple groups depending on time granularity
    the first step will be to produce of start and end date pairs where each item follows on from the last
    eg. (Jan-March, April-June, July-Sep, etc.)
    **/

    public ChartCalculator(Impressions impressions, Clicks clicks, Servers servers) {
        this.impressions = impressions;
        this.clicks = clicks;
        this.servers = servers;
    }

    // creates a list of dates separated by a constant interval
    public void createDates() {
        ArrayList<LocalDateTime> dates = new ArrayList<>();
        dates.add(LocalDateTime.now());

        // calculates time difference
        long weeks = ChronoUnit.WEEKS.between(LocalDateTime.now(), LocalDateTime.now().plusYears(1));

        // gets dates at every interval
        for (long i=1; i<weeks; i++) {
            dates.add(LocalDateTime.now().plusWeeks(i));
        }

        System.out.println(dates);
        System.out.println(dates.size());
    }
}
