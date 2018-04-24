package com.example.inhamap.Components;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.inhamap.Models.NodeItem;
import com.example.inhamap.R;

/**
 * Created by myown on 2018. 4. 24..
 */

public class NodeImageButton extends AppCompatImageButton {

    public NodeImageButton(Context context) {
        super(context);
    }

    public NodeImageButton(Context context, NodeItem item){
        super(context);
        switch (item.getNodeStatus()){
            case 0:{
                this.setBackgroundResource(R.drawable.node_icon_1);
                break;
            }
            default:{
                this.setBackgroundResource(R.drawable.node_icon_1);
                break;
            }
        }
        FrameLayout.LayoutParams p = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        float d = context.getResources().getDisplayMetrics().density;
        p.setMargins((int)(d*item.getMarginLeft()), (int)(d*item.getMarginTop()), 0, 0);
        this.setLayoutParams(p);
    }


}
