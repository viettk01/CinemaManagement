package services.userServices;

import entities.user.UserStaff;
import ultis.Parameter;

import java.time.LocalDate;
import java.util.Map;

import static ultis.Parameter.*;
import static ultis.Parameter.staff;

public class AccountStaffServices {
    String username;
    String password;
    String name;
    String email;
    String phoneNumber;
    LocalDate birthOfDate;

    public UserStaff registerStaff() {
        System.out.println("===== MENU REGISTER =====");
        username = Parameter.ultis.inputUsername();
        password = Parameter.ultis.inputPassword();
        name = Parameter.ultis.inputName();
        email = Parameter.ultis.inputEmail();
        phoneNumber = Parameter.ultis.inputPhoneNumber();
        System.out.println("Nhập ngày tháng năm sinh");
        birthOfDate = Parameter.ultis.inputLocalDate();
        System.out.println("Đăng ký thành công!");
        return new UserStaff(username, password, name, email, phoneNumber, birthOfDate);
    } // đăng kí tài khoản nội bộ

    public void loginStaff() {
        System.out.println("\t===== LOGIN STAFF =====");
        System.out.print("Nhập username: ");
        username = scanner.nextLine();
        System.out.print("Nhập password: ");
        password = scanner.nextLine();
        Parameter.ultis.loginStaff(username, password);
    }

    public void staffProfile(int idStaff) {
        System.out.println("\t===== PROFILE =====");
        System.out.println("1. thông tin tài khoản"); // OK
        System.out.println("2. Thay đổi tên người dùng"); // OK
        System.out.println("3. Thay đổi mật khẩu"); // OK
        System.out.println("4. Thay đổi email");
        System.out.println("5. Thay đổi số điện thoại");
        System.out.println("0. Exit");
        int select = Parameter.ultis.inputInt();
        switch (select) {
            case 1:
                profileInfo(idStaff);
                break;
            case 2:
                changeUserName(idStaff);
                break;
            case 3:
                changePassword(idStaff);
                break;
            case 4:
                changeEmail(idStaff);
                break;
            case 5:
                changePhoneNumber(idStaff);
                break;
            default:
                stateManager.stateMenuManager(idStaff);
                break;
        }
    }


    public void profileInfo(int idStaff) {
        System.out.println(staffMap.get(idStaff));
        ultis.pressEnter();
        stateManager.stateStaffAccount(idStaff);
    }

    public void forgetPassword(String username) {
        System.out.println("1. Đăng nhập lại");
        System.out.println("2. Quên mật khẩu");
        System.out.println("0. Exit");
        select = Integer.parseInt(scanner.nextLine());
        switch (select) {
            case 1 -> state.loginStaffState();
            case 2 -> resetPassword(username);
            default -> state.startState();
        }
    }

    public void changePassword(int idStaff) {
        System.out.println("Nhập email để thực hiện thay đổi password");
        String email = scanner.nextLine();
        staff = staffMap.get(idStaff);
        if (!staff.getEmail().equals(email)) {
            System.out.println("Email sai vui lòng kiểm tra lại");
            System.out.println("1. Nhập lại email");
            System.out.println("0. Exit");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> changePassword(idStaff);
                default -> stateManager.stateStaffAccount(idStaff);
            }
        }
        staff = staffMap.get(idStaff);
        System.out.println("Nhập mật khẩu mới");
        String password = ultis.inputPassword();
        staff.setPassword(password);
        System.out.println("Đã đổi mật khẩu thành công");
        ultis.pressEnter();
        stateManager.stateStaffAccount(idStaff);
    } // đổi mật khẩu cho tài khoản đã đăng nhập

    public void resetPassword(String username) {
        System.out.println("Nhập email để thực hiện thay đổi mật khẩu");
        String email = scanner.nextLine();
        boolean userExists = false;
        for (Map.Entry<Integer, UserStaff> userEntry : staffMap.entrySet()) {
            if (userEntry.getValue().getUsername().equals(username)) {
                userExists = true;
                if (userEntry.getValue().getEmail().equals(email)) {
                    System.out.println("Email chính xác vui lòng nhập mật khẩu mới");
                    String newPassword = ultis.inputPassword();
                    userEntry.getValue().setPassword(newPassword);
                    System.out.println("Mật khẩu đã được thay đổi vui lòng đăng nhập lại");
                    state.loginState();
                    break;
                } else {
                    System.out.println("Email sai vui lòng kiểm tra lại");
                    System.out.println("1. Tiếp tục quên mật khẩu");
                    System.out.println("0. Trở lại menu chính");
                    select = ultis.inputInt();
                    switch (select) {
                        case 1 -> resetPassword(username);
                        case 2 -> state.startState();
                    }
                    break;
                }
            }
        }
    }// đổi mật khẩu cho tài khoản chưa đăng nhập

    public void changeUserName(int idStaff) {
        System.out.println("Nhập password để thực hiện thay đổi username");
        String password = ultis.inputPassword();
        staff = staffMap.get(idStaff);
        if (!staff.getPassword().equals(password)) {
            System.out.println("Password sai vui lòng kiểm tra lại");
            System.out.println("1. Nhập lại password");
            System.out.println("0. Exit");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> changeUserName(idStaff);
                default -> stateManager.stateStaffAccount(idStaff);
            }
        }
        System.out.println("Password chính xác, mời bạn nhập username mới");
        String usernameChange = ultis.inputUsername();
        staff.setUsername(usernameChange);
        System.out.println("Username đã được thay đổi thành: '" + usernameChange +"'");
        ultis.pressEnter();
        stateManager.stateStaffAccount(idStaff);
    }

    public void changeEmail(int idStaff) {
        System.out.println("Nhập số điện thoại để xác minh");
        String phoneNumber = ultis.inputPhoneNumber();
        staff = staffMap.get(idStaff);
        if (!staff.getPhoneNumber().equals(phoneNumber)) {
            System.out.println("Số điện thoại không đúng vui lòng thử lại");
            System.out.println("1. Nhập lại số điện thoại");
            System.out.println("0. Exit");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> changeEmail(idStaff);
                default -> stateManager.stateStaffAccount(idStaff);
            }
            String emailChange = ultis.inputEmail();
            staff.setEmail(emailChange);
            System.out.println("Email đã được thay đổi thành: " + emailChange);
            ultis.pressEnter();
            stateManager.stateStaffAccount(idStaff);
        }
    }


    public void changePhoneNumber(int idStaff){
        System.out.println("Nhập email để thực hiện thay đổi số điện thoại");
        String email = ultis.inputEmail();
        staff = staffMap.get(idStaff);
        if (!staff.getEmail().equals(email)) {
            System.out.println("Email sai vui lòng kiểm tra lại");
            System.out.println("1. Nhập lại email");
            System.out.println("0. Exit");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> changePhoneNumber(idStaff);
                default -> stateManager.stateStaffAccount(idStaff);
            }
        }
        System.out.println("Nhập số điện thoại mới");
        String newPhoneNumber = ultis.inputPhoneNumber();
        staff.setPhoneNumber(newPhoneNumber);
        System.out.println("Thay đổi thành công, số điện thoại mới là: " + newPhoneNumber);
        ultis.pressEnter();
        stateManager.stateStaffAccount(idStaff);
    }

}
