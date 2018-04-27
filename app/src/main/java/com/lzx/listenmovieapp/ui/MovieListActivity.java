package com.lzx.listenmovieapp.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzx.listenmovieapp.R;
import com.lzx.listenmovieapp.adapter.MovieListAdapter;
import com.lzx.listenmovieapp.base.BaseActivity;
import com.lzx.listenmovieapp.bean.MovieListInfo;
import com.lzx.listenmovieapp.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 设置
 *
 * @author cx
 */
public class MovieListActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.tv_back)
    TextView tv_back;

    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    private String title;
    private List<MovieListInfo> mData;
    private BaseQuickAdapter mAdapter;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBarMarginTop(R.id.ll_title)
                .statusBarColor(R.color.colorPrimary)
                .init();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_source_detail;
    }

    @Override
    protected void initData() {
        title = getIntent().getStringExtra("title");

        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MovieListInfo info = new MovieListInfo();
            info.setImg("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1709857625,355767256&fm=179&w=115&h=161&img.JPEG");
            info.setName("战狼");
            info.setDesc("扬我国威，热血再起");

            mData.add(info);
        }
    }

    @Override
    protected void initView() {
        tv_title.setText(title);
        initRecyclerView();
    }

    private void initRecyclerView() {
        rv_list.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new MovieListAdapter(R.layout.item_movie_list, mData);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.MyToast(MovieListActivity.this, "您选择了" + mData.get(position).getName());
            }
        });
        rv_list.setAdapter(mAdapter);
    }

    @Override
    protected void setListener() {
        tv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

            case R.id.tv_back:
                finish();
                break;
        }
    }
}
