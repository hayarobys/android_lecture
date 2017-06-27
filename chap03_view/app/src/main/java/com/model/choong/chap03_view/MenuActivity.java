package com.model.choong.chap03_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

	}

	// activity_menu.xml에 정의한 android:onClick에 지정한 아이디와 같은 이름의 매개변수를 호출함
	// 버튼에 대한 입력을 View 형태의 매개변수로 함께 전달해줌.
	public void onBackBtnClick(View v){
		Toast.makeText(getApplicationContext(), "돌아가기 버튼 클릭", Toast.LENGTH_SHORT).show();
		finish();       // 현재 Activity화면 소멸
	}
}
