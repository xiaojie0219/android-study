package com.example.administrator.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;

/**
 * Created by jay on 2016/11/18.
 */
public class HomeFragment extends Fragment {

    /**
     * 显示指定的视图
     * @inflater     resource ID，指明了当前的Fragment对应的资源文件
     * @container    该Fragment在Activity中的父容器控件
     * @savedInstanceState 是否连接该布局和其父容器控件，在这里的情况设置为false，因为系统已经插入了这个布局到父控件，设置为true将会产生多余的一个View Group。
     * 当Fragment被加入Activity中时，它会处在对应的View Group中。

    　　Fragment有两种加载方式：一种是在Activity的layout中使用标签<fragment>声明；另一种方法是在代码中把它加入到一个指定的ViewGroup中。

    　　另外，Fragment它可以并不是Activity布局中的任何一部分，它可以是一个不可见的部分。
     */
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

}
