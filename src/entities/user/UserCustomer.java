package entities.user;

import entities.Rule;
import entities.movie.Bill;
import entities.voucher.Voucher;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserCustomer {

    private static int autoId = 0;
    public int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate birthOfDate;
    private ArrayList<Voucher> voucher = new ArrayList<>();
    private Double balance;
    private Rule status;
    private ArrayList<Bill> bill;
    private Staff staff;

    public UserCustomer() {
    }
    public UserCustomer(String username, String password, String name, String email, String phoneNumber, LocalDate birthOfDate) {
        this.id = ++autoId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthOfDate = birthOfDate;
        this.balance = 50000.0;
        this.status = Rule.TRUE;
        this.staff = Staff.CUSTOMER;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public ArrayList<Bill> getBill() {
        return bill;
    }

    public void setBill(ArrayList<Bill> bill) {
        this.bill = bill;
    }

    public LocalDate getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(LocalDate birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public Rule getStatus() {
        return status;
    }

    public void setStatus(Rule status) {
        this.status = status;
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

    public ArrayList<Voucher> getVoucher() {
        return voucher;
    }

    public void setVoucher(ArrayList<Voucher> voucher) {
        this.voucher = voucher;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\n===== Thông tin =====" +
                "\n- id: " + id +
                "\n- username: " + username +
                "\n- Tên: " + name +
                "\n- Email: " + email +
                "\n- Số điện thoại: " + phoneNumber +
                "\n- Ngày tháng năm sinh: " + birthOfDate;
    }
}
