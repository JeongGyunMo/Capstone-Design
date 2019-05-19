package com.example.clubmanagement.Fragment;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.clubmanagement.Adapter.ListViewAdapter;
import com.example.clubmanagement.Database.ClubData;
import com.example.clubmanagement.Database.ImageURL.Image_File;
import com.example.clubmanagement.R;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class PageOneFragment extends Fragment {
    private ListView listview;
    private ListViewAdapter adapter;
    HashMap<String, String> Club_Item = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> Club_Item_list;
    ClubData Cd = new ClubData();
    Image_File ht;
    public static PageOneFragment newInstance() {
        Bundle args = new Bundle();
        PageOneFragment fragment = new PageOneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_page_one, container, false);

        //변수 초기화
        adapter = new ListViewAdapter();
        listview = (ListView) v.findViewById(R.id.List_view);

        //어뎁터 할당
        listview.setAdapter(adapter);

/*
        url = "http://192.168.0.3/club_icon/노네임.png";
        ht = new Image_File(url);
        TossImage(ht, url);
        ht.run();
        Drawable Club_Image = new BitmapDrawable(getResources(), ht.bitmap);
        /*
        ImageView img1;
        img1 = (ImageView)v.findViewById(R.id.imim);
        img1.setImageBitmap(ht.bitmap);
*/

        Cd.ClearListData();
        String temp = Cd.Temp;
        Cd.GetListData(temp);
        Club_Item_list = Cd.Club_Item_list;

        for (int i = 0; i < Club_Item_list.size(); i++) {
            Club_Item = Club_Item_list.get(i);
            String url = Club_Item.get("INTRO_FILE_NM");
            ht = new Image_File(url);
            ht.run();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            adapter.addVO(new BitmapDrawable(getResources(), ht.bitmap), Club_Item.get("CLUB_ID"), Club_Item.get("CLUB_NM"));
        }

        return v;
    }
}