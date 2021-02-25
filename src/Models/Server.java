package Models;

public class Server {
    private String entryDate; // entry date and time
    private int id; // ~19 digit unique user id
    private String exitDate; // exit date and time
    private int pagesViewied; // num of pages viewed
    private Boolean conversation; // has the user acted after clicking?

    public Server(String entryDate, int id, String exitDate, int pagesViewied, Boolean conversation) {
        this.entryDate = entryDate;
        this.id = id;
        this.exitDate = exitDate;
        this.pagesViewied = pagesViewied;
        this.conversation = conversation;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public int getPagesViewied() {
        return pagesViewied;
    }

    public void setPagesViewied(int pagesViewied) {
        this.pagesViewied = pagesViewied;
    }

    public Boolean getConversation() {
        return conversation;
    }

    public void setConversation(Boolean conversation) {
        this.conversation = conversation;
    }
}
