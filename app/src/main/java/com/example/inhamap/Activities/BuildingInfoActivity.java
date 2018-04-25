package com.example.inhamap.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.inhamap.Adapter.DoorData;
import com.example.inhamap.Adapter.MyAdapter;
import com.example.inhamap.R;

import java.util.ArrayList;

public class BuildingInfoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<DoorData> myDataset;
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_info);

        /* toolbar */
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("출발지 검색");

        /* recyclerview */
        mRecyclerView = (RecyclerView) findViewById(R.id.buildingInfo);
        mRecyclerView.setHasFixedSize(true);

        //linear layout manager 을 통해 스크롤 목록 표시.
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        myDataset = new ArrayList<>();
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        //recycler list 뷰 목록 생성
        myDataset.add(new DoorData("하이테크 고층부 문", R.drawable.elevator, R.drawable.wheelchair, R.drawable.stair));
        myDataset.add(new DoorData("하이테크 고층부 문2", R.drawable.elevator, 0, R.drawable.stair));
        myDataset.add(new DoorData("하이테크 고층부 문3"));
        myDataset.add(new DoorData("하이테크 고층부 문4"));
        myDataset.add(new DoorData("하이테크 고층부 문5"));
        myDataset.add(new DoorData("하이테크 고층부 문6"));
        myDataset.add(new DoorData("하이테크 고층부 문7"));
        myDataset.add(new DoorData("하이테크 고층부 문8"));
        myDataset.add(new DoorData("하이테크 고층부 문9"));
    }

    /* toolbar 생성하는 함수 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
}
