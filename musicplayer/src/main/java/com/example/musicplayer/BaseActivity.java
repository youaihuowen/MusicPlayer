package com.example.musicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * @auhtor WUYIXIONG
 * @description Activity的基类
 */
public abstract class BaseActivity extends FragmentActivity {

    private int screen = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screen=setScreen();
        if (screen==0){
            //去标题
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            //设置全屏,去除状态栏
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else if (screen==1){
            //去标题
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        //绑定布局
        setContentView(setContent());
        //加载控件
        initView();
        //加载监听
        setLisetner();
    }

    /**
     * 绑定布局
     * @return 布局的id
     */
    protected abstract int setContent();

    /**
     * 绑定控件
     */
    protected abstract void initView();

    /**
     * 设置监听
     */
    protected abstract void setLisetner();

    /**
     * 设置屏幕是否有标题或全屏
     * @return 0全屏 1有状态栏 其余的数既有标题栏又有状态栏
     */
    protected abstract int setScreen();
}
