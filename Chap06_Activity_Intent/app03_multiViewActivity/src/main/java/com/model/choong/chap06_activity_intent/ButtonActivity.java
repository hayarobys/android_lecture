package com.model.choong.chap06_activity_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity{
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button);

		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent( ButtonActivity.this, ImageActivity.class);
				startActivity(intent);
			}
		});
	}
}
