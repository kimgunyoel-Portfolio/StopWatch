package com.example.stopwatch.LoadData.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.stopwatch.R;
import com.example.stopwatch.SaveData.Activity.SaveData;
import com.example.stopwatch.SaveData.Activity.SaveDataActivity;

public class LoadDataActivity extends AppCompatActivity {

    LoadData cLoadData; //!< Activity 하위클래스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);

        cLoadData = new LoadData(this); //!< Activity 하위클래스 객체생성
    }


    /**
     * 뒤로가기버튼 누르면 SaveDataActivity 이동
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.out.println("백버튼 눌림");       //!< 디버그
        Intent intent = new Intent(this, SaveDataActivity.class);   //!< 인텐트 LoadDataActivity -> SaveDataActivity
        startActivity(intent);  //!< start
    }
}
