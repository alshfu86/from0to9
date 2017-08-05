package com.alsh.from0to9.ViewModel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;

import com.alsh.from0to9.Model.Model;

/**
 * Created by User on 2017-07-09.
 */

public class View2Model extends BaseObservable {
  Model model;



  public View2Model() {
    this.model = Model.getInstance();
  }

  boolean silent;
  public void setSilent(boolean b){
    silent=b;
    model.setSilent(b);
  }
  public boolean isSilent() {
    return silent;
  }

  boolean vibration;
  public void setVibration(boolean b){
    silent=b;
    model.setVibration(b);
  }
  public boolean isVibration() {
    return silent;
  }

  public ObservableField<Drawable> mySilentImage(){
    return model.getMySilentImage();
  }

}
