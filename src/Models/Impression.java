package Models;

public class Impression {
    private String date; // date and time
    private int id; // ~19 digit unique id
    private String gender; // male or female
    private String age; // <25, 25-34, 35-44, 45-54, >54
    private String income; // high, medium or low
    private String context; // blog, new, shopping, social media
    private int impressionCost; // 6 d.p. value (>0)

    public Impression(String date, int id, String gender, String age, String income, String context, int impressionCost) {
        this.date = date;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.income = income;
        this.context = context;
        this.impressionCost = impressionCost;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getImpressionCost() {
        return impressionCost;
    }

    public void setImpressionCost(int impressionCost) {
        this.impressionCost = impressionCost;
    }
}
