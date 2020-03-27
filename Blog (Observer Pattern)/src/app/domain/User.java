package app.domain;

public class User {
    String name;
    boolean notificationByEmailIsEnabled = true;

    public User(String name, boolean notificationByEmailIsEnabled) {
        this.name = name;
        this.notificationByEmailIsEnabled = notificationByEmailIsEnabled;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNotificationByEmailIsEnabled() {
        return this.notificationByEmailIsEnabled;
    }

    public boolean getNotificationByEmailIsEnabled() {
        return this.notificationByEmailIsEnabled;
    }

    public void setNotificationByEmailIsEnabled(boolean notificationByEmailIsEnabled) {
        this.notificationByEmailIsEnabled = notificationByEmailIsEnabled;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User notificationByEmailIsEnabled(boolean notificationByEmailIsEnabled) {
        this.notificationByEmailIsEnabled = notificationByEmailIsEnabled;
        return this;
    }

}