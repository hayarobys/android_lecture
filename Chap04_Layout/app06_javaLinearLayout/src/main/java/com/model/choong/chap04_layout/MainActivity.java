package com.model.choong.chap04_layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity{
	/*
	* 자바 코드로 UI 구성하기
	* */

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 버튼 객체 생성
		Button btn1 = new Button(this);
		btn1.setText("Button1");

		Button btn2 = new Button(this);
		btn2.setText("Button2");

		// 레이아웃 객체 생성
		LinearLayout li = new LinearLayout(this);
		li.setOrientation(LinearLayout.VERTICAL);       // 정렬방식

		li.addView(btn1);       // 컴포넌트 추가
		li.addView(btn2);

		setContentView(li);     // 화면에 보여줌
	}
}
