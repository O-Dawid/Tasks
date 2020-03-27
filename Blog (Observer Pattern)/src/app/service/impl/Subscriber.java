package app.service.impl;

import app.domain.User;
import app.service.Notification;
import app.service.NotificationTags;
import app.service.Observer;

public class Subscriber implements Observer, Notification {
    private final static String NOTIFICATION = "[%s] %s, There are new messages";
    User user;

    public Subscriber(User user) {
        this.user = user;
    }

    @Override
    public void update() {
        sendEMail();
    }

    @Override
    public void sendEMail() {
        if (user.getNotificationByEmailIsEnabled())
            System.out.println(String.format(NOTIFICATION, NotificationTags.EMAIL, user.getName()));

    }

}