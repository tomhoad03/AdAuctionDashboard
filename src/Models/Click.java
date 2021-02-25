package Models;

public class Click {
    private String date; // date and time
    private int id; // ~19 digit unique user id
    private double clickCost; // 6 d.p. value (>0)

    public Click(String date, int id, int clickCost) {
        this.date = date;
        this.id = id;
        this.clickCost = clickCost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getClickCost() {
        return clickCost;
    }

    public void setClickCost(int clickCost) {
        this.clickCost = clickCost;
    }
}
