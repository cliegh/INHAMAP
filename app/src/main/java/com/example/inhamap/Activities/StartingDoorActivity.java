package com.example.inhamap.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inhamap.Adapter.DoorData;
import com.example.inhamap.Adapter.MyAdapter;
import com.example.inhamap.Adapter.RecyclerItemClickListener;
import com.example.inhamap.R;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

public class StartingDoorActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<DoorData> myDataset;
    Toolbar myToolbar;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);

        /* recyclerview */
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        //linear layout manager 을 통해 스크롤 목록 표시.
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        myDataset = new ArrayList<>();
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        myDataset.add(new DoorData("하이테크 고층부 문", R.drawable.elevator, R.drawable.wheelchair, R.drawable.stair));
        myDataset.add(new DoorData("하이테크 고층부 문2", R.drawable.elevator, 0, R.drawable.stair));
        myDataset.add(new DoorData("하이테크 고층부 문3"));
        myDataset.add(new DoorData("하이테크 고층부 문4"));
        myDataset.add(new DoorData("하이테크 고층부 문5"));
        myDataset.add(new DoorData("하이테크 고층부 문6"));
        myDataset.add(new DoorData("하이테크 고층부 문7"));
        myDataset.add(new DoorData("하이테크 고층부 문8"));
        myDataset.add(new DoorData("하이테크 고층부 문9"));

        /* toolbar */
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("경로 선택");

        PhotoView photoView = (PhotoView) findViewById(R.id.imageView);
        photoView.setImageResource(R.drawable.hi_2ho_1);

        text = (TextView) findViewById(R.id.textView2);
        text.setOnClickListener(this);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), "텍뷰2 클릭됨", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView2:// TextView가 클릭될 시 할 코드작성
                Toast.makeText(getApplicationContext(), "텍뷰2 클릭됨", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, DestinationFindActivity.class);
                startActivity(intent);
                break;
            case R.id.textView3:
                Toast.makeText(getApplicationContext(), "텍뷰3 클릭됨", Toast.LENGTH_LONG).show();
                break;
        }
    }

}
