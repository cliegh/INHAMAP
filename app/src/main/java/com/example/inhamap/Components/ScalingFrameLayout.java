package com.example.inhamap.Components;

import android.content.Context;
import android.widget.FrameLayout;

/**
 * Created by myown on 2018. 4. 28..
 */

public class ScalingFrameLayout extends FrameLayout {

    public ScalingFrameLayout(Context context){
        super(context);
        setWillNotDraw(false); // 이건 무슨 함수?
    }

}
