package com.example.clubmanagement.Popup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.clubmanagement.Form.Application_Form;
import com.example.clubmanagement.R;

public class PopupActivity extends Activity {
    TextView txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_activity);
    }

    // 버튼 클릭
    public void mYES(View v){
        //데이터 전달하기
        Intent intent = new Intent(this, Application_Form.class);
        startActivity(intent);
        //intent.putExtra("result", "Close Popup");
        //setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }
    // 취소 클릭
    public void mNo(View v){
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
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
