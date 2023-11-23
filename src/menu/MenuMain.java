package menu;


import ultis.Parameter;

import static ultis.Parameter.select;
import static ultis.Parameter.state;

public class MenuMain {
    //                      MENU MAIN
    public void menuMainDisplay() {
        System.out.println("\t===== MENU =====");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("0. Exit");
        System.out.print("Chọn: ");
        select = Parameter.ultis.inputInt();
        menuMainSelect();
    }

    public void menuMainSelect() {
        switch (select) {
            case 1:
                state.loginState();
                break;
            case 2:
                state.registerState();
                break;
            default:
                System.out.println("Kết thúc chương trình");
                break;
        }
    }


}
