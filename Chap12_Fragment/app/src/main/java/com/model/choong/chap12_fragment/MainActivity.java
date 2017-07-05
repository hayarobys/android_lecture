package com.model.choong.chap12_fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SampleListFragment.ListItemSelectedListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	}

	@Override
	public void onListItemSelected(int index){
		SampleViewerFragment imageViewer = (SampleViewerFragment)getFragmentManager().findFragmentById(R.id.image_viewer_fragment);

		imageViewer.update(index);
	}
}
