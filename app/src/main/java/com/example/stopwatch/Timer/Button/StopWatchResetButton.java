package com.example.stopwatch.Timer.Button;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.Timer.Common.Define;
import com.example.stopwatch.Timer.ListView.StopWatchListView;
import com.example.stopwatch.R;
import com.example.stopwatch.Timer.Thread.TimeThread;

public class StopWatchResetButton {

    AppCompatActivity aStopWatchResetButton;    //!< Activity
    StopWatchListView cStopWatchListView;       //!< 리스트뷰
    TimeThread cTimeThread;                     //!< 날짜 쓰레드

    Button resetbutton;                         //!< 초기화버튼
    Button startbutton;                         //!< 시작버튼
    Button restartbutton;                       //!< 재시작버튼
    Button savebutton;                          //!< 저장버튼
    Button loadingbutton;                       //!< 기록보기버튼

    TextView textView;                          //!< 텍스트뷰

    /**
     * 생성자
     * @param appCompatActivity - Activity
     * @param timeThread        - 날짜 쓰레드
     * @param stopWatchListView - 리스트뷰
     */
    public StopWatchResetButton(AppCompatActivity appCompatActivity, TimeThread timeThread, StopWatchListView stopWatchListView){

        aStopWatchResetButton = appCompatActivity;      //!< Activity
        cStopWatchListView = stopWatchListView;         //!< 리스트뷰 인자받기
        cTimeThread = timeThread;                       //!< 날짜쓰레드 인자받기

        setStopWatchResetButton();                      //!< 초기화버튼 메서드
    }

    /**
     * 재시작버튼 상황처리
     */
    public void setStopWatchResetButton(){
        resetbutton = (Button)aStopWatchResetButton.findViewById(R.id.bt_reset);            //!< 초기화버튼 id값 연결
        startbutton = (Button)aStopWatchResetButton.findViewById(R.id.bt_start);            //!< 시작버튼 id값 연결
        restartbutton = (Button)aStopWatchResetButton.findViewById(R.id.bt_restart);        //!< 재시작버튼 id값 연결
        savebutton = (Button)aStopWatchResetButton.findViewById(R.id.bt_save);              //!< 저장버튼 id값 연결
        loadingbutton = (Button)aStopWatchResetButton.findViewById(R.id.bt_saveloading);    //!< 기록보기버튼 id값 연결
        textView = (TextView) aStopWatchResetButton.findViewById(R.id.swtv1);               //!< 텍스트뷰 id 값 연결

        resetbutton.setOnClickListener(new View.OnClickListener() {                         //!< 초기화버튼 클릭 리스ㅓ
            @Override
            public void onClick(View v) {

                if(Define.ins().STATS == Define.PAUSE) {                                    //!< 시간상태변수가 중지상태일때
                    System.out.println("리셋버튼 눌림");                                      //!< 디버그
                    Define.ins().STATS = Define.INIT;                                       //!< 시간상태변수 초기상태 설정
                    Define.ins().lBaseTime = 0;                                             //!< 실수담을 시작변수 초기화
                    Define.ins().IPauseTime = 0;                                            //!< 실수담을 중지변수 초기화

                    textView.setText("00:00:00");                                           //!< 텍스트뷰 출력 ("00:00:00")
                    cStopWatchListView.cStopWatchListViewAdapter.mItem.clear();             //!< 구간기록 초기화
                    cStopWatchListView.cStopWatchListViewAdapter.notifyDataSetChanged();    //!< 리스트뷰 갱신

                    startbutton.setVisibility(v.VISIBLE);                                   //!< 시작버튼 보이게 설정
                    resetbutton.setVisibility(v.GONE);                                      //!< 초기화버튼 안보이게 설정
                    restartbutton.setVisibility(v.GONE);                                    //!< 재시작버튼 안보이게 설정
                    savebutton.setVisibility(v.GONE);                                       //!< 저장버튼 안보이게설정
                    loadingbutton.setVisibility(v.VISIBLE);                                 //!< 기록보기버튼 보이게 설정
                }
            }
        });


    }
}
