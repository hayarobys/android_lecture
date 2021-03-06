package com.model.choong.chap08_db;

import android.content.ContentValues;
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
				ContentValues contentValues = new ContentValues();

				//NULL, '20170630', '홍길동', '컴퓨터공학과', 2
				contentValues.put("NUMBER", "20170630");
				contentValues.put("NAME", "홍길동");
				contentValues.put("DEPARTMENT", "컴퓨터공학과");
				contentValues.put("GRADE", "2");

				// 현재 컬럼 항목의 갯수를 반환하는건가?(레코드 갯수?)
				long result = dbManager.insert(contentValues);
				displayDBdata.setText("레코드 추가");
				break;

			case R.id.update:
				//dbManager.update("20170630");

				// public int update(ContentValues contentValues, String whereClause, String[] whereArgs){
				ContentValues values = new ContentValues();
				values.put("NAME", "이순신");
				// where절이 하나일 경우 whereClause에 넣어주고, 여러개면 whereArgs에 넣어준다?

				// 수정된 레코드 갯수를 반환.
				int resultUpdate = dbManager.update(values, "number=20170630", null);
				displayDBdata.setText("레코드 수정");
				break;

			case R.id.delete:
				//dbManager.delete();
				int resultDelete = dbManager.delete(null, null);

				displayDBdata.setText("레코드 삭제");
				break;

			case R.id.select:
				/* 기존방법
				Cursor cursor = dbManager.getSelect();*/

				/*또 다른 방법*/
				// 이 메소드를 이용한다.
				// database.query(TABLE_STUDENTS, columns, selection, selectionArgs, groupBy, having, orderBy);
				String[] columns = new String[]{"id", "number", "name", "department", "grade"};
				Cursor cursor = dbManager.getSelect(columns, null, null, null, null, null);
				// where조건절이 있다면
				//Cursor cursor = dbManager.getSelect(columns, number='20170630'", null, null, null, null);

				//조건절이 여러개 있다면
				//Cursor cursor = dbManager.getSelect(columns, number='20170630'", "여따가 써준다는데 어떻게?", null, null, null);

				displayDBdata.setText("");

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
