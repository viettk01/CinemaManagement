package services.userServices.manager.function;

import entities.Notification;
import ultis.Parameter;

import static ultis.Parameter.notifications;

public class NotificationServices {
    public void addNotification(){
        System.out.println("Nhập tiêu đề thông báo");
        String title = Parameter.scanner.nextLine();
        System.out.println("Nhập nội dung của thông báo");
        String content = Parameter.scanner.nextLine();
        Notification notification = new Notification(title, content);
        notifications.add(notification);
    }
}
