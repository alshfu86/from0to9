package com.alsh.from0to9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main4Activity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main4);
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
