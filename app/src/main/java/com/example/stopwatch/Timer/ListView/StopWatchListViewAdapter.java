package com.example.stopwatch.Timer.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stopwatch.R;

import java.util.ArrayList;

public class StopWatchListViewAdapter extends BaseAdapter {

    public ArrayList<StopWatchListViewItem> mItem = new ArrayList<>();      //!< 어레이리스트 객체생성

    @Override
    public int getCount() {         //!< 리스트뷰 아이템 갯수만큼 리턴
        return mItem.size();
    }

    @Override
    public Object getItem(int position) {   //!< 리스트뷰 포지션에 맞게 리턴
        return mItem.get(position);
    }

    @Override
    public long getItemId(int position) {   //!< 리스트뷰 id 포지션에 맞게 리턴
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();      //!< 컨텍스트 연결

        if (convertView == null) {      //!< 컨버트뷰 null일때
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);   //!< 레이아웃 인플레이터 선언
            convertView = inflater.inflate(R.layout.listview_item, parent, false);                      //!< 컨버트뷰에 리스트뷰아이템 적용
        }

        TextView textView = (TextView)convertView.findViewById(R.id.listviewitemtv1);   //!< 텍스트뷰 id값 연결
        StopWatchListViewItem myItem = (StopWatchListViewItem) getItem(position);       //!< 리스트뷰 아이템 getItem(포지션)에 맞게
        textView.setText(myItem.getTime());                                             //!< setText

        return convertView;     //!< 리턴 컨버트뷰
    }
    /**
     * add아이템 메서드
     * @param time - 시간
     */
    public void addItem(String time){
        StopWatchListViewItem myItem = new StopWatchListViewItem(); //!< 리스트뷰 아이템 객체생성
        myItem.setTime(time);       //!< 시간인자값 set
        mItem.add(myItem);          //!< 아이템에 저장
    }
}
