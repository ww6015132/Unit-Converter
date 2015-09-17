package com.example.wei.unitconverter;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ImageView mAreaImage, mLengthImage, mTempImage, mVolumnImage, mWeightImage;
    private ImageView mSelBg;
    private LinearLayout mTab_item_container;
    private FragmentManager mFM = null;

    LinearLayout content_container;
    private int mSelectIndex = 0;

    private View last, now;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        changeToArea();
    }

    private void initView(){
        mTab_item_container = (LinearLayout) findViewById(R.id.tab_item_container);
        mAreaImage = (ImageView) findViewById(R.id.tab_bt_1);
        mLengthImage = (ImageView) findViewById(R.id.tab_bt_2);
        mTempImage = (ImageView) findViewById(R.id.tab_bt_3);
        mVolumnImage = (ImageView) findViewById(R.id.tab_bt_4);
        mWeightImage = (ImageView) findViewById(R.id.tab_bt_5);

        mAreaImage.setOnClickListener(this);
        mLengthImage.setOnClickListener(this);
        mTempImage.setOnClickListener(this);
        mVolumnImage.setOnClickListener(this);
        mWeightImage.setOnClickListener(this);

        mSelBg = (ImageView) findViewById(R.id.tab_bg_view);
        LayoutParams lp = mSelBg.getLayoutParams();
        lp.width = mTab_item_container.getWidth() / 5;

        content_container = (LinearLayout) findViewById(R.id.content_container);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        LayoutParams lp = mSelBg.getLayoutParams();
        lp.width = mTab_item_container.getWidth() / 5;
    }

    @Override
    public void onClick(View arg0) {

        switch (arg0.getId()) {
            case R.id.tab_bt_1:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(0);
                startAnimation(last, now);
                mSelectIndex = 0;
                changeToArea();
                break;
            case R.id.tab_bt_2:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(1);
                startAnimation(last, now);
                mSelectIndex = 1;

                changeBussiness();
                break;
            case R.id.tab_bt_3:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(2);
                startAnimation(last, now);
                mSelectIndex = 2;

                changeMessage();
                break;
            case R.id.tab_bt_4:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(3);
                startAnimation(last, now);
                mSelectIndex = 3;

                changeSetting();
                break;
            case R.id.tab_bt_5:
                last = mTab_item_container.getChildAt(mSelectIndex);
                now = mTab_item_container.getChildAt(4);
                startAnimation(last, now);
                mSelectIndex = 4;

                changeWeight();
                break;
            default:
                break;
        }
    }
    private void startAnimation(View last, View now) {
        TranslateAnimation ta = new TranslateAnimation(last.getLeft(), now.getLeft(), 0, 0);
        ta.setDuration(300);
        ta.setFillAfter(true);
        mSelBg.startAnimation(ta);
    }

    private void changeToArea() {
        Fragment f = new AreaFragment();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        Log.i("changeToArea","running");
        ft.commit();
    }

    public void changeBussiness() {
        Fragment f = new AreaFragment();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    public void changeMessage() {
        Fragment f = new AreaFragment();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    public void changeSetting() {
        Fragment f = new AreaFragment();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
    }

    public void changeWeight() {
        Fragment f = new AreaFragment();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.content_container, f);
        ft.commit();
        Toast.makeText(MainActivity.this,"fragment1",Toast.LENGTH_SHORT).show();
    }

    private static Boolean isQuit = false;
    private Timer timer = new Timer();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isQuit == false) {
                isQuit = true;
                Toast.makeText(getBaseContext(), "this", Toast.LENGTH_SHORT).show();
                TimerTask task = null;
                task = new TimerTask() {
                    @Override
                    public void run() {
                        isQuit = false;
                    }
                };
                timer.schedule(task, 2000);
            } else {
                finish();
            }
        } else {
        }
        return false;
    }
}
