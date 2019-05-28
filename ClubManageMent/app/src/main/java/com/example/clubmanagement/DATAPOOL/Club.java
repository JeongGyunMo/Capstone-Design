package com.example.clubmanagement.DATAPOOL;

import android.app.Activity;
import android.os.Bundle;

import com.example.clubmanagement.Database.ClubData;

import java.util.ArrayList;
import java.util.HashMap;
import com.example.clubmanagement.Database.ClubData;

public class Club{
    public static ArrayList<HashMap<String, String>> Club_Item_list;
    public Club(){
        ClubData ClubD = new ClubData();
        ClubD.GetListData(ClubD.Temp);
        Club_Item_list = ClubD.Club_Item_list;
    }
}
