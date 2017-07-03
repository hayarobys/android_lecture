package com.model.choong.chap09_thread;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{
	Button btnWheel;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnWheel = (Button)findViewById(R.id.btnWheel);
		btnWheel.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				showDialog(1); // 대화 상자 호출
				Thread t = new Thread(new Runnable(){
					@Override
					public void run(){
						// 3초가 지나면 다이얼로그 닫기
						TimerTask task = new TimerTask(){
							@Override
							public void run(){
								removeDialog(1);
							}
						};

						Timer timer = new Timer();
						timer.schedule(task, 3000);	// 3초 뒤에 task.start() 호출
					}
				});

				t.start();
			}
		});
	}

	@Override
	protected Dialog onCreateDialog(int id){	// 사용자에게 보여짐
		ProgressDialog dialog = new ProgressDialog(this);
		dialog.setTitle("작업중...");	// 대하상자 제목
		dialog.setMessage("잠시만...");	// 대화상자 메시지 내용
		dialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "취소", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which){
				removeDialog(1);	// 취소(NEGATIVE) 버튼 클릭시 대화상자 닫음.
			}
		});
		return dialog;
	}
}
