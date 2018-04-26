package com.lzx.listenmovieapp.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;

/**
 * Author：Road
 * Date  ：2018/4/26
 */

public class BaseActivity extends AppCompatActivity {
    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }
    }

    private boolean isImmersionBarEnabled() {
        return true;
    }

    private void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(false);
        mImmersionBar.flymeOSStatusBarFontColorInt(Color.WHITE);
        mImmersionBar.init();
    }

}
