package com.example.stopwatch.Timer.Dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.Button;

import com.example.stopwatch.R;

public class SaveDialogCancelButton {

    Dialog dSaveDialogCancelButton; //!< 다이얼로그
    Button cancelbutton;            //!< 다이얼로그 취소버튼

    /**
     * 생성자
     * @param dialog - 다이얼로그
     */
    public SaveDialogCancelButton(Dialog dialog){
        dSaveDialogCancelButton = dialog;     //!< 다이얼로그
        setCancelButton();                    //!< 다이얼로그 취소 메서드
    }

    /**
     * 다이얼로그 취소버튼 상황처리 메서드
     */
    public void setCancelButton() {
        cancelbutton = (Button)dSaveDialogCancelButton.findViewById(R.id.dialog_cancelbt);  //!< 다이얼로그 취소버튼 id값 연결
        cancelbutton.setOnClickListener(new View.OnClickListener() {                        //!< 다이얼로그 취소버튼 클릭 리스너
            @Override
            public void onClick(View v) {
                System.out.println("취소버튼 눌림");      //!< 디버그
                dSaveDialogCancelButton.dismiss();      //!< 다이얼로그 꺼짐
            }
        });

    }

}
