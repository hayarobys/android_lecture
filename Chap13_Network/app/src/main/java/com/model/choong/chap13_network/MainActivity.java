package com.model.choong.chap13_network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
	EditText editURL;
	Button btnRequest;
	TextView txtResult;
	String result;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editURL = (EditText)findViewById(R.id.editURL);
		btnRequest = (Button)findViewById(R.id.btnRequest);
		txtResult = (TextView)findViewById(R.id.result);

		// TextView 스크롤 기능 적용
		txtResult.setMovementMethod(new ScrollingMovementMethod());

		btnRequest.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				final String requestURL = editURL.getText().toString();
			}
		});
	} // onCreate(Bundle)
} // class MainActivity{}
