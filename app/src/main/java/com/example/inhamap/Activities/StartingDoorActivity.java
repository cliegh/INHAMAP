package com.example.inhamap.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inhamap.R;
import com.github.chrisbanes.photoview.PhotoView;

public class StartingDoorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);

        PhotoView photoView = (PhotoView) findViewById(R.id.imageView);
        photoView.setImageResource(R.drawable.hi_2ho_1);


    }
}
