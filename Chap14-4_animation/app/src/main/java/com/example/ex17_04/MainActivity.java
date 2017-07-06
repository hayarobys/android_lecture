package com.example.ex17_04;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    
       Button btnStart;
       ImageView imgScale;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnStart = (Button)findViewById(R.id.btnStart);
        imgScale = (ImageView)findViewById(R.id.imgScale);
        
        btnStart.setOnClickListener( new View.OnClickListener() {

         @Override
          public void onClick(View v) {

             // scale 애니메이션 설정
             ScaleAnimation anim = new ScaleAnimation(0, 1, 0, 1);
             anim.setDuration(4000);
             imgScale.startAnimation(anim);
          }
       });
        
    }
}