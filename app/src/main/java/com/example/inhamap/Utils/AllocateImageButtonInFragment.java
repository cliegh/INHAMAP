package com.example.inhamap.Utils;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.inhamap.Components.NodeImageButton;
import com.example.inhamap.Models.NodeItem;
import com.example.inhamap.R;

import java.util.ArrayList;

/**
 * Created by myown on 2018. 4. 24..
 */

public class AllocateImageButtonInFragment {

    private Context context;
    private FrameLayout frameLayout;

    // test code
    private ArrayList<NodeItem> list;

    public AllocateImageButtonInFragment(final Context context, FrameLayout layout){
        this.context = context;
        this.frameLayout = layout;

        /*
        ImageButton button1 = new ImageButton(this.context);
        button1.setBackgroundResource(R.drawable.node_icon_1);

        button1 = (ImageButton)setMargin(button1, 100, 100);
        */
        this.list = new ArrayList<NodeItem>();
        initList();
        for(int i = 0; i < this.list.size(); i++){
            NodeImageButton btn = new NodeImageButton(this.context, this.list.get(i));
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupWindow popup = new PopupWindow(v);
                    LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View view = inflater.inflate(R.layout.map_popup_window, null);
                    popup.setContentView(view);
                    //팝업의 크기 설정
                    popup.setWindowLayoutMode(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    //팝업 뷰 터치 되도록
                    popup.setTouchable(true);
                    //팝업 뷰 포커스도 주고
                    popup.setFocusable(true);
                    //팝업 뷰 이외에도 터치되게 (터치시 팝업 닫기 위한 코드)
                    popup.setOutsideTouchable(true);
                    popup.setBackgroundDrawable(new BitmapDrawable());
                    //인자로 넘겨준 v 아래로 보여주기
                    popup.showAsDropDown(v);
                }
            });
            this.frameLayout.addView(btn);
        }
    }


    private void initList(){
        this.list.add(new NodeItem(0, 1270, 105, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1379, 132, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1409, 168, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1270, 105, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1168, 62, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1103, 133, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 995, 133, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1096, 172, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1096, 247, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1042, 254, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1013, 352, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 916, 172, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 919, 373, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1029, 404, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1139, 378, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1142, 300, "non", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 950, 212, "non", 0.0f, 0.0f));

    }
}
