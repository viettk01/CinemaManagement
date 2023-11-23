package ultis;

import entities.Rule;
import entities.voucher.Voucher;

import java.time.LocalDate;

import static ultis.Parameter.vouchers;

public class Logic {
    public void logicVoucher(){
        voucherEnable();
        voucherExpired();
    }
    public void voucherEnable(){
        for (Voucher voucher : vouchers) {
            if (LocalDate.now().equals(voucher.getEnableDate())  || LocalDate.now().isAfter(voucher.getEnableDate())) {
                voucher.setRule(Rule.TRUE);
                break;
            }
        }
    }
    public void voucherExpired(){
        for (Voucher voucher : vouchers){
            if (LocalDate.now().equals(voucher.getEndDate()) || LocalDate.now().isAfter(voucher.getEndDate())){
                voucher.setRule(Rule.FALSE);
            }
        }
    }
}
