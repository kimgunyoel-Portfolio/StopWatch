package com.example.stopwatch.Timer.FileIOStream;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.Timer.Common.Define;
import com.example.stopwatch.Timer.Dialog.Define.DefineData;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class FileIOStreamListRead {

    AppCompatActivity aFileIOStreamListRead;
    FileIOStreamRead cFileIOStreamRead;


    public FileIOStreamListRead(AppCompatActivity appCompatActivity){

        aFileIOStreamListRead = appCompatActivity;

        cFileIOStreamRead = new FileIOStreamRead(aFileIOStreamListRead);


    }

    public void setFileList(){
        String path = aFileIOStreamListRead.getFilesDir().getAbsolutePath() + "/time8/";
        System.out.println("timepath :" + path);

        File directory = new File(path);
        File[] files = directory.listFiles();

        List<String> lstFileName = new ArrayList<>();

        DefineData.ins().lstReadFileData.clear();
        if(files != null) {
            System.out.println("파일갯수 : " + files.length);
            for(int i = 0 ; i < files.length ; i++) {
                lstFileName.add(files[i].getName());
                DefineData.ins().lstReadFileData.add(files[i].getName());
            }
        }

        System.out.println("lstFileName : " + lstFileName);
        System.out.println("lstReadFileData : " + DefineData.ins().lstReadFileData);

    }
}
