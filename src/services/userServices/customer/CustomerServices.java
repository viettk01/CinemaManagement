package services.userServices.customer;

import entities.Notification;
import entities.movie.Bill;
import entities.user.UserCustomer;
import entities.voucher.Voucher;
import ultis.Parameter;

import java.util.ArrayList;

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
        ArrayList<Bill> bills = customerMap.get(idUser).getBill();
        try {
            if (bills.size() == 0) {
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

}
