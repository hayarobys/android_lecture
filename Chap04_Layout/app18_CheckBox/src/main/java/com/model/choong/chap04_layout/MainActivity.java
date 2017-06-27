package com.model.choong.chap04_layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
	String msg = "체크된 메뉴는 ";
	CheckBox chkA;
	CheckBox chkB;
	CheckBox chkC;
	TextView txtResult;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*참조변수 선언을 인스턴스 변수로 해버리면 익명변수 안에서 접근하지 못한다.
		* 그러므로 필드변수로 선언했음.*/

		chkA = (CheckBox)findViewById(R.id.chkA);
		chkB = (CheckBox)findViewById(R.id.chkB);
		chkC = (CheckBox)findViewById(R.id.chkC);
		txtResult = (TextView)findViewById(R.id.txtResult);

		chkA.setOnCheckedChangeListener(new EventHandler());
		chkB.setOnCheckedChangeListener(new EventHandler());
		chkC.setOnCheckedChangeListener(new EventHandler());
	}

	private class EventHandler implements CompoundButton.OnCheckedChangeListener{
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
			if(isChecked){
				if(msg.contains(buttonView.getText())){

				}else{
					if(!msg.contains("는 ")){
						msg += "는 ";
					}

					msg += 	buttonView.getText().toString() + " ";
				}
				txtResult.setText(msg);
			}else{
				if(msg.substring(msg.length()).equals(buttonView.getText().toString() + " ")){
					/*여기 조건이 계속 false네. 어디가 잘못된걸까?*/
					msg = msg.replace("는 ", "");
				}

				msg = msg.replace(buttonView.getText().toString() + " ", "");
				txtResult.setText(msg);
			}
		}
	}
}
