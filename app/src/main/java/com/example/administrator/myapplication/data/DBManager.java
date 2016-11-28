package com.example.administrator.myapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojay on 2016/11/25.
 */
public class DBManager {
    private DBHelper helper;
    private SQLiteDatabase db;
    private List<User> userList = new ArrayList<User>();
    private User user = new User("jay","tiger");

    public DBManager(Context context){
        helper = new DBHelper(context);
        //因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);
        //所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
        db = helper.getWritableDatabase();
        userList.add(user);
        addUser(userList);
    }

    public void addUser(List<User> users){
        //开始事务
        db.beginTransaction();
        try{
            for (User user:users) {
                db.execSQL("INSERT INTO user VALUES(?,?)",new Object[]{user.getUserName(),user.getPassWd()});
            }
            //设置事务成功完成
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //结束事务
            db.endTransaction();
        }
    }
    public void closeDB(){
        db.close();
    }

}