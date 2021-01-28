package com.example.stopwatch.Timer.Button;

import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.Timer.Common.Define;
import com.example.stopwatch.R;
import com.example.stopwatch.Timer.Thread.TimeThread;

public class StopWatchStartButton {

    AppCompatActivity aStopWatchStartButton;        //!< Activity

    TimeThread cTimeThread;                         //!< 시간 쓰레드

    Button startbutton;         //!< 시작버튼
    Button pausebutton;         //!< 중지버튼
    Button lapbutton;           //!< 구간기록버튼
    Button savebutton;          //!< 저장버튼
    Button loadingbutton;       //!< 기록보기 버튼

    /**
     * 생성자
     * @param appCompatActivity - Activity
     * @param timeThread        - 날짜 쓰레드
     */
    public StopWatchStartButton(AppCompatActivity appCompatActivity, TimeThread timeThread){

        aStopWatchStartButton = appCompatActivity;      //!< Activity
        Define.ins().STATS = Define.INIT;               //!<  시간 상태 변수상자에 초기상태 입력
        SetStopWatchStartButton();                      //!< 시작버튼 메서드
        cTimeThread = timeThread;                       //!< 시간 쓰레드 인자받기


    }

    /**
     * 시작버튼 행동처리 메서드
     */
    public void SetStopWatchStartButton(){

        startbutton = (Button)aStopWatchStartButton.findViewById(R.id.bt_start);        //!< 시작버튼 id값 연결
        pausebutton = (Button)aStopWatchStartButton.findViewById(R.id.bt_pause);        //!< 중지버튼 id값 연결
        lapbutton = (Button)aStopWatchStartButton.findViewById(R.id.bt_lap);            //!< 구간기록 id값 연결
        savebutton = (Button)aStopWatchStartButton.findViewById(R.id.bt_save);          //!< 저장버튼 id값 연결
        loadingbutton = (Button)aStopWatchStartButton.findViewById(R.id.bt_saveloading);//!< 기록보기버튼 id값 연결


        startbutton.setOnClickListener(new View.OnClickListener() {         //!< 시작버튼 클릭 리스너
            @Override
            public void onClick(View v) {
                System.out.println("시작버튼 눌림 ");                         //!< 디버그

                if(Define.ins().STATS == Define.INIT) {                     //!< 시간 상태 변수가 초기상태이면
                    System.out.println("시작버튼");                          //!< 디버그
                    Define.ins().lBaseTime = SystemClock.elapsedRealtime(); //!< 실수담을 변수에 실시간시간 입력
                    cTimeThread.startTimer();                               //!< 쓰레드 핸들러 변수선언해서 집어넣기
                    Define.ins().STATS = Define.RUN;                        //!< 시간상태 변수 시작상태

                    //!<버튼 이동처리
                    startbutton.setVisibility(v.GONE);                      //!< 시작버튼 안보이게 설정
                    pausebutton.setVisibility(v.VISIBLE);                   //!< 중지버튼 보이게 설정
                    lapbutton.setVisibility(v.VISIBLE);                     //!< 구간기록 버튼 보이게 설정
                    loadingbutton.setVisibility(v.GONE);                    //!< 기록보기버튼 안보이게 설정
                    savebutton.setVisibility(v.VISIBLE);                    //!< 저장버튼 보이게 설정

                }

            }
        });
    }
}
