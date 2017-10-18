package com.example.android.advance2_lesson1_customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.android.advance2_lesson1_customview.widget.customView.TouchEventView;

public class MainActivity extends AppCompatActivity {

    private TouchEventView mTouchEventView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTouchEventView = (TouchEventView) findViewById(R.id.touchView);
    }

    public void onButtonEraseClicked(View view) {
        mTouchEventView.erase();
    }
}
