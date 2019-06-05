package com.example.clubmanagement.Restaurant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.clubmanagement.Adapter.ListRestaurantAdapter;
import com.example.clubmanagement.R;

public class Restaurant_Activity extends AppCompatActivity{

    private ListRestaurantAdapter adapter_rest;
    private ListView listview;
    private String store [] = {"도스마스","대암감자탕","룡의부활","병천순대국","이삭토스트","타박네","쥬시","한솥","함께밥상","GS25"};
    private String number [] = {"033-0000-0000", "033-0001-0001", "033-0002-0002", "033-0003-0003", "033-0004-0004", "033-0005-0005", "033-0006-0006","033-0007-0007","033-0006-0006","033-0006-0006"};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_page);

        adapter_rest = new ListRestaurantAdapter();
        listview = (ListView) findViewById(R.id.restaurant_info);
        DataInput();

    }

    private void DataInput() {
        listview.setAdapter(adapter_rest);
        for(int i = 0; i < store.length; i++) {
            adapter_rest.addVO(store[i],number[i]);
        }
    }
}
