package com.model.choong.chap08_db;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

	StudentsDBManager dbManager;
	EditText displayDBdata;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dbManager = StudentsDBManager.getInstance(this);
		displayDBdata = (EditText)findViewById(R.id.editText);
	}	// onCreate(Bundle)

	public void onClick(View view){
		switch(view.getId()){
			case R.id.insert:
				ContentValues contentValues = new ContentValues();

				contentValues.put("NUMBER", "20170630");
				contentValues.put("NAME", "홍길동");
				contentValues.put("DEPARTMENT", "컴퓨터공학과");
				contentValues.put("AGE", "21");
				contentValues.put("GRADE", 2);

				long result = dbManager.insert(contentValues);
				displayDBdata.setText("레코드 추가" + result);
				break;

			case R.id.update:
				ContentValues values = new ContentValues();
				values.put("NAME", "이순신");
				int resultUpdate = dbManager.update(values, "number=20170630", null);
				displayDBdata.setText("레코드 수정" + resultUpdate);
				break;

			case R.id.delete:
				int resultDelete = dbManager.delete(null, null);
				displayDBdata.setText("레코드 삭제" + resultDelete);
				break;

			case R.id.select:
				Log.d("로그찍기: ", "이쪽은?");
				String[] columns = new String[]{"id", "number", "name", "department", "age", "grade"};
				Log.d("로그찍기: ", "여기는 왔니?");
				Cursor cursor = dbManager.getSelect(columns, "number='20170630'", null, null, null, null);
				Log.d("로그찍기: ", "여기까지 수행되었음.");
				displayDBdata.setText("");

				if(cursor != null){
					while(cursor.moveToNext()){
						int id = cursor.getInt(0);
						String number = cursor.getString(1);
						String name = cursor.getString(2);
						String department = cursor.getString(3);
						String age = cursor.getString(4);
						int grade = cursor.getInt(5);

						displayDBdata.append(
							"id: " + id +
								"\n학번: " + number +
								"\n이름: " + name +
								"\n학과: " + department +
								"\n나이: " + age +
								"\n등급: " + grade +
								"\n"
						);
					}
					cursor.close();
				}
				break;

			default:
		}
	}	// onClick()
}
