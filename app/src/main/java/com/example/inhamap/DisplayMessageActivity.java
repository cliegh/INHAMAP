package com.example.inhamap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        PhotoView photoView = (PhotoView) findViewById(R.id.imageView);
        photoView.setImageResource(R.drawable.hi_2ho_1);

    }
}
