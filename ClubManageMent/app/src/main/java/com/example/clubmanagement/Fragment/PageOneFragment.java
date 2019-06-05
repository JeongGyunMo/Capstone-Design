package com.example.clubmanagement.Fragment;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
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
import com.example.clubmanagement.ClubPage.ClubPositon;
import com.example.clubmanagement.ClubPage.Club_page;
import com.example.clubmanagement.DATAPOOL.Club;
import com.example.clubmanagement.DATAPOOL.Club_Member;
import com.example.clubmanagement.DATAPOOL.Club_UserID;
import com.example.clubmanagement.Database.ClubData;
import com.example.clubmanagement.Database.Club_Member_Data;
import com.example.clubmanagement.Database.ImageURL.Image_File;
import com.example.clubmanagement.R;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class PageOneFragment extends Fragment {
    private ListView listview;
    private ListViewAdapter adapter;
    private int[] img = {R.drawable.hallym,R.drawable.light,R.drawable.eleven,R.drawable.noname};
    private String[] ClubName = {"Hallym","팬타곤","일레븐","노네임"};
    private String[] Context = {"한림대학교를 자랑하기 위해서 만들었습니다.","공대의 농구 실력을 위해서 만들었습니다.","공학 공부를 위해서 만들었습니다.","공대의 축구 실력을 위해서 만들었습니다."};
    int count;

   // ClubData Cd = new ClubData();
    //Club_Member_Data CMD = new Club_Member_Data();
    Image_File ht;
    public static PageOneFragment newInstance() {
        Bundle args = new Bundle();
        PageOneFragment fragment = new PageOneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_page_one, container, false);
        adapter = new ListViewAdapter();
        listview = (ListView) v.findViewById(R.id.List_view);
        DataInput();

        return v;
    }

    private void DataInput(){
        listview.setAdapter(adapter);
        count = 0;
       // for(int i = 0; i<4;i++){
            adapter.addVO(ContextCompat.getDrawable(this.getActivity() ,img[0]),ClubName[0],Context[0]);
        //}

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), (position+1) +"번째 리스트가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
                ClubPositon.position = position;
                startActivity(new Intent(getActivity(), Club_page.class));
            }
        });

    }
}