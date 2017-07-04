package com.model.choong.chap10_servicebroadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
	Button btnStart, btnStop;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStart = (Button)findViewById(R.id.btnStart);
		btnStop = (Button)findViewById(R.id.btnStop);

		btnStart.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				startService(new Intent(getApplicationContext(), MusicService.class));
			}
		});

		btnStop.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				// 서비스를 종료하고 싶다면 인텐트에 해당 서비스를 찾도록 적어주면 됨.
				stopService(new Intent(getApplicationContext(), MusicService.class));
			}
		});
	}
}
