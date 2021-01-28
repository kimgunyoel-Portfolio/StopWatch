package com.example.stopwatch.Timer.FileIOStream;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by 이승환 on 2017-12-20.
 */

public class FileIOStreamRead {
    AppCompatActivity aFileIOStreamRead;
    public FileIOStreamRead(AppCompatActivity fragmentActivity) {
        aFileIOStreamRead = fragmentActivity;

    }

    /**
     * @since 2017-11-28
     * @exp 파일에서 텍스트 읽기
     * @param fileName
     */
    public String readData(String fileName) {
        String sDataFilePath = aFileIOStreamRead.getFilesDir().getAbsolutePath() + "/time8/";
        System.out.println("경로 : "+ aFileIOStreamRead.getFilesDir().getAbsolutePath());
        System.out.println("sDataFilePath :" + sDataFilePath);
        File fData = new File(sDataFilePath + fileName);
        String sReadData = "";
        String sReadDataTemp = "";

        try {
            FileInputStream fisData = new FileInputStream(fData);
            BufferedReader bisData = new BufferedReader(new InputStreamReader(fisData));

            while ((sReadDataTemp = bisData.readLine()) != null) {
                sReadData += sReadDataTemp;
            }

            System.out.println("sReadData : " + sReadData);
            return sReadData;

        }catch(Exception e) {
            e.printStackTrace();
        }

        return "파일읽기실패";
    }

}