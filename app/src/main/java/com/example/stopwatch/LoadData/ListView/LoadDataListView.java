package com.example.stopwatch.LoadData.ListView;

import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.LoadData.Define.DefineLoadData;
import com.example.stopwatch.R;
import com.example.stopwatch.Timer.Dialog.Define.DefineData;
import com.example.stopwatch.Timer.FileIOStream.FileIOStreamListRead;
import com.example.stopwatch.Timer.FileIOStream.FileIOStreamRead;

public class LoadDataListView {

    AppCompatActivity aLoadDataListView;        //!< Activity
    FileIOStreamRead cFileIOStreamRead;         //!< 파일입출력 파일읽기
    FileIOStreamListRead cFileIOStreamListRead; //!< 파일입출력 파일리스트읽기

    public LoadDataListViewAdapter cLoadDataListViewAdapter;    //!< 리스트뷰 어댑터

    /**
     * 생성자
     * @param appCompatActivity - Activity
     */
    public LoadDataListView(AppCompatActivity appCompatActivity){

        aLoadDataListView = appCompatActivity;                              //!< Activity
        cLoadDataListViewAdapter = new LoadDataListViewAdapter();           //!< 어댑터 객체생성
        cFileIOStreamRead = new FileIOStreamRead(aLoadDataListView);        //!< 파일읽기 객체생성
        cFileIOStreamListRead = new FileIOStreamListRead(aLoadDataListView);//!< 파일리스트 객체생성

        setLoadDataListView();  //!< 리스트뷰 메서드
    }

    /**
     * 리스트뷰 상황처리 메서드
     */
    public void setLoadDataListView() {
       ListView listView = (ListView)aLoadDataListView.findViewById(R.id.loaddata_lv1); //!< 리스트뷰 id값 연결
       listView.setAdapter(cLoadDataListViewAdapter);                                   //!< set어댑터

        cFileIOStreamListRead.setFileList();                                            //!< 파일리스트 메서드
        String arr = cFileIOStreamRead.readData(DefineData.ins().lstReadFileData.get(DefineLoadData.ins().iListViewPosition));  //!< 스트링변수에 파일경로 디파인 리스트뷰 아이템 포지션값 저장
        String[] arrdata = arr.split("#");      //!< 스트링배열변수에 제목 스플릿
        String[] data = arrdata[1].split("&");  //!< 스트링 변수에 구간기록 스플릿해서 출력

        for(int i = 0 ; i < data.length ; i++) {             //!< 구간기록 길이만큼 for문
            cLoadDataListViewAdapter.addLoadItem(data[i]);   //!< (i)만큼 리스트뷰add아이템
        }
    }
}

