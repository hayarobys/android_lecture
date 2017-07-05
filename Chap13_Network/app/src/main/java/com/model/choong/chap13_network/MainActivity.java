package com.model.choong.chap13_network;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

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

				MyDialogFragment fragment = MyDialogFragment.newInstance();
				// 로딩바를 띄운다.
				fragment.show(getFragmentManager(), "TAG");

				// 작업 스레드 생성(5초이상 걸리는 작업을 메인 쓰레드에서 수행하면 앱이 응답없음 상태로 들어간다.)
				Thread thread = new Thread(new Runnable(){
					@Override
					public void run(){
						try{
							URL url = new URL(requestURL);
							InputStream is = url.openStream();
							streamToString(is);
						}catch(MalformedURLException e){ // new URL(String url)에서 발생
							e.printStackTrace();
						}catch(IOException e){	// url.openStream()과 streamToString(InputStream)에서 발생
							e.printStackTrace();
						}
					} // run()
				}); // new Thread(new Runnable(){})
			} // onClick(View){}
		}); // setOnClickListener(new View.OnClickListener(){})
	} // onCreate(Bundle)

	// InputStream으로 받은 정보를 String으로 변경하는 기능 정의
	public String streamToString(InputStream is) throws IOException{
		StringBuffer buffer = new StringBuffer();	// StringBuffer는 동기화 처리되어있음.
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		reader.readLine(); // 여기부터 다시 시작
	} // streamToString()

	public static class MyDialogFragment extends DialogFragment{
		private static MyDialogFragment dialogFragment = null;

		public static MyDialogFragment newInstance(){	// 싱글톤은 getInstance라고 작명하는 경우가 많다.
			if(dialogFragment == null){
				dialogFragment = new MyDialogFragment();
			}

			return dialogFragment;
		}

		@NonNull
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState){
			ProgressDialog dialog = new ProgressDialog(getActivity());
			dialog.setTitle("네트워크");
			dialog.setMessage("요청중...");
			dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

			return dialog;

			//return super.onCreateDialog(savedInstanceState);
		}
	} // inner class MyDialogFragent{}
} // class MainActivity{}
