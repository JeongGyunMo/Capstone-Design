package com.example.clubmanagement.Fragment;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clubmanagement.Adapter.ListViewAdapter;
import com.example.clubmanagement.Database.ClubData;
import com.example.clubmanagement.Popup.PopupActivity;
import com.example.clubmanagement.R;

import java.util.ArrayList;
import java.util.HashMap;

import static android.app.Activity.RESULT_OK;

public class PageTwoFragment extends Fragment {
    private ListView listview ;
    private ListViewAdapter adapter;
    private int[] img = {R.drawable.one,R.drawable.two,R.drawable.three};
    private String[] Title = {"정준일 바램","윤종신 좋니","러블리즈 아츄"};
    private String[] Context = {"정준일 명곡","윤종신 히트곡","러블리즈 히트곡"};
    HashMap<String, String> Club_Item = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> Club_Item_list;
    ClubData Cd = new ClubData();
    TextView txtResult;
    Button popUp;

    public static PageTwoFragment newInstance() {
        Bundle args = new Bundle();
        PageTwoFragment fragment = new PageTwoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page_two, container, false);

        Spinner checkSpinner = (Spinner) v.findViewById(R.id.spinner_Check);
        ArrayAdapter Adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.major, android.R.layout.simple_spinner_item);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        checkSpinner.setAdapter(Adapter);

        //변수 초기화
        adapter = new ListViewAdapter();
        listview = (ListView) v.findViewById(R.id.List_view);

        //어뎁터 할당
        listview.setAdapter(adapter);


        Cd.ClearListData();
        Club_Item_list = Cd.GetListData();
//        Toast.makeText(getActivity(),"size = " + Club_Item_list.size(), Toast.LENGTH_LONG).show();

        for(int i = 0; i< Club_Item_list.size(); i++){
            Club_Item = Club_Item_list.get(i);
            adapter.addVO(ContextCompat.getDrawable(this.getActivity() ,R.drawable.two), Club_Item.get("CLUB_NM"), Club_Item.get("CLUB_GB_CD"));
        }

/*
        //adapter를 통한 값 전달
        for(int i=0; i<img.length;i++){
            adapter.addVO(ContextCompat.getDrawable(this.getActivity() ,img[i]),Title[i],Context[i]);
        }
*/
        txtResult = (TextView)v.findViewById(R.id.txtResult);
        popUpStart(v);
        return v;
    }

    private void popUpStart(View v) {
        popUp = (Button) v.findViewById(R.id.button) ;
        popUp.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity.class);
                intent.putExtra("data", "Test Popup");
                startActivityForResult(intent, 1);

            }
        }) ;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                //데이터 받기
                String result = data.getStringExtra("result");
                txtResult.setText(result);
            }
        }
    }
}