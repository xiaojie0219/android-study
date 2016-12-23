package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 此adpter是在一个fragment中切换不同的view，好处是在一个activity中可以取得所有view中的值
 * Created by jay on 2016/12/23.
 */
public class ViewAdapter extends PagerAdapter{
    private List<View> list_view;
    private List<String> list_title;
    private int[] tabImg;
    private Context context;

    public ViewAdapter(Context context,List<View> list_view,List<String> list_title,int[] tabImg){
        this.list_view = list_view;
        this.list_title = list_title;
        this.tabImg = tabImg;
        this.context = context;
    }
    @Override
    public int getCount(){
        return list_view.size();
    }
    @Override
    public boolean isViewFromObject(View view,Object object){
        return view == object;
    }
    @Override
    public Object instantiateItem(ViewGroup container,int position){
        ((ViewPager)container).addView(list_view.get(position),0);
        return list_view.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        ((ViewPager) container).removeView(list_view.get(position));
    }
    /**
     * 此方法是给TabLayout中的tab赋值的，就是显示名称,并且给其添加icon的图标
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position){
        //这段被注的代码，是只显示文字，不显示图标
        //return  list_Title.get(position % list_Title.size());

        Drawable dImage = context.getResources().getDrawable(tabImg[position], null);
        dImage.setBounds(0, 0, dImage.getIntrinsicWidth(), dImage.getIntrinsicHeight());
        //这里前面加的空格就是为图片显示
        SpannableString sp = new SpannableString("  "+ list_title.get(position));
        ImageSpan imageSpan = new ImageSpan(dImage, ImageSpan.ALIGN_BOTTOM);
        sp.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return  sp;
    }
}
