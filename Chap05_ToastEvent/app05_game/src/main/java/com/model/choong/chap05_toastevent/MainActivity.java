package com.model.choong.chap05_toastevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
	Button btn1, btn2, btn3, btn4;
	TextView tv;
	int r;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
		btn4 = (Button)findViewById(R.id.btn4);
		tv = (TextView)findViewById(R.id.textView2);

		// 1~3 랜덤 생성
		//int num = (int)(Math.random() * 4) + 1;
		r = new Random().nextInt(4) + 1;

	}	// onCreate(Bundle)

	public void btn1Click(View v){
		if(r == 1){
			tv.setText("축하합니다. 당첨되셨습니다.");
		}else{
			tv.setText("안타깝습니다.\n다음 기회에 다시 도전하세요.");
		}
	}

	public void btn2Click(View v){
		if(r == 2){
			tv.setText("축하합니다. 당첨되셨습니다.");
		}else{
			tv.setText("안타깝습니다.\n다음 기회에 다시 도전하세요.");
		}
	}

	public void btn3Click(View v){
		if(r == 3){
			tv.setText("축하합니다. 당첨되셨습니다.");
		}else{
			tv.setText("안타깝습니다.\n다음 기회에 다시 도전하세요.");
		}
	}

	public void btn4Click(View v){
		if(r == 4){
			tv.setText("축하합니다. 당첨되셨습니다.");
		}else{
			tv.setText("안타깝습니다.\n다음 기회에 다시 도전하세요.");
		}
	}
}	// class MainActivity{}
