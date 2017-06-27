package com.model.choong.app3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	Button btn;
	TextView tv;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn = (Button)findViewById(R.id.button);
		tv = (TextView)findViewById(R.id.textView);

		btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				tv.setText("버튼 클릭");

				// getApplicationContext() 는 자기 자신의 객체를 반환
				Toast.makeText(getApplicationContext(), "이전화면으로 돌아갑니다.", Toast.LENGTH_LONG).show();
				finish();       // 현재 액티비티를 소멸하는 기능.

			}
		});
	}
}
