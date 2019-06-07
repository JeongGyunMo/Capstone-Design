package com.example.clubmanagement.Item;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.clubmanagement.Form.Application_Form;
import com.example.clubmanagement.R;

public class Itempopup extends Activity implements View.OnClickListener{
    Button itemrental; // 버튼 선언
    Button itemreturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.item_activity);

        itemrental = (Button)findViewById(R.id.itemrental); // 팝업 버튼 아이디
        itemrental.setOnClickListener(this);

        itemreturn = (Button)findViewById(R.id.itemreturn);
        itemreturn.setOnClickListener(this);
    }

    // 버튼 클릭
    public void mYES(View v){
        //데이터 전달하기
        //Intent intent = new Intent(this, Application_Form.class);
        //startActivity(intent);
        //intent.putExtra("result", "Close Popup");
        //setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }
    // 취소 클릭
    public void mNo(View v){
        //데이터 전달하기
        //Intent intent = new Intent();
        //intent.putExtra("result", "Close Popup");
       // setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }

    public void onClick(View view){
        if(view == itemrental) {
            try {

                new AlertDialog.Builder(this)
                        .setTitle("대여")
                        .setMessage("대여 되었습니다.")
                        .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Item_Activity.quantity[Item_Activity.select] -=1;
                                finish();
                            }
                        })
                        .show(); // 팝업창 보여줌
            }
            catch (Exception e){

            }
        }
        else if(view == itemreturn){
            switch(Item_Activity.select){
                case 0:
                    if(Item_Activity.quantity[0] < 3)
                        Item_Activity.quantity[0] += 1;
                    else
                        Toast.makeText(getApplicationContext(), "대여하지 않았습니다.", Toast.LENGTH_LONG).show();
                    break;
                case 1:
                     if(Item_Activity.quantity[1] < 50 )
                        Item_Activity.quantity[1] += 1;
                     else
                         Toast.makeText(getApplicationContext(), "대여하지 않았습니다.", Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    if(Item_Activity.quantity[2] < 3 )
                        Item_Activity.quantity[2] += 1;
                    else
                        Toast.makeText(getApplicationContext(), "대여하지 않았습니다.", Toast.LENGTH_LONG).show();
                    break;
                case 3:
                    if(Item_Activity.quantity[3] < 5 )
                        Item_Activity.quantity[3] += 1;
                    else
                        Toast.makeText(getApplicationContext(), "대여하지 않았습니다.", Toast.LENGTH_LONG).show();
                    break;
            }



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

