package com.example.administrator.myapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 2016/11/14.
 */
public class StudyActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_main);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);

        final EditText eText1 = (EditText)findViewById(R.id.etext1);
        final EditText eText2 = (EditText)findViewById(R.id.etext2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "重置成功",
                        Toast.LENGTH_SHORT).show();
                eText1.setText("");
                eText2.setText("");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(eText1.getEditableText()) ){
                    Toast.makeText(getApplicationContext(), "用户名不能为空",
                            Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(eText2.getEditableText()) ){
                    Toast.makeText(getApplicationContext(), "密码不能为空",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "登录成功",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(StudyActivity.this,MainActivity.class);
                    startActivity(intent);
//                    finish();
                }
            }
        });
    }
}
