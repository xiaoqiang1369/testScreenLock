package com.fff.xiaoqiang.testscreenlock;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class ScreenLockService extends Service {

    private BroadcastReceiver screenLockReceiver;

    public ScreenLockService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        screenLockReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                    Intent lockScreen = new Intent(ScreenLockService.this, ScreenLockActivity.class);
                    lockScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(lockScreen);
                }
            }
        };

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(screenLockReceiver, filter);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }



}
