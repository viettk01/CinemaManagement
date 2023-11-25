package states;

import ultis.Parameter;

public class StateCustomer {
    // State Menu của người dùng
    public void customerMenuState(int idUser){
        Parameter.customerMenu.show(idUser);
    }

    // State quản lý tài khoản người dùng
    public void accountManager(int idUser) {
        Parameter.accountService.userProfile(idUser);
    }


    // State in ra danh sách phim
    public void movieInfoState(int idUser){
        Parameter.movieService.movieInfo(idUser);
    }

    // State mua vé
    public void buyTicketState(int idMovie, int idUser) {
        Parameter.movieService.buyTicket(idMovie, idUser);
    }

    // State kiểm tra voucher của tài khoản
    public void voucherPrintState(int idUser) {
        Parameter.customerSevice.printVoucher(idUser);
    }

    // State in ra các thông báo của tài khoản người dùng
    public void notificationPrintState(int idUser) {
        Parameter.customerSevice.printUserNotification(idUser);
    }

    // State xem thông tin số dư của tài khoản
    public void balanceInfoState(int idUser){
        Parameter.customerSevice.balanceInfo(idUser);
    }

    // State xem thông tin vé đã mua
    public void billInfoState(int idUser) {
        Parameter.customerSevice.printBill(idUser);
    }

    // State cho người dùng đánh giá phim
    public void rateMovieState(int idUser) {
        Parameter.customerSevice.rateChose(idUser);
    }
}
