package com.example.clubmanagement.ClubPage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.clubmanagement.Adapter.ApplyListAdapter;
import com.example.clubmanagement.Adapter.ListMemberAdapter;
import com.example.clubmanagement.Apply.ApplyActivity;
import com.example.clubmanagement.ListVO.ListVO;
import com.example.clubmanagement.ListVO.ListVO_Apply;
import com.example.clubmanagement.R;

import static android.app.PendingIntent.getActivity;

public class Club_Apply_member extends AppCompatActivity implements View.OnClickListener{
    private ListView listview ;
    private ApplyListAdapter adapter;
    private int[] Apply_Img= { R.drawable.check,R.drawable.check,R.drawable.box,R.drawable.box,R.drawable.check,R.drawable.check,R.drawable.x,R.drawable.x,R.drawable.box,R.drawable.check,R.drawable.box};
    private String[] Apply_name= {"권기호","정호준","김성태", "흑운장", "보겸", "아이서", "김균모", "유지형", "정지민", "이편한", "아디소"};
    private String[] Apply_major = {"빅데이터","스마트IOT","일본학과","법학과","바이오메디컬","영어영문학곽","빅데이터","콘텐츠IT","빅데이터","콘텐츠IT","빅데이터"};
    int Pos = Integer.MAX_VALUE;
    Button Deny;
    Button Accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_list);

        //변수 초기화
        adapter = new ApplyListAdapter();
        listview = (ListView) findViewById(R.id.Apply_ListView);

        //어뎁터 할당
        listview.setAdapter(adapter);

        //adapter를 통한 값 전달
        for(int i=0; i<Apply_Img.length;i++){
            adapter.addVO(ContextCompat.getDrawable(this,Apply_Img[i]),Apply_name[i],Apply_major[i]);
        }

        Deny = (Button)findViewById(R.id.deny);
        Deny.setOnClickListener(this);
        Accept = (Button) findViewById(R.id.accept);
        Accept.setOnClickListener(this);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pos = position;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == Deny) {
            new AlertDialog.Builder(Club_Apply_member.this)
                    .setTitle("거절확인")
                    .setMessage("거절되었습니다.")
                    .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show(); // 팝업창 보여줌
        }
        else if(v == Accept){
            new AlertDialog.Builder(Club_Apply_member.this)
                .setTitle("가입확인")
                .setMessage("가입승인 되었습니다.")
                .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
            .show(); // 팝업창 보여줌
        }
    }
}

