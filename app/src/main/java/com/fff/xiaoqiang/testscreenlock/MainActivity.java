package com.fff.xiaoqiang.testscreenlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startScreenService();
    }

    private void startScreenService(){
        Intent intent = new Intent(this, ScreenLockService.class);
        startService(intent);
    }
}
