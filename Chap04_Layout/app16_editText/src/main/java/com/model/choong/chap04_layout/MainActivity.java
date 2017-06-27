package com.model.choong.chap04_layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_inputtype2);

		//setContentView(R.layout.activity_edittext_editable);

		/*
		setContentView(R.layout.activity_main);
		TextView view = (TextView)findViewById(R.id.textView0);
		view.setSelected(true);	// 선택한 효과 부여. 마퀴 애니메이션을 보이기 위해 사용한 코드.
		*/
	}
}
