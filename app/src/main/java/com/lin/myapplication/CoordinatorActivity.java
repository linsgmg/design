package com.lin.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CoordinatorActivity extends AppCompatActivity {
    private Button coordinatorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        coordinatorBtn = (Button) findViewById(R.id.coordinator_btn);

        coordinatorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "点我了", Snackbar.LENGTH_LONG).setAction("exit", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityCompat.finishAffinity(CoordinatorActivity.this);
                    }
                }).show();
            }
        });
    }
}
