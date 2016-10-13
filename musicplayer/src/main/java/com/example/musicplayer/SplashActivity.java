package com.example.musicplayer;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;

import com.example.musicplayer.util.Cons;

public class SplashActivity extends BaseActivity {

    @Override
    protected int setContent() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        readState();
    }

    @Override
    protected void setLisetner() {

    }

    @Override
    protected int setScreen() {
        return 0;
    }

    private void readState(){
        Intent mIntent;
        SharedPreferences sp = getSharedPreferences(Cons.APP_STATE,MODE_PRIVATE);
        if (sp.getBoolean(Cons.SETUP_STATE,false)){
            //如已安装该应用,直接关闭开屏页,直接开启下一页
            finish();
            mIntent = new Intent(this, MainActivity.class);
            startActivity(mIntent);
        }else {
            //更新安装状态
            SharedPreferences.Editor editor= sp.edit();
            editor.putBoolean(Cons.SETUP_STATE,true);
            editor.commit();

            //设定一个计时器,三秒后开启主页面,第一个参数为该计时器的总计时时间,
            // 第二个为调用onTick的时间间隔
            CountDownTimer countDownTimer=new CountDownTimer(3000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    finish();
                    Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            };
            //开启计时任务
            countDownTimer.start();
        }
    }


}
