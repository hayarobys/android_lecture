package com.model.choong.chap02_basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn);
        tv = (TextView)findViewById(R.id.textView);

        // 안드로이드는 클래스 이름에 점이 들어간 경우가 많다. View.OnClickListener 전부가 하나의 인터페이스 이름임에 주의.
        // 패키지명이거나 메서드 호출하는게 절대 아니다!
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("버튼을 클릭하셨군요!!!");
            }
        });

    }   // onCreate()
}   // class MainActivity
