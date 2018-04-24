package com.example.inhamap.Adapter;

import com.example.inhamap.R;

public class DoorData {
    public String doorName;
    public int elevator;
    public int wheelchair;
    public int stair;

    public DoorData(String doorName){
        this.doorName = doorName;
        this.elevator = R.drawable.elevator;
        this.wheelchair = R.drawable.wheelchair;
        this.stair = R.drawable.stair;
    }

    public DoorData(String doorName,int elevator,int wheelchair,int stair){
        this.doorName = doorName;
        this.elevator = elevator;
        this.wheelchair = wheelchair;
        this.stair = stair;
    }

}
