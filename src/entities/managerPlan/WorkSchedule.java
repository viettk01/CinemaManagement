package entities.managerPlan;

import entities.user.Staff;

import java.time.LocalDate;

public class WorkSchedule {
    private LocalDate workDate;
    private String user;
    private String staff;

    public WorkSchedule() {
    }

    public WorkSchedule(LocalDate workDate, String user, Staff staff) {
        this.workDate = workDate;
        this.user = user;
        this.staff = String.valueOf(staff);
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "WorkSchedule{" +
                "workDate='" + workDate + '\'' +
                ", user=" + user +
                '}';
    }
}
