package com.example.actjumpactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private final static String TAG = "MainActivity";
    private Button btn_act_next;
    private TextView tv_life;
    private String mStr = "";

    private void refreshLife(String desc) {
        Log.d(TAG, desc);
        mStr = String.format("%s%s %s %s \n", mStr, DateUtil.getNowTimeDetail(), TAG, desc);
        tv_life.setText(mStr);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_act_next = (Button) findViewById(R.id.btn_act_next);
        btn_act_next.setOnClickListener(this);

        tv_life = (TextView) findViewById(R.id.tv_life);
        refreshLife("OnCreate");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_act_next) {
            Intent intent = new Intent(this, ActNextActivity.class);
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onStart() {
        refreshLife("onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        refreshLife("onStop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        refreshLife("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        refreshLife("onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        refreshLife("onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        refreshLife("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String nextLife = data.getStringExtra("life");
        refreshLife("\n" + nextLife);
        refreshLife("onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
    }
}