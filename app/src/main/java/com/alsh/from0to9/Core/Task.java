package com.alsh.from0to9.Core;
import android.content.Context;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibrary;
import android.gesture.Prediction;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.alsh.from0to9.DB.DBHelper;
import com.alsh.from0to9.DB.Result;
import com.alsh.from0to9.Main2Activity;
import com.alsh.from0to9.MainActivity;
import com.alsh.from0to9.Model.Model;
import com.alsh.from0to9.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by User on 005 05.03.17.
 */

public class Task {
  private Context applicationContext;

  public Task() {
  }

  public static Task getInstance() {
    return ourInstance;
  }

  private static final Task ourInstance = new Task();

  Model model;
  Gesture gesture;
  GestureLibrary mGestureLib;
  String gestureName;
  Context context;
  MediaPlayer mediaPlayer = new MediaPlayer();
  Uri path;
  Vibrator v;
  DBHelper db;
  int ran;
  boolean goToNext;
  boolean random;
  boolean finish;
  public boolean isFinish() {
    return finish;
  }

  public void setFinish(boolean finish) {
    this.finish = finish;
  }

  public DBHelper getDb() {
    db = new DBHelper(context);
    return db;
  }
  public boolean isGoToNext() {
    return goToNext;
  }


  public void setGoToNext(boolean goToNext) {
    this.goToNext = goToNext;
  }
  public void setRan(int ran) {
    this.ran = ran;
  }
  public boolean isRandom() {
    return random;
  }
  public void setRandom(boolean random) {
    this.random = random;
  }
  public void setPath(int i) {
    path = Uri.parse("android.resource://com.alsh.from0to9/" + i);
  }
  public void setContext(Context context) {
    this.context = context;
    v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
  }
  public void setGestureName(String gestureName) {
    this.gestureName = gestureName;
  }
  public void setmGestureLib(GestureLibrary mGestureLib) {
    this.mGestureLib = mGestureLib;
  }
  public void SetGesture(Gesture gesture) {
    this.gesture = gesture;
  }
  public void cheacker() {
    Handler handler = new Handler();
    ArrayList<Prediction> predictions = mGestureLib.recognize(gesture);
    this.model = Model.getInstance();
    model.setIsVisibilityImage(true);
    switch (model.getI()) {

      case -2:
        gameOver(handler, true, R.drawable.game_over_fel, "", false);
        break;
      case 10:
        gameOver(handler, true, R.drawable.game_over_bra, "", false);
        break;
      default:
        if (predictions.size() > 0) {
          Prediction prediction = predictions.get(0);
          if (prediction.score > 1.0) {
            if (prediction.name.equals(gestureName)) {
              model.setIplus();
              this.setGoToNext(true);
              gameOver(handler, false, R.drawable.bra, "Good Job", true);
            } else if (!prediction.name.equals(gestureName)) {
              this.setGoToNext(false);
              model.setIminus();
              gameOver(handler, false, R.drawable.fel, "Wrong !!!", false);

            }
          }
        }
        break;

    }

  }

  private void gameOver(Handler handler, boolean isGameOver, int drawRes, String message, boolean right) {
    model.setResult(message);
    model.setMyImage(ContextCompat.getDrawable(context, drawRes));
    model.setIsVisibility(false);

    if (isGameOver == true) {
      if (drawRes == R.drawable.game_over_fel) {
        if (model.isVibration()) {
          v.vibrate(5000);
        }
        setPath(R.raw.ru_fel_game_over);
        mediaPlayer();
      }
      getDb().addResult(new Result("", Integer.toString(model.getI())));
      this.setFinish(true);
      model.setI(0);

      handler.postDelayed(new Runnable() {
        @Override
        public void run() {
          Intent intent = new Intent(context, Main2Activity.class);
          context.startActivity(intent);
        }

      }, 5000);


    } else {


        Log.d("CDA", Boolean.toString(isFinish()));
        isRight(right);
        taskTimer(handler, 3000);
        this.setFinish(false);


    }

  }
  private void isRight(boolean b) {
    if (b == true) {
      setPath(R.raw.ru_bra);
      mediaPlayer();
    } else {
      setPath(R.raw.ru_fel);
      mediaPlayer();
      if (model.isVibration()) {
        v.vibrate(1000);
      }
    }
  }
  private void taskTimer(Handler handler, int time) {
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        model.setIsVisibility(true);
        if (!isFinish()) {
          tasker();
        }
      }

    }, time);
  }
  public void tasker() {
    Random generator = new Random();
    if (isRandom()==true) {
      ran = generator.nextInt(10);
      //model.setIsVisibilityImage(false);
    }
    this.model = Model.getInstance();
    if (this.isGoToNext()) {
      ran++;
    }
    switch (ran) {
      case 1:
        if(isRandom()==true){model.setIsVisibilityImage(false);}
        game("Write 1", ContextCompat.getDrawable(context, R.drawable.en), "en", R.raw.ru_en);
        break;
      case 2:
        if(isRandom()==true){model.setIsVisibilityImage(false);}
        game("Write 2", ContextCompat.getDrawable(context, R.drawable.tva), "tva", R.raw.ru_tva);
        break;
      case 3:
        if(isRandom()==true){model.setIsVisibilityImage(false);}
        game("Write 3", ContextCompat.getDrawable(context, R.drawable.tre), "tre", R.raw.ru_tre);
        break;
      case 4:
        if(isRandom()==true){model.setIsVisibilityImage(false);}
        game("Write 4", ContextCompat.getDrawable(context, R.drawable.fyra), "fyra", R.raw.ru_fyra);
        break;
      case 5:
        if(isRandom()==true){model.setIsVisibilityImage(false);}
        game("Write 5", ContextCompat.getDrawable(context, R.drawable.fem), "fem", R.raw.ru_fem);
        break;
      case 6:
        if(isRandom()==true){model.setIsVisibilityImage(false);}
        game("Write 6", ContextCompat.getDrawable(context, R.drawable.sex), "sex", R.raw.ru_sex);
        break;
      case 7:
        if(isRandom()==true){model.setIsVisibilityImage(false);}
        game("Write 7", ContextCompat.getDrawable(context, R.drawable.sju), "sju", R.raw.ru_sju);
        break;
      case 8:
        game("Write 8", ContextCompat.getDrawable(context, R.drawable.atta), "atta", R.raw.ru_atta);
        break;
      case 9:
        if(isRandom()==true){model.setIsVisibilityImage(false);}
        game("Write 9", ContextCompat.getDrawable(context, R.drawable.nio), "nio", R.raw.ru_nio);
        break;
      default:
        if(isRandom()==true){model.setIsVisibilityImage(false);}
        game("Write 0", ContextCompat.getDrawable(context, R.drawable.noll), "noll", R.raw.ru_noll);
        break;
    }
    if (ran == 10) {
      ran = 0;
    }

  }
  private void game(String t, Drawable drawable, String en, int en2) {
    model.setTask(t);
    model.setMyImage(drawable);
    setGestureName(en);
    setPath(en2);
    mediaPlayer();
  }
  private void mediaPlayer() {
    if (model.isSilent()) {
      mediaPlayer.stop();
      mediaPlayer.reset();
      try {
        mediaPlayer.setDataSource(context, path);
        mediaPlayer.prepare();
        mediaPlayer.start();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


  }

}
