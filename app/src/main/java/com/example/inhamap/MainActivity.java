package com.example.inhamap;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

public class MainActivity extends AppCompatActivity {

    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* toolbar */
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("출발지 검색");

        /* photoView : 사진 확대 축소 가능하게 해주는 라이브러리 */
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.test3);
    }

    /* toolbar 생성하는 함수 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    //추가된 소스, ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_search:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "찾기 버튼 클릭됨", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, DisplayMessageActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings2:
                Toast.makeText(getApplicationContext(), "항목 1 버튼 클릭됨", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(this, DisplayMessageActivity.class);
                startActivity(intent2);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }
    }


}
