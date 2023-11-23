package services.userServices.manager.plan;

import entities.Rule;
import entities.user.Staff;
import entities.user.UserCustomer;
import entities.voucher.Voucher;
import ultis.Parameter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static ultis.Parameter.*;

public class VoucherServices {
    public void addVoucher(int idManager) {
        System.out.println("nhập tên voucher");
        String name = Parameter.scanner.nextLine();
        System.out.println("Nhập số tiền giảm giá của voucher");
        Double cost = Parameter.ultis.inputDouble();
        System.out.println("Nhập nội dung của voucher");
        String description = Parameter.scanner.nextLine();
        LocalDate enableDate;
        while (true) {
            System.out.println("Nhập ngày voucher bắt đầu có hiệu lực:");
            enableDate = Parameter.ultis.inputLocalDate();

            boolean checkLocalDate = enableDate.isAfter(LocalDate.now());
            if (!checkLocalDate == true) {
                System.out.println("Ngày nhập vào phải là từ sau ngày hôm nay trở đi");
            } else {
                break;
            }
        }

        System.out.println("nhập hạn sử dụng: ");
        LocalDate endDate = Parameter.ultis.inputLocalDate();

        Rule rule = Rule.NULL;
        Voucher voucher = new Voucher(name, cost, description, enableDate, endDate, rule);
        vouchers.add(voucher);
        for (Map.Entry<Integer, UserCustomer> userEntry : Parameter.customerMap.entrySet()) {
            if (userEntry.getValue().getStaff().equals(Staff.CUSTOMER)) {
                userEntry.getValue().setVoucher(vouchers);
            }
        }
        state.logicState();

        System.out.println("Đã thêm thành công, thông tin voucher: "+voucher);
        Parameter.ultis.pressEnter();
        stateManager.stateManagePlan(idManager);
    }



}
