package com.example.stopwatch.Timer.Dialog;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.R;
import com.example.stopwatch.SaveData.Activity.SaveDataActivity;
import com.example.stopwatch.Timer.Common.Define;
import com.example.stopwatch.Timer.Dialog.Define.DefineSaveDialog;
import com.example.stopwatch.Timer.FileIOStream.FileIOStreamCheckDir;
import com.example.stopwatch.Timer.FileIOStream.FileIOStreamCheckFile;
import com.example.stopwatch.Timer.FileIOStream.FileIOStreamListRead;
import com.example.stopwatch.Timer.FileIOStream.FileIOStreamRead;
import com.example.stopwatch.Timer.FileIOStream.FileIOStreamWrite;
import com.example.stopwatch.Timer.ListView.StopWatchListView;

public class SaveDialogSaveButton {
    AppCompatActivity aSaveDialogSaveButton;    //!< Activity
    Dialog dSaveDialogSaveButton;               //!< 다이얼로그
    Button savebutton;                          //!< 저장버튼
    EditText savename;                          //!< 제목 edittext

    SaveDialogTime cSaveDialogTime;             //!< 다이얼로그 시간
    StopWatchListView cStopWatchListView;       //!< 리스트뷰

    FileIOStreamCheckDir cFileIOStreamCheckDir;  //!< 파일입출력 파일생성
    FileIOStreamCheckFile cFileIOStreamCheckFile;//!< 파일입출력 파일경로
    FileIOStreamWrite cFileIOStreamWrite;        //!< 파일입출력 파일쓰기
    FileIOStreamRead cFileIOStreamRead;          //!< 파일입출력 파일읽기
    FileIOStreamListRead cFileIOStreamListRead;  //!< 파일립출력 리스트읽기

    /**
     * 생성자
     * @param dialog - 다이얼로그
     * @param appCompatActivity - Activity
     * @param stopWatchListView - 리스트뷰
     */
    public SaveDialogSaveButton(Dialog dialog, AppCompatActivity appCompatActivity,StopWatchListView stopWatchListView){
        aSaveDialogSaveButton = appCompatActivity;                              //!< Activity
        dSaveDialogSaveButton = dialog;                                         //!< 다이얼로그
        setSaveButton();                                                        //!< 저장버튼 메서드
        cSaveDialogTime = new SaveDialogTime(dialog, appCompatActivity);        //!< 다이얼로그 시간 객체생성
        cStopWatchListView = stopWatchListView;                                 //!< 리스트뷰 인자받기

        cFileIOStreamRead = new FileIOStreamRead(aSaveDialogSaveButton);        //!< 파일읽기 객체생성
        cFileIOStreamListRead = new FileIOStreamListRead(aSaveDialogSaveButton);//!< 파일리스트읽기 객체생성
        cFileIOStreamWrite = new FileIOStreamWrite(aSaveDialogSaveButton);      //!< 파일쓰기 객체생성
        cFileIOStreamCheckFile = new FileIOStreamCheckFile(aSaveDialogSaveButton);//!< 파일경로 객체생성
    }

    /**
     * 다이얼로그 저장버튼 상황처리 메서드
     */
    public void setSaveButton () {
        savebutton = (Button)dSaveDialogSaveButton.findViewById(R.id.dialog_savebt);    //!< 다이얼로그 저장버튼 ID값 연결
        savename = (EditText) dSaveDialogSaveButton.findViewById(R.id.dialog_et1);      //!< 파일제목 edittext id값 연결
        savebutton.setOnClickListener(new View.OnClickListener() {                      //!< 다이얼로그 저장버튼 클릭 리스너
            @Override
            public void onClick(View v) {
                System.out.println("다이얼로그 저장버튼 눌림");                            //!< 디버그

                //!< #1 경로확인
                cFileIOStreamCheckDir = new FileIOStreamCheckDir(aSaveDialogSaveButton);
                cFileIOStreamCheckDir.checkDir();

                //!< #2 구간기록 데이터 결합
                String sTemp = "";
                for(int i = 0 ; i < cStopWatchListView.cStopWatchListViewAdapter.mItem.size() ; i++){   //!< 리스트뷰 아이템 사이즈 만큼 for문 돌면서
                    sTemp += cStopWatchListView.cStopWatchListViewAdapter.mItem.get(i).getTime();       //!< 리스트뷰아이템 사이즈만큼 시간가져오기
                    if(i != cStopWatchListView.cStopWatchListViewAdapter.mItem.size() -1){              //!< 리스트뷰 아이템 사이즈가 리스트뷰아이템 -1 이 아닐떄
                        sTemp += "&";                                                                   //!< "&" 단위
                    }
                }

                //!< #3 파일내용 데이터 결합
                cSaveDialogTime.setSaveDialogTime();                                //!< 저장시간(파일이름) 설정
                String sSaveData = savename.getText().toString() + "#" + sTemp;     //!< 저장내용(파일내용)
                System.out.println("저장내용 확인하자 :" + sSaveData);                //!< 디버그

                //!< #4 데이터 쓰기
                cFileIOStreamCheckFile.checkFile(DefineSaveDialog.ins().sSaveTime, sSaveData);  //!< 파일쓰기  시간, 파일내용
                System.out.println("저장확인");                                                  //!< 디버그
                cFileIOStreamListRead.setFileList();                                            //!< 파일리스트 설정

                //<! #5 저장된 파일 이름 시간 들고 액티비티로 이동
                Intent intent = new Intent(aSaveDialogSaveButton, SaveDataActivity.class);      //!< 인텐트 다이얼로그 -> SaveDataActivity
                aSaveDialogSaveButton.startActivity(intent);                                    //!< start
            }
        });
    }
}
