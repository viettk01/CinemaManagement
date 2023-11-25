package services.userServices.customer;

import entities.Rule;
import entities.user.UserCustomer;
import entities.voucher.Voucher;
import ultis.Parameter;

import java.time.LocalDate;
import java.util.Map;
import static ultis.Parameter.*;

public class AccountServices {
    Voucher voucherNewUser = new Voucher("Chào bạn mới", 100000.0, "Voucher dành tặng cho người dùng mới giảm 50.000đ cho đơn hàng, có thời hạn 7 ngày kể từ ngày tạo tài khoản", LocalDate.now(), LocalDate.now().plusDays(7), Rule.TRUE);
    String username;
    String password;
    String name;
    String email;
    String phoneNumber;
    LocalDate birthOfDate;

    public void registerCustomer() {
        vouchers.add(voucherNewUser);
        System.out.println("===== MENU REGISTER =====");
        username = Parameter.ultis.inputUsername();
        password = Parameter.ultis.inputPassword();
        name = Parameter.ultis.inputName();
        email = Parameter.ultis.inputEmail();
        phoneNumber = Parameter.ultis.inputPhoneNumber();
        System.out.println("Nhập ngày tháng năm sinh");
        birthOfDate = Parameter.ultis.inputLocalDate();
        System.out.println("Đăng ký thành công!");
        customer = new UserCustomer(username, password, name, email, phoneNumber, birthOfDate);
        customer.setVoucher(vouchers);
        customerMap.put(customer.getId(), customer);
        state.loginCustomerState();
    } // đăng kí người dùng


    public void loginType() {
        System.out.println("\t===== LOGIN =====");
        System.out.println("Vui lòng lựa chọn kiểu đăng nhập");
        System.out.println("1. Đăng nhập tài khoản người dùng");
        System.out.println("2. Đăng nhập tài khoản nhân viên");
        System.out.println("0. Quay lại menu");
        select = ultis.inputInt();
        switch (select) {
            case 1 -> state.loginCustomerState();
            case 2 -> state.loginStaffState();
            default -> state.startState();
        }
    }

    public void loginCustomer() {
        System.out.println("\t===== LOGIN =====");
        System.out.print("Nhập username: ");
        username = scanner.nextLine();
        System.out.print("Nhập password: ");
        password = scanner.nextLine();
        Parameter.ultis.loginCustomer(username, password);
    }

    public void userProfile(int idUser) {
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
                profileInfo(idUser);
                break;
            case 2:
                changeUserName(idUser);
                break;
            case 3:
                changePassword(idUser);
                break;
            case 4:
                changeEmail(idUser);
                break;
            case 5:
                changePhoneNumber(idUser);
                break;
            default:
                stateCustomer.customerMenuState(idUser);
                break;
        }
    }


    public void profileInfo(int idUser) {
        System.out.println(customerMap.get(idUser));
        ultis.pressEnter();
        stateCustomer.accountManager(idUser);
    }

    public void forgetPassword(String username) {
        System.out.println("1. Đăng nhập lại");
        System.out.println("2. Quên mật khẩu");
        System.out.println("0. Exit");
        select = Integer.parseInt(scanner.nextLine());
        switch (select) {
            case 1 -> state.loginCustomerState();
            case 2 -> resetPassword(username);
            default -> state.startState();
        }
    }

    public void changePassword(int idUser) {
        System.out.println("Nhập email để thực hiện thay đổi password");
        String email = scanner.nextLine();
        customer = customerMap.get(idUser);
        if (!customer.getEmail().equals(email)) {
            System.out.println("Email sai vui lòng kiểm tra lại");
            System.out.println("1. Nhập lại email");
            System.out.println("0. Exit");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> changePassword(idUser);
                default -> stateCustomer.customerMenuState(idUser);
            }
        }
        customer = customerMap.get(idUser);
        System.out.println("Nhập mật khẩu mới");
        String password = ultis.inputPassword();
        customer.setPassword(password);
        System.out.println("Đã đổi mật khẩu thành công");
        ultis.pressEnter();
        ultis.pressEnter();
        stateCustomer.accountManager(idUser);
    } // đổi mật khẩu cho tài khoản đã đăng nhập

    public void resetPassword(String username) {
        System.out.println("Nhập email để thực hiện thay đổi mật khẩu");
        String email = scanner.nextLine();
        boolean userExists = false;
        for (Map.Entry<Integer, UserCustomer> userEntry : customerMap.entrySet()) {
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

    public void changeUserName(int idUser) {
        System.out.println("Nhập password để thực hiện thay đổi username");
        String password = ultis.inputPassword();
        customer = customerMap.get(idUser);
        if (!customer.getPassword().equals(password)) {
            System.out.println("Password sai vui lòng kiểm tra lại");
            System.out.println("1. Nhập lại password");
            System.out.println("0. Exit");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> changeUserName(idUser);
                default -> stateCustomer.customerMenuState(idUser);
            }
        }
        System.out.println("Password chính xác, mời bạn nhập username mới");
        String usernameChange = ultis.inputUsername();
        customer.setUsername(usernameChange);
        System.out.println("Username đã được thay đổi thành: '" + usernameChange +"'");
        ultis.pressEnter();
        stateCustomer.customerMenuState(customer.getId());
    }

    public void changeEmail(int idUser) {
        System.out.println("Nhập số điện thoại để xác minh");
        String phoneNumber = ultis.inputPhoneNumber();
        customer = customerMap.get(idUser);
        if (!customer.getPhoneNumber().equals(phoneNumber)) {
            System.out.println("Số điện thoại không đúng vui lòng thử lại");
            System.out.println("1. Nhập lại số điện thoại");
            System.out.println("0. Exit");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> changeEmail(idUser);
                default -> stateCustomer.customerMenuState(idUser);
            }
        String emailChange = ultis.inputEmail();
        customer.setEmail(emailChange);
        System.out.println("Email đã được thay đổi thành: " + emailChange);
        ultis.pressEnter();
        stateCustomer.accountManager(idUser);
        }
    }


    public void changePhoneNumber(int idUser){
        System.out.println("Nhập email để thực hiện thay đổi số điện thoại");
        String email = ultis.inputEmail();
        customer = customerMap.get(idUser);
        if (!customer.getEmail().equals(email)) {
            System.out.println("Email sai vui lòng kiểm tra lại");
            System.out.println("1. Nhập lại email");
            System.out.println("0. Exit");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> changePhoneNumber(idUser);
                default -> stateCustomer.customerMenuState(idUser);
            }
        }
        System.out.println("Nhập số điện thoại mới");
        String newPhoneNumber = ultis.inputPhoneNumber();
        customer.setPhoneNumber(newPhoneNumber);
        System.out.println("Thay đổi thành công, số điện thoại mới là: " + newPhoneNumber);
        ultis.pressEnter();
        stateCustomer.accountManager(idUser);
    }

}

