package states;

import entities.Notification;
import services.userServices.manager.function.NotificationServices;
import services.userServices.manager.plan.VoucherServices;

import static ultis.Parameter.*;

public class StateManager {
    // State Menu Manager
    public void stateMenuManager(int idManager) {
        managerMenu.show(idManager);
    }

    // State Quản lý tài khoản của người dùng
    public void stateStaffAccount(int idStaff) {
        accountStaffService.staffProfile(idStaff);
    }

    // State quản lý nhân sự
    public void stateManagerStaff(int idManager) {
        managerMenu.managerStaffMenu(idManager);
    }
    public void stateAddStaff(int idManager) {
        staffService.addStaff(idManager);
    } // state thêm nhân viên mới
    public void stateDismissStaffing(int idManager) {
        staffService.dismissStaffing(idManager);
    } // Sa thải nhân viên
    public void stateSearchIdStaff(int idManager) {
        staffService.searchIdStaff(idManager);
    } // state tìm kiếm nhân viên theo id
    public void statePrintInfoStaff(int idManager) {
        staffService.printInfoStaffMenu(idManager);
    } // state di chuyển đến menu lựa chọn in ra thông tin nhân sự

    // State quản lý phim
    public void stateManagerMovie(int idManager) {
        managerMenu.managerMovieMenu(idManager);
    } //Menu

    public void stateAddMovie(int idManager) {
        managerMovieServices.addMovie(idManager);
    } // state thêm phim mới

    public void stateRemoveMovie(int idManager) {
        managerMovieServices.removeMovie(idManager);
    }

    public void stateSearchId(int idManager) {
        managerMovieServices.searchIdMovie(idManager);
    } // state tìm kiếm phim theo id

    public void statePrintMovie(int idManager) {
        managerMovieServices.printMovieMenu(idManager);
    } // state menu in phim

    // State quản lý kế hoạch
    public void stateManagePlan(int idManager) {
        managerMenu.managePlanMenu(idManager);
    } //Menu
    // State menu quản lý lịch làm việc
    public void stateManageWorkSchedule(int idManager) {
        workScheduleServices.manager(idManager);
    } // menu workSchedule
    // State menu quản lý targer
    public void stateManageTarget(int idManager) {
        targetServices.manager(idManager);
    }
    // State menu thêm lịch training nhân viên
    public void stateManageTraining(int idManager) {
        trainingServices.manager(idManager);
    }
    // State chuyển hướng đến tạo voucher
    public void stateAddVoucher(int idManager) {
        new VoucherServices().addVoucher(idManager);
    }
    // State chuyển hướng đến tạo thông báo
    public void stateAddNotification(int idManager) {
        new NotificationServices().addNotification();
    }
    // State chuyển đến vị trí in ra tổng số vé được bán của phim
    public void stateMovieSold(int idManager) {
        movieService.movieTotalSale(idManager);
    }



}
