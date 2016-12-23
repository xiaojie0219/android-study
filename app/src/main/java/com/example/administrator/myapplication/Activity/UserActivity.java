package com.example.administrator.myapplication.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.FragmentAdapter;
import com.example.administrator.myapplication.adapter.ViewAdapter;
import com.example.administrator.myapplication.data.User;
import com.example.administrator.myapplication.fragment.HomeFragment;
import com.example.administrator.myapplication.fragment.SettingFragment;
import com.example.administrator.myapplication.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay on 2016/11/17.
 */
public class UserActivity extends AppCompatActivity {
    private MediaPlayer backGroundMusic ;
    private TabLayout tab_title;
    private ViewPager vp_pager;

    private List<String> list_title;                                      //tab名称列表
    private List<View> list_view;
    private List<Fragment> list_fragment;

    private View homeView;                                                //定义主页页面
    private View settingView;                                               //定义设置页面
    private View userView;                                                 //定义用户页面

    private ViewAdapter vAdapter;                                         //定义以view为切换的adapter
    private FragmentAdapter fAdapter;                                     //定义以fragment为切换的adapter

    private HomeFragment homeFragment;
    private SettingFragment settingFragment;
    private UserFragment userFragment;
    private int[] tabImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        backGroundMusic.start();
        initControls();
        viewChanage();
        //fragmentChange();
    }
    /**
     * 初始化控件
     */
    private void initControls()
    {
        tab_title = (TabLayout)findViewById(R.id.sliding_tabs);
        vp_pager = (ViewPager)findViewById(R.id.viewpager);

        //为tabLayout上的图标赋值
        tabImg = new int[]{R.drawable.home,R.drawable.setting,R.drawable.user};
    }

    /**
     * 采用在viewpager中切换 view 的方式,并添加了icon的功能
     */
    private void viewChanage()
    {
        list_view = new ArrayList<>();
        LayoutInflater mInflater = getLayoutInflater();

        homeView = mInflater.inflate(R.layout.fragment_home, null);
        settingView = mInflater.inflate(R.layout.fragment_setting, null);
        userView = mInflater.inflate(R.layout.fragment_user, null);
        list_view.add(homeView);
        list_view.add(settingView);
        list_view.add(userView);

        list_title = new ArrayList<>();
        list_title.add("主页");
        list_title.add("设置");
        list_title.add("我的");

        //设置TabLayout的模式,这里主要是用来显示tab展示的情况的
        //TabLayout.MODE_FIXED          各tab平分整个工具栏,如果不设置，则默认就是这个值
        //TabLayout.MODE_SCROLLABLE     适用于多tab的，也就是有滚动条的，一行显示不下这些tab可以用这个
        //                              当然了，你要是想做点特别的，像知乎里就使用的这种效果
        tab_title.setTabMode(TabLayout.MODE_FIXED);

        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);

        //为TabLayout添加tab名称
        tab_title.addTab(tab_title.newTab().setText(list_title.get(0)));
        tab_title.addTab(tab_title.newTab().setText(list_title.get(1)));
        tab_title.addTab(tab_title.newTab().setText(list_title.get(2)));


        vAdapter = new ViewAdapter(this,list_view,list_title,tabImg);
        vp_pager.setAdapter(vAdapter);

        //将tabLayout与viewpager连起来
        tab_title.setupWithViewPager(vp_pager);
    }

    /**
     * 采用viewpager中切换fragment
     */
    private void fragmentChange()
    {
        list_fragment = new ArrayList<>();

        homeFragment = new HomeFragment();
        settingFragment = new SettingFragment();
        userFragment = new UserFragment();


        list_fragment.add(homeFragment);
        list_fragment.add(settingFragment);
        list_fragment.add(userFragment);

        list_title = new ArrayList<>();
        list_title.add("主页");
        list_title.add("设置");
        list_title.add("我的");

        fAdapter = new FragmentAdapter(getSupportFragmentManager(),list_fragment,list_title);
        vp_pager.setAdapter(fAdapter);

        //将tabLayout与viewpager连起来
        tab_title.setupWithViewPager(vp_pager);
    }



    /*
    private Menu menu = null;
    private static final int RED_MENU_ID = Menu.FIRST;
    private static final int GREEN_MENU_ID = Menu.FIRST + 1;
    private static final int BLUE_MENU_ID = Menu.FIRST +2 ;
*/
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        backGroundMusic = MediaPlayer.create(this, R.raw.oxygen);
        backGroundMusic.start();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentList fragmentList = new FragmentList();
        fragmentTransaction.add(R.id.frag_list,fragmentList);
        fragmentTransaction.commit();
    }
    */
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


    @Override
    protected void onDestroy(){
        super.onDestroy();
        backGroundMusic.stop();
        finish();
    }


}
