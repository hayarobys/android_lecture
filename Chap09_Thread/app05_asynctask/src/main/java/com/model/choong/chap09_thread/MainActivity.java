package com.model.choong.chap09_thread;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
	Button btn;
	ProgressDialog dialog;
	int pValue;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn = (Button)findViewById(R.id.button);

		btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				MyAsyncTask asyncTask = new MyAsyncTask();
				asyncTask.execute(100);	// 이 값이 params로 들어가는구나
			}
		});
	} // onCreate(Bundle)

	public class MyAsyncTask extends AsyncTask<Integer, Integer, String>{
		@Override	// 백그라운드에서 동작하는 메소드
		protected String doInBackground(Integer... params){
			while(pValue < params[0]){
				pValue++;
				publishProgress(pValue);	// onProgressUpdate(Integer...)가 호출됨

				try{	Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}

			pValue = 0;
			return "다운로드 완료";
		}

		@Override	// 가장 먼저 호출
		protected void onPreExecute(){
			super.onPreExecute();

			dialog = new ProgressDialog(MainActivity.this);
			dialog.setTitle("작업중...");
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "취소", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int which){
					dialog.dismiss();
				}
			});

			dialog.show();
		}

		@Override	// 상태 진행바를 갱신하는 메소드
		protected void onProgressUpdate(Integer... values){
			super.onProgressUpdate(values);

			dialog.setProgress(values[0]);	// 0~100 의 값. 프로그래스바의 채워진 정도를 설정한다.
		}

		@Override	// 작업 종료시 호출(마지막으로 호출)
		protected void onPostExecute(String s){
			// 매개변수 s는 doInBackground(Integer...)가 리턴한 값이 들어옴.
			super.onPostExecute(s);

			dialog.dismiss();	// 대화상자 닫기
			Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
		}

	} // inner class MyAsncTask{}


} // class MainActivity{}
