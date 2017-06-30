package com.model.choong.chap08_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/*
* SQLiteOpenHelper를 이용하면 혹시나 openOrCreateDatabase에 실패하더라도 처리할 수단이 존재한다.
* */
public class StudentsDBManager extends SQLiteOpenHelper{
	private static StudentsDBManager dbManager;

	// DB명, 테이블명, DB 버전 정보를 정의한다.
	static final String DB_STUDENTS = "Students.db";
	static final String TABLE_STUDENTS = "Students";
	static final int DB_VERSION = 3;	// 유지보수 과정에서 테이블 수정이 이루어졌다면 이 버전값만 기존보다 큰 숫자로 대체해주면 된다.

	private StudentsDBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
		super(context, name, factory, version);
	}

	@Override
	public void onOpen(SQLiteDatabase db){
		super.onOpen(db);
	}

	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL(
			"CREATE TABLE IF NOT EXISTS " + TABLE_STUDENTS + "(" +
				"ID INTEGER PRIMARY KEY AUTOINCREMENT," +
				"NUMBER TEXT," +
				"NAME TEXT," +
				"DEPARTMENT TEXT," +
				"AGE TEXT," +
				"GRADE INTEGER" +
			");"
		);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		// sqlHelper가 테이블을 체크하는 과정에서 onUpgrade를 호출한다.
		// 이때 아래 써준 로직대로 버전이 다르단게 확인되면 기존 테이블을 버리고 새로 생성한다.
		// 기존 레코드는 날아가니 주의.

		if(oldVersion < newVersion){
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);

			onCreate(db);
		}
	}

	public static StudentsDBManager getInstance(Context context){
		if(dbManager == null){
			dbManager = new StudentsDBManager(context, DB_STUDENTS, null, DB_VERSION);
		}

		return dbManager;
	}	// getInstance(Context)

	public long insert(ContentValues contentValues){
		return getWritableDatabase().insert(TABLE_STUDENTS, null, contentValues);
	}	// insert()

	public Cursor getSelect(String[] columns, String selection, String[] selectionArgs,
				String groupBy, String having, String orderBy){
		return getReadableDatabase().query(TABLE_STUDENTS, columns, selection, selectionArgs, groupBy, having, orderBy);
	}	// select()

	//public void update(String number){
	public int update(ContentValues contentValues, String whereClause, String[] whereArgs){
		return getWritableDatabase().update(TABLE_STUDENTS, contentValues, whereClause, whereArgs);

	}	// update()

	public int delete(String whereClause, String[] whereArgs){
		return getWritableDatabase().delete(TABLE_STUDENTS, whereClause, whereArgs);
	}	// delete()
}
