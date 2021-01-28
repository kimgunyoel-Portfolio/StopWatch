package com.example.stopwatch.Timer.FileIOStream;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 이승환 on 2017-12-20.
 */

public class FileIOStreamCheckFile {
    AppCompatActivity aFileIOStreamCheckFile;

    public FileIOStreamCheckFile(AppCompatActivity fragmentActivity) {
        aFileIOStreamCheckFile = fragmentActivity;
    }

    public void checkFile(String fileName, String initData) {
        String sFilePath = aFileIOStreamCheckFile.getFilesDir().getAbsolutePath() + "/time8/";
        File fFile = new File(sFilePath + fileName);
        System.out.println("path : " + fFile.toString());

        if(!fFile.exists()) {
            try{
                FileOutputStream fosDataFile = new FileOutputStream(fFile, false);
                fosDataFile.write(initData.getBytes());
                fosDataFile.close();
                System.out.println("텍스트파일 생성완료");

            }catch(IOException e) {
                e.printStackTrace();

            }
        }

        if(fFile.exists()){
            System.out.println("텍스트파일 있음");
        }else {
            System.out.println("텍스트파일 없음");
        }

        //!< 테스트용
//        fFile.delete();

    }
}
