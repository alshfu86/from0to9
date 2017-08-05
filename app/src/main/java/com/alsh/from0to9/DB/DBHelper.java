package com.alsh.from0to9.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 2017-07-05.
 */

public class DBHelper extends SQLiteOpenHelper implements IDBHelper{

  public static final int    DATABASE_VERSION = 1;
  public static final String DATABASE_NAME = "game";
  public static final String TABLE_RESULT = "result";
  public static final String KEY_ID = "_id";
  public static final String KEY_TIME = "name";
  public static final String KEY_SOURCE = "source";



  public DBHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_RESULT + "("
      + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TIME + " TEXT,"
      + KEY_SOURCE + " TEXT" + ")";
    db.execSQL(CREATE_CONTACTS_TABLE);
  }


  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESULT);
    onCreate(db);
  }


  @Override
  public void addResult(Result result) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    DateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm:ss");
    Date date = new Date();
    System.out.println();
    String curentTime=dateFormat.format(date);
    values.put(KEY_TIME, curentTime);
    values.put(KEY_SOURCE, result.getSource());
    db.insert(TABLE_RESULT, null, values);
    db.close();
  }

  @Override
  public Result getResult(int id) {
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.query(TABLE_RESULT, new String[] { KEY_ID,
        KEY_TIME, KEY_SOURCE }, KEY_ID + "=?",
      new String[] { String.valueOf(id) }, null, null, null, null);

    if (cursor != null){
      cursor.moveToFirst();
    }
    Result contact = new Result(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
    return contact;
  }

  @Override
  public void deleteAll() {
    SQLiteDatabase db = this.getWritableDatabase();
    db.delete(TABLE_RESULT, null, null);
    db.close();
  }

  @Override
  public List<Result> getAllResults() {
    List<Result> contactList = new ArrayList<Result>();
    String selectQuery = "SELECT  * FROM " + TABLE_RESULT;

    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    if (cursor.moveToFirst()) {
      do {
        Result result = new Result();
        result.setID(Integer.parseInt(cursor.getString(0)));
        result.setTime(cursor.getString(1));
        result.setSource(cursor.getString(2));
        contactList.add(result);
      } while (cursor.moveToNext());
    }

    return contactList;
  }

  public Cursor getAllItems() {
    SQLiteDatabase db = this.getWritableDatabase();
    return db.query(TABLE_RESULT, null, null, null, null, null, null);
  }


}
