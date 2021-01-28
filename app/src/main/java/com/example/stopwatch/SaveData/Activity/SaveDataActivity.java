package com.example.stopwatch.SaveData.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.stopwatch.R;
import com.example.stopwatch.Timer.Activity.StopWatchActivity;
import com.example.stopwatch.Timer.Dialog.Define.DefineData;
import com.example.stopwatch.Timer.Dialog.SaveDialog;
import com.example.stopwatch.Timer.Dialog.SaveDialogSaveButton;
import com.example.stopwatch.Timer.FileIOStream.FileIOStreamListRead;
import com.example.stopwatch.Timer.FileIOStream.FileIOStreamRead;

public class SaveDataActivity extends AppCompatActivity {

    SaveData cSaveData;     //!< Activity 하위 클래스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        cSaveData = new SaveData(this); //!< Activity 하위 클래스 객체생성

        System.out.println("lstReadFileData : " + DefineData.ins().lstReadFileData);    //!< 디버그
    }

    @Override
    public void onBackPressed() {       //!< 뒤로가기버튼 누를시 인텐트 상황
        super.onBackPressed();
        System.out.println("백버튼 눌림");       //!< 디버그
        Intent intent = new Intent(this , StopWatchActivity.class);     //!< SaveDataAcitivty -> StopWatchActivity
        startActivity(intent);      //!< start
    }
}
