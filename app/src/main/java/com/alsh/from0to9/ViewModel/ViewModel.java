package com.alsh.from0to9.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.BindingConversion;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.alsh.from0to9.MainActivity;
import com.alsh.from0to9.Model.Model;

/**
 * Created by User on 005 05.03.17.
 */

public class ViewModel extends BaseObservable {
  Model model;
  boolean silent;
  public ViewModel(MainActivity mainActivity){
    this.model=Model.getInstance();
  }

  public ObservableField<String> task() {
    return model.getTask();
  }

  public ObservableField<String> result() {
    return model.getResult();
  }

  public ObservableField<String> sorce() {
    return model.getSorce();
  }

  public ObservableField<Drawable> myImage(){
    return model.getMyImage();
  }
  public ObservableInt rattingBar(){
    return model.getRattingBarValue();
  }

  //  @BindingConversion
  public ObservableBoolean isVisibility(){
    return model.getIsVisibility();
  }

  //  @BindingConversion
  public ObservableBoolean isVisibilityImage(){
    return model.getIsVisibilityImage();
  }




  @BindingConversion
  public static int convertBooleanToVisibility(ObservableBoolean visible) {
    return visible.get() ? View.VISIBLE : View.GONE;
  }
}
