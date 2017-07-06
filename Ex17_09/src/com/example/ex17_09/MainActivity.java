package com.example.ex17_09;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    
    Button btnStart;
    ImageView imgRotate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnStart = (Button)findViewById(R.id.btnStart);
        imgRotate = (ImageView)findViewById(R.id.imgRotate);
        
        btnStart.setOnClickListener( new View.OnClickListener() {

           @Override
          public void onClick(View v) {

           // rotate 애니메이션 설정
             Animation anim =
 AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

              imgRotate.startAnimation(anim);

          }
    });  
  }
}