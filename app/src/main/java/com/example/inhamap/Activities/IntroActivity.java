package com.example.inhamap.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.inhamap.R;

/**
 * Created by myown on 2018. 4. 18..
 */

public class IntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // 2초 후 화면 전환
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        }, 2000);
    }
}
