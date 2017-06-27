package com.model.choong.chap05_toastevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
	TextView result;
	Button btn1, btn2, btn3, btn4, btn5, btn6;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		result = (TextView)findViewById(R.id.txtResult);

		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
		btn4 = (Button)findViewById(R.id.btn4);
		btn5 = (Button)findViewById(R.id.btn5);
		btn6 = (Button)findViewById(R.id.btn6);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);

	}

	// 권장하진 않지만, 자바에 익숙한 이를 위해 제공하긴 하는 이벤트 처리 방법.
	@Override
	public void onClick(View v){
		String msg = null;

		if(v.getId() == R.id.btn1){
			msg = "당신은 서울에서 태어났군요.";
		}else if(v.getId() == R.id.btn2){
			msg = "당신은 경기도에서 태어났군요.";
		}else if(v.getId() == R.id.btn3){
			msg = "당신은 충청도에서 태어났군요.";
		}else if(v.getId() == R.id.btn4){
			msg = "당신은 경상도에서 태어났군요.";
		}else if(v.getId() == R.id.btn5){
			msg = "당신은 전라도에서 태어났군요.";
		}else if(v.getId() == R.id.btn6){
			msg = "당신은 강원도에서 태어났군요.";
		}

		result.setText(msg);
	}
}
