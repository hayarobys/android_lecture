package com.model.choong.chap10_servicebroadcast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Date;

/**
 * Created by pc on 2017-07-04.
 */

// 서비스를 개발할땐 Sercice(android.app)를 상속하자.
/*
<service	android:name=".BackgroundService"
		android:enabled="true"
		android:exported="true"/>
	AndroidManifest.xml에 이 서비스 클래스를 등록해주자.
*/
// Intent에 의해 이 클래스가 실행되면 onCreate -> onStartCommand -> onDestroy 순으로 호출된다.
public class BackgroundService extends Service{
	boolean flag;

	@Nullable
	@Override
	public IBinder onBind(Intent intent){
		return null;
	} // onBind

	@Override
	public void onCreate(){
		super.onCreate();

		flag = true;
	} // onCreate

	// 무언가의 이유로 서비스가 강제종료 되었을때, 재시작 하도록 설정해놨다면 호출되는 메소드.
	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		//return super.onStartCommand(intent, flags, startId);
		Thread t = new Thread(new Runnable(){
			@Override
			public void run(){
				while(flag){
					try{	Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();	// 근데 어디에 출력되지? 콘솔창이 어딨지?
					}

					Date d = new Date();
					Log.i("MyLog", d.toString());
				}
			}
		});

		t.start();
		//return START_NOT_STICKY;	// 강제종료 되었을때 재실행 하지마라.
		return START_STICKY;		// 강제종료 되었을때 재실행 하라.
		//return START_REDELIVER_INTENT;
		//return START_STICKY_COMPATIBILITY;
	} // onStartCommand

	@Override
	public void onDestroy(){
		super.onDestroy();

		flag = false;
	} // onDestroy
}