package menu;

import entities.user.Staff;
import ultis.Parameter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static ultis.Parameter.*;

public class ManagerMenu {
    /////////// MENU MANAGER ////////////////
    public void show(int idManager) {
        System.out.println("\t===== MANAGER =====");
        System.out.println("1. Quản lý nhân sự");
        System.out.println("2. Quản lý phim");
        System.out.println("3. Quản lý các công việc");
        System.out.println("4. Xem tổng số vé bán của các phim");
        System.out.println("5. Quản lý tài khoản");
        System.out.println("0. Đăng xuất");
        select = Parameter.ultis.inputInt();
        switch (select) {
            case 1:
                stateManager.stateManagerStaff(idManager);
                break;
            case 2:
                stateManager.stateManagerMovie(idManager);
                break;
            case 3:
                stateManager.stateManagePlan(idManager);
                break;
            case 4:
                stateManager.stateMovieSold(idManager);
                break;
            case 5:
                stateManager.stateStaffAccount(idManager);
                break;
            default:
                state.startState();
                break;
        }
    }

    /////////// MENU STAFF MANAGER ///////////

    public void managerStaffMenu(int idManager){
        System.out.println("===== MANAGER =====");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Sa thải nhân viên");
        System.out.println("3. Tìm thông tin nhân viên theo id");
        System.out.println("4. In ra thông tin tất cả các nhân viên");
        System.out.println("0. Quay lại menu");
        select = Parameter.ultis.inputInt();
        switch (select) {
            case 1:
                stateManager.stateAddStaff(idManager);
                break;
            case 2:
                stateManager.stateDismissStaffing(idManager);
                break;
            case 3:
                stateManager.stateSearchIdStaff(idManager);
                break;
            case 4:
                stateManager.statePrintInfoStaff(idManager);
                break;
            default:
                stateManager.stateMenuManager(idManager);
                break;
        }
    }



    /////////// MENU MOVIE MANAGER ///////////

    public void managerMovieMenu(int idManager){
        System.out.println("\t===== MANAGER =====");
        System.out.println("1. Thêm phim mới");
        System.out.println("2. Gỡ phim");
        System.out.println("3. Tìm thông tin phim theo id");
        System.out.println("4. In ra thông tin phim");
        System.out.println("0. Exit");
        select = Parameter.ultis.inputInt();
        switch (select) {
            case 1:
                stateManager.stateAddMovie(idManager);
                break;
            case 2:
                stateManager.stateRemoveMovie(idManager);
                break;
            case 3:
                stateManager.stateSearchId(idManager);
                break;
            case 4:
                stateManager.statePrintMovie(idManager);
                break;
            default:
                break;
        }
    }

    /////////// CREATE PLAN //////////////////


    public void managePlanMenu(int idManager){
        System.out.println("\t===== MANAGER =====");
        System.out.println("1. Sắp xếp lịch làm việc ");
        System.out.println("2. Quản lý target");
        System.out.println("3. Quản lý lịch Training nhân viên");
        System.out.println("4. Tạo voucher gửi đến người dùng");
        System.out.println("5. Tạo thông báo đến người dùng");
        System.out.println("0. Exit");
        select = ultis.inputInt();
        managePlanSelect(idManager);
    }

    public void managePlanSelect(int idManager){
        switch (select){
            case 1:
                stateManager.stateManageWorkSchedule(idManager);
                break;
            case 2:
                stateManager.stateManageTarget(idManager);
                break;
            case 3:
                stateManager.stateManageTraining(idManager);
                break;
            case 4:
                stateManager.stateAddVoucher(idManager);
                break;
            case 5:
                stateManager.stateAddNotification(idManager);
            default:
                stateManager.stateMenuManager(idManager);
                break;
        }
    }

}
