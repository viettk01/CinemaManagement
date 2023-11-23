package services.userServices.manager.plan;

import entities.managerPlan.Training;
import entities.user.Staff;
import entities.user.UserStaff;

import java.time.LocalDate;
import java.util.Map;

import static ultis.Parameter.*;

public class TrainingServices implements Plane {


    @Override
    public void manager(int idManager) {
        System.out.println("1. Tạo lịch training nhân viên");
        System.out.println("2. Xóa lịch training nhân viên");
        System.out.println("3. Xem lịch Training nhân viên");
        System.out.println("0. Exit");
        select = ultis.inputInt();
        switch (select) {
            case 1:
                add(idManager);
                break;
            case 2:
                remove(idManager);
                break;
            case 3:
                print(idManager);
                break;
            default:
                break;
        }
    }

    @Override
    public void add(int idManager) {
        System.out.println("Nhập ngày training nhân viên");
        LocalDate dateTraining = ultis.inputLocalDate();
        LocalDate now = LocalDate.now();
        boolean checkLocalDate = dateTraining.isAfter(now);
        if (!checkLocalDate == true) {
            System.out.println("Ngày nhập vào phải là từ sau ngày hôm nay trở đi");
            add(idManager);
        }
        System.out.println("Nhập số lượng nhân viên cần training");
        int n = ultis.inputInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập id nhân viên cần training");
            int idUser = ultis.inputInt();
            UserStaff userStaff = staffMap.get(idUser);
            String name = userStaff.getName();
            Staff staff = userStaff.getStaff();
            Training training = new Training(dateTraining, idUser, name, staff);
            trainingMap.put(training.getId(), training);
        }
        stateManager.stateManageTraining(idManager);
    }

    @Override
    public void edit(int idManager) {

    }

    @Override
    public void remove(int idManager) {
        System.out.println("Nhập ngày training cần xóa");
        LocalDate dateTraining = ultis.inputLocalDate();
        for (Map.Entry<Integer, Training> trainingEntry : trainingMap.entrySet()) {
            if (!trainingEntry.getValue().getTrainingDate().equals(dateTraining)) {
                System.out.println("Không có lịch training nhân viên vào ngày " + dateTraining + "Trên hệ thống vui lòng nhập lại");
                remove(idManager);
            } else {
                trainingMap.remove(trainingEntry);
                System.out.println("Đã xóa thành công lịch training vào ngày " + dateTraining);
                break;
            }
        }
        stateManager.stateManageTraining(idManager);
    }

    @Override
    public void print(int idManager) {
        System.out.println("Bạn muốn xem lịch training theo ngày hay toàn bộ?");
        System.out.println("1. Theo ngày");
        System.out.println("2. Toàn bộ");
        System.out.println("0. Exit");
        select = ultis.inputInt();
        switch (select) {
            case 1:
                while (true) {
                    System.out.println("Nhập ngày bạn muốn xem lịch");
                    LocalDate dateCheck = ultis.inputLocalDate();
                    for (Map.Entry<Integer, Training> trainingEntry : trainingMap.entrySet()) {
                        if (!trainingEntry.getValue().getTrainingDate().equals(dateCheck)) {
                            System.out.println("Không có lịch training nhân viên vào ngày " + dateCheck + "Trên hệ thống vui lòng lựa chọn");
                            System.out.println("1. Nhập lại");
                            System.out.println("0. Quay lại");
                            select = ultis.inputInt();
                            switch (select) {
                                case 1:
                                    continue;
                                default:
                                    print(idManager);
                            }
                            System.out.println("===== TRAINING LIST =====");
                            System.out.println(trainingEntry.getValue());
                            break;
                        }
                        break;
                    }
                }

            case 2:
                System.out.println("===== TRAINING LIST =====");
                trainingMap.forEach((key, value) -> {
                    System.out.println(value);
                });
                break;
            default:
                break;
        }
        stateManager.stateManagePlan(idManager);
    }
}
