package com.model.choong.chap07_adapterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
}


/*
* dip = density independency pixel(밀도 독립 픽셀?)
*
* mdpi - 320px - 1inch - 2.54cm
* 1dp = 1pixel
*
* hdpi(mdpi의 1.5배) = 480px
* 1dp = 1.5pixel
*
* xhdpi - 640px
* 1dp = 2pixel
*
* xxhdpi - 960px
* 1dp = 3pixel
*
* 16dp = 16sp (글자는 대각선 길이로 계산한다. sp는 이렇게 16sp일때의 대각선 길이에서 배율을 곱해가며 글자 크기를 계산한다.)
* */