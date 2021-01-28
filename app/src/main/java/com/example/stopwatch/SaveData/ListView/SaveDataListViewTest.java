package com.example.stopwatch.SaveData.ListView;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.LoadData.Activity.LoadDataActivity;
import com.example.stopwatch.LoadData.Define.DefineLoadData;
import com.example.stopwatch.R;
import com.example.stopwatch.Timer.Dialog.Define.DefineData;
import com.example.stopwatch.Timer.FileIOStream.FileIOStreamListRead;
import com.example.stopwatch.Timer.FileIOStream.FileIOStreamRead;

import java.io.File;

public class SaveDataListViewTest {

    AppCompatActivity aSaveDataListViewTest;            //!< Activity
    ListView listView;                                  //!< 리스트뷰
    SaveDataListViewAdapter cSaveDataListViewAdapter;   //!< 어댑터
    FileIOStreamRead cFileIOStreamRead;                 //!< 파일입출력 파일 읽기
    FileIOStreamListRead cFileIOStreamListRead;         //!< 파일입출력 파일리스트 읽기

    /**
     * 생성자
     * @param appCompatActivity
     */
    public SaveDataListViewTest(AppCompatActivity appCompatActivity) {

        aSaveDataListViewTest = appCompatActivity;      //!< Activity
        listView = (ListView) aSaveDataListViewTest.findViewById(R.id.savedata_lv1);   //!< 리스트뷰 id값 연결
        cSaveDataListViewAdapter = new SaveDataListViewAdapter();                      //!< 어댑터 객체생성
        cFileIOStreamRead = new FileIOStreamRead(aSaveDataListViewTest);               //!< 파일읽기 객체생성
        cFileIOStreamListRead = new FileIOStreamListRead(aSaveDataListViewTest);       //!< 파일리스트 읽기 객체생성

        setSaveDataListViewTest();        //!< 리스트뷰 스플릿 메서드
        listviewClickEvent();             //!< 리스트뷰 클릭 메서드
    }

    /**
     * 리스트뷰 스플릿 #단위 ( 파일 제목과  구간기록 스플릿)
     */
    public void setSaveDataListViewTest() {
        listView.setAdapter(cSaveDataListViewAdapter);      //!< set어댑터
        cFileIOStreamListRead.setFileList();                //!< 파일입출력 파일메서드
        for (int i = 0; i < DefineData.ins().lstReadFileData.size(); i++) {                                      //!< 파일갯수만큼 for문
            System.out.println("읽기결과" + cFileIOStreamRead.readData(DefineData.ins().lstReadFileData.get(i))); //!< 디버그
            String arr = cFileIOStreamRead.readData(DefineData.ins().lstReadFileData.get(i));                    //!< 파일제목과 구간기록 리스트 스트링변수에 저장
            String[] arrdata = arr.split("#");                                                            //!< 스트링배열 변수에 스트링변수 스플릿(#) 저장
            if (arrdata.length != 0) {                                                                           //!< 스트링 배열 변수가 0이 아니면
                cSaveDataListViewAdapter.addSaveItem(arrdata[0], DefineData.ins().lstReadFileData.get(i));       //!< 0번부터 for문
            }
        }
    }

    /**
     * 리스트뷰 클릭 리스너 메서드
     */
        public void listviewClickEvent(){
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {      //!< 리스트뷰 클릭 리스너
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               System.out.println("리스트뷰 클릭 "+ position);                        //!< 디버그
               setSaveDataListView(position);                                       //!< 포지션에 맞게 AlertDialog 출력
           }
       });
    }

    /**
     * AlertDialog  상황처리 메서드
     * @param position - 인자값 포지션
     */
    public void setSaveDataListView(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(aSaveDataListViewTest);   //!< AlertDialog객체생성

        builder.setPositiveButton("취소", new DialogInterface.OnClickListener() {  //!< 취소버튼 클릭리스너
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        builder.setNegativeButton("보기", new DialogInterface.OnClickListener() {   //!< 구간기록 리스트뷰 저장된 엑티비티로 넘어가는 버튼
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(aSaveDataListViewTest , LoadDataActivity.class); //!< 인텐트 SaveDataActivity -> LoadDataActivity
                DefineLoadData.ins().iListViewPosition = position;                          //!< 디파인 int형 변수에 포지션값 저장
                aSaveDataListViewTest.startActivity(intent);                                //!< start
                aSaveDataListViewTest.finish();                                             //!< finish
            }
        });

        builder.setNeutralButton("삭제", new DialogInterface.OnClickListener() {  //!< 삭제 버튼 클릭 리스너
            @Override
            public void onClick(DialogInterface dialog, int id) {
                File file = new File(aSaveDataListViewTest.getFilesDir().getAbsolutePath() + "/time8/" + cSaveDataListViewAdapter.mItem.get(position).getSday());   //!< 파일 객체생성
                System.out.println("파일이름" + cSaveDataListViewAdapter.mItem.get(position).getSday());        //!< 디버그
                // 지정한 경로에 파일이 존재하는 지 확인
                // 지정한 경로에 파일이 존재하는 경우
                if(file.exists()){
                    System.out.println("file.exists() : " + file.exists());
                    //파일 삭제 성공시
                    if(file.delete()){
                        System.out.println("파일삭제 성공");
                    }else {
                        System.out.println("파일삭제 실패");
                    }
                }else {
                    System.out.println("파일없음");
                }
                cSaveDataListViewAdapter.mItem.remove(position);    //!< 포지션값 재설정
                cSaveDataListViewAdapter.notifyDataSetChanged();    //!< 포지션값 갱싱
            }
        });

        AlertDialog alertDialog = builder.create(); //!< 다이얼로그 생성
        alertDialog.show();                         //!< 다이얼로그 출력
    }

}
