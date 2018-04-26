package com.lzx.listenmovieapp.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzx.listenmovieapp.R;
import com.lzx.listenmovieapp.adapter.HomeAdapter;
import com.lzx.listenmovieapp.base.BaseActivity;
import com.lzx.listenmovieapp.bean.HomeItem;
import com.lzx.listenmovieapp.utils.ToastUtil;
import com.tmall.ultraviewpager.UltraViewPager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private UltraViewPager viewPager;
    private LinearLayout ll_voice;
    private RecyclerView rv_ist;

    private List<View> views;
    public static final int[] IMAGES = {R.mipmap.viewpaer, R.mipmap.viewpaer,
            R.mipmap.viewpaer, R.mipmap.viewpaer, R.mipmap.viewpaer
    };

    private BaseQuickAdapter mAdapter;
    private List<HomeItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewPager();
        initRecyclerView();
        setListener();
    }

    private void setListener() {
        ll_voice.setOnClickListener(this);
    }

    private void initRecyclerView() {
        mData = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            HomeItem item = new HomeItem();
            item.setResId(R.mipmap.ic_launcher_round);
            item.setTitle("听影");
            mData.add(item);
        }

        rv_ist.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter = new HomeAdapter(R.layout.item_home, mData);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
        rv_ist.setAdapter(mAdapter);
    }

    private void initViewPager() {
        views = new ArrayList<>();
        // 将ImageView添加到view
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        for (int i = 0; i < IMAGES.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(params);
            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inPreferredConfig = Bitmap.Config.RGB_565;
            opt.inPurgeable = true;
            opt.inInputShareable = true;
            InputStream is = getResources().openRawResource(IMAGES[i]);
            Bitmap bm = BitmapFactory.decodeStream(is, null, opt);
            BitmapDrawable bd = new BitmapDrawable(getResources(), bm);
            iv.setBackgroundDrawable(bd);
            views.add(iv);
        }

        viewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        });
        viewPager.setAdapter(new MyAdapter());
        viewPager.initIndicator();
        viewPager.getIndicator().setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(Color.BLUE)
                .setNormalColor(Color.WHITE)
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));
        viewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        viewPager.getIndicator().build();
        //设定页面循环播放
        viewPager.setInfiniteLoop(true);
        //设定页面自动切换  间隔2秒
        viewPager.setAutoScroll(2500);
    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        ll_voice = findViewById(R.id.ll_voice);
        rv_ist = findViewById(R.id.rv_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ll_voice:
                ToastUtil.MyToast(this, "开始语音");
                break;
        }
    }


    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }
    }

}
