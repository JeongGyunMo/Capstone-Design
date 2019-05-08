package com.example.clubmanagement.Fragment;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.clubmanagement.Adapter.ListViewAdapter;
import com.example.clubmanagement.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageOneFragment extends Fragment {
    private ListView listview ;
    private ListViewAdapter adapter;
    private int[] img = {R.drawable.one,R.drawable.two,R.drawable.three};
    private String[] Title = {"정준일 바램","윤종신 좋니","러블리즈 아츄"};
    private String[] Context = {"정준일 명곡","윤종신 히트곡","러블리즈 히트곡"};

    public static PageOneFragment newInstance(){
        Bundle args = new Bundle();
        PageOneFragment fragment = new PageOneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page_three, container, false);

        //변수 초기화
        adapter = new ListViewAdapter();
        listview = (ListView) v.findViewById(R.id.List_view);

        //어뎁터 할당
        listview.setAdapter(adapter);

        //adapter를 통한 값 전달
        for(int i=0; i<img.length;i++){
            adapter.addVO(ContextCompat.getDrawable(this.getActivity() ,img[i]),Title[i],Context[i]);
        }

        return v;
    }

}