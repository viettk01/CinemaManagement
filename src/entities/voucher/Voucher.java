package entities.voucher;

import entities.Rule;

import java.time.LocalDate;

public class Voucher {
    private String name;
    private Double cost;
    private String description;
    private LocalDate enableDate;
    private LocalDate endDate;
    private Rule rule;

    public Voucher(String name, Double cost, String description, LocalDate enableDate, LocalDate endDate, Rule rule) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.enableDate = enableDate;
        this.endDate = endDate;
        this.rule = rule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDate getEnableDate() {
        return enableDate;
    }

    public void setEnableDate(LocalDate enableDate) {
        this.enableDate = enableDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "\nVoucher: " + name +
                "\n " + description +
                "\n " + cost +
                "\n Hạn sử dụng: " + endDate;
    }
}

