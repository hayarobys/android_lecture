package com.model.choong.chap10_servicebroadcast;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

			}
		});
	}

	Handler handler = new Handler(){
		// 이벤트가 발생하면 안드로이드는 handleMessage를 호출?
		@Override
		public void handleMessage(Message msg){
			super.handleMessage(msg);
			showNotification();	// 알림을 띄우는 기능
		}
	};

	public void showNotification(){
		// 알림을 클릭했을 때 특정 액티비티를 활성화 시킬 인텐트 객체 준비.
		Intent intent = new Intent(this, MainActivity.class);

		// 플래그를 사용하여 MainActivity 실행
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		// 인텐트 전달자 객체에 인텐트를 포장한다.
		// 여러개 전송할땐 getActivities(), 단일전송엔 getActivity()
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
		
	}
} // class MainActivity{}
