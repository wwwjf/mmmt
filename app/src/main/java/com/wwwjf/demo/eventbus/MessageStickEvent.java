package com.wwwjf.demo.eventbus;

/**
 * Created by wengjianfeng on 2018/9/13.
 */

public class MessageStickEvent {
    private String mMessage;

    public MessageStickEvent(String message){
        mMessage = message;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
