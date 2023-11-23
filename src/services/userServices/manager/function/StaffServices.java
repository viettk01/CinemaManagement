package services.userServices.manager.function;

import entities.Rule;
import entities.user.Staff;
import entities.user.UserStaff;
import ultis.Parameter;

import java.util.Map;

import static ultis.Parameter.*;

public class StaffServices {
    // Thêm nhân viên mới
    public void addStaff(int idManager) {
        System.out.println("===== MENU ADD STAFF =====");
        System.out.println("Lựa chọn vị trí công việc cho nhân viên mới");
        System.out.println("1. TICKET SALESPERSON (Nhân viên bán vé)");
        System.out.println("2. PROJECTIONIST (Kỹ thuật viên chiếu phim)");
        System.out.println("3. USHER (Nhân viên hướng dẫn khách)");
        System.out.println("0. Quay lại");
        System.out.print("Chọn: ");
        Parameter.select = Parameter.ultis.inputInt();
        addStaffSelect(idManager);
    }

    public void addStaffSelect(int idManager) {
        switch (select) {
            case 1:
                staff = accountStaffService.registerStaff();
                staff.setStaff(Staff.TICKET_SALESPERSON);
                staff.setStatus(Rule.TRUE);
                Parameter.staffMap.put(staff.getId(), staff);
                stateManager.stateManagerStaff(idManager);
                break;
            case 2:
                staff = Parameter.accountStaffService.registerStaff();
                staff.setStaff(Staff.PROJECTIONIST);
                staff.setStatus(Rule.TRUE);
                Parameter.staffMap.put(staff.getId(), staff);
                stateManager.stateManagerStaff(idManager);
            case 3:
                staff = Parameter.accountStaffService.registerStaff();
                staff.setStaff(Staff.USHER);
                staff.setStatus(Rule.TRUE);
                Parameter.staffMap.put(staff.getId(), staff);
                stateManager.stateManagerStaff(idManager);
            default:
                stateManager.stateManagerStaff(idManager); // quay trở lại màn hình quản lý nhân sự
                break;
        }
    }

    // Đuổi việc nhân viên
    public void dismissStaffing(int idManager){
        System.out.println("===== MENU REMOVE =====");
        System.out.println("Nhập id nhân viên mà bạn muốn cho nghỉ việc");
        int id = Parameter.ultis.inputInt();

        if (staffMap.get(id).getStatus().equals(Rule.FALSE)) {
            System.out.println("Nhân viên này đang trong trạng thái nghỉ việc!");
            System.out.println("1. Nhập lại id");
            System.out.println("0. Quay lại");
            select = ultis.inputInt();
            switch (select) {
                case 1 -> dismissStaffing(idManager);
                default -> stateManager.stateManagerStaff(idManager);
            }
        }
        UserStaff staff = staffMap.get(id);
        if (!staffMap.containsKey(id)) {
            System.out.println("id không tồn tại vui lòng kiểm tra lại id nhân viên và nhập lại");
            dismissStaffing(idManager);
        }
        System.out.println("Thông tin nhân viên bạn muốn cho nghỉ việc \n"+ staff);
        System.out.println("bạn có xác nhận đuổi việc nhân viên này không");
        System.out.println("1. Xác nhận đuổi việc");
        System.out.println("0. Quay trở lại");
        select = ultis.inputInt();
        if (select == 0) {
            stateManager.stateManagerStaff(idManager);
        }
        staff.setStatus(Rule.FALSE); //Rule False = sa thải
        System.out.println("Đã cho nghỉ việc nhân viên thành công");
        ultis.pressEnter();
        stateManager.stateManagerStaff(idManager);
    }

    // Tìm kiếm thông tin nhân viên theo id
    public void searchIdStaff(int idManager){
        System.out.println("Nhập id nhân viên");
        int id = Parameter.ultis.inputInt();
        if (!staffMap.containsKey(id)){
            System.out.println("id không tồn tại vui lòng nhập lại");
            searchIdStaff(idManager);
        }
        System.out.println(staffMap.get(id));
        ultis.pressEnter();
        stateManager.stateManagerStaff(idManager);
    }

    // In ra danh sách nhân viên
    public void printInfoStaffMenu(int idManager) {
        System.out.println("1. In danh sách nhân viên đang làm việc");
        System.out.println("2. In danh sách nhân viên đã nghỉ việc");
        System.out.println("0. Quay lại");
        select = ultis.inputInt();
        switch (select) {
            case 1 -> printInfoStaffTrue(idManager); //True
            case 2 -> printInfoStaffFalse(idManager); //False
            default -> stateManager.stateManagerStaff(idManager);
        }
    }

    // In ra danh sách nhân viên đang làm việc
    public void printInfoStaffTrue(int idManager) {
        System.out.println("Danh sách nhân viên đang làm việc");
        for (Map.Entry<Integer, UserStaff> staffEntry : staffMap.entrySet()) {
                if (staffEntry.getValue().getStatus().equals(Rule.TRUE)){
                    System.out.println(staffEntry.getValue());
                }
        }
        ultis.pressEnter();
        stateManager.stateManagerStaff(idManager);
    }

    public void printInfoStaffFalse(int idManager) {
        System.out.println("Danh sách nhân viên đã nghỉ việc");
        for (Map.Entry<Integer, UserStaff> staffEntry : staffMap.entrySet()) {
            if (staffEntry.getValue().getStatus().equals(Rule.FALSE)){
                System.out.println(staffEntry.getValue());
            }
        }
        ultis.pressEnter();
        stateManager.stateManagerStaff(idManager);
    }

}
