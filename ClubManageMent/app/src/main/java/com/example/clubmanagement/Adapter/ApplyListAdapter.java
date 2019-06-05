package com.example.clubmanagement.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clubmanagement.Club_Home.Club_Home;
import com.example.clubmanagement.ListVO.ListVO;
import com.example.clubmanagement.ListVO.ListVO_Apply;
import com.example.clubmanagement.R;

import java.util.ArrayList;

public class ApplyListAdapter extends BaseAdapter {

    private ArrayList<ListVO_Apply> listVO_Apply = new ArrayList<ListVO_Apply>();

    public ApplyListAdapter() {
    }
    @Override
    public int getCount() {
        return listVO_Apply.size();
    }

    // ** 이 부분에서 리스트뷰에 데이터를 넣어줌 **
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //postion = ListView의 위치      /   첫번째면 position = 0
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.apply_listview, parent, false);
        }


        ImageView Apply_img = (ImageView) convertView.findViewById(R.id.Apply_img);
        TextView Apply_name = (TextView) convertView.findViewById(R.id.Apply_name);
        TextView Apply_major = (TextView) convertView.findViewById(R.id.Apply_major);


        final ListVO_Apply listViewItem = listVO_Apply.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        Apply_img.setImageDrawable(listViewItem.getApply_Img());
        Apply_name.setText(listViewItem.getApply_name());
        Apply_major.setText(listViewItem.getApply_major());

        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public Object getItem(int position) {
        return listVO_Apply.get(position);
    }

    // 데이터값 넣어줌
    public void addVO(Drawable Apply_Img, String Apply_name, String setApply_major) {
        ListVO_Apply item = new ListVO_Apply();

        item.setApply_Img(Apply_Img);
        item.setApply_name(Apply_name);
        item.setApply_major(setApply_major);

        listVO_Apply.add(item);
    }
}