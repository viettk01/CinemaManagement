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
        System.out.println("6. Đánh giá phim đã xem");
        System.out.println("7. Quản lý tài khoản");
        System.out.println("0. Exit");
        select = Parameter.ultis.inputInt();
        switch (select) {
            case 1 -> stateCustomer.movieInfoState(idUser);
            case 2 -> stateCustomer.voucherPrintState(idUser);
            case 3 -> stateCustomer.notificationPrintState(idUser);
            case 4 -> stateCustomer.balanceInfoState(idUser);
            case 5 -> stateCustomer.billInfoState(idUser);
            case 6 -> stateCustomer.rateMovieState(idUser);
            case 7 -> stateCustomer.accountManager(idUser);
            default -> state.startState();
        }
    }
}
