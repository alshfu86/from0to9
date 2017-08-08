package com.alsh.from0to9;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alsh.from0to9.Model.Model;
import com.alsh.from0to9.ViewModel.View2Model;
import com.alsh.from0to9.databinding.ActivityMain2Binding;


public class Main2Activity extends AppCompatActivity {
  Model model;
  @Override

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMain2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
    binding.setModel(new View2Model());
    this.model=Model.getInstance();
    model.setSilent(false);
    model.setVibration(false);
    model.setMySilentImage(this);

  }

  // Метод обработки нажатия на кнопку

  public void buttonClickFunction(View v)
  {
    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    intent.putExtra("typeOfGame", "from0to9");
    startActivity(intent);
  }

  public void exit(View v)
  {
    onStop();
  }

  public void support(View v)
  {
    Intent intent = new Intent(getApplicationContext(), Main5Activity.class);
    startActivity(intent);
  }

  public void result(View v)
  {
    Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
    startActivity(intent);
  }

  public void random(View v)
  {
    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    intent.putExtra("typeOfGame", "random");
    startActivity(intent);
  }




  @Override
  protected void onStop() {
    super.onStop();
    this.finish();
  }


}

