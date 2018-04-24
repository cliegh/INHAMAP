package com.example.inhamap.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inhamap.R;
import com.github.chrisbanes.photoview.PhotoView;

public class DestinationDoorActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar myToolbar;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);

        /* toolbar */
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("경로 선택");

        PhotoView photoView = (PhotoView) findViewById(R.id.imageView);
        photoView.setImageResource(R.drawable.hi_2ho_1);

        text = (TextView) findViewById(R.id.recommendTextView);
        text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.recommendTextView:// TextView가 클릭될 시 할 코드작성
                Toast.makeText(getApplicationContext(), "텍뷰2 클릭됨", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, NavigationActivity.class);
                startActivity(intent);
                break;
            case R.id.textView3:
                Toast.makeText(getApplicationContext(), "텍뷰3 클릭됨", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
