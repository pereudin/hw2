package ru.pereudin.hw2.rx;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class RxPresenter {

    private static final String TAG = "RxPresenter";

    public Observable<String> getMessage() {

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    for (int i = 0; i < 10; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        String mes = "Message for you: " + i;
                        Log.d(TAG, "getMessage: " + Thread.currentThread().getName() + ": " + mes);
                        emitter.onNext(mes);
                    }
                } catch (InterruptedException e) {
                    Log.d(TAG, "getMessage: not disposed");
                }

            }
        }).subscribeOn(Schedulers.io());

        return observable;

    }

}
