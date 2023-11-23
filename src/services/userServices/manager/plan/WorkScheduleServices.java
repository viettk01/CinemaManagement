package services.userServices.manager.plan;

import entities.managerPlan.WorkSchedule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static ultis.Parameter.*;

public class WorkScheduleServices implements Plane{
    @Override
    public void manager(int idManager) {
        System.out.println("===== MANAGER =====");
        System.out.println("1. Thêm lịch làm việc");
        System.out.println("2. Xem thông tin lịch làm việc");
        System.out.println("0. Quay lại");
        select = ultis.inputInt();
        switch (select) {
            case 1 -> add(idManager);
            default -> stateManager.stateManageWorkSchedule(idManager);
        }
    }

    @Override
    public void add(int idManager) {
        System.out.println("\t===== MANAGER =====");
        System.out.println("nhập ngày làm việc cần sắp ca");

        LocalDate workDate = ultis.inputLocalDate();
        LocalDate now = LocalDate.now();
        boolean checkLocalDate = workDate.isAfter(now);
        if (!checkLocalDate == true) {
            System.out.println("Ngày nhập vào phải là từ sau ngày hôm nay trở đi");
            add(idManager);
        }

        System.out.println("Nhập số lượng nhân viên đi làm ngày " +workDate);
        int n = ultis.inputInt();
        for (int i = 0; i < n; i++) {
            while (true){
                System.out.println("Nhập id nhân viên:");
                int id = ultis.inputInt();
                if (!staffMap.containsKey(id)){
                    System.out.println("id không tồn tại, mời bạn kiểm tra id và nhập lại");
                    System.out.println("1. Nhập lại id");
                    System.out.println("0. Quay Lại");
                    select = ultis.inputInt();
                    switch (select) {
                        case 1:
                            continue;
                        default:
                            stateManager.stateManagerMovie(idManager);
                            break;
                    }
                }
                WorkSchedule workSchedule = new WorkSchedule(workDate, staffMap.get(id).getUsername(), staffMap.get(id).getStaff());
                workSchedules.add(workSchedule);
                System.out.println("Thêm thành công!");
                break;

            }
        }
        System.out.println("danh sách nhân viên đi làm ngày "+workDate+" "+workSchedules);
        ultis.pressEnter();
        stateManager.stateManageWorkSchedule(idManager);
    }

    @Override
    public void edit(int idManager) {

    }

    @Override
    public void remove(int idManager) {

    }

    @Override
    public void print(int idManager) {
        if (workSchedules.size() == 0) {
            System.out.println("Chưa đặt lịch training cho nhân viên");
            ultis.pressEnter();
            stateManager.stateManagerStaff(idManager);
        }

        System.out.println("1. In danh lịch làm việc theo ngày");
        System.out.println("2. In danh tất cả lịch làm việc");
        System.out.println("0. Quay lại");
        select = ultis.inputInt();
        switch (select) {
            case 1 -> printInfoDate(idManager); //True
            case 2 -> printInfoAll(idManager); //False
            default -> stateManager.stateManagerStaff(idManager);
        }
    }

    public void printInfoDate(int idManager) {
        System.out.println("Nhập ngày bạn muốn xem lịch làm việc");
        LocalDate date = ultis.inputLocalDate();
        for (WorkSchedule workSchedule: workSchedules) {
            if (workSchedule.getWorkDate().equals(date)){
                System.out.println(workSchedule);
                break;
            }
        }
        ultis.pressEnter();
        stateManager.stateManageWorkSchedule(idManager);
    }

    public void printInfoAll(int idManager){
        for (WorkSchedule workSchedule: workSchedules) {
                System.out.println(workSchedule);
        }
        ultis.pressEnter();
        stateManager.stateManageWorkSchedule(idManager);
    }
}
