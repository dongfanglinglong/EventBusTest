package com.df.eventbustest;

/**
 * Created by chenfu on 2015/10/23.
 */
public class SecondEvent {
    private String mMsg;

    public SecondEvent(String msg) {
        // TODO Auto-generated constructor stub
        mMsg = "MainEvent:" + msg;
    }

    public String getMsg() {
        return mMsg;
    }
}
