package com.example.stopwatch.SaveData.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stopwatch.R;

import java.util.ArrayList;

public class SaveDataListViewAdapter extends BaseAdapter {

    public ArrayList<SaveDataListViewItem> mItem = new ArrayList<>();   //!< 어레이리스트 객체생성

    @Override
    public int getCount() {    //!< 리스트뷰 아이템갯수만큼 리턴
        return mItem.size();
    }

    @Override
    public Object getItem(int position) {   //!< 리스트뷰 아이템 포지션에 맞게 리턴
        return mItem.get(position);
    }

    @Override
    public long getItemId(int position) {   //!< 리스트뷰 아이템 id 포지션에 맞게 리턴
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();  //!< 컨텍스트 연결

        if(convertView == null){        //!< 컨버트뷰 null일때
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //!< 레이아웃 인플레이터 선언
            convertView = inflater.inflate(R.layout.savedata_item, parent, false);                 //!< 컨버트뷰에 리스트뷰아이템 적용
        }

        TextView textView1 = (TextView)convertView.findViewById(R.id.savedata_listviewitem1);   //!< 텍스트뷰 제목 id값 연결
        TextView textView2 = (TextView)convertView.findViewById(R.id.savedata_listviewitem2);   //!< 텍스트뷰 날짜 id값 연결

        SaveDataListViewItem saveDataListViewItem = (SaveDataListViewItem) getItem(position);   //!< 리스트뷰아티템 객체생성

        textView1.setText(saveDataListViewItem.getSname());                                     //!< setText (제목)
        textView2.setText(saveDataListViewItem.getSday());                                      //!< setText (날짜)

        return convertView; //!< 리턴 컨버트뷰
    }

    /**
     * add아이템 메서드
     * @param name - 제목
     * @param day - 날짜
     */
    public void addSaveItem(String name, String day){

        SaveDataListViewItem saveDataListViewItem = new SaveDataListViewItem(); //!< 리스트뷰아이템 객체생성
        saveDataListViewItem.setSname(name);    //!< set제목
        saveDataListViewItem.setSday(day);      //!< set날짜

        mItem.add(saveDataListViewItem);        //!< add(리스트뷰아이템)

    }
}
