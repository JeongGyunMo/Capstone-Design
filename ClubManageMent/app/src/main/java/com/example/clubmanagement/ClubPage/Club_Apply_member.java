package com.example.clubmanagement.ClubPage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.clubmanagement.Adapter.ApplyListAdapter;
import com.example.clubmanagement.Adapter.ListMemberAdapter;
import com.example.clubmanagement.ListVO.ListVO_Apply;
import com.example.clubmanagement.R;

import static android.app.PendingIntent.getActivity;

public class Club_Apply_member extends AppCompatActivity {
    private ListView listview ;
    private ApplyListAdapter adapter;
    private int[] Apply_Img= { R.drawable.check,R.drawable.check,R.drawable.box,R.drawable.box,R.drawable.check,R.drawable.check,R.drawable.x,R.drawable.x,R.drawable.box,R.drawable.check,R.drawable.box};
    private String[] Apply_name= {"권기호","정호준","김성태", "흑운장", "보겸", "아이서", "김균모", "유지형", "정지민", "이편한", "아디소"};
    private String[] Apply_major = {"빅데이터","스마트IOT","일본학과","법학과","바이오메디컬","영어영문학곽","빅데이터","콘텐츠IT","빅데이터","콘텐츠IT","빅데이터"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_member_page);

        //변수 초기화
        adapter = new ApplyListAdapter();
        listview = (ListView) findViewById(R.id.member_list_view);

        //어뎁터 할당
        listview.setAdapter(adapter);

        //adapter를 통한 값 전달
        for(int i=0; i<Apply_Img.length;i++){
            adapter.addVO(ContextCompat.getDrawable(this,Apply_Img[i]),Apply_name[i],Apply_major[i]);
        }
    }
}

