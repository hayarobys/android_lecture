package com.model.choong.chap10_servicebroadcast;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service{
	MediaPlayer player;

	public MusicService(){
	}

	@Override
	public IBinder onBind(Intent intent){
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void onCreate(){
		super.onCreate();

		player = MediaPlayer.create(this, R.raw.shes_gone);
		player.setLooping(false);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		//return super.onStartCommand(intent, flags, startId);
		Toast.makeText(getApplicationContext(), "music start...", Toast.LENGTH_LONG);
		player.start();	// start()라니, 작업 쓰레드로 돌리는가 보군.
		return START_STICKY;
	}

	@Override
	public void onDestroy(){
		super.onDestroy();
		Toast.makeText(getApplicationContext(), "music stop...", Toast.LENGTH_SHORT);
		player.stop();
	}
}
