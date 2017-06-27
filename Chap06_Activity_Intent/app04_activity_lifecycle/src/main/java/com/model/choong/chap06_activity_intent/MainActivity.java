package com.model.choong.chap06_activity_intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("MyLOG", "onCreate() 호출");
	}

	@Override
	protected void onStart(){
		super.onStart();
		Log.i("MyLOG", "onStart() 호출");
	}	// Log.i() 의 i는 inform의 약자.



	@Override
	protected void onResume(){
		super.onResume();
		Log.i("MyLOG", "onResume() 호출");
	}
}
