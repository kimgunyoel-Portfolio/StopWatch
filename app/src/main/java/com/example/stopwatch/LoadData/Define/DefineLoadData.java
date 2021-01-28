package com.example.stopwatch.LoadData.Define;

import com.example.stopwatch.Timer.Dialog.Define.DefineData;

public class DefineLoadData {

    public int iListViewPosition;   //!< 리스트뷰 포지션값 저장할 변수

    /**
     * @author
     * @since	2020 - 07 - 10
     * @param	instance Singleton Pattern
     */
    private static DefineLoadData instance;
    public static DefineLoadData ins() {
        if (instance == null) {
            instance = new DefineLoadData();
        }

        return instance;

    }
}
