package com.model.choong.chap04_layout;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
	TextView txtResult;
	RadioGroup radioGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtResult = (TextView)findViewById(R.id.txtResult);
		radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
				switch(checkedId){
					case R.id.radio0:
						txtResult.setText("선택한 과일 : 사과");
						break;
					case R.id.radio1:
						txtResult.setText("선택한 과일 : 배");
						break;
					case R.id.radio2:
						txtResult.setText("선택한 과일 : 바나나");
						break;
					default:
				}
			}
		});
	}
}
