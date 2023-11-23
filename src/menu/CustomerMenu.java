package menu;

import ultis.Parameter;

import static ultis.Parameter.*;


public class CustomerMenu {
    public void show(int idUser) {
        System.out.println("1. Phim");
        System.out.println("2. Voucher");
        System.out.println("3. Thông báo");
        System.out.println("4. Ví");
        System.out.println("5. Xem vé đã mua");
        System.out.println("6. Quản lý tài khoản");
        System.out.println("0. Exit");
        select = Parameter.ultis.inputInt();
        switch (select) {
            case 1:
                stateCustomer.movieInfoState(idUser);
                break;
            case 2:
                stateCustomer.voucherPrintState(idUser);
                break;
            case 3:
                stateCustomer.notificationPrintState(idUser);
                break;
            case 4:
                stateCustomer.balanceInfoState(idUser);
                break;
            case 5:
                stateCustomer.billInfoState(idUser);
                break;
            case 6:
                stateCustomer.accountManager(idUser);
                break;
            default:
                state.startState();
                break;
        }
    }
}
