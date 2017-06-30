/*
 * DB매니저 객체는 싱글턴(Singleton)으로 구현
 *     - 쓰레드 블럭을 사전에 차단하기 위함.
 *
 * CRUD를 구현하는 두가지 방법을 소개하고 있다.
 *     첫째, SQL명령문을 그대로 이용하기 - 익숙한 방법
 *     둘째, 안드로이드에서 제공하는 메소드 이용하기 - 범용적인 방법
 *
 */

package com.model.choong.chap08_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StudentsDBManager{
	private static StudentsDBManager dbManager;
	private SQLiteDatabase database;
	// 안드로이드에서 기본으로 제공하는 SQLite DB에 접근하기 위한 클래스.
	// 모든 안드로이드 운영체제에 하나씩 탑재되어 있는듯 하다.
	// 그러니 우리는 각자의 앱에서 각자의 계정을 만들어 접근하기만 하면 된다.

	// DB명, 테이블명, DB 버전 정보를 정의한다.
	static final String DB_STUDENTS = "Students.db";
	static final String TABLE_STUDENTS = "Students";
	static final int DB_VERSION = 1;

	private StudentsDBManager(Context context){
		database = context.openOrCreateDatabase(DB_STUDENTS, Context.MODE_PRIVATE, null);
		// DB_STUDENTS 라는 이름의 DB로 접속하되, 없는 DB라면 이 이름으로 생성하라.
		// Context.MODE_PRIVATE - 이 DB는 외부앱에서의 접근을 금한다.
		// (이외에도 MODE_WORLD_READABLE / MPDE_WORLD_WRITEABLE / MODE_ENABLE_WRITE_AHEAD_LOGGING 이 존재)
		// 마지막 인자는 CursorFactory - JDBC의 ResultSet과 동일한 역할.
		// DB에 접속할때부터 ResultSet을 할당할 필요는 없기에 그냥 null을 넣어주는 경우가 흔하다.

		// SQLite / MySQL에서 사용가능한 명령어 - ~ if not exists [TABLE_NAME] - 존재하면 놔두고, 없으면 ~하라.
		// AUTOINCREMENT 또한 여기서만 사용가능. - Sequence 기능(자동 숫자증가)
		database.execSQL(
			"CREATE TABLE IF NOT EXISTS " + TABLE_STUDENTS + "(" +
				"ID INTEGER PRIMARY KEY AUTOINCREMENT," +
				"NUMBER TEXT," +
				"NAME TEXT," +
				"DEPARTMENT TEXT," +
				"GRADE INTEGER" +
			");"
		);	// 안드로이드에서는 세미콜론을 붙여도 되고 안붙여도 된다.
	}	// constructor StudentsDBManager(){}

	public static StudentsDBManager getInstance(Context context){
		if(dbManager == null){
			dbManager = new StudentsDBManager(context);
		}

		return dbManager;
	}	// getInstance(Context)

	public long insert(ContentValues contentValues){

		//Insert하는 두가지 방법 - 1
		/*
		database.execSQL(
			"INSERT INTO " + TABLE_STUDENTS + " VALUES(NULL, '20170630', '홍길동', '컴퓨터공학과', 2);"
		);
		*/

		// Ctrl + Q = 도큐먼트 참조
		// Ctrl + P = 매개변수 타입 확인
		// Ctrl + Space = 자동완성 기능
		// Ctrl + Enter = 자동임포트 기능?

		//Insert하는 두가지 방법 - 2
		// contentValues엔 수정할 데이터들이 키 밸류 형식으로 담겨있다.
		return database.insert(TABLE_STUDENTS, null, contentValues);
	}	// insert()

	public Cursor getSelect(String[] columns, String selection, String[] selectionArgs,
				String groupBy, String having, String orderBy){

		Cursor cursor = null;
		cursor = database.query(TABLE_STUDENTS, columns, selection, selectionArgs, groupBy, having, orderBy);

		/*
		Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_STUDENTS + ";", null);
		*/
		return cursor;
	}	// select()

	//public void update(String number){
	public int update(ContentValues contentValues, String whereClause, String[] whereArgs){
		/*database.execSQL("UPDATE " + TABLE_STUDENTS + " SET NAME = '이순신' WHERE NUMBER = " + number + ";");*/

		//String table, android.content.ContentValues values, String whereClause, String[] whereArgs
		return database.update(TABLE_STUDENTS, contentValues, whereClause, whereArgs);

	}	// update()

	//public void delete(){
		/*
		database.execSQL("DELETE FROM " + TABLE_STUDENTS + ";");	// SQLite는 세미콜론을 붙여도 되고 안붙여도 된다.
		*/

	public int delete(String whereClause, String[] whereArgs){
		// 수정된 레코드 수 반환.
		return database.delete(TABLE_STUDENTS, whereClause, whereArgs);
	}	// delete()
}
