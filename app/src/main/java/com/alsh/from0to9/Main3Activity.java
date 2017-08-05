package com.alsh.from0to9;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.alsh.from0to9.DB.DBHelper;
import com.alsh.from0to9.DB.Result;

import java.util.List;

public class Main3Activity extends AppCompatActivity {
  private Cursor mCursor;
  private SimpleCursorAdapter mCursorAd;
  private ListView mLv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main3);

    DBHelper db = new DBHelper(this);

    mCursor = db.getAllItems();

    String[] from = new String[] { DBHelper.KEY_TIME, DBHelper.KEY_SOURCE };
    int[] to = new int[] { R.id.tvName, R.id.tvEmail };

    mCursorAd = new SimpleCursorAdapter(this, R.layout.item, mCursor, from, to, 0);
    mLv = (ListView) findViewById(R.id.lv);
    mLv.setAdapter(mCursorAd);

    db.close();




  }

  @Override
  protected void onStop() {
    super.onStop();
    this.finish();
  }

  @Override
  public void onBackPressed() {
    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
    startActivity(intent);
    onStop();
  }


}
