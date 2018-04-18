package com.example.inhamap.Commons;

import android.app.Application;
import android.util.Log;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

/**
 * Created by myown on 2018. 4. 18..
 */

public class GlobalApplication extends Application {

    // 어플리케이션이 최초 실행되면 호출되는 함수
    // 사용 전 AndroidManifest.xml 에 등록해서 (android:name) 사용해야함.
    private Socket mSocket;
    {
        try{
            mSocket = IO.socket(URL.SERVER_URL);
            mSocket.connect();
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        Log.d("SOCKET_CONNECTION", "socket connected");
    }

    public Socket getSocket(){
        return mSocket;
    }
}
