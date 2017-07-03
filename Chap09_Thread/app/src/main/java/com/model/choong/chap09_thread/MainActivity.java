package com.model.choong.chap09_thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnANR = (Button)findViewById(R.id.btn1);
		Button btnNoANR = (Button)findViewById(R.id.btn2);

		btnANR.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Thread thread = new Thread(new Runnable(){
					@Override
					public void run(){
						play();
					}
				});

				thread.start();
			}
		});

		btnNoANR.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){

			}
		});
	} // onCreate(Bundle)

	public void play(){
		boolean flag = true;
		int num = 0;

		while(flag){
			if(++num > 20){
				flag = false;
			}

			try{	Thread.sleep(10000);
			}catch(InterruptedException i){
				i.printStackTrace();
			}
			Log.i("MyLog", "num: " + num);
		}

		Log.i("MyLog", "End...");
	} // play()
} // class MainActivity{}
