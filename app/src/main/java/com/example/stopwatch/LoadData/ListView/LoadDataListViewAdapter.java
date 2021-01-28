package com.example.stopwatch.LoadData.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stopwatch.R;

import java.util.ArrayList;

public class LoadDataListViewAdapter extends BaseAdapter {

    public ArrayList<LoadDataListViewItem> mItem = new ArrayList<>(); //!< ArrayList 객체 생성

    @Override
    public int getCount() { //!< 리스트뷰 아이템갯수만큼 리턴
        return mItem.size();
    }

    @Override
    public Object getItem(int position) {       //!< 리스트뷰 아이템 포지션에 맞게 리턴
        return mItem.get(position);
    }

    @Override
    public long getItemId(int position) {       //!< 리스트뷰 아이템 id 포지션에 맞게 리턴
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();  //!< 컨텍스트 연결

        if(convertView == null){    //!< 컨버트뷰 null일때
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);    //!< 레이아웃 인플레이터 선언
            convertView = inflater.inflate(R.layout.loaddata_item,parent,false);     //!< 컨버트뷰에 리스트뷰아이템 적용
        }

        TextView textView1 = (TextView)convertView.findViewById(R.id.loaddata_listviewitem1);       //!< 텍스트뷰에 id값 연결

        LoadDataListViewItem loadDataListViewItem = (LoadDataListViewItem)getItem(position);        //!< 리스트뷰아이템 객체생성

        textView1.setText(loadDataListViewItem.getSlap());      //!< setText 리스트뷰 구간기록 아이템

        return convertView;     //!< 리턴 컨버트뷰
    }

    /**
     * add아이템 메서드
     * @param lap - 구간기록
     */
    public void addLoadItem(String lap){

        LoadDataListViewItem loadDataListViewItem = new LoadDataListViewItem(); //!< 리스트뷰아이템 객체생성
        loadDataListViewItem.setSlap(lap);  //!< 리스트뷰아이템 set
        mItem.add(loadDataListViewItem);    //!< add아이템

    }
}
