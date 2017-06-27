package com.model.choong.chap04_layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
	ImageView img01;
	ImageView img02;
	ImageView img03;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		img01 = (ImageView)findViewById(R.id.imageView01);
		img02 = (ImageView)findViewById(R.id.imageView02);
		img03 = (ImageView)findViewById(R.id.imageView03);
	}

	/*버튼위젯의 아이디와 동일한 이름의 메소드를 선언하면, 자동으로 연결된다.*/
	public void btn1Click(View v){
		img01.setVisibility(View.VISIBLE);
		img02.setVisibility(View.INVISIBLE);
		img03.setVisibility(View.INVISIBLE);
	}

	public void btn2Click(View v){
		img01.setVisibility(View.INVISIBLE);
		img02.setVisibility(View.VISIBLE);
		img03.setVisibility(View.INVISIBLE);
	}

	public void btn3Click(View v){
		img01.setVisibility(View.INVISIBLE);
		img02.setVisibility(View.INVISIBLE);
		img03.setVisibility(View.VISIBLE);
	}
}
