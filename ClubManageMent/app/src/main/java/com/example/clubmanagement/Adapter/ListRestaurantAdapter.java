package com.example.clubmanagement.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.clubmanagement.ListVO.ListVO_Restaurant;
import com.example.clubmanagement.R;
import java.util.ArrayList;

public class ListRestaurantAdapter extends BaseAdapter {

    private ArrayList<ListVO_Restaurant> listVO = new ArrayList<ListVO_Restaurant>();

    public ListRestaurantAdapter() {
    }
    @Override
    public int getCount() {
        return listVO.size();
    }

    // ** 이 부분에서 리스트뷰에 데이터를 넣어줌 **
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //postion = ListView의 위치      /   첫번째면 position = 0
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.restaurant_page, parent, false);
        }

        Log.d("error:","오류발생");
        //ImageView image = (ImageView) convertView.findViewById(R.id.img);
        TextView name = (TextView) convertView.findViewById(R.id.store);
        TextView number = (TextView) convertView.findViewById(R.id.number);

        final ListVO_Restaurant listViewItem = listVO.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        //   image.setImageDrawable(listViewItem.getImg());
        name.setText(listViewItem.getStore());
        number.setText(listViewItem.getNumber());
        //Toast.makeText(context, (pos + 1) + "번째 리스트가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
        //Club_Home ch = new Club_Home();

        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public Object getItem(int position) {
        return listVO.get(position);
    }

    // 데이터값 넣어줌
    public void addVO(String name, String number) {

        ListVO_Restaurant item = new ListVO_Restaurant();

        //  item.setImg(icon);
        item.setStore(name);
        item.setNUmber(number);
        listVO.add(item);
    }
}