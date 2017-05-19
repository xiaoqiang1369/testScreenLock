package com.fff.xiaoqiang.testscreenlock;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;

public class ScreenLockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //屏蔽系统的锁屏界面，将此activity设置为锁屏界面
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

        setContentView(R.layout.activity_screen_lock);

        setRightSlide();
    }

    //右滑解锁
    private void setRightSlide(){
        SlidrConfig config = new SlidrConfig.Builder()
                .position(SlidrPosition.LEFT)
                .sensitivity(1f)
                .scrimColor(Color.BLACK)
                .scrimStartAlpha(0.8f)
                .scrimEndAlpha(0f)
                .velocityThreshold(2400)
                .distanceThreshold(0.5f)
                .build();
        Slidr.attach(this, config);
    }

    @Override
    protected void onUserLeaveHint() {
        //用户手动点击Home键或者手动切换app时，此方法会被调用，在这里销毁掉此界面。
        this.finish();
        super.onUserLeaveHint();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();    屏蔽返回按钮
    }

}
