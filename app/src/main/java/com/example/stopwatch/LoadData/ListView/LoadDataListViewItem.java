package com.example.stopwatch.LoadData.ListView;

public class LoadDataListViewItem {
    /**
     * 리스트뷰 아이템
     * 리스트뷰 아이템 내부에 들어갈 내용을 저장하는 클래스
     * 각 뷰의 내용마다 set, get이 가능하도록 구현
     */

    private String slap;    //!< 구간기록 저장할 아이템 변수

    public void setSlap(String lap){    //!< set구간기록
        this.slap = lap;    //!< 인자구간기록 아이템변수에 저장
    }

    public String getSlap(){    //!< get구간기록
        return slap;    //!< 리턴 구간기록
    }


}
