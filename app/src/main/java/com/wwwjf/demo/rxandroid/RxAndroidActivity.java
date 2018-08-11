package com.wwwjf.demo.rxandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.wwwjf.demo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxAndroidActivity extends Activity {
    public static final String TAG = RxAndroidActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxandroid);

        //被观察者
        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                Log.e(TAG, "subscribe: currentThread Name:" +
                        Thread.currentThread().getName());
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });

        //观察者
        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "==============onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "==============onNext");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "==============onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "==============onComplete");

            }
        };
        //1、订阅
        observable.subscribe(observer);
        //2、链式设置订阅
        /*Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/
    }
}
