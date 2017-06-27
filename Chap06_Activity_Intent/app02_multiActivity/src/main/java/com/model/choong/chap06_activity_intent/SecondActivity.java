package com.model.choong.chap06_activity_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}

	// 3번 화면으로 전환
	public void onBtnActivity3(View v){
		Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
		startActivity(intent);
	}

	// 1번 화면으로 전환
	public void onBtnBack(View v){
		Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
	}
}
