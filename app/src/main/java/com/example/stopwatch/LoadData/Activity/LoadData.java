package com.example.stopwatch.LoadData.Activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.stopwatch.LoadData.ListView.LoadDataListView;

public class LoadData {

    AppCompatActivity aLoadData;        //!< Activity
    LoadDataListView cLoadDataListView; //!< 리스트뷰

    /**
     * 생성자
     * @param appCompatActivity - Activity
     */
    public LoadData(AppCompatActivity appCompatActivity){

        aLoadData = appCompatActivity;  //!< Activity
        cLoadDataListView = new LoadDataListView(aLoadData);  //!< 리스트뷰 객체생성
    }
}
