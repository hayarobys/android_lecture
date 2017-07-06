package com.example.ex17_01;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    
   Button btnStart;
   AnimationDrawable drawable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ImageView�� �ִϸ��̼� ����.
        ImageView imgFrame = (ImageView)findViewById(R.id.imgFrame);
        
        drawable = (AnimationDrawable) imgFrame.getBackground();
        
        
        btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener( new View.OnClickListener() {

                @Override
               public void onClick(View v) {

                   if( drawable.isRunning()){	
				
			   btnStart.setText("����");
			   drawable.stop();
				   
		   }else{
			   btnStart.setText("����");
			   drawable.start();
		   }

              }
        });
    }
}