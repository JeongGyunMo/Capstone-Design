package com.example.clubmanagement.Restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_page);
        adapter_rest = new ListRestaurantAdapter();
        listview = (ListView) findViewById(R.id.restaurant_info);
        listview.setAdapter(adapter_rest);
        //back = (Button)findViewById(R.id.back); // 팝업 버튼 아이디
        //back.setOnClickListener();
        adapter_rest.addVO("룡의 부활",  "033-0001-0001");

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
}
