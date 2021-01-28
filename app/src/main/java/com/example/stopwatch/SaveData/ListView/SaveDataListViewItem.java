package com.example.stopwatch.SaveData.ListView;

public class SaveDataListViewItem {

    /**
     * 리스트뷰 아이템
     * 리스트뷰 아이템 내부에 들어갈 내용을 저장하는 클래스
     * 각 뷰의 내용마다 set, get이 가능하도록 구현
     */

    private String sname;   //!< 제목 변수
    private String sday;    //!< 날짜 변수

    public void setSname(String name){  //!< set제목
        this.sname = name;              //!< 인자 제목 변수에 저장
    }

    public String getSname(){           //!< get제목
        return sname;                   //!< 리턴제목
    }

    public void setSday(String day){    //!< set날짜
        this.sday = day;                //!< 인자 날짜 변수에 저장
    }

    public String getSday(){            //!< get날짜
        return sday;                    //!< 리턴 날짜
    }

}
