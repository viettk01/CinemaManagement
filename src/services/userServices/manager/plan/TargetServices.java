package services.userServices.manager.plan;

import entities.managerPlan.Target;
import ultis.Parameter;

import static ultis.Parameter.*;

public class TargetServices implements Plane {

    @Override
    public void manager(int idManager) {
        System.out.println("1. Tạo target");
        System.out.println("2. Xem target");
        System.out.println("3. Sửa hoặc xóa target");
        System.out.println("0. Exit");
        select = Parameter.ultis.inputInt();
        switch (select) {
            case 1 -> add(idManager);
            case 2 -> print(idManager);
            case 3 -> edit(idManager);
            default -> stateManager.stateMenuManager(idManager);
        }
    }

    @Override
    public void add(int idManager) {
        System.out.println("Nhập tháng muốn tạo target ");
        int month = Parameter.ultis.inputInt();
        System.out.print("Nhập target tháng: ");
        double targetMonth = Parameter.ultis.inputDouble();
        double targetHalfMonth = targetMonth / 4;
        double targetDay = targetMonth / 30;
        Target target = new Target(targetMonth, targetHalfMonth, targetDay);
        targetMap.put(month, target);
        System.out.println("Đã thêm target cho tháng: "+month);
        ultis.pressEnter();
        stateManager.stateManageTarget(idManager);
    }

    @Override
    public void edit(int idManager) {
        if (targetMap.size() == 0) {
            System.out.println("Hệ thống ghi nhận chưa tháng nào được đặt target");
            ultis.pressEnter();
            stateManager.stateManageTarget(idManager);
        }
        System.out.println("Nhập tháng mà bạn muốn sửa hoặc xóa target");
        int month = Parameter.ultis.inputInt();
        if (!targetMap.containsKey(month)) {
            System.out.println("Không có dữ liệu của tháng bạn nhập vào vui lòng kiểm tra lại");
            edit(idManager);
        }
        Target target = targetMap.get(month);
        System.out.println("Bạn muốn sửa hay xóa target?");
        System.out.println("1. Sửa");
        System.out.println("2. Xóa");
        System.out.println("3. Exit");
        select = Parameter.ultis.inputInt();
        switch (select) {
            case 1:
                System.out.println("Nhập target mới cho tháng " + month);
                double targetMonth = Parameter.ultis.inputDouble();
                target.setTargetMonth(targetMonth);
                System.out.println("cập nhật target thành công");
                stateManager.stateManageTarget(idManager);
                break;
            case 2:
                targetMap.remove(month);
                System.out.println("Đã xóa thành công target tháng " + month);
                stateManager.stateManageTarget(idManager);
                break;
            default:
                stateManager.stateManageTarget(idManager);
                break;
        }
    }

    @Override
    public void remove(int idManager) {

    }

    @Override
    public void print(int idManager) {
        if (targetMap.size() == 0) {
            System.out.println("Hệ thống ghi nhận chưa tháng nào được đặt target");
            ultis.pressEnter();
            stateManager.stateManageTarget(idManager);
        }

        System.out.println("Bạn muốn xem target theo tháng hay xem toàn bộ?");
        System.out.println("1. Xem theo Tháng");
        System.out.println("2. Xem Toàn Bộ");
        System.out.println("0. Exit");
        select = Parameter.ultis.inputInt();
        switch (select) {
            case 1:
                System.out.println("Nhập tháng");
                int inputMonth = Parameter.ultis.inputInt();
                Target target = targetMap.get(inputMonth);
                System.out.println(target);
                ultis.pressEnter();
                stateManager.stateManageTarget(idManager);
                break;
            case 2:
                System.out.println(targetMap);
                ultis.pressEnter();
                stateManager.stateManageTarget(idManager);
                break;
            default:
                break;
        }
    }
}
