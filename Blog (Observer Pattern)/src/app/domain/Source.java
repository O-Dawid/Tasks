package app.domain;

import java.util.ArrayList;
import java.util.List;

import app.service.Observable;
import app.service.Observer;

public class Source implements Observable {
    String name;
    List<Observer> subscribers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);

    }

    @Override
    public void notifyObservers() {
        subscribers.forEach(Observer::update);
    }

    public void publish(String post) {
        System.out.println("NEW POST: " + post);
        notifyObservers();
    }

}