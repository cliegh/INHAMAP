package com.example.inhamap.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inhamap.R;

/**
 * Created by myown on 2018. 4. 18..
 */

public class CustomMapFragment extends Fragment {

    TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // fragment layout 추가
        View view = inflater.inflate(R.layout.fragment_custom_map, null);

        textView = (TextView)view.findViewById(R.id.custom_map_text_view);

        return view;
    }

}
