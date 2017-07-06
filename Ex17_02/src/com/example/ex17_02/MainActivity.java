package com.example.ex17_02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    
    Button btnStart;
    ImageView imgAlpha;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnStart = (Button)findViewById(R.id.btnStart);
        imgAlpha = (ImageView)findViewById(R.id.imgAlpha);
        
        btnStart.setOnClickListener( new View.OnClickListener() {

           @Override
          public void onClick(View v) {

           // alpha 애니메이션 설정
           AlphaAnimation anim = new AlphaAnimation(0, 1);
           anim.setDuration(4000);
           imgAlpha.startAnimation(anim);

          }
    });  
  }
}