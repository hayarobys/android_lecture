package com.model.choong.chap07_adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// res/values/arrays.xml에 <string-array name="fruits"> 라는 태그를 이용했기에
		// 아래처럼 R.array로 접근한다.
		String[] fruits = getResources().getStringArray(R.array.fruits);

		// this 만 넣어줘도 되지만, 명확하게 내 자신임을 밝히는 의미에서 MainActivity.this를 사용.
		ArrayAdapter adapter = new ArrayAdapter<String>(
			MainActivity.this, android.R.layout.simple_list_item_1, fruits
			//C:\Users\pc\AppData\Local\Android\sdk\platforms\android-25\data\res\layout\simple_list_item_1.xml
		);

		ListView listView = (ListView)findViewById(R.id.listView);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getApplicationContext(),
					((TextView)view).getText().toString() + position, Toast.LENGTH_SHORT).show();
			}
		});
	}
}


/*
* dip = density independency pixel ? Device independent pixel?
* dpi = dot per inch
*
* ldpi - 80px
* 1dp = 0.5pixel
*
* mdpi - 160px - 1inch - 2.54cm
* 1dp = 1pixel
*
* hdpi(mdpi의 1.5배) = 240px
* 1dp = 1.5pixel
*
* xhdpi - 320px
* 1dp = 2pixel
*
* xxhdpi - 480px
* 1dp = 3pixel
*
* 16dp = 16sp (글자는 대각선 길이로 계산한다. sp는 이렇게 16sp일때의 대각선 길이에서 배율을 곱해가며 글자 크기를 계산한다.)
* */