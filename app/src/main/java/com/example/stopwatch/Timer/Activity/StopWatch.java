package com.example.stopwatch.Timer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.Timer.Button.WatchButton;
import com.example.stopwatch.Timer.ListView.StopWatchListView;

public class StopWatch {

    AppCompatActivity aStopWatch;           //!< Activity
    StopWatchListView cStopWatchListView;   //!< 리스트뷰 클래스
    WatchButton cWatchButton;               //!< 버튼 종합 클래스

    /**
     * 생성자
     * @param appCompatActivity - Activity
     */
    public StopWatch (AppCompatActivity appCompatActivity) {

        aStopWatch = appCompatActivity;                                 //!< Activity
        cStopWatchListView = new StopWatchListView(aStopWatch);         //!< 리스트뷰 객체생성
        cWatchButton = new WatchButton(aStopWatch, cStopWatchListView); //!< 버튼 종합클래스 객체생성 ( Activity, 리스트뷰)

    }

}
