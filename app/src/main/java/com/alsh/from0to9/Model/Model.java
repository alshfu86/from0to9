package com.alsh.from0to9.Model;

/**
 * Created by User on 2017-07-04.
 */

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ProgressBar;

import com.alsh.from0to9.R;

/**
 * Created by User on 005 05.03.17.
 */

public class Model {

  private static final Model ourInstance = new Model();
 Context context;
  public static Model getInstance() {
    return ourInstance;
  }

  private Model() {}

  int i;

  public int getI() {
    return i;
  }

  boolean silent;
  public boolean isSilent() {
    return silent;
  }
  public void setSilent(boolean b) {
    silent = b;
  }

  boolean vibration;
  public boolean isVibration() {
    return vibration;
  }
  public void setVibration(boolean b) {
    vibration = b;
  }


  ObservableField<String> task = new ObservableField<>();
  ObservableField<String> result = new ObservableField<>();
  ObservableField<String> sorce = new ObservableField<>();

  ObservableField<Drawable> myImage = new ObservableField<>();
  public ObservableField<Drawable> getMyImage() {
    return myImage;
  }
  public void setMyImage(Drawable drawable) {
    myImage.set(drawable);
  }

  ObservableField<Drawable> mySilentImage = new ObservableField<>();
  public ObservableField<Drawable> getMySilentImage() {
    return mySilentImage;
  }
  public void setMySilentImage(Context context) {
    mySilentImage.set(ContextCompat.getDrawable(context, R.drawable.toggle_on));
  }







  ObservableInt rattingBarValue = new ObservableInt();

  ObservableBoolean isVisibility = new ObservableBoolean();

  ObservableBoolean isVisibilityImage = new ObservableBoolean();





  public void setI(int i) {
    this.i = i;
  }

  public ObservableInt getRattingBarValue() {
    return rattingBarValue;
  }

  public void setRattingBarValue() {
    rattingBarValue.set(i);
  }



  public void setTask(String t) {
    task.set(t);
  }

  public void setResult(String r) {
    result.set(r);
  }

  public void setSorce() {
    sorce.set(Integer.toString(i));
  }

  public ObservableField<String> getTask() {
    return task;
  }

  public ObservableField<String> getResult() {
    return result;
  }

  public ObservableField<String> getSorce() {
    return sorce;
  }

  public void setIplus() {
    i++;
    setSorce();
    setRattingBarValue();
  }

  public void setIminus() {
    i--;
    setSorce();
    setRattingBarValue();
  }

  public ObservableBoolean getIsVisibility() {
    return isVisibility;
  }
  public ObservableBoolean getIsVisibilityImage() {
    return isVisibilityImage;
  }

  public void setIsVisibility(boolean b) {
    isVisibility.set(b);
  }

  public void setIsVisibilityImage(boolean b) {
    isVisibilityImage.set(b);
  }
}

