package com.example.clubmanagement.Fragment;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.AdapterView;
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
//import android.widget.Toast;

import com.example.clubmanagement.Adapter.ListViewAdapter;
import com.example.clubmanagement.Apply.ApplyActivity;
import com.example.clubmanagement.ClubPage.ClubPoster;
import com.example.clubmanagement.DATAPOOL.Club;
import com.example.clubmanagement.Database.ClubData;
import com.example.clubmanagement.Database.Club_Member_Data;
import com.example.clubmanagement.Database.ImageURL.Image_File;
import com.example.clubmanagement.ListVO.ListVO;
import com.example.clubmanagement.R;

import java.util.ArrayList;
import java.util.HashMap;

import static android.app.Activity.RESULT_OK;
import static java.lang.Thread.sleep;

public class PageThreeFragment extends Fragment {
    private ListView listview;
    private ListViewAdapter adapter;
    int Code = 0;
    private int[] img = {R.drawable.hallym,R.drawable.light,R.drawable.eleven,R.drawable.noname,R.drawable.video,R.drawable.cloud,R.drawable.general,R.drawable.wings,R.drawable.heart,R.drawable.shop,R.drawable.triangle,R.drawable.waterdrop};
    private String[] ClubName = {"Hallym","팬타곤","일레븐","노네임","영상틀","한빛","힙합PD","CCC","씨애랑","VIP","불꽃슛","음감실"};
    private String[] Context = {"한림대학교를 자랑하기 위해서 만들었습니다.","공대의 농구 실력을 위해서 만들었습니다.","공학 공부를 위해서 만들었습니다.","공대의 축구 실력을 위해서 만들었습니다.","영상 제작 동아리", "사진 동아리","힙합 노래 동아리","교회 동아리","공대 학술 동아리","전자공 학술 동아리","축구 동아리","음악 감상 동아리"};
    //HashMap<String, String> Club_Item = new HashMap<String, String>();
    //ArrayList<HashMap<String, String>> Club_Item_list;
    TextView txtResult;
    Button applyUp;
    ClubPoster Cp;
    boolean flag = false;
    int Pos = Integer.MAX_VALUE ;

    public static PageThreeFragment newInstance() {
        Bundle args = new Bundle();
        PageThreeFragment fragment = new PageThreeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page_three, container, false);

        Spinner checkSpinner = (Spinner) v.findViewById(R.id.spinner_Check);
        ArrayAdapter Adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.major, android.R.layout.simple_spinner_item);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        checkSpinner.setAdapter(Adapter);

        checkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Code = position;
                adapter = new ListViewAdapter();
                DataInput(Code);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        listview = (ListView) v.findViewById(R.id.List_view);
        ApplyStart(v);
        return v;
    }

    private void ApplyStart(final View v) {

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pos = position;
            }
        });

        applyUp = (Button) v.findViewById(R.id.button);
        applyUp.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Pos < listview.getCount()){
                    ListVO Vo = (ListVO)(listview.getAdapter().getItem(Pos));
                    Cp.image = (BitmapDrawable) Vo.getImg();
                    Intent intent = new Intent(getActivity(), ApplyActivity.class);
                    startActivityForResult(intent, 1);
                }
                else{
                    Toast.makeText(getContext(),"동아리를 선택하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String result = data.getStringExtra("result");
                txtResult.setText(result);
            }
        }
    }
    private void DataInput(int Code) {
        listview.setAdapter(adapter);
        if(flag) {
            adapter.getClass();
        }
        flag = true;
        if(Code == 0) {
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[10]), ClubName[10], Context[10]);
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[4]), ClubName[4], Context[4]);
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[5]), ClubName[5], Context[5]);
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[6]), ClubName[6], Context[6]);
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[11]), ClubName[11], Context[11]);
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[7]), ClubName[7], Context[7]);
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[0]), ClubName[0], Context[0]);
        }else if(Code == 2){
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[10]), ClubName[10], Context[10]);
        }else if(Code == 4) {
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[4]), ClubName[4], Context[4]);
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[5]), ClubName[5], Context[5]);
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[6]), ClubName[6], Context[6]);
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[11]), ClubName[11], Context[11]);
        }else if(Code == 5){
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[7]), ClubName[7], Context[7]);
        }else if(Code == 6){
            adapter.addVO(ContextCompat.getDrawable(this.getActivity(), img[0]), ClubName[0], Context[0]);
        }
    }

/*
    private void DataInput(int Code) {
        listview.setAdapter(adapter);
        if(flag) {
            adapter.getClass();
            Club_Item_list.clear();
        }
        flag = true;
        Club_Item_list = Club.Club_Item_list;
        for (int i = 0; i < Club_Item_list.size(); i++) {
            Club_Item = Club_Item_list.get(i);
            String url = Club_Item.get("INTRO_FILE_NM");
            Image_File ht = new Image_File(url);
            ht.run();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Cp.image = new BitmapDrawable(getResources(),ht.bitmap);
            if (Club_Item.get("CLUB_GB_CD").equals("1002") && Code == 0) {
                adapter.addVO(Cp.image, Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
            } else if (Club_Item.get("CLUB_GB_CD").equals("1002") && Code == 1) {
                if (Club_Item.get("CLUB_AT_CD").equals("2001")) {
                    adapter.addVO(Cp.image, Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            } else if (Club_Item.get("CLUB_GB_CD").equals("1002") && Code == 2) {
                if (Club_Item.get("CLUB_AT_CD").equals("2002")) {
                    adapter.addVO(Cp.image, Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            } else if (Club_Item.get("CLUB_GB_CD").equals("1002") && Code == 3) {
                if (Club_Item.get("CLUB_AT_CD").equals("2003")) {
                    adapter.addVO(Cp.image, Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            } else if (Club_Item.get("CLUB_GB_CD").equals("1002") && Code == 4) {
                if (Club_Item.get("CLUB_AT_CD").equals("2004")) {
                    adapter.addVO(Cp.image, Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            } else if (Club_Item.get("CLUB_GB_CD").equals("1002") && Code == 5) {
                if (Club_Item.get("CLUB_AT_CD").equals("2005")) {
                    adapter.addVO(Cp.image, Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            } else if (Club_Item.get("CLUB_GB_CD").equals("1002") && Code == 6) {
                if (Club_Item.get("CLUB_AT_CD").equals("2006")) {
                    adapter.addVO(Cp.image, Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            }
        }
    }*/
}
