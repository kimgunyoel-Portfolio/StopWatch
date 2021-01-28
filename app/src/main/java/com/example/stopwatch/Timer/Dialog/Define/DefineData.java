package com.example.stopwatch.Timer.Dialog.Define;

import java.util.ArrayList;

public class DefineData {

    public ArrayList<String> lstReadFileData = new ArrayList<String>(); //!< 어레이리스트형태 파일
    public String sDefineData = "";


    /**
     * @author
     * @since	2020 - 07 - 05
     * @param	instance Singleton Pattern
     */
    private static DefineData instance;
    public static DefineData ins() {
        if (instance == null) {
            instance = new DefineData();
        }

        return instance;

    }
}
