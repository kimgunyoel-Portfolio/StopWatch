package com.example.stopwatch.Timer.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.Timer.ListView.StopWatchListView;
import com.example.stopwatch.Timer.Thread.TimeThread;

public class WatchButton {

    AppCompatActivity aWatchButton; //!< Activity
    TimeThread cTimeThread;         //!< 날짜 쓰레드

    StopWatchStartButton cStopWatchStartButton;         //!< 시작버튼 클래스
    StopWatchPauseButton cStopWatchPauseButton;         //!< 중지버튼 클래스
    StopWatchLapButton cStopWatchLapButton;             //!< 구간기록버튼 클래스
    StopWatchResetButton cStopWatchResetButton;         //!< 초기화버튼 클래스
    StopWatchReStartButton cStopWatchReStartButton;     //!< 재시작버튼 클래스
    StopWatchSaveButton cStopWatchSaveButton;           //!< 저장버튼 클래스
    StopWatchLoadingButton cStopWatchLoadingButton;     //!< 리스트뷰 기록보기버튼 클래스

    /**
     * 생성자
     * @param appCompatActivity - Acitivity
     * @param stopWatchListView - 리스트뷰
     */
    public WatchButton(AppCompatActivity appCompatActivity, StopWatchListView stopWatchListView) {

        aWatchButton = appCompatActivity;     //!< Activity

        cTimeThread = new TimeThread(aWatchButton);
        //!< 시작버튼 ( 버튼 상위클래스 , 시간 쓰레드)
        cStopWatchStartButton = new StopWatchStartButton(aWatchButton, cTimeThread);
        //!< 멈춤버튼 ( 버튼 상위클래스 , 시간 쓰레드)
        cStopWatchPauseButton = new StopWatchPauseButton(aWatchButton, cTimeThread);
        //!< 구간기록 버튼 ( 버튼 상위클래스 , 시간 쓰레드 , 리스트뷰)
        cStopWatchLapButton = new StopWatchLapButton(aWatchButton, cTimeThread, stopWatchListView);
        //!< 초기화 버튼 ( 버튼 상위클래스 , 시간 쓰레드 , 리스트뷰)
        cStopWatchResetButton = new StopWatchResetButton(aWatchButton, cTimeThread, stopWatchListView);
        //!< 계속 버튼 ( 버튼 상위클래스 , 시간 쓰레드 )
        cStopWatchReStartButton = new StopWatchReStartButton(aWatchButton, cTimeThread);
        //!<저장하기 버튼 ( 버튼 상위클래스 , 시간 쓰레드 , 리스트뷰)
        cStopWatchSaveButton = new StopWatchSaveButton(aWatchButton, cTimeThread, stopWatchListView);
        //!<기록보기 버튼 ( 버튼 상위클래스 , 시간 쓰레드 )
        cStopWatchLoadingButton = new StopWatchLoadingButton(aWatchButton, cTimeThread);

    }



}
