package entities.managerPlan;

import entities.user.Staff;

import java.time.LocalDate;

public class Training {
    private static int autoNumber;
    private int numericalOrder;
    private LocalDate trainingDate;
    private int id;
    private String name;
    private Staff staff;

    public Training() {
    }

    public Training(LocalDate trainingDate, int id, String name, Staff staff) {
        this.id = ++autoNumber;
        this.trainingDate = trainingDate;
        this.id = id;
        this.name = name;
        this.staff = staff;
    }

    public int getNumericalOrder() {
        return numericalOrder;
    }

    public void setNumericalOrder(int numericalOrder) {
        this.numericalOrder = numericalOrder;
    }

    public LocalDate getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(LocalDate trainingDate) {
        this.trainingDate = trainingDate;
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

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return  " Ngày training: " + trainingDate +
                "\n Nhân viên: " + name +
                "\n Chức vụ: " + staff;
    }
}
