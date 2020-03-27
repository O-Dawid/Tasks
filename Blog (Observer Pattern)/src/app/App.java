package app;

import app.domain.Source;
import app.domain.User;
import app.service.impl.Subscriber;

public class App {
    public static void main(String[] args) throws Exception {
        Source computerStore = new Source();
        Source blog = new Source();

        User bob = new User("Bob", true);
        User marysia = new User("Marysia", false);

        computerStore.addObserver(new Subscriber(bob));
        computerStore.publish("New PRODUCT! Iphone X for 1000 $");

        blog.addObserver(new Subscriber(marysia));
        marysia.setNotificationByEmailIsEnabled(true);
        blog.publish("How to avoid CORONAVIRUS");
    }
}