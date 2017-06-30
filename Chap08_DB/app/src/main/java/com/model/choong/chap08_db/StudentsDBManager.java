/*
 * DB매니저 객체는 싱글턴(Singleton)으로 구현
 */

package com.model.choong.chap08_db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class StudentsDBManager{
	private static StudentsDBManager dbManager;
	private SQLiteDatabase database;

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
		);	// 안드로이드에서는 세미콜론을 붙인다.
	}	// constructor StudentsDBManager(){}

	public static StudentsDBManager getInstance(Context context){
		if(dbManager == null){
			dbManager = new StudentsDBManager(context);
		}

		return dbManager;
	}	// getInstance(Context)

	public void insert(){
		database.execSQL(
			"INSERT INTO " + TABLE_STUDENTS + "(" +
				"ID, NUMBER, NAME, DEPARTMENT, GRADE" +
			")VALUES(NULL, '20170630', '홍길동', '컴퓨터공학과', 2);"
		);
	}	// insert()

	public void select(){
		//	"SELECT * FROM" + TABLE_STUDENTS + ";"
	}
}
