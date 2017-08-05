package com.alsh.from0to9.DB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 2017-07-05.
 */

public class Result {
  int _id;
  String _time;
  String _source;

  public Result(int i, String string, String cursorString){
  }
  public Result(){
  }
  public Result(int id, String source){
    this._id = id;
    this._time = getTime();
    this._source = source;
  }

  public Result(String time, String source){
    this._time = time;
    this._source = source;
  }

  public int getID(){
    return this._id;
  }

  public void setID(int id){
    this._id = id;
  }

  public String getSource(){
    return this._source;
  }

  public void setSource(String source){
    this._source = source;
  }

  public String getTime(){
    return this._time;
  }

  public void setTime(String time){
    this._time = time;
  }
}
