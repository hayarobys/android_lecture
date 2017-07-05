package com.model.choong.chap12_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SampleViewerFragment extends Fragment{
	String[] imageTitles = {"dream01.png", "dream02.png", "dream03.png"};
	int[] imageLocations = {R.drawable.dream01, R.drawable.dream02, R.drawable.dream03};

	// LayoutInflater.inflater(XML파일) - 레이아웃파일을 View객체로 변환하는 메소드.
	// FragmentManager 는 이 메소드를 통해 프래그먼트를 View타입으로 변환해 관리하게된다.
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
		// return super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.image_viewer_fragment, container);
	}

	// 위에서 View타입으로 변환된 Fragment를 getView()로 얻어온다.
	public void update(int index){
		TextView title = (TextView)getView().findViewById(R.id.title);
		ImageView image = (ImageView)getView().findViewById(R.id.image);

		title.setText(imageTitles[index]);
		image.setImageResource(imageLocations[index]);
	}
}
