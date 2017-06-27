package com.model.choong.chap05_toastevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
	EditText editText;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText = (EditText)findViewById(R.id.edit);

		editText.setOnKeyListener(new View.OnKeyListener(){
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event){
				// 이벤트가 키 업 이벤트 이면서, 엔터키를 누르면
				if((event.getAction() == KeyEvent.ACTION_UP)
					&& (keyCode == KeyEvent.KEYCODE_ENTER)){
					Toast.makeText(
						getApplicationContext(),
						editText.getText().toString(),
						Toast.LENGTH_LONG
					).show();
				}
				return false;
			}	// onKey()
		});
	}	// onCreate(Bundle)
}	// class MainActivity
