package entities;

public enum Rule {
    TRUE,  // Nhân viên: Đang làm việc | Voucher: Đang trong thời gian nên có thể sử dụng | Movie: Đang chiếu
    FALSE, // Nhân viên: Nghỉ Việc | Voucher: Quá hạn sử dụng | Movie: Dừng chiếu (Gỡ bỏ)
    NULL;  // Nhân viên: # | Voucher: Chưa đến thời gian hiệu lực (Không thể sử dụng) | Movie: Chưa đến thời gian công chiếu
}
