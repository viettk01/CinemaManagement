package ultis;

import entities.Rule;
import entities.movie.Genre;
import entities.movie.Ticket;
import entities.movie.TicketStatus;
import entities.user.UserCustomer;
import entities.user.UserStaff;
import entities.voucher.Voucher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ultis.Parameter.*;
import static ultis.Parameter.select;

public class Ultis {
    // Các hàm input

    public void pressEnter() {
        System.out.println("Ấn Enter để tiếp tục");
        String ok = scanner.nextLine();
    }

    public int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(Parameter.scanner.nextLine());
            } catch (Exception e) {
                System.out.println("nhập sai định dạng vui lòng nhập lại định dạng là số");
            }
        }
    }

    public double inputDouble() {
        while (true) {
            try {
                return Double.parseDouble(Parameter.scanner.nextLine());
            } catch (Exception e) {
                System.out.println("nhập sai định dạng vui lòng nhập lại định dạng là số");
            }
        }
    }

    public String inputEmail() {
        while (true) {
            System.out.println("Nhập email theo định dạng abc@gmail.com: ");
            String email = Parameter.scanner.nextLine();
            if (validateEmail(email)) {
                if (checkUserEmail(email)) {
                    System.out.println("Email đã tồn tại, vui lòng chọn email khác.");
                } else {
                    return email;
                }
            } else {
                System.out.println("Email không hợp lệ vui lòng nhập lại theo định dạng abc@gmail.com");
            }
        }
    }

    public String inputUsername() {
        while (true) {
            System.out.print("Nhập username: ");
            String username = Parameter.scanner.nextLine();
            if (checkUserName(username)) {
                System.out.println("Tài khoản đã tồn tại, vui lòng chọn tài khoản khác.");
            } else {
                return username;
            }
        }
    }

    public String inputName() {
        System.out.print("nhập tên người dùng: ");
        return Parameter.scanner.nextLine();
    }

    public String inputPhoneNumber() {
        while (true) {
            try {
                System.out.print("Nhập số điện thoại: ");
                String phoneNumber = Parameter.scanner.nextLine();
                if (validatePhoneNumber(phoneNumber)) {
                    if (checkUserPhoneNumber(phoneNumber)) {
                        System.out.println("Số điện thoại đã tồn tại, vui lòng chọn số khác.");
                    } else {
                        return phoneNumber;
                    }
                } else {
                    System.out.println("Số điện thoại phải là số bắt đầu bằng số 0 và phải chứa 10 kí tự");
                }
            } catch (Exception e) {
                System.out.println("Số điện thoại phải là số bắt đầu bằng số 0 và phải chứa 10 kí tự");
            }
        }
    }

    public String inputPassword() {
        while (true) {
            System.out.println("Nhập password (Yêu cầu password chứa ít nhất 1 chữ in hoa, 1 chữ thường, 1 ký tự đặc biệt từ 7 đến 15 ký tự.): ");
            String password = Parameter.scanner.nextLine();
            if (validatePassword(password)) {
                return password;
            } else {
                System.out.println("Mật khẩu không hợp lệ mời bạn nhập lại");
            }
        }
    }

    public LocalDate inputLocalDate() {
        while (true) {
            try {
                System.out.println("Nhập đơn vị ngày theo định dạng (dd/MM/yyyy)");
                String input = Parameter.scanner.nextLine();
                return LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng ngày tháng, vui lòng nhập ngày tháng theo định dạng (dd/MM/yyyy)");
            }
        }
    }

    public Genre selectGenre() {
        System.out.println("Chọn thể loại phim mà bạn vừa thêm");
        System.out.println("1. Hành động");
        System.out.println("2. Kinh dị");
        System.out.println("3. Khoa học viễn tưởng");
        System.out.println("4. Phim tình cảm");
        Parameter.select = inputInt();
        switch (Parameter.select) {
            case 1:
                System.out.println("Đã thêm thể loại hành động cho phim");
                return Genre.ACTION;
            case 2:
                System.out.println("Đã thêm thể loại kinh dị cho phim");
                return Genre.HORROR;
            case 3:
                System.out.println("Đã thêm thể loại khoa học viễn tưởng cho phim");
                return Genre.SCIENCE_FICTION;
            case 4:
                System.out.println("Đã thêm thể loại lãng mạn cho phim");
                return Genre.ROMANCE;
            default:
                System.out.println("Kết thúc chương trình");
                return null;
        }
    }

    // Hàm tái sử dụng
    public Ticket[][] createTicket(){
        Ticket[][] array = new Ticket[5][6];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                array[i][j] = new Ticket(TicketStatus.UNSOLD);
            }
        } return array;
    }

    //Hàm Kiểm Tra

    public void loginCustomer(String username, String password) {
        boolean userExists = false;
        for (Map.Entry<Integer, UserCustomer> userEntry : customerMap.entrySet()) {
            if (userEntry.getValue().getUsername().equals(username)) {
                userExists = true;
                if (!userEntry.getValue().getPassword().equals(password)) {
                    System.out.println("Mật khẩu không chính xác. Vui lòng kiểm tra lại.");
                    accountService.forgetPassword(username);
                }
                System.out.println("Đăng nhập thành công");
                int id = userEntry.getValue().getId();
                System.out.println("Xin chào " + userEntry.getValue().getName());
                System.out.println("Mời bạn lựa chọn chức năng");
                stateCustomer.customerMenuState(id);
                break;
            }
        }
        if (!userExists) {
            System.out.println("Tên người dùng không tồn tại.");
            System.out.println("1. Đăng nhập lại");
            System.out.println("0. Trở lại menu chính");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> state.loginCustomerState();
                case 0 -> state.startState();
            }
        }
    }

    public void loginStaff(String username, String password) {
        boolean userExists = false;
        for (Map.Entry<Integer, UserStaff> staffEntry : staffMap.entrySet()) {
            if (staffEntry.getValue().getUsername().equals(username)) {
                userExists = true;
                if (!staffEntry.getValue().getPassword().equals(password)) {
                    System.out.println("Mật khẩu không chính xác. Vui lòng kiểm tra lại.");
                    accountStaffService.forgetPassword(username);
                }
                if (staffEntry.getValue().getStatus().equals(Rule.FALSE)){
                    System.out.println("Tài khoản đã bị nghỉ việc vui lòng kiểm tra lại");
                    System.out.println("Trở về menu chính");
                    ultis.pressEnter();
                    state.startState();
                }
                System.out.println("Đăng nhập thành công");
                int idStaff = staffEntry.getValue().getId();
                System.out.println("Xin chào " + staffEntry.getValue().getName());
                System.out.println("Mời bạn lựa chọn chức năng");
                stateManager.stateMenuManager(idStaff);
                break;
            }
        }
        if (!userExists) {
            System.out.println("Tên người dùng không tồn tại.");
            System.out.println("1. Đăng nhập lại");
            System.out.println("0. Trở lại menu chính");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> state.loginStaffState();
                default -> state.startState();
            }
        }
    }

    public static boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    } // Kiểm tra định dạng Email

    public static boolean validatePassword(String password) {
        String passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[.,-_;]).{7,15}$";
        Pattern pattern = Pattern.compile(passRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    } // Kiểm tra định dạng mật khẩu

    public static boolean validatePhoneNumber(String phoneNumber) {
        String passRegex = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(passRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    } // Kiểm tra định dạng Số điện thoại

    public boolean checkUserName(String username) {
        for (Map.Entry<Integer, UserCustomer> userEntry : customerMap.entrySet()) {
            if (userEntry.getValue().getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    } // Kiểm tra username đã tồn tại chưa

    public boolean checkUserEmail(String email) {
        for (Map.Entry<Integer, UserCustomer> userEntry : customerMap.entrySet()) {
            if (userEntry.getValue().getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }  // Kiểm tra email đã tồn tại chưa

    public boolean checkUserPhoneNumber(String phoneNumber) {
        for (Map.Entry<Integer, UserCustomer> userEntry : customerMap.entrySet()) {
            if (userEntry.getValue().getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }  // Kiểm tra số điện thoại đã tồn tại chưa

    public Boolean checkVoucher(Voucher voucher) {
        if (voucher.getRule() == Rule.NULL) {
            System.out.println("Voucher chưa đến ngày sử dụng vui lòng kiểm tra lại thời gian");
            return false;
        } else if (voucher.getRule() == Rule.FALSE) {
            System.out.println("Voucher đã hết hạn");
            return false;
        } else {
            return true;
        }
    } // Kiểm tra voucher đã đến ngày hoặc hết ngày sử dụng chưa
}
