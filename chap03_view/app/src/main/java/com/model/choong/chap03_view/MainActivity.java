package com.model.choong.chap03_view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView tv = (TextView)findViewById(R.id.textView);

		Button btn1 = (Button)findViewById(R.id.btn);
		Button btn2 = (Button)findViewById(R.id.btn2);
		Button btn3 = (Button)findViewById(R.id.btn3);

		btn1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// 뒷쪽 Uri로 요청 하겠다는 의도를 담은 코드.
				Intent intent = new Intent(
					Intent.ACTION_VIEW, Uri.parse("http://m.naver.com")
				);
				// 안드로이드에게 이 의도를 담은 Intent객체를 전달.
				startActivity(intent);
			}
		});
		btn2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// Uri에 주소를 적으면 인터넷으로, 번호를 적으면 전화기능을 요청.
				Intent intent = new Intent(
					Intent.ACTION_VIEW, Uri.parse("tel:010-1111-1111")
				);
				startActivity(intent);
			}
		});
		btn3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// 첫번째 매개변수인 getApplicationContext()는 현재 보여지는 액티비티인
				// 내 객체를 반환, 두번째 매개변수는 이동할 액티비티를 적어줌.
				Intent intent = new Intent(
					getApplicationContext(), MenuActivity.class
				);
				// 안드로이드에게 이 intent를 전달
				startActivity(intent);
			}
		});
	}
}
