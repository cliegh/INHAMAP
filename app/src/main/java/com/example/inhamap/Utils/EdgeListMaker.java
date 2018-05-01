package com.example.inhamap.Utils;

import android.util.Log;

import com.example.inhamap.Models.AdjacentEdge;
import com.example.inhamap.Models.EdgeList;
import com.example.inhamap.Models.NodeItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EdgeListMaker {
    private EdgeList edges;
    private ArrayList<NodeItem> nodes;

    public EdgeListMaker(JSONObject json){
        this.edges = new EdgeList();
        NodeListMaker nodeList = new NodeListMaker(json);
        this.nodes = nodeList.getItems();
        try{
            JSONArray arr = json.getJSONArray("nodeList");
            for(int i = 0; i < arr.length(); i++){
                JSONObject node = arr.getJSONObject(i);
                long curNodeID = node.getLong("nodeID");
                NodeItem tmp1 = findBodeByID(curNodeID);
                JSONArray adj = node.getJSONArray("adjacent");
                for(int j = 0; j < adj.length(); j++){
                    long adjNodeID = adj.getLong(j);
                    NodeItem tmp2 = findBodeByID(adjNodeID);
                    if(tmp1 != null && tmp2 != null){
                        this.edges.addEdge(tmp1, tmp2);
                    }
                }
            }
        }catch (JSONException jsonEx){
            jsonEx.printStackTrace();
        }
        Log.e("EDGE", Integer.toString(this.edges.size()));
    }

    private NodeItem findBodeByID(long id){
        for(int i = 0; i < nodes.size(); i++){
            if(this.nodes.get(i).getNodeID() == id){
                return this.nodes.get(i);
            }
        }
        return null;
    }

    public EdgeList getEdges(){
        return this.edges;
    }
}
