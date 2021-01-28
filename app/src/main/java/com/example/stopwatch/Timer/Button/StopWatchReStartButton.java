package com.example.stopwatch.Timer.Button;

import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.Timer.Common.Define;
import com.example.stopwatch.R;
import com.example.stopwatch.Timer.Thread.TimeThread;

public class StopWatchReStartButton {

    AppCompatActivity aStopWatchReStartButton; //!< Activity
    TimeThread cTimeThread;                    //!< 시간 쓰레드

    Button restartbutton;                      //!< 재시작 버튼
    Button pausebutton;                        //!< 중지 버튼
    Button lapbutton;                          //!< 구간기록 버튼
    Button resetbutton;                        //!< 초기화 버튼

    /**
     * 생성자
     * @param appCompatActivity - Activity
     * @param timeThread        - 날짜 쓰레드
     */
    public StopWatchReStartButton(AppCompatActivity appCompatActivity, TimeThread timeThread){

        aStopWatchReStartButton = appCompatActivity;    //!< Activity
        cTimeThread = timeThread;                       //!< 시간쓰레드 인자받기
        setStopWatchReStartButton();                    //!< 재시작버튼 메서드

    }

    /**
     * 재시작버튼 상황처리
     */
    public void setStopWatchReStartButton(){
        restartbutton = (Button)aStopWatchReStartButton.findViewById(R.id.bt_restart);  //!< 재시작버튼 id값 연결
        pausebutton = (Button)aStopWatchReStartButton.findViewById(R.id.bt_pause);      //!< 중지버튼 id값 연결
        lapbutton = (Button)aStopWatchReStartButton.findViewById(R.id.bt_lap);          //!< 구간기록버튼 id값 연결
        resetbutton = (Button)aStopWatchReStartButton.findViewById(R.id.bt_reset);      //!< 초기화버튼 id값 연결

        restartbutton.setOnClickListener(new View.OnClickListener() {                   //!< 재시작버튼 클릭 리스너
            @Override
            public void onClick(View v) {
                if(Define.ins().STATS == Define.PAUSE){                                 //!< 시간상태변수가 중지상태일때
                    System.out.println("계속버튼 눌림");                                  //!< 디버그

                    long restart = SystemClock.elapsedRealtime();                       //!< 실수 재시작변수에 실시간 시간 저장
                    Define.ins().lBaseTime += (restart - Define.ins().IPauseTime);      //!< 중지한 시간에 기존시간을 더해 시간 재시작
                    cTimeThread.restartTimer();                                         //!< 날짜쓰레드 재시작
                    Define.ins().STATS = Define.RUN;                                    //!< 시간상태변수 시작상태 설정

                    restartbutton.setVisibility(View.GONE);                             //!< 재시작버튼 안보이게 설정
                    resetbutton.setVisibility(View.GONE);                               //!< 초기화버튼 안보이게 설정
                    pausebutton.setVisibility(View.VISIBLE);                            //!< 중지버튼 보이게 설정
                    lapbutton.setVisibility(View.VISIBLE);                              //!< 구간기록버튼 보이게 설정
                }
            }
        });
    }
}
