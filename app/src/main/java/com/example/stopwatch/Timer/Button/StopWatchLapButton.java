package com.example.stopwatch.Timer.Button;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.Timer.Common.Define;
import com.example.stopwatch.Timer.ListView.StopWatchListView;
import com.example.stopwatch.R;
import com.example.stopwatch.Timer.Thread.TimeThread;

public class StopWatchLapButton {

    AppCompatActivity aStopWatchLapButton;  //!< Activity
    StopWatchListView cStopWatchListView;   //!< 리스트뷰
    TimeThread cTimeThread;                 //!< 시간쓰레드
    TextView textView1;                     //!< 구간기록 텍스트
    Button lapbutton;                       //!< 구간기록 버튼

    /**
     * 생성자
     * @param appCompatActivity -Activity
     * @param timeThread        -날짜 쓰레드
     * @param stopWatchListView - 리스트뷰
     */
    public StopWatchLapButton (AppCompatActivity appCompatActivity, TimeThread timeThread, StopWatchListView stopWatchListView){
        aStopWatchLapButton = appCompatActivity;    //!< Activity
        cStopWatchListView = stopWatchListView;     //!< 리스트뷰 인자받기
        cTimeThread = timeThread;                   //!< 시간쓰레드 인자받기

        setStopWatchLapButton();                    //!< 구간기록버튼 메서드
    }

    /**
     * 구간기록버튼 상황처리
     */
    public void setStopWatchLapButton(){
        lapbutton = (Button)aStopWatchLapButton.findViewById(R.id.bt_lap); //!< 구간기록버튼 id값연결
        textView1 = (TextView)aStopWatchLapButton.findViewById(R.id.swtv1);//!< 구간기록 텍스트뷰 id값 연결

        lapbutton.setOnClickListener(new View.OnClickListener() {          //!< 구간기록 버튼 리슨너
            @Override
            public void onClick(View v) {
                System.out.println("구간기록 눌림");                        //!< 디버그
                if(Define.ins().STATS == Define.RUN){                     //!< 시간상태변수가 작동중일때
                    String sTimelist = textView1.getText().toString();    //!< 스트링변수에 텍스트뷰 스트링형태로 저장
                    System.out.println("구간기록 목록 :" + sTimelist);      //!< 디버그
                    //!< 리스트뷰 인자 넘긴거 쓰기 어댑터는 리스트뷰에서 받음
                    cStopWatchListView.cStopWatchListViewAdapter.addItem(sTimelist);     //!< 리스트뷰 add아이템 구간기록
                    cStopWatchListView.cStopWatchListViewAdapter.notifyDataSetChanged(); //!< 리스트뷰 갱시

                }

            }
        });

    }

}
