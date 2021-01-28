package com.example.stopwatch.Timer.Button;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.R;
import com.example.stopwatch.Timer.Dialog.SaveDialog;
import com.example.stopwatch.Timer.ListView.StopWatchListView;
import com.example.stopwatch.Timer.Thread.TimeThread;

public class StopWatchSaveButton {

    AppCompatActivity aStopWatchSaveButton;     //!< Activity
    TimeThread cTimeThread;                     //!< 날짜 쓰레드
    Button savebutton;                          //!< 저장버튼
    SaveDialog cSaveDialog;                     //!< 다이얼로그
    StopWatchListView cStopWatchListView;       //!< 리스트뷰

    /**
     * 생성자
     * @param appCompatActivity -Activity
     * @param timeThread        -날짜쓰레드
     * @param stopWatchListView - 리스트뷰
     */
    public StopWatchSaveButton(AppCompatActivity appCompatActivity, TimeThread timeThread, StopWatchListView stopWatchListView){

        aStopWatchSaveButton  = appCompatActivity;  //!< Activity
        cTimeThread = timeThread;                   //!< 날짜 쓰레드 인자받기
        cStopWatchListView = stopWatchListView;     //!< 리스트뷰 인자받기
        cSaveDialog = new SaveDialog(aStopWatchSaveButton, aStopWatchSaveButton, cStopWatchListView);   //!< 다이얼로그 객체생성 (context , Activity , 리스트뷰)

        setStopWatchSaveButton();                   //!< 저장버튼 메서드
    }

    /**
     * 저장버튼 상황처리 메서드
     */
    public void setStopWatchSaveButton(){
        savebutton = (Button)aStopWatchSaveButton.findViewById(R.id.bt_save);   //!< 저장버튼 id값 연결

        savebutton.setOnClickListener(new View.OnClickListener() {              //!< 저장버튼 클릭 리스너
            @Override
            public void onClick(View v) {
                System.out.println("저장버튼눌림");   //!< 디버그
                cSaveDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));   //!< 다이얼로그 배경화면 투명 적용
                cSaveDialog.setCancelable(true);                                //!< 다이얼로그 true상태 뒤로가기 누르면 꺼짐
                cSaveDialog.show();                                             //!< 다이얼로그 출력
            }
        });
    }
}
