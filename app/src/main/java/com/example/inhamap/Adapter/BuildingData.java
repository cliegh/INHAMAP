package com.example.inhamap.Adapter;

import java.util.ArrayList;

public class BuildingData {
    /*
    이걸 비롯해서 빌딩이름 이라는 파라미터(하나만 넘어옴)를 이용해서 객체지향적으로 활용할수 있도록 작성.
    일단, static한 정보들 어디 저장해야함. 건물이름, 건물주소, 건물 설명, 문1, 문2, ... , 문3,
    문 개수를 갖고 있어야함.
    */
    public String buildingName;
    public String buildingAddress;
    public String buildingExplain;
    public int numberOfDoors;

    public BuildingData(String BuildingName, String buildingAddress, String buildingExplain, int numberOfDoors){
        this.buildingName = BuildingName;
        this.buildingAddress = buildingAddress;
        this.buildingExplain = buildingExplain;
        this.numberOfDoors = numberOfDoors;
    }



}
