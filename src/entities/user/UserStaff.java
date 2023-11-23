package entities.user;

import entities.Rule;

import java.time.LocalDate;

public class UserStaff {
    private static int autoId = 0;
    public int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate birthOfDate;
    Staff staff;
    private Rule status;

    public UserStaff() {
    }
    // contructor register
    public UserStaff(String username, String password, String name, String email, String phoneNumber, LocalDate birthOfDate) {
        this.id = ++autoId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthOfDate = birthOfDate;
    }
    // Contructor Hardcode
    public UserStaff(String username, String password, String name, String email, String phoneNumber, LocalDate birthOfDate, Staff staff, Rule status) {
        this.id = ++autoId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthOfDate = birthOfDate;
        this.staff = staff;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(LocalDate birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Rule getStatus() {
        return status;
    }

    public void setStatus(Rule status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n===== Thông tin =====" +
                "\n- id: " + id +
                "\n- username: " + username +
                "\n- Tên: " + name +
                "\n- Email: " + email +
                "\n- Số điện thoại: " + phoneNumber +
                "\n- Ngày tháng năm sinh: " + birthOfDate+
                "\n- Chức Vụ: " +staff;
    }
}
