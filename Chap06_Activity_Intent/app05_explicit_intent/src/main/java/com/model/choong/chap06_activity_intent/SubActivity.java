package com.model.choong.chap06_activity_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);

		Intent intent = getIntent();	// 이 액티비티를 띄우면서 전달된 intent가 있다면 반환.
		String name = intent.getExtras().getString("key");
				// getExtras() - Intent에 담긴 데이터를 꺼내는 메소드.
				// Object형식으로 반환되기에 getString()으로 문자열 변환.

	}	// onCreate()
}	// class SubActivity{}
