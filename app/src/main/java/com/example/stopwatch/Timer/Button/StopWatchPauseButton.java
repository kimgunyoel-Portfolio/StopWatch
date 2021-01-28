package com.example.stopwatch.Timer.Button;

import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.Timer.Common.Define;
import com.example.stopwatch.R;
import com.example.stopwatch.Timer.Thread.TimeThread;

public class StopWatchPauseButton {

    AppCompatActivity aStopWatchPauseButton;        //!< Activity
    TimeThread cTimeThread;                         //!< 시간쓰레드

    Button pausebutton;                             //!< 중지 버튼
    Button lapbutton;                               //!< 구간기록 버튼
    Button restartbutton;                           //!< 재시작 버튼
    Button resetbutton;                             //!< 초기화 버튼

    /**
     * 생성자
     * @param appCompatActivity -Activity
     * @param timeThread        - 시간 쓰레드
     */
    public StopWatchPauseButton(AppCompatActivity appCompatActivity, TimeThread timeThread){

        aStopWatchPauseButton = appCompatActivity;  //!< Activity
        setStopWatchPauseButton();                  //!< 중지버튼 메서드
        cTimeThread = timeThread;                   //!< 시간쓰레드 인자받기

    }

    /**
     * 중지버튼 상황처리 메서드
     */
    public void setStopWatchPauseButton(){
        pausebutton = (Button)aStopWatchPauseButton.findViewById(R.id.bt_pause);        //!< 중지버튼 id값 연결
        lapbutton = (Button) aStopWatchPauseButton.findViewById(R.id.bt_lap);           //!< 구간기록버튼 id값 연결
        restartbutton = (Button) aStopWatchPauseButton.findViewById(R.id.bt_restart);   //!< 재시작버튼 id값 연결
        resetbutton = (Button) aStopWatchPauseButton.findViewById(R.id.bt_reset);       //!< 초기화버튼 id값 연결

        pausebutton.setOnClickListener(new View.OnClickListener() {                     //!< 중지버튼 클릭 리스너
            @Override
            public void onClick(View v) {
                if(Define.ins().STATS == Define.RUN){                                   //!< 시간상태 변수가 작동중일때
                    System.out.println("멈춤버튼 눌림");                                  //!< 디버그
                    cTimeThread.pauseTimer();                                           //!< 시간 멈춤
                    Define.ins().IPauseTime = SystemClock.elapsedRealtime();            //!< 실수담을 변수에 중지시간 저장
                    Define.ins().STATS = Define.PAUSE;                                  //!< 시간상태 변수 중지상태
                    System.out.println("Define.status change :" + Define.ins().STATS);  //!< 디버그

                    pausebutton.setVisibility(v.GONE);                                  //!< 중지버튼 안보이게 설정
                    lapbutton.setVisibility(v.GONE);                                    //!< 구간기록버튼 안보이게 설정
                    restartbutton.setVisibility(v.VISIBLE);                             //!< 재시작버튼 보이게 설정
                    resetbutton.setVisibility(v.VISIBLE);                               //!< 초기화버튼 보이게 설정

                }
            }
        });

    }

}
