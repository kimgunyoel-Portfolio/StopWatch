package com.example.stopwatch.Timer.ListView;

import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.R;

public class StopWatchListView {
    /**
     * 구간기록에 사용할 리스트뷰
     */

    AppCompatActivity aStopWatchListView;       //!< Activity
    public StopWatchListViewAdapter cStopWatchListViewAdapter;      //!< 어댑터

    /**
     * 생성자
     * @param appCompatActivity -Activity
     */
    public StopWatchListView(AppCompatActivity appCompatActivity){

        aStopWatchListView = appCompatActivity;     //!< Activity
        cStopWatchListViewAdapter = new StopWatchListViewAdapter(); //!< 어댑터 객체생성

        setStopWatchListView();     //!< 리스트뷰 메서드
    }

    /**
     * 리스트뷰 id값연결 , set어댑터
     */
    public void setStopWatchListView() {
        ListView listView = (ListView)aStopWatchListView.findViewById(R.id.swlv1);      //!< 구간기록 리스트뷰 id값 연결
        listView.setAdapter(cStopWatchListViewAdapter);                                 //!< set어댑터
    }

}
