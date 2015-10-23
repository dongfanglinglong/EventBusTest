package com.df.eventbustest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import de.greenrobot.event.EventBus;

/**
 * Created by chenfu on 2015/10/23.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked"));
            }
        });
    }
}
