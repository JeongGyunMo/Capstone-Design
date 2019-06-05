package com.example.clubmanagement.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.clubmanagement.ListVO.ListVO_Restaurant;
import com.example.clubmanagement.R;
import java.util.ArrayList;

public class ListRestaurantAdapter extends BaseAdapter {

    private ArrayList<ListVO_Restaurant> listVO_Res = new ArrayList<ListVO_Restaurant>();

    @Override
    public int getCount() {
        return listVO_Res.size();
    }

    // ** 이 부분에서 리스트뷰에 데이터를 넣어줌 **
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //postion = ListView의 위치      /   첫번째면 position = 0
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.restaurant_listview, parent, false);
        }

        Log.d("error:","오류발생");
        TextView name = (TextView) convertView.findViewById(R.id.store);
        TextView number = (TextView) convertView.findViewById(R.id.number);

        final ListVO_Restaurant listViewItem = listVO_Res.get(position);

        name.setText(listViewItem.getStore());
        number.setText(listViewItem.getNumber());

        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public Object getItem(int position) {
        return listVO_Res.get(position);
    }

    // 데이터값 넣어줌
    public void addVO(String name, String number) {

        ListVO_Restaurant item = new ListVO_Restaurant();

        //  item.setImg(icon);
        item.setStore(name);
        item.setNUmber(number);
        listVO_Res.add(item);
    }
}