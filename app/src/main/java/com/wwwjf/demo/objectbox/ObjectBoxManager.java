package com.wwwjf.demo.objectbox;

import android.content.Context;

import io.objectbox.BoxStore;

public class ObjectBoxManager {

    private static BoxStore boxStore;

    public static void init(Context context){
        boxStore = MyObjectBox.builder()
                .androidContext(context)
                .build();
    }

    public static BoxStore get(){
        return boxStore;
    }
}
