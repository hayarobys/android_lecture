package com.model.choong.chap06_activity_intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
	EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et = (EditText)findViewById(R.id.editText);
	}

	public void btnClick(View v){

	}
}
