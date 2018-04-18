package com.example.inhamap.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.inhamap.R;
import com.github.chrisbanes.photoview.PhotoView;

public class NavigationActivity extends AppCompatActivity {

    Toolbar myToolbar;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        /* toolbar */
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("최단경로 안내");

        PhotoView photoView = (PhotoView) findViewById(R.id.imageView4);
        photoView.setImageResource(R.drawable.hi_2ho_1);

    }
}
