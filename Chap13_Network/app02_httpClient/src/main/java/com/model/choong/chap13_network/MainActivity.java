package com.model.choong.chap13_network;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
	EditText id, passwd;
	Button request;
	TextView result;

	String strResult;
	String urlPath;

	MyDialogFragment fragment;
	Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		id = (EditText)findViewById(R.id.id);
		passwd = (EditText)findViewById(R.id.passwd);
		request = (Button)findViewById(R.id.login);
		result = (TextView)findViewById(R.id.result);

		request.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				fragment = MyDialogFragment.newInstance();
				fragment.show(getFragmentManager(), "TAG");

				String userId = id.getText().toString();
				String userPw = passwd.getText().toString();

				// 서버에 넘겨 줄 파라미터 저장
				// import org.apache.http.*; 마시멜로6.0부터 제외된 패키지.
				// 사용하고자하면 그래들에 의존성 추가할 것.
				ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
				list.add(new BasicNameValuePair("userid", userId));
				list.add(new BasicNameValuePair("userPw", userPw));

				urlPath = "http://211.183.9.165:8090/Android/login.jsp?"
						+ URLEncodedUtils.format(list, "UTF-8");

				Thread thread = new Thread(new Runnable(){
					@Override
					public void run(){
						InputStream is = requestGet(urlPath);

						strResult = streamToString(is);
						fragment.dismiss();

						handler.post(new Runnable(){
							@Override
							public void run(){
								result.setText(strResult);
							} // run()
						});
					} // run()
				});

				thread.start();
			} // onClick(View)
		});
	} // onCreate(Bundle)

	public InputStream requestGet(String urlPath){
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(urlPath);
		InputStream is = null;
		try{
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(IOException e){
			e.printStackTrace();
		}
		return is;
	}

	public String streamToString(InputStream is){
		StringBuffer buffer = new StringBuffer();	// StringBuffer는 동기화 처리되어있음.
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		String str = null;
		try{
			str = reader.readLine();

			while(str != null){
				buffer.append(str);
				str = reader.readLine();
				//buffer.append('\n'); // html태그니까 줄바꿈 필요없으려나? CSS/javascript는 필요할텐데?
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{reader.close();}catch(IOException e){e.printStackTrace();}
		}
		return buffer.toString();
	} // streamToString()

	public static class MyDialogFragment extends DialogFragment{
		private static MyDialogFragment dialogFragment = null;

		public static MyDialogFragment newInstance(){
			if(dialogFragment == null){
				dialogFragment = new MyDialogFragment();
			}

			return dialogFragment;
		}

		@NonNull
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState){
			ProgressDialog dialog = new ProgressDialog(getActivity());
			dialog.setTitle("로그인");
			dialog.setMessage("요청중...");
			dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

			return dialog;
		}
	} // inner class MyDialogFragent{}
} // class MainActivity{}
