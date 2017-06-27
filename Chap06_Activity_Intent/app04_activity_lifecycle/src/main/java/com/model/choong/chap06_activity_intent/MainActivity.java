package com.model.choong.chap06_activity_intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

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

	public void btnClickFinish(View v){
		finish();
	}

	@Override
	protected void onPause(){
		/*화면 전환 직전, 터치 이벤트를 잠깐 중지시키는 메소드?*/
		super.onPause();
		Log.i("MyLOG", "onPause() 호출");
	}

	@Override
	protected void onStop(){
		/*화면 전환이 이루어진 직후 호출되는 메소드*/
		super.onStop();
		Log.i("MyLOG", "onStop() 호출");
	}

	@Override
	protected void onDestroy(){
		/*모든 작업이 끝난후 메모리에서 내리는 메소드*/
		super.onDestroy();
		Log.i("MyLOG", "onDestroy() 호출");
	}
}
