package ru.pereudin.hw2.observer;

import android.util.Log;

public class Iam implements Observer {

    public static final String TAG = "Iam";

    @Override
    public void updateData(String message) {
        Log.d(TAG, "Имя потока: " + Thread.currentThread().getName() + ". " + message);
    }
}
