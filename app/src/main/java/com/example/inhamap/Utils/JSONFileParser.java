package com.example.inhamap.Utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by myown on 2018. 4. 30..
 */

public class JSONFileParser {
    private String fileName;
    private JSONObject json;
    private Context context;

    public JSONFileParser(Context context, String fileName){
        this.fileName = fileName;
        this.context = context;
        String json = null;
        try {
            InputStream is = this.context.getAssets().open(fileName);
            int size = is.available();
            //Log.e("JSON", Integer.toString(size));
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            this.json = new JSONObject(json);
        } catch (IOException ex) {
            ex.printStackTrace();
        }catch (JSONException jsonEx){
            jsonEx.printStackTrace();
        }
        if(json != null){
            //Log.e("JSON", json);
        }
    }

    public JSONObject getJSON(){
        return this.json;
    }
}
