package com.example.stopwatch.SaveData.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.SaveData.ListView.SaveDataListViewTest;

public class SaveData {

    AppCompatActivity aSaveData;        //!< Activity
    SaveDataListViewTest cSaveDataListViewTest; //!< 리스트뷰

    /**
     * 생성자
     * @param appCompatActivity - Activity
     */
    public SaveData(AppCompatActivity appCompatActivity){

        aSaveData = appCompatActivity; //!< Activity
        cSaveDataListViewTest = new SaveDataListViewTest(aSaveData);    //!< 리스트뷰 객체생성
    }
}
