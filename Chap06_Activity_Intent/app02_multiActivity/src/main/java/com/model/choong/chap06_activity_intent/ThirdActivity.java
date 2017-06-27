package com.model.choong.chap06_activity_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ThirdActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
	}

	// 2번 화면으로 전환
	public void onBtnBack(View v){
		finish();	// 현재 액티비티 종료
	}

	// 1번 화면으로 전환
	public void onBtnBack2(View v){
		Intent intent = new Intent(ThirdActivity.this, FirstActivity.class);
		startActivity(intent);
	}
}
