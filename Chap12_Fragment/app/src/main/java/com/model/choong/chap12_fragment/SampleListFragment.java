package com.model.choong.chap12_fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SampleListFragment extends ListFragment{
	ListItemSelectedListener selectedListener;
	private int index = 0;

	// 프레그먼트는 액티비티에 탑재되는 순간 onAttach()가 호출되고, 다음으로 프래그먼트 클래스의 onCreate()가 호출된다.
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);

		selectedListener = (ListItemSelectedListener)activity;
	}

	// 세번째로 onActivityCreated()가 호출되는건가?
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);

		// 리스트뷰(심플리스트아이템1)로 생성한 어댑터(어레이어댑터)를 또 다른 어댑터(리스트 어댑터)에 결합.
		setListAdapter(ArrayAdapter.createFromResource(getActivity(), R.array.image_titles, android.R.layout.simple_list_item_1));

		if(savedInstanceState != null){
			index = savedInstanceState.getInt("index");
			selectedListener.onListItemSelected(index);
		}

	} // onActivityCreated()

	// 메모리 부족으로 프래그먼트 소멸직전에 onSaveInstanceState() 호출.
	// 이때 저장할 데이터가 있다면 Bundle에 보관하라는 의미에서 매개변수로 Bundle객체 전달됨.
	@Override
	public void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putInt("index", index);
	}

	// 이 프래그먼트 내의 항목이 클릭되었을때 호출되는 메소드.
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
		super.onListItemClick(l, v, position, id);

		index = position;
		selectedListener.onListItemSelected(index);
	}

	public interface ListItemSelectedListener{
		public void onListItemSelected(int index);
	}
} // class SampleListFragment{}
