package com.example.stopwatch.Timer.Common;



public class Define {
    //!< 초기상태
    public static final int INIT = 0;
    //!< 가동상태
    public static final int RUN = 1;
    //!< 멈춤상태
    public static final int PAUSE = 2;
    //!< 초기상태 넣어줄 변수
    public int STATS = INIT;
    //!< 실수담을 변수상자 2개
    public long lBaseTime;
    public long IPauseTime;


    /**
     * @author
     * @since	2020 - 07 - 05
     * @param	instance Singleton Pattern
     */
    private static Define instance;
    public static Define ins() {
        if (instance == null) {
            instance = new Define();
        }

        return instance;

    }
}
