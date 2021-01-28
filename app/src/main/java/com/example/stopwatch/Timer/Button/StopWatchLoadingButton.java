package com.example.stopwatch.Timer.Button;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.R;
import com.example.stopwatch.SaveData.Activity.SaveDataActivity;
import com.example.stopwatch.Timer.Thread.TimeThread;

public class StopWatchLoadingButton {

    AppCompatActivity aStopWatchLoadingButton;  //!< Activity
    TimeThread ctimeThread;                     //!< 시간쓰레드

    /**
     * 생성자
     * @param appCompatActivity - Activity
     * @param timeThread        - 날짜 쓰레드
     */
    public StopWatchLoadingButton(AppCompatActivity appCompatActivity, TimeThread timeThread){

        aStopWatchLoadingButton = appCompatActivity; //!< Activity
        ctimeThread = timeThread;                    //!< 날짜 쓰레드
        setStopWatchLoadingButton();                 //!< 기록보기버튼 메서드

    }

    /**
     * 기록보기 상황처리 메서드
     */
    public void setStopWatchLoadingButton(){
        Button button = (Button)aStopWatchLoadingButton.findViewById(R.id.bt_saveloading);  //!< 기록보기 버튼 id값 연결
        button.setOnClickListener(new View.OnClickListener() {                              //!< 기록보기버튼 클릭 리슨너
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aStopWatchLoadingButton, SaveDataActivity.class);//!< 인텐트 StopWatchActivity -> SaveDataActivity
                aStopWatchLoadingButton.startActivity(intent);                              //!< start
                aStopWatchLoadingButton.finish();                                           //!< finish

            }
        });

    }
}
