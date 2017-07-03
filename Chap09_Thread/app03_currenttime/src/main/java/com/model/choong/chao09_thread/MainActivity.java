package com.model.choong.chao09_thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity{
	Button btnStart;
	Button btnStop;
	TextView tv;

	boolean flag = true;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStart = (Button)findViewById(R.id.btnStart);
		btnStop = (Button)findViewById(R.id.btnStop);
		tv = (TextView)findViewById(R.id.txtTime);

		btnStart.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Thread t = new Thread(new Runnable(){
					@Override
					public void run(){
						while(flag){
							Date date = new Date();
							String currentTime = "현재 시간은: " + date.toString();
							//tv.setText(currentTime); // 안드로이드는 작업쓰레드에서 UI에 접근하면 강제종료되도록 짜여져있다.
										// UI접근은 메인쓰레드(UI쓰레드)에서만 하자.
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
				Thread t = new Thread(new Runnable(){
					@Override
					public void run(){

					}
				});
			}
		});
	}
} // class MainActivity{}
