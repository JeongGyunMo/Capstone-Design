package com.example.clubmanagement.Item;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.clubmanagement.Adapter.ItemListAdapter;
import com.example.clubmanagement.Adapter.ListRestaurantAdapter;
import com.example.clubmanagement.R;

public class Item_Activity  extends AppCompatActivity {

    private ItemListAdapter adapter_Item;
    private ListView listview;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_form);

        adapter_Item = new ItemListAdapter();
        listview = (ListView) findViewById(R.id.item_listview);
        
        listview.setAdapter(adapter_Item);

        adapter_Item.addVO("컴퓨터",  "1개");

    }
}
