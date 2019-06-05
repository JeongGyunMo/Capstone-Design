package com.example.clubmanagement.Restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.clubmanagement.Adapter.ListRestaurantAdapter;
import com.example.clubmanagement.Adapter.ListViewAdapter;
import com.example.clubmanagement.ClubPage.Club_page;
import com.example.clubmanagement.R;

public class Restaurant_Activity extends AppCompatActivity {
    Button back;
    private ListRestaurantAdapter adapter_rest;
    private ListView listview;
    private String store [] = {"도스마스","대암감자탕","룡의부활","병천순대국","이삭토스트","한솥","함께밥상"};
    private String number [] = {"033-0000-0000", "033-0001-0001", "033-0002-0002", "033-0003-0003", "033-0004-0004", "033-0005-0005", "033-0006-0006"};

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_page);
        adapter_rest = new ListRestaurantAdapter();
        listview = (ListView) findViewById(R.id.restaurant_info);
        listview.setAdapter(adapter_rest);
        //back = (Button)findViewById(R.id.back); // 팝업 버튼 아이디
        //back.setOnClickListener();
        DataInput();

    }

    public void mBack(View v){
        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);
    }

    public void onClick(View view){
        if(view == back){
            startActivity(new Intent(this, Club_page.class));
        }
    }

    private void DataInput(){
        listview.setAdapter(adapter_rest);
        adapter_rest.addVO(store[0], number[0]);
    }
}
