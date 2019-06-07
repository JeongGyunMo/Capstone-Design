package com.example.clubmanagement.Item;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.clubmanagement.Adapter.ItemListAdapter;
import com.example.clubmanagement.Adapter.ListRestaurantAdapter;
import com.example.clubmanagement.Adapter.ListViewAdapter;
import com.example.clubmanagement.Apply.ApplyActivity;
import com.example.clubmanagement.ClubPage.ClubPositon;
import com.example.clubmanagement.ClubPage.Club_page;
import com.example.clubmanagement.R;

import static java.lang.Thread.sleep;

public class Item_Activity  extends AppCompatActivity {
    private String[] Item = {"컴퓨터","A4","키보드","충전기"};
    public static int[] quantity = {3,50,3,5};
    public static int select;
    private ItemListAdapter adapter_Item;
    private ListView listview;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_form);

        adapter_Item = new ItemListAdapter();
        listview = (ListView) findViewById(R.id.item_listview);
        listview.setAdapter(adapter_Item);

        for(int i = 0; i < 4; i ++) {
            adapter_Item.addVO(Item[i], quantity[i] + "개");
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                select = position;
                Intent intent = new Intent(Item_Activity.this, Itempopup.class);
                startActivityForResult(intent, 1);
            }
        });

    }
    @Override
    public void onResume() {
        super.onResume();

        adapter_Item = new ItemListAdapter();
        //listview = (ListView) findViewById(R.id.item_listview);
        listview.setAdapter(adapter_Item);
        for(int i = 0; i < 4; i ++) {
            adapter_Item.addVO(Item[i], quantity[i] + "개");
        }
    }


}
