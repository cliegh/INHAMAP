package com.example.inhamap.Utils;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.inhamap.Components.NodeImageButton;
import com.example.inhamap.Components.TestDrawingView;
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
    private ArrayList<NodeImageButton> btnList;
    private NodeImageButton startNodeButton;
    private NodeImageButton destinationNodeButton;

    public AllocateImageButtonInFragment(final Context context, final FrameLayout layout){
        this.context = context;
        this.frameLayout = layout;

        /*
        ImageButton button1 = new ImageButton(this.context);
        button1.setBackgroundResource(R.drawable.node_icon_1);

        button1 = (ImageButton)setMargin(button1, 100, 100);
        */
        this.list = new ArrayList<NodeItem>();
        this.btnList = new ArrayList<NodeImageButton>();
        initList();
        for(int i = 0; i < this.list.size(); i++){
            NodeImageButton btn = new NodeImageButton(this.context, this.list.get(i));
            this.btnList.add(btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int objIndex = 0;
                    for(int i = 0; i < btnList.size(); i++){
                        if(btnList.get(i) == v){
                            objIndex = i;
                            break;
                        }
                    }
                    NodeItem tmpItem = list.get(objIndex);
                    Log.e("NODE_ITEM", tmpItem.getNodeName());

                    final PopupWindow popup = new PopupWindow(v);
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

                    // test code
                    final TestDrawingView test = (TestDrawingView)layout.findViewById(R.id.map_fragment_surface_view);

                    // 팝업 뷰에 배치된 컴포넌트(버튼) 등록
                    Button start = (Button)view.findViewById(R.id.popup_window_button_start_node);
                    final int buttonIndex = objIndex;
                    start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.e("POPUP", "출발");
                            if(startNodeButton != null){
                                startNodeButton.setBackgroundImageByStatus(0);
                            }
                            startNodeButton = btnList.get(buttonIndex);
                            startNodeButton.setBackgroundImageByStatus(3);
                            popup.dismiss();
                        }
                    });
                    Button destination = (Button)view.findViewById(R.id.popup_window_button_destination_node);
                    destination.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.e("POPUP", "도착");
                            if(destinationNodeButton != null){
                                destinationNodeButton.setBackgroundImageByStatus(0);
                            }
                            destinationNodeButton = btnList.get(buttonIndex);
                            destinationNodeButton.setBackgroundImageByStatus(4);
                            popup.dismiss();
                        }
                    });
                    Button detail = (Button)view.findViewById(R.id.popup_window_button_detail_information);
                    detail.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.e("POPUP", "상세");
                            if(test == null){
                                Log.e("TEST", "test is null");
                                return;
                            }
                            test.drawLine(30f, 30f, 1000f, 1000f);
                        }
                    });

                    //팝업 뷰 텍스트 뷰 설정
                    TextView name = (TextView)view.findViewById(R.id.popup_window_menu_text_view_title);
                    name.setText(tmpItem.getNodeName());

                    //인자로 넘겨준 v 아래로 보여주기
                    popup.showAsDropDown(v);
                }
            });
            this.frameLayout.addView(btn);
        }
    }


    private void initList(){
        JSONFileParser json = new JSONFileParser(this.context, "node_data");
        NodeListMaker list = new NodeListMaker(json.getJSON());
        ArrayList<NodeItem> items = list.getItems();
        for(int i = 0; i < items.size(); i++){
            this.list.add(items.get(i));
        }
        /*
        this.list.add(new NodeItem(0, 1270, 105, "non1", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1379, 132, "non2", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1409, 168, "non3", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1270, 105, "non4", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1168, 62, "non5", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1103, 133, "non6", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 995, 133, "non7", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1096, 172, "non8", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1096, 247, "non9", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1042, 254, "non10", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1013, 352, "non11", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 916, 172, "non12", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 919, 373, "non13", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1029, 404, "non14", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1139, 378, "non15", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 1142, 300, "non16", 0.0f, 0.0f));
        this.list.add(new NodeItem(0, 950, 212, "non17", 0.0f, 0.0f));

        this.list.add(new NodeItem(1,1155,84, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1178,77, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1217,75, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1243,121, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1270,126, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1365,124, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1280,223, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1297,203, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1400,186, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1264,238, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1266,261, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1216,262, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1161,267, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1161,302, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1160,378, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1160,427, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1031,428, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,899,427, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,896,374, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,899,282, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,952,259, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1011,257, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1042,231, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1093,226, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,901,173, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,901,125, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,995,109, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1103,94, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1104,120, "edge1", 0.0f, 0.0f));
        this.list.add(new NodeItem(1,1162,120, "edge1", 0.0f, 0.0f));
        */
    }
}
