package com.example.inhamap.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by myown on 2018. 4. 29..
 */

public class TestDrawingView extends View {

    private float startX;
    private float startY;
    private float endX;
    private float endY;
    private boolean isDrawing = true;

    public TestDrawingView(Context context){
        super(context);
        init();
    }

    public TestDrawingView(Context context, AttributeSet attr){
        super(context, attr);
        init();
    }

    private void init(){

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e("TEST_VIEW", "Canvas loaded.");
        if(!isDrawing){
            isDrawing = true;
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(10);
            canvas.drawLine(startX, startY, endX, endY, paint);
        }else{
            isDrawing = false;
        }
    }

    public void drawLine(float startX, float startY, float endX, float endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        invalidate();
    }
}
