package com.model.choong.chap10_servicebroadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
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
				handler.sendEmptyMessageDelayed(0, 5000);	// 5초 뒤에 이벤트 발생
			}
		});
	}

	Handler handler = new Handler(){
		// BroadcastReceiver는 이벤트를 수신하면 handleMessage()를 호출함.
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

		// Notification 객체 생성(알림 메세지 생성)
		Notification notification = new NotificationCompat.Builder(this)
				.setContentIntent(pendingIntent)
				.setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
				.setContentTitle("알림 제목")
				.setContentText("알림 내용입니다...")
				.setTicker("알림 메세지 도착")
				.setAutoCancel(true)
				.build();
		// setTicker()는 뭐지? 액션바 상단에 보여지는 글씨라는데 아이콘만 달랑 보이네.

		// 2. NotificationManager 객체 가져오기
		NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

		// 3. 알림 띄우기(알림 아이디, Notification 객체)
		notificationManager.notify(999, notification);

		// 4. 원하는 시점에 취소 할 거라면, 알림의 아이디값을 알고 있으면 된다.
		notificationManager.cancel(999);
	} // showNotification()
} // class MainActivity{}
