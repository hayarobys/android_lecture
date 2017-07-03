package com.model.choong.chap09_thread;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
	Button btnStart;
	Button btnStop;
	TextView tv;
	Handler handler;
	boolean flag = true;
	String currentTime = "현재 시간은: ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStart = (Button)findViewById(R.id.btnStart);
		btnStop = (Button)findViewById(R.id.btnStop);
		tv = (TextView)findViewById(R.id.txtTime);

		handler = new Handler();

		btnStart.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Thread t = new Thread(new Runnable(){
					@Override
					public void run(){
						while(flag){
							Date date = new Date();
							currentTime = "현재 시간은: " + date.toString();

							// Handler의 메시지큐에 실행할 작업을 넣는 코드
							handler.post(new Runnable(){
								@Override
								public void run(){
									tv.setText(currentTime);
								}
							});

							Log.i("MyLog", currentTime);

							try{	Thread.sleep(1000);
							}catch(InterruptedException e){
								e.printStackTrace();
							}
						}
					}
				});
				t.start();
			}
		});

		btnStop.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				flag = false;
			}
		});
	}
}
