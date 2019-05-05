package com.example.coordination;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SwipeDismissBehavior.OnDismissListener {
    private TextView mMainText;
    private RecyclerView mMainRecycler;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainText = (TextView) findViewById(R.id.main_text);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mMainText.getLayoutParams();
//        SwipeDismissBehavior<TextView> behavior = new SwipeDismissBehavior<>();
//        behavior.setListener(this);
//        params.setBehavior(behavior);

//        MyBehavior behavior = new MyBehavior();
//        params.setBehavior(behavior);


        mMainRecycler = (RecyclerView) findViewById(R.id.main_recycler);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.format(Locale.CANADA, "第%03d条数据", i));
        }
        mMainRecycler.setAdapter(new MyAdapter(this, list));

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    public void onDismiss(View view) {
        view.setVisibility(View.GONE);
        Snackbar.make(view, "你删除了一个控件", Snackbar.LENGTH_LONG).setAction("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainText.setVisibility(View.VISIBLE);
                ViewCompat.animate(mMainText).alpha(1).start();
            }
        }).show();
    }

    @Override
    public void onDragStateChanged(int i) {

    }
}
