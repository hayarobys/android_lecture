package com.model.choong.chap06_activity_intent;

import android.content.Intent;
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
		String str = et.getText().toString();
		Intent intent = new Intent(MainActivity.this, SubActivity.class);
		intent.putExtra("key", str);	// putExta() - 다른 액티비티로 데이터를 전달하는 메소드
		// map처럼 key, value를 이용한다.

		startActivity(intent);

	}
}
