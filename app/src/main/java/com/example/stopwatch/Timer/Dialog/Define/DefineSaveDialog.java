package com.example.stopwatch.Timer.Dialog.Define;

import com.example.stopwatch.Timer.Common.Define;

public class DefineSaveDialog {
    public String sSaveTime = "";   //!< 시간담을 변수상자

    /**
     * @author
     * @since	2020 - 07 - 05
     * @param	instance Singleton Pattern
     */
    private static DefineSaveDialog instance;
    public static DefineSaveDialog ins() {
        if (instance == null) {
            instance = new DefineSaveDialog();
        }

        return instance;

    }
}
