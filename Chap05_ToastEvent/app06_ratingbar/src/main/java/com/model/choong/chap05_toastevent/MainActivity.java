package com.model.choong.chap05_toastevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
	RatingBar rbar;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		rbar = (RatingBar)findViewById(R.id.ratingBar);
		rbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser){
				Toast.makeText(	getApplicationContext(),
						"RatingBar Point: " + rating,
						Toast.LENGTH_SHORT
				).show();
			}	// onRatingChanger()
		});
	}	// onCreate(Bundle)
}	// class MainActivity{}
