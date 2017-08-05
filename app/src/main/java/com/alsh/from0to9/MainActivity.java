package com.alsh.from0to9;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import android.util.Log;

import com.alsh.from0to9.Core.Task;
import com.alsh.from0to9.Model.Model;
import com.alsh.from0to9.ViewModel.ViewModel;
import com.alsh.from0to9.databinding.ContentMainBinding;


public class MainActivity extends Activity implements GestureOverlayView.OnGesturePerformedListener {

  private static final Object TAG = "LOG";
  private GestureLibrary mGestureLib;
  Task task;
  Model model;



  @RequiresApi(api = Build.VERSION_CODES.N)
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    String typeOfGame = intent.getStringExtra("typeOfGame");
    ContentMainBinding binding = DataBindingUtil.setContentView(this, R.layout.content_main);
    binding.setModel(new ViewModel(this));


    mGestureLib = GestureLibraries.fromRawResource(this, R.raw.gestures);
    if (!mGestureLib.load()) {}
    GestureOverlayView gestures = (GestureOverlayView) findViewById(R.id.gestures);
    gestures.addOnGesturePerformedListener(this);
    this.task = Task.getInstance();
    this.model = Model.getInstance();
    //Log.d((String) TAG, typeOfGame);
    if (typeOfGame.equals("random")) {
      Log.d((String) TAG, typeOfGame + " RANDOM");
      task.setRandom(true);
      model.setIsVisibilityImage(false);
    } else if (typeOfGame.equals("from0to9")) {
      Log.d((String) TAG, typeOfGame + " From0To9");
      task.setRandom(false);
      model.setIsVisibilityImage(true);
    }
    model.setIsVisibility(true);
    model.setI(0);
    model.setRattingBarValue();
    task.setContext(this);
    task.setmGestureLib(mGestureLib);
    task.setRan(0);
    task.setFinish(false);
    task.tasker();
    Log.d((String) TAG, "IM hire");
  }

  @RequiresApi(api = Build.VERSION_CODES.N)
  public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
    task.SetGesture(gesture);
    task.cheacker();
  }

  @Override
  protected void onStop() {
    super.onStop();
    super.onDestroy();
    this.finish();
  }

  @Override
  public void onBackPressed() {
    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
    startActivity(intent);
    task.setFinish(true);
    Log.d("CDA", "onBackPressed Called");
    onStop();
  }


  @RequiresApi(api = Build.VERSION_CODES.N)
  private void refreshActivity() {

  }

}
