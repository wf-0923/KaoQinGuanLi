package com.example.wangfan.wf_kaoqin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {
    private Button jump;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        startMainActivity();//启动下面写的一个方法
        jump=(Button)findViewById(R.id.jump);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zhudong = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(zhudong);

            }
        });
    }
    private void startMainActivity() {
        TimerTask delayTask = new TimerTask() {
            @Override
            public void run() {
                Intent zidong = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(zidong);
                WelcomeActivity.this.finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(delayTask, 3000);//延时2秒执行 run 里面的操作
    }
}


