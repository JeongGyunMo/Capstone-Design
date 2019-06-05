package com.example.clubmanagement.ClubPage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
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

public class Club_page_member extends AppCompatActivity {
    private ListView listview ;
    private ListMemberAdapter adapter;
    private String[] staff= {"회장","부회장","총무","회원","회원","회원","회원","회원","회원","회원","회원"};
    private String[] name= {"정균모","이호명","이지아", "김중형", "김중형", "김중형", "김중형", "김중형", "김중형", "김중형", "김중형"};
    private String[] major= {"빅데이터","콘텐츠IT","빅데이터","콘텐츠IT","빅데이터","콘텐츠IT","빅데이터","콘텐츠IT","빅데이터","콘텐츠IT","빅데이터"};
    private String[] phoneNM= {"010-5253-4567","010-5352-1523","010-3525-5232","010-9424-5525","010-9424-5525","010-9424-5525","010-9424-5525","010-9424-5525","010-9424-5525","010-9424-5525","010-9424-5525"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_member_page);

        //변수 초기화
        adapter = new ListMemberAdapter();
        listview = (ListView) findViewById(R.id.member_list_view);

        //어뎁터 할당
        listview.setAdapter(adapter);

        //adapter를 통한 값 전달
        for(int i=0; i<staff.length;i++){
            adapter.addVO(staff[i],name[i],major[i],phoneNM[i]);
        }
    }
}

