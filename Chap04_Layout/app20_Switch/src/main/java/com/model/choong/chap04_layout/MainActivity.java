package com.model.choong.chap04_layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
	Switch sound;
	TextView txtResult;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sound = (Switch)findViewById(R.id.switch1);
		txtResult = (TextView)findViewById(R.id.txtResult);

		sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
				if(isChecked){
					txtResult.setText("ON");
				}else{
					txtResult.setText("OFF");
				}
			}
		});
	}
}
