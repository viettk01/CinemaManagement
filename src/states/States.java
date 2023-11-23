package states;

import services.userServices.customer.AccountServices;
import ultis.Data;
import ultis.Logic;
import ultis.Parameter;

public class States {
    // State Khởi động
    public void initState() {
        new Data().addUser();
        new Data().addNotification();
        new Data().addMovie();
        new Data().addManager();
        logicState();
    }

    public void logicState() {
        new Logic().logicVoucher();
    }
    // States Bắt đầu
    public void startState() {
    Parameter.menuMain.menuMainDisplay();
    }

    // State Đăng Ký
    public void registerState() {
        Parameter.accountService.registerCustomer();
    }

    // State Đăng Nhập
    public void loginState(){
    Parameter.accountService.loginType();
    }

    public void loginCustomerState() {
        Parameter.accountService.loginCustomer();
    }

    public void loginStaffState() {
        Parameter.accountStaffService.loginStaff();
    }
}
