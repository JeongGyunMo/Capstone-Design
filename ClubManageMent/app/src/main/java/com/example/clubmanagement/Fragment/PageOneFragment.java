package com.example.clubmanagement.Fragment;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.clubmanagement.Adapter.ListViewAdapter;
import com.example.clubmanagement.Database.ClubData;
import com.example.clubmanagement.Database.Club_Member_Data;
import com.example.clubmanagement.Database.ImageURL.Image_File;
import com.example.clubmanagement.R;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class PageOneFragment extends Fragment {
    public String ID;
    private ListView listview;
    private ListViewAdapter adapter;
    HashMap<String, String> Club_Item = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> Club_Item_list;
    HashMap<String, String> Club_Member_Item = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> Club_Member_Item_list;

    ClubData Cd = new ClubData();
    Club_Member_Data CMD = new Club_Member_Data();
    Image_File ht;
    public static PageOneFragment newInstance() {
        Bundle args = new Bundle();
        PageOneFragment fragment = new PageOneFragment();
        fragment.setArguments(args);
        return fragment;
    }
    /*
    public void SENDID(String STUDENT_ID){
        //ID = STUDENT_ID;
        //Toast.makeText(getActivity(), STUDENT_ID, Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_page_one, container, false);
        adapter = new ListViewAdapter();
        listview = (ListView) v.findViewById(R.id.List_view);

        listview.setAdapter(adapter);


        //변수 초기화

        //DataInput();
        //어뎁터 할당
        return v;
    }

    private void DataInput(){
        String Ids = ID;
        listview.setAdapter(adapter);
        CMD.ClearListData();
        CMD.GetListData(CMD.Temp);
        Club_Member_Item_list = CMD.Club_Member_Item_list;

        Cd.ClearListData();
        Cd.GetListData(Cd.Temp);
        Club_Item_list = Cd.Club_Item_list;

        for (int i = 0; i < Club_Member_Item_list.size(); i++) {
            Club_Member_Item = Club_Member_Item_list.get(i);
            if(Club_Member_Item.get("STUDENT_ID").equals(ID)){
                Club_Item = Club_Item_list.get(i);
                if(Club_Member_Item.get("CLUB_ID").equals(Club_Item.get("CLUB_ID"))){
                    String url = Club_Item.get("INTRO_FILE_NM");
                    ht = new Image_File(url);
                    ht.run();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    adapter.addVO(new BitmapDrawable(getResources(), ht.bitmap), Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            }
        }


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), (position+1) +"번째 리스트가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}