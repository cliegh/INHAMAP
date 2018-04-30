package com.example.inhamap.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

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

        //Get the Intent that started this activity and extract the string
        //Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String buildingName = "인하대학교 하이테크센터";

        /* toolbar */
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("상세 정보");

        TextView buildNameView = (TextView) findViewById(R.id.buildingName) ;
        buildNameView.setText(buildingName) ;

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

        //recycler list 뷰 목록 생성 ==> for문으로 처리하고, 하이테크라는 인자(건물 이름)가 넘어왔을때 문 개수만큼 포문 돌면서 add 생성하도록 하자.
        myDataset.add(new DoorData("하이테크 고층부 문", R.drawable.elevator, R.drawable.wheelchair, R.drawable.stair));
        this.addlist();
    }

    /* toolbar 생성하는 함수 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void addlist(){
        for(int i=0;i<buildDoor.length;i++) {
            //myDataset.add(new DoorData("하이테크 고층부 문", R.drawable.elevator, R.drawable.wheelchair, R.drawable.stair));
            myDataset.add(new DoorData(buildDoor[i].name, buildDoor[i].elevator, buildDoor[i].wheelchair, buildDoor[i].stair));
        }
    }
}
