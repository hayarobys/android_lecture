package com.model.choong.chap06_activity_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FirstActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
	}

	public void onBtnActivity2(View v){
		// 2번 화면으로 전환
		Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
		startActivity(intent);
	}
}
