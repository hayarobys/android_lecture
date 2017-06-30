package com.model.choong.chap08_db;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
	StudentsDBManager dbManager;
	EditText displayDBdata;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dbManager = StudentsDBManager.getInstance(this);// 여기서 this를 쓸시 Context반환\
		displayDBdata = (EditText)findViewById(R.id.editText);
	}	// onCreate(Bundle)

	public void onClick(View view){
		switch(view.getId()){
			case R.id.insert:
				dbManager.insert();
				break;
			case R.id.update:
				dbManager.update("20170630");
				break;
			case R.id.delete:
				dbManager.delete();
				break;
			case R.id.select:
				displayDBdata.setText("");
				Cursor cursor = dbManager.getSelect();

				if(cursor != null){
					// SQLite에서 데이터를 읽어오는 방법
					while(cursor.moveToNext()){
						int id = cursor.getInt(0);
						String number = cursor.getString(1);
						String name = cursor.getString(2);
						String department = cursor.getString(3);
						int grade = cursor.getInt(4);

						displayDBdata.append(
							"id: " + id +
								"\n학번: " + number +
								"\n이름: " + name +
								"\n학과: " + department +
								"\n등급: " + grade +
								"\n"
						);
					}
				}

				cursor.close();
				break;
			default:
		}
	}	// onClick()

}	// class MainActivity{}
