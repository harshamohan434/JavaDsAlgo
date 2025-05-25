package DesignPatterns;

public class Factory {
    public static void main(String[] args) {
        String notify1 = "mobile";
        String notify2 = "email";

        NotificationFactory factory = notify1.equals("mobile")? new MobileNotificationFactoy(): new EmailNotificationFactory();

        Notification notification = factory.createNotification();

        notification.notifyUser();

    }
}


abstract class NotificationFactory{
    public abstract Notification createNotification();

    public void notifyUser(){
        Notification notification = createNotification();
        notification.notifyUser();
    }

}

class EmailNotificationFactory extends NotificationFactory{

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class MobileNotificationFactoy extends NotificationFactory{

    @Override
    public Notification createNotification() {
        return new MobileNotification();
    }
}


interface Notification{
    void notifyUser();
}

class EmailNotification implements Notification{

    @Override
    public void notifyUser() {
        System.out.println("Sending email");
    }
}

class MobileNotification implements Notification{

    @Override
    public void notifyUser() {
        System.out.println("sending mobile notifiation");
    }
}
