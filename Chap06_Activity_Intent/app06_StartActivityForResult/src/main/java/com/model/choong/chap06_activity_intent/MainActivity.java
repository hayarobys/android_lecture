package com.model.choong.chap06_activity_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView)findViewById(R.id.textView2);
	}

	public void btnClick(View v){
		Intent intent = new Intent(this, SubActivity.class);
		// startActivity(intent);
		startActivityForResult(intent, 1);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode == 1){
			if(resultCode == Activity.RESULT_OK){
				tv.setText(data.getStringExtra("msg"));
			}else if(resultCode == Activity.RESULT_CANCELED){
				tv.setText("취소 버튼을 누르셨습니다.");
			}
		}
	}
}
