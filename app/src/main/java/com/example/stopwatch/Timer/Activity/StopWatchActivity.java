package com.example.stopwatch.Timer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stopwatch.R;
import com.example.stopwatch.Timer.Activity.StopWatch;
import com.example.stopwatch.Timer.Dialog.SaveDialog;

public class StopWatchActivity extends AppCompatActivity {

        StopWatch cStopWatch;   //!< Activity 하위 클래스

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            cStopWatch = new StopWatch(this);   //!< Activity 하위클래스 객체생성

        }

}
