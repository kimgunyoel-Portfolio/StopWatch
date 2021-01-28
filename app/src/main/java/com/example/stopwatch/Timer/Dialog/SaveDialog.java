package com.example.stopwatch.Timer.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.R;
import com.example.stopwatch.Timer.ListView.StopWatchListView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveDialog extends Dialog {

    AppCompatActivity aSaveDialog;      //!< Activity
    Context mContext;                   //!< 컨텍스트

    SaveDialogSaveButton cSaveDialogSaveButton;     //!< 다이얼로그 저장버튼
    SaveDialogCancelButton cSaveDialogCancelButton; //!< 다이얼로그 취소버튼
    SaveDialogTime cSaveDialogTime;                 //!< 다이얼로그 시간
    StopWatchListView cStopWatchListView;           //!< 리스트뷰

    /**
     * 생성자
     * @param context - 컨텍스트
     * @param appCompatActivity - Activity
     * @param stopWatchListView - 리스트뷰
     */
    public SaveDialog(@NonNull Context context, AppCompatActivity appCompatActivity, StopWatchListView stopWatchListView){
        super(context);
        aSaveDialog = appCompatActivity;        //!< Activity
        mContext = context;                     //!< 컨텍스트 연결
        cStopWatchListView = stopWatchListView; //!< 리스트뷰 인자받기

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //!< 온크리에이트
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_dialog);               //!< 다이얼로그 레이아웃
        cSaveDialogSaveButton = new SaveDialogSaveButton(this, aSaveDialog,cStopWatchListView);     //!< 다이얼로그 저장버튼 객체생성
        cSaveDialogCancelButton = new SaveDialogCancelButton(this);                                        //!< 다이얼로그 취소버튼 객체생성
        cSaveDialogTime = new SaveDialogTime(this, aSaveDialog);                                    //!< 다이얼로그 객체생성

    }
}
