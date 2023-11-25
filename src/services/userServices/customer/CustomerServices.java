package services.userServices.customer;

import entities.Notification;
import entities.movie.Bill;
import entities.movie.Rate;
import entities.user.UserCustomer;
import entities.voucher.Voucher;
import ultis.Parameter;

import java.util.ArrayList;
import java.util.Map;

import static ultis.Parameter.*;

public class CustomerServices {
    public void printVoucher(int idUser) {
        ArrayList<Voucher> voucher = customerMap.get(idUser).getVoucher();
        if (voucher.size() >= 1) {
            System.out.println("bạn đang có " + voucher.size() + " voucher:");
            for (int i = 0; i < voucher.size(); i++) {
                System.out.println((i + 1) + "-\t" + voucher);
            }
        } else {
            System.out.println("Hiện tại bạn chưa có voucher nào");
        }
        Parameter.ultis.pressEnter();
        stateCustomer.customerMenuState(idUser);
    }

    public void printUserNotification(int idUser){
        UserCustomer user = customerMap.get(idUser);
        for (Notification notificationCheck : notifications){
            if (notificationCheck.getIdUserName() == user.getId()){
                System.out.println("*" + notificationCheck);
            } else {
                System.out.println("[NEW]" + notificationCheck);
                notificationCheck.setIdUserName(idUser);
            }
        }
        ultis.pressEnter();
        stateCustomer.customerMenuState(idUser);
    }

    public void balanceInfo(int idUser){
        UserCustomer customer = customerMap.get(idUser);
        double balance = customer.getBalance();
        System.out.println("Số dư hiện tại của bạn là: " +balance);
        ultis.pressEnter();
        stateCustomer.customerMenuState(idUser);
    }

    public void printBill(int idUser) {
        UserCustomer customer = customerMap.get(idUser);
        if(customer == null ){
            System.out.println("ID user  k tồn tại");
            return;
        }
        ArrayList<Bill> bills = customerMap.get(idUser).getBill();
        try {
            if (bills.isEmpty()) {
                System.out.println("Hiện tại bạn chưa có vé nào");
            } else {
                System.out.println("bạn đã mua " + bills.size() + " vé:");
                for (int i = 0; i < bills.size(); i++) {
                    System.out.println((i + 1) + "-\t" + bills);
                }
            }
        } catch (Exception e) {
            System.out.println("Hiện tại bạn chưa có vé nào");
            Parameter.ultis.pressEnter();
            stateCustomer.customerMenuState(idUser);
        }
        Parameter.ultis.pressEnter();
        stateCustomer.customerMenuState(idUser);
    }

    public void rateChose(int idUser) {
        try {
            if (bills.size() == 0) {
                System.out.println("Hiện tại hệ thống chưa ghi nhận bạn từng xem bộ phim nào, mời bạn thưởng thức bộ phim và để lại đánh giá sau");
                Parameter.ultis.pressEnter();
                stateCustomer.customerMenuState(idUser);
            } else {
                System.out.println("bạn đã xem " + bills.size() + " phim:");
                for (int i = 0; i < bills.size(); i++) {
                    Bill bill = bills.get(i);
                    System.out.println("stt: "+ (i + 1) + " -\t" + bill.getMovieName());
                }
            }
        } catch (Exception e) {
            System.out.println("Hiện tại hệ thống chưa ghi nhận bạn từng xem bộ phim nào, mời bạn thưởng thức bộ phim và để lại đánh giá sau");
            Parameter.ultis.pressEnter();
            stateCustomer.customerMenuState(idUser);
        }
        System.out.println("Bạn có muốn đánh giá phim đã xem không?");
        System.out.println("1. Để lại đánh giá");
        System.out.println("0. Trở lại menu");
        select = ultis.inputInt();
        switch (select) {
            case 1 -> rate(idUser);
            default -> stateCustomer.customerMenuState(idUser);
        }
    }

    public void rate(int idUser){
        System.out.println("Nhập số thứ tự của phim mà bạn muốn đánh giá ");
        int billNumber = ultis.inputInt();
        Bill bill = bills.get(billNumber - 1);

        System.out.println("Nhập số sao bạn muốn chấm cho phim (từ 1 - 5)");
        int starPoint = ultis.inputInt();
        System.out.println("Mời bạn để lại bình luận giành cho phim");
        String comment = scanner.nextLine();
        Rate rate = new Rate(idUser, customerMap.get(idUser).getName(), comment,starPoint);
        rateMap.put(idUser, rate);
        movieMap.get(bill.getMovieId()).setRateMap(rateMap);
        System.out.println("Gửi đánh giá thành công, đang trở về menu");
        ultis.pressEnter();
        stateCustomer.customerMenuState(idUser);
    }
}
