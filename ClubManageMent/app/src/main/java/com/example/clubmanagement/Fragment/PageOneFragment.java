package com.example.clubmanagement.Fragment;

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
import com.example.clubmanagement.R;

import java.util.ArrayList;
import java.util.HashMap;

public class PageOneFragment extends Fragment {
    private ListView listview ;
    private ListViewAdapter adapter;
    HashMap<String, String> Club_Item = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> Club_Item_list;
    ClubData Cd = new ClubData();

    public static PageOneFragment newInstance(){
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
        Cd.ClearListData();
        Toast.makeText(getActivity(),"size = " + Club_Item.size(), Toast.LENGTH_LONG).show();
        String temp  = Cd.Temp;
        Cd.GetListData(temp);
        Club_Item_list = Cd.Club_Item_list;

        for(int i = 0; i< Club_Item_list.size(); i++){
            Club_Item = Club_Item_list.get(i);
            adapter.addVO(ContextCompat.getDrawable(this.getActivity() ,R.drawable.one), Club_Item.get("CLUB_ID"), Club_Item.get("CLUB_NM"));
        }

        return v;
    }

}