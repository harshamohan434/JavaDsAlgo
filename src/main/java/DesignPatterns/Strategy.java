package DesignPatterns;

public class Strategy {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();

        notificationService.setStrategy(new EmailNotificationStrategy());
        notificationService.notifyUser("example@gmail.com", "email send");

        notificationService.setStrategy(new PushNotificaitonStrategy());
        notificationService.notifyUser("device123", "message sent");

        notificationService.setStrategy(new SmsNotificationStrategy());
        notificationService.notifyUser("+19876543210", "123 is your OTP");
    }
}

class NotificationService{
    NotificationStrategy notificationStrategy;
    void setStrategy(NotificationStrategy notificationStrategy){this.notificationStrategy = notificationStrategy;};
    public void notifyUser(String to, String message){
        if (notificationStrategy == null)
            throw new IllegalStateException("Notify User not set");
        notificationStrategy.send(to, message);
    }
}

interface NotificationStrategy {
    void send(String to, String message);
}

class EmailNotificationStrategy implements NotificationStrategy{

    @Override
    public void send(String to, String message) {
        System.out.printf("Sent email to %s with message %s", to, message);
    }
}

class SmsNotificationStrategy implements NotificationStrategy{

    @Override
    public void send(String to, String message) {
        System.out.printf("Sent SMS to %s with message %s", to, message);
    }
}

class PushNotificaitonStrategy implements NotificationStrategy{
    @Override
    public void send(String to, String message) {
        System.out.printf("Sent PUSH to %s with message %s", to, message);
    }
}
