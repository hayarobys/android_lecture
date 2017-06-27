package com.model.choong.chap06_activity_intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class ImageActivity extends AppCompatActivity{
	ImageButton imgUp, imgDown;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);

		imgUp = (ImageButton)findViewById(R.id.imageButton1);
		imgDown = (ImageButton)findViewById(R.id.imageButton2);

		imgUp.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				if(event.getAction() == MotionEvent.ACTION_DOWN){	// ACTION_DOWN - 터치로 화면이 눌렸을때.
					imgUp.setVisibility(View.INVISIBLE);
					imgDown.setVisibility(View.VISIBLE);
				}else if(event.getAction() == MotionEvent.ACTION_UP){	// ACTION_UP - 손을 떼었을때
					imgUp.setVisibility(View.VISIBLE);
					imgDown.setVisibility(View.INVISIBLE);
				}
				return false;
			}	// onTouch(View, MotionEvent)
		});	// setOnTouchListener()
	}	// onCreate(Bundle)
}	// class ImageActivity{}
