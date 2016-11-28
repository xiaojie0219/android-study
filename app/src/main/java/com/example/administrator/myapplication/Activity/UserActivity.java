package com.example.administrator.myapplication.Activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.myapplication.R;

/**
 * Created by jay on 2016/11/17.
 */
public class UserActivity extends Activity {


    /*
    private Menu menu = null;
    private static final int RED_MENU_ID = Menu.FIRST;
    private static final int GREEN_MENU_ID = Menu.FIRST + 1;
    private static final int BLUE_MENU_ID = Menu.FIRST +2 ;
*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);


/*
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentList fragmentList = new FragmentList();
        fragmentTransaction.add(R.id.frag_list,fragmentList);
        fragmentTransaction.commit();
*/

    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add(0, RED_MENU_ID, 0, R.string.red);
        menu.add(0, GREEN_MENU_ID, 0, R.string.green);
        menu.add(0,BLUE_MENU_ID,0,R.string.blue);
        this.menu = menu;
        return true;
    }
    */



}
