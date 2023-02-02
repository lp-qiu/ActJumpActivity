package com.example.actjumpactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActNextActivity extends AppCompatActivity implements OnClickListener {

    private final static String TAG = "ActNextActivity";
    private Button btn_act_pre;
    private TextView tv_life;
    private String mStr = "";

    private void refreshLife(String desc) {
        Log.d(TAG, desc);
        mStr = String.format("%s     %s %s %s \n", mStr, DateUtil.getNowTimeDetail(), TAG, desc);
        tv_life.setText(mStr);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_next);

        btn_act_pre = (Button) findViewById(R.id.btn_act_pre);
        btn_act_pre.setOnClickListener(this);

        tv_life = (TextView) findViewById(R.id.tv_life);
        refreshLife("onCreate");
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
    public void onClick(View view) {
        if (view.getId() == R.id.btn_act_pre) {
            Intent intent = new Intent();
            intent.putExtra("life", mStr);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }
}
