package com.example.inhamap.Threads;

import android.util.Log;

/**
 * Created by myown on 2018. 4. 29..
 */

public class DrawOnSurfaceViewThread extends Thread {

    public DrawOnSurfaceViewThread(){
        Log.e("THREAD", "Thread constructor.");
    }

    @Override
    public void run() {
        super.run();
        Log.e("TREAD", "Thread runs.");
    }
}
