package com.wwwjf.demo.thread;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

public class BaseHandler<T extends BaseHandlerCallback> extends Handler {

    WeakReference<T> mWeakReference;

    public BaseHandler(T t){
        mWeakReference = new WeakReference<>(t);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        T t = mWeakReference.get();
        if (t != null){
            t.callback(msg);
        }
    }
}

