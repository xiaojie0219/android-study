package com.example.administrator.myapplication.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;

/**
 * Created by jay on 2016/11/18.
 */
public class FragmentSetting extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        return  inflater.inflate(R.layout.flagment_setting,container,false);
    }
}
