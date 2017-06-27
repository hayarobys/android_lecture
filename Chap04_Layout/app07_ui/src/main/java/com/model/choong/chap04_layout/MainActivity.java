package com.model.choong.chap04_layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn1 = (Button)findViewById(R.id.button1);
		btn1.setText("코드에서도 변경 가능");

		Button btn2 = (Button)findViewById(R.id.button2);
		btn2.setEnabled(false); // 두번째 버튼 비활성화
	}
}
