package com.model.choong.chap13_network;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URLEncoder;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
	EditText id, passwd;
	Button request;
	TextView result;

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
				MyDialogFragment fragment = MyDialogFragment.newInstance();
				fragment.show(getFragmentManager(), "TAG");

				String userId = id.getText().toString();
				String userPw = passwd.getText().toString();

				// 서버에 넘겨 줄 파라미터 저장
				// import org.apache.http.*; 마시멜로6.0부터 제외된 패키지.
				// 사용하고자하면 그래들에 의존성 추가할 것.
				ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
				list.add(new BasicNameValuePair("userid", userId));
				list.add(new BasicNameValuePair("userPw", userPw));

				String urlPath = "http://211.183.9.165:8090/Android/login.jsp?"
						+ URLEncodedUtils.format(list, "UTF-8");
			}
		});
	} // onCreate(Bundle)

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
