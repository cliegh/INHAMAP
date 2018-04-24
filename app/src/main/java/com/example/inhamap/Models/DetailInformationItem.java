package com.example.inhamap.Models;

import java.io.Serializable;

/**
 * Created by myown on 2018. 4. 24..
 */

public class DetailInformationItem implements Serializable {
    private int buildingCode;
    private double userLongitude;
    private double userLatitude;

    public DetailInformationItem(){
        // default constructor
    }

    public DetailInformationItem(int code, double lat, double lng){
        this.buildingCode = code;
        this.userLongitude = lng;
        this.userLatitude = lat;
    }

    public int getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(int buildingCode) {
        this.buildingCode = buildingCode;
    }

    public double getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(double userLongitude) {
        this.userLongitude = userLongitude;
    }

    public double getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(double userLatitude) {
        this.userLatitude = userLatitude;
    }
}
