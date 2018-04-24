package com.example.inhamap.Models;

import java.io.Serializable;

/**
 * Created by myown on 2018. 4. 24..
 */

public class DetailInformationItem implements Serializable {
    private int buildingCode;

    public DetailInformationItem(){
        // default constructor
    }

    public int getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(int buildingCode) {
        this.buildingCode = buildingCode;
    }
}
