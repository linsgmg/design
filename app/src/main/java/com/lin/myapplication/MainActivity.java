package com.lin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TabLayout tab;
    private ViewPager pager;
    private Toolbar toolbar;
    private DrawerLayout draw;
    private NavigationView navigation;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab = (TabLayout) findViewById(R.id.tab);
        pager = (ViewPager) findViewById(R.id.pager);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        draw = (DrawerLayout) findViewById(R.id.draw);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, draw, toolbar, 0, 0);
        draw.addDrawerListener(toggle);
        toggle.syncState();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(String.format(Locale.CANADA, "第%02d页", i));
        }

        pager.setAdapter(new MyAdapter(getSupportFragmentManager(), list));
        tab.setupWithViewPager(pager);

        navigation = (NavigationView) findViewById(R.id.navigation);
        navigation.setItemIconTintList(null);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_04:
                        finish();
                        break;
                }
                draw.closeDrawer(GravityCompat.START);//收起
                return true;
            }
        });

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Snackbar" ,Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, "Undo", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,CoordinatorActivity.class));
                    }
                }).show();
            }
        });

    }
}
