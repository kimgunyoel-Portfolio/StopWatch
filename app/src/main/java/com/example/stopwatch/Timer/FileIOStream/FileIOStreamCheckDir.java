package com.example.stopwatch.Timer.FileIOStream;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

/**
 * Created by 이승환 on 2017-12-20.
 */

public class FileIOStreamCheckDir {
    AppCompatActivity aFileIOStreamCheckDir;

    public FileIOStreamCheckDir(AppCompatActivity appCompatActivity) {
        aFileIOStreamCheckDir = appCompatActivity;
    }

    /**
     * @since	2017 - 10 - 27
     * @author - sweetycat-
     * @param
     * @exp    파일입출력을 위한 기본 폴더 여부 확인 기본 폴더가 없을 경우 생성한다.
     */
    public void checkDir() {
        String sDirPath = aFileIOStreamCheckDir.getFilesDir().getAbsolutePath() + "/time8/";
        File fFile = new File(sDirPath);

        if(!fFile.exists()) {
            fFile.mkdirs();
            System.out.println("기본폴더생성");
        }

        if(fFile.exists()) {
            System.out.println("폴더있음");

        }

        //!< 테스트용
        //!< 폴더 삭제시 아래 주석제거 후 컴파일
        //fFile.delete();
        //System.out.println("폴더삭제");

    }

}
