package Models;

public class Campaign {
    public static void main(String[] args) {
        MetricCalculator calculator1 = new MetricCalculator();
        MetricCalculator calculator2 = new MetricCalculator();

        calculator1.calculateMetrics(2, 200, "2015-01-01 12:01:21", "2015-01-01 13:51:59");
        calculator1.print();

        System.out.println(" ");

        calculator2.calculateMetrics(2, 200, "n/a", "n/a");
        calculator2.print();
    }
}
