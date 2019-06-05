package com.example.clubmanagement.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.clubmanagement.ListVO.ListVO_Member;
import com.example.clubmanagement.R;

import java.util.ArrayList;

public class ListMemberAdapter extends BaseAdapter {

    private ArrayList<ListVO_Member> listVO_Member = new ArrayList<ListVO_Member>() ;

    @Override
    public int getCount() {
        return listVO_Member.size() ;
    }

    // ** 이 부분에서 리스트뷰에 데이터를 넣어줌 **
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //postion = ListView의 위치      /   첫번째면 position = 0
        final int pos = position;
        final Context context = parent.getContext();


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.club_member_listview, parent, false);
        }

        TextView staff = (TextView) convertView.findViewById(R.id.staff) ;
        TextView name = (TextView) convertView.findViewById(R.id.name) ;
        TextView major = (TextView) convertView.findViewById(R.id.major) ;
        TextView phoneNM = (TextView) convertView.findViewById(R.id.phoneNM) ;

        ListVO_Member listViewMember = listVO_Member.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        staff.setText(listViewMember.getStaff());
        name.setText(listViewMember.getName());
        major.setText(listViewMember.getMajor());
        phoneNM.setText(listViewMember.getPhoneNM());


        //리스트뷰 클릭 이벤트

        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return position ;
    }


    @Override
    public Object getItem(int position) {
        return listVO_Member.get(position) ;
    }

    // 데이터값 넣어줌
    public void addVO(String staff, String name, String major, String phoneNM) {
        ListVO_Member item = new ListVO_Member();
        item.setStaff(staff);
        item.setName(name);
        item.setMajor(major);
        item.setPhoneNM(phoneNM);

        listVO_Member.add(item);
    }
}