package com.model.choong.chap08_db;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity{
	StudentsDBManager dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dbManager = StudentsDBManager.getInstance(this);// 여기서 this를 쓸시 Context반환\

	}	// onCreate(Bundle)

	public void onClick(View view){
		switch(view.getId()){
			case R.id.insert:
				dbManager.insert();
				break;
			case R.id.update:

				break;
			case R.id.delete:

				break;
			case R.id.select:

				break;
			default:
		}
	}	// onClick()

}	// class MainActivity{}
