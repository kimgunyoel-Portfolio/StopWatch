package com.example.stopwatch.Timer.Thread;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.Timer.Common.Define;
import com.example.stopwatch.R;



public class TimeThread extends Thread{

    AppCompatActivity aTimeThread;  //!< Activity
    TextView textView;              //!< 텍스트뷰

    /**
     * 생성자
     * @param appCompatActivity - Activity
     */
    public TimeThread(AppCompatActivity appCompatActivity){
        aTimeThread = appCompatActivity;        //!< Activity
        textView = (TextView)aTimeThread.findViewById(R.id.swtv1); //!< 텍스트뷰 id값 연결

    }


    public Handler handler = new Handler(){     //!< 핸들러

        @Override
        public void handleMessage(@NonNull Message msg) {
            textView.setText(getTime());            //!< 텍스트뷰에 경과한 시간 담기
            handler.sendEmptyMessage(0);      //!< 핸들러 메시지 0
    }
    };

    public void startTimer() {                 //!< 시작 시간 메서드
        handler.sendEmptyMessage(0);     //!< 핸들러 메시지 0
    }

    public void pauseTimer() {                 //!< 중지 시간 메서드
        handler.removeMessages(0);       //!< 재시작 핸들러 메시지 0
    }

    public void restartTimer(){                //!< 재시작 시간 메서드
        handler.sendEmptyMessage(0);     //!< 핸들러 메시지 0
    }

    private String getTime(){
        //경과된 시간 체크
        long nowTime = SystemClock.elapsedRealtime();
        //시스템이 부팅된 이후의 시간?
        long overTime = nowTime - Define.ins().lBaseTime;

        long m = overTime/1000/60;      //!< 분 공식
        long s = (overTime/1000)%60;    //!< 초 공식
        long ms = overTime % 1000;      //!< 밀리초 공식

        String recTime = String.format("%02d:%02d:%03d",m,s,ms);    //!< 분 , 초 , 밀리초 스트링형태

        return recTime; //!< 리턴
    }



}
