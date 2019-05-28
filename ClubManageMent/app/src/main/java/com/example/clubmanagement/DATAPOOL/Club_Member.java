package com.example.clubmanagement.DATAPOOL;

import com.example.clubmanagement.Database.ClubData;
import com.example.clubmanagement.Database.Club_Member_Data;

import java.util.ArrayList;
import java.util.HashMap;

public class Club_Member {
    public static ArrayList<HashMap<String, String>> Club_Member_Item_list;
    public Club_Member(){
        Club_Member_Data ClubMember = new Club_Member_Data();
        ClubMember.GetListData(ClubMember.Temp);
        Club_Member_Item_list = ClubMember.Club_Member_Item_list;
    }
}
