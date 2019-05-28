package com.example.clubmanagement.ClubPage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ListView;

import com.example.clubmanagement.Adapter.ListMemberAdapter;
import com.example.clubmanagement.Adapter.ListViewAdapter;
import com.example.clubmanagement.Database.ClubData;
import com.example.clubmanagement.Database.Club_Member_Data;
import com.example.clubmanagement.Database.ImageURL.Image_File;
import com.example.clubmanagement.R;
import com.example.clubmanagement.login.LoginActivity;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class Club_page_member extends Activity {
    private ListView listview;
    private ListMemberAdapter adapter;
    HashMap<String, String> Club_Member_Item = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> Club_Member_Item_list;
    Club_Member_Data CMD = new Club_Member_Data();
    Image_File ht;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_page_clubmember);

        ListView v = (ListView)findViewById(R.id.Club_Member);

        adapter = new ListMemberAdapter();
        listview = (ListView) v.findViewById(R.id.Club_Member);


        DataInput();
    }

    private void DataInput(){
        listview.setAdapter(adapter);
        CMD.ClearListData();
        CMD.GetListData(CMD.Temp);
        Club_Member_Item_list = CMD.Club_Member_Item_list;
        for (int i = 0; i < Club_Member_Item_list.size(); i++) {
            Club_Member_Item = Club_Member_Item_list.get(i);
            if(Club_Member_Item.get("CLUB_ID").equals(ClubPositon.position)){
                adapter.addVO(Club_Member_Item.get("STUDENT_ID"), Club_Member_Item.get("NM"));
            }
        }
    }
}

