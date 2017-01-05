package com.example.administrator.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jay on 2016/12/23.
 */
public class FragmentAdapter extends FragmentPagerAdapter{
    private List<Fragment> list_fragment;
    private List<String> list_title;

    public FragmentAdapter(FragmentManager fm,List<Fragment>list_fragment,List<String> list_title){
        super(fm);
        this.list_fragment = list_fragment;
        this.list_title = list_title;
    }

    @Override
    public Fragment getItem(int i){
        return list_fragment.get(i);
    }

    @Override
    public int getCount(){
        return list_fragment.size();
    }

    /**
     * 此方法是给tablayout中的tab赋值的，就是显示名称
     * ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return list_title.get(position % list_title.size());
    }
}
