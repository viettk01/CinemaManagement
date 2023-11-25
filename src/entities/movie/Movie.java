package entities.movie;

import entities.Rule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Movie {

    private static int autoId;
    private int id;
    private String name;
    private String description;
    private LocalDate releaseDate; // ngày công chiếu
    private Genre genre;
    private double price;
    private Rule rule;
    private Ticket[][] ticket; // vé
    private int totalSold;
    private Map<Integer, Rate> rateMap;

    public Movie() {
    }

    public Movie(Map<Integer, Rate> rateMap) {
        this.rateMap = rateMap;
    }

    public Movie(String name, String description, LocalDate releaseDate, Genre genre, double price, Ticket[][] ticket, Rule rule) {
        this.id = ++autoId;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.price = price;
        this.ticket = ticket;
        this.rule = rule;
    }

    public Movie(String name, String description, LocalDate releaseDate, Genre genre, double price, Rule rule, Ticket[][] ticket, int totalSold) {
        this.id = ++autoId;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.price = price;
        this.ticket = ticket;
        this.rule = rule;
        this.totalSold = totalSold;
    }

    public Map<Integer, Rate> getRateMap() {
        return rateMap;
    }

    public void setRateMap(Map<Integer, Rate> rateMap) {
        this.rateMap = rateMap;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Movie.autoId = autoId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(int totalSold) {
        this.totalSold = totalSold;
    }

    public Ticket[][] getTicket() {
        return ticket;
    }

    public void setTicket(Ticket[][] ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return  "Stt: " + id +
                "\n- Tên: " + name +
                "\n- Nội dung: " + description +
                "\n- Ngày công chiếu: " + releaseDate +
                "\n- Thể Loại: " + genre +
                "\n- Giá vé: " + price +
                "\n- Bình luận của người xem: " + rateMap;
    }
}
