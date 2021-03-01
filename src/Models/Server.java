package Models;

import java.time.LocalDateTime;

public class Server {
    LocalDateTime entryDate; // entry date and time, stored as date
    long id; // ~19 digit unique user id
    LocalDateTime exitDate; // exit date and time
    int pages; // num of pages viewed
    boolean conversion; // has the user acted after clicking?

    public Server(LocalDateTime entryDate, long id, LocalDateTime exitDate, int pages, boolean conversion) {
        this.entryDate = entryDate;
        this.id = id;
        this.exitDate = exitDate;
        this.pages = pages;
        this.conversion = conversion;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public int getPages() {
        return pages;
    }

    public boolean isConversion() {
        return conversion;
    }
}
