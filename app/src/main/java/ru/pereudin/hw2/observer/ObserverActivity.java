package ru.pereudin.hw2.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import ru.pereudin.hw2.R;

public class ObserverActivity extends AppCompatActivity {

    private Spam spam = new Spam();
    private Iam iam = new Iam();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
    }

    public void subscribe(View view) {
        spam.registerObserver(iam);
    }

    public void unsubscribe(View view) {
        spam.unregisterObserver(iam);
    }

    public void sendSpam(View view) {
        spam.newSpam("You receive this spam because you subscribed to it");
    }
}
