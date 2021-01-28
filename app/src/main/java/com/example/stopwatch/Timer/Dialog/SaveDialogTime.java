package com.example.stopwatch.Timer.Dialog;

import android.app.Dialog;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.R;
import com.example.stopwatch.Timer.Common.Define;
import com.example.stopwatch.Timer.Dialog.Define.DefineSaveDialog;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveDialogTime {

    AppCompatActivity aSaveDialogTime;      //!< Activity
    Dialog dSaveDialogTime;                 //!< 다이얼로그
    TextView timetext;                      //!< 텍스트뷰

    /**
     * 생성자
     * @param dialog - 다이얼로그
     * @param appCompatActivity - Activity
     */
    public SaveDialogTime(Dialog dialog, AppCompatActivity appCompatActivity){
        dSaveDialogTime = dialog;   //!< 다이얼로그
        aSaveDialogTime = appCompatActivity;    //!< Activity
        setSaveDialogTime();                    //!< 다이얼로그 시간 메서드
        setTextview();                          //!< 텍스트뷰 메서드
    }

    /**
     * 텍스트뷰 출력 메서드
     */
    public void setTextview() {
        timetext = (TextView) dSaveDialogTime.findViewById(R.id.dialog_timetv);     //< 다이얼로그 텍스트 id값 연결
        timetext.setText(DefineSaveDialog.ins().sSaveTime);                         //!< setText 저장한시간 출력
    }

    /**
     * 다이얼로그 저장시간 메서드
     */
    public void setSaveDialogTime() {
        DefineSaveDialog.ins().sSaveTime = ""; //!< 싱글톤 시간저장할 변수
        Long now = System.currentTimeMillis(); //!< 시간소요 실수
        Date mDate = new Date(now);            //!< 데이터 객체생성
        SimpleDateFormat simpleDate = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");  //!< 년 월 일 시 분 초
        String getTime = simpleDate.format(mDate);      //!< 스트링변수 에 simpleDate(mDate) 저장
        System.out.println("getTime :" + getTime);      //!< 디버그
        DefineSaveDialog.ins().sSaveTime = getTime;     //!< 싱글톤 변수에 스트링getTime 저장
    }
}
