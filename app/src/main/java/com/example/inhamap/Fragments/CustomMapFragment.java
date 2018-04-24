package com.example.inhamap.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

import com.example.inhamap.R;
import com.example.inhamap.Utils.AllocateImageButtonInFragment;

/**
 * Created by myown on 2018. 4. 18..
 */

public class CustomMapFragment extends Fragment implements View.OnTouchListener{

    private ScrollView vScroll;
    private HorizontalScrollView hScroll;
    private static int Xpos = 0;
    private static int Ypos = 0;
    private View view;
    private ViewGroup viewGroup;
    private FrameLayout layout;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // fragment layout 추가
        View view = inflater.inflate(R.layout.fragment_custom_map, null);
        this.viewGroup = container;

        this.view = view;
        initSetting();
        return view;
    }

    private void eventSetting(){

    }

    private void initSetting(){
        layout = (FrameLayout)view.findViewById(R.id.map_fragment_frame_layout);

        vScroll = (ScrollView)view.findViewById(R.id.map_fragment_vertical_scroll);
        hScroll = (HorizontalScrollView)view.findViewById(R.id.map_fragment_horizontal_scroll);

        vScroll.setFadingEdgeLength(0);
        hScroll.setFadingEdgeLength(0);

        vScroll.setOnTouchListener(this);
        hScroll.setOnTouchListener(this);

        AllocateImageButtonInFragment allocate = new AllocateImageButtonInFragment(getActivity(), layout);
    }

    private void scroll(int x, int y){
        hScroll.scrollBy(x, 0);
        vScroll.scrollBy(0, y);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Xpos = (int) event.getRawX();
                Ypos = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int Xpos2 = (int) event.getRawX();
                int Ypos2 = (int) event.getRawY();
                scroll(Xpos - Xpos2, Ypos - Ypos2);
                Xpos = Xpos2;
                Ypos = Ypos2;
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                Xpos = (int) event.getRawX();
                Ypos = (int) event.getRawY();
                break;
            }
        Xpos = (int) event.getRawX();
        Ypos = (int) event.getRawY();
        return true;
    }

}
