package ru.pereudin.hw2.observer;

import java.util.ArrayList;

public class Spam implements Observable {

    private static final String TAG = "Spam";

    private ArrayList<Observer> arrayList;
    private String message;

    public Spam() {
        arrayList = new ArrayList<>();
    }

    public void newSpam(String spam) {
        message = spam;

        notifyAllObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        arrayList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        arrayList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (int i = 0; i < arrayList.size(); i++) {
            Observer observer = arrayList.get(i);
            observer.updateData(message);
        }
    }
}
