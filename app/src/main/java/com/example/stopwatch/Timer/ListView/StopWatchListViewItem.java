package com.example.stopwatch.Timer.ListView;

public class StopWatchListViewItem {

    /**
     * 리스트뷰 아이템
     * 리스트뷰 아이템 내부에 들어갈 내용을 저장하는 클래스
     * 각 뷰의 내용마다 set, get이 가능하도록 구현
     */

    private String stime;   //!< 스트링 시간변수

    public void setTime (String time){  //!< set시간
        this.stime = time;  //!< 시간변수 = 인자변수

    }

    public String getTime () {      //!< get 시간
        return stime;   //!< 리턴 시간
    }


}
