package com.model.choong.chap06_activity_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity{
	EditText edit;
	Button btn1, btn2;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);

		edit = (EditText)findViewById(R.id.editText);
		btn1 = (Button)findViewById(R.id.button1);
		btn2 = (Button)findViewById(R.id.button2);

		btn1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent();
				intent.putExtra("msg", edit.getText().toString());
				setResult(Activity.RESULT_OK, intent);
				finish();
			}
		});

		btn2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				setResult(Activity.RESULT_CANCELED);
				finish();
			}
		});
	}
}
