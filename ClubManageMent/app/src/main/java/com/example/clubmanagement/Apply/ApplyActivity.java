package com.example.clubmanagement.Apply;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import com.example.clubmanagement.ClubPage.ClubPoster;
import com.example.clubmanagement.ClubPage.Club_page;
import com.example.clubmanagement.Form.Application_Form;
import com.example.clubmanagement.Fragment.FragmentStart;
import com.example.clubmanagement.R;

public class ApplyActivity extends Activity implements View.OnClickListener{
    Button apply; // 버튼 선언
    Button cancel;
    LinearLayout linear;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.apply_activity);

        //팝업 버튼 설정
        linear = (LinearLayout)findViewById(R.id.linr);
        linear.setBackground(ClubPoster.image);

        apply = (Button)findViewById(R.id.apply); // 팝업 버튼 아이디
        apply.setOnClickListener(this);

        cancel = (Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
    }

    public void mJoin(View v){
        //데이터 전달하기
        Intent intent = new Intent(this, Application_Form.class);
        startActivity(intent);
        //intent.putExtra("result", "Close Popup");
        //setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }

    public void mBack(View v){
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }

    public void onClick(View view){
        if(view == apply) {
            try {
                String Selected_Club_id = getIntent().getStringExtra("CLUB_ID");

                new AlertDialog.Builder(this)
                        .setTitle("가입확인")
                        .setMessage("가입신청 되었습니다.")
                        .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show(); // 팝업창 보여줌
            }
            catch (){

            }
        }
        else if(view == cancel){
            finish();
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}