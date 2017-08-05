package com.alsh.from0to9.DB;

import java.util.List;

/**
 * Created by User on 2017-07-05.
 */

public interface IDBHelper {
  public void addResult(Result result);
  public Result getResult(int id);
   public List<Result> getAllResults();
  // public int getContactsCount();
  // public int updateContact(Contact contact);
  // public void deleteContact(Contact contact);
  public void deleteAll();
}
