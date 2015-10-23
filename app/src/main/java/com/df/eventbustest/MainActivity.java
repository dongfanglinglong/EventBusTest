package com.df.eventbustest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class MainActivity extends Activity {


    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(
            threadMode = ThreadMode.MainThread
    )
    public void onEventMainThread(FirstEvent event) {
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        textView.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Subscribe(
            threadMode = ThreadMode.MainThread
    )
    public void onEventMainThread(SecondEvent event) {

        Log.d("harvic", "onEventMainThread收到了消息：" + event.getMsg());
    }

    @Subscribe(
            threadMode = ThreadMode.PostThread
    )
    public void onEvent(ThirdEvent event) {
        Log.d("harvic", "OnEvent收到了消息：" + event.getMsg());
    }

    //SecondEvent接收函数二
    @Subscribe(
            threadMode = ThreadMode.BackgroundThread
    )

    public void onEventBackgroundThread(SecondEvent event) {
        Log.d("harvic", "onEventBackground收到了消息：" + event.getMsg());
    }

    //SecondEvent接收函数三
    @Subscribe(
            threadMode = ThreadMode.Async
    )
    public void onEventAsync(SecondEvent event) {
        Log.d("harvic", "onEventAsync收到了消息：" + event.getMsg());
    }
}
