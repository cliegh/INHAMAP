package com.example.inhamap.Components;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.util.TypedValue;
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
            case 1:{
                this.setBackgroundResource(R.drawable.node_icon_4);
                break;
            }
            case 2:{
                this.setBackgroundResource(R.drawable.node_icon_3);
                break;
            }
            case 3:{
                this.setBackgroundResource(R.drawable.node_icon_2);
                break;
            }
            case 4:{
                this.setBackgroundResource(R.drawable.node_icon_5);
                break;
            }
            default:{
                this.setBackgroundResource(R.drawable.node_icon_1);
                break;
            }
        }
        // 버튼의 영역을 30dp 로 고정
        final int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25, getResources().getDisplayMetrics());
        final int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25, getResources().getDisplayMetrics());
        FrameLayout.LayoutParams p = new FrameLayout.LayoutParams(width, height);

        float d = context.getResources().getDisplayMetrics().density;
        p.setMargins((int)(d*item.getMarginLeft()), (int)(d*item.getMarginTop()), 0, 0);
        this.setLayoutParams(p);
    }

    public void setBackgroundImageByStatus(int status){
        switch (status){
            case 0:{
                this.setBackgroundResource(R.drawable.node_icon_1);
                break;
            }
            case 1:{
                this.setBackgroundResource(R.drawable.node_icon_4);
                break;
            }
            case 2:{
                this.setBackgroundResource(R.drawable.node_icon_3);
                break;
            }
            case 3:{
                this.setBackgroundResource(R.drawable.node_icon_2);
                break;
            }
            case 4:{
                this.setBackgroundResource(R.drawable.node_icon_5);
                break;
            }
            default:{
                this.setBackgroundResource(R.drawable.node_icon_1);
                break;
            }
        }
    }
}
