package com.example.administrator.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.data.DBManager;
import com.example.administrator.myapplication.data.User;

/**
 * Created by jay on 2016/12/20.
 */
public class RegisterActivity extends Activity{
    private DBManager dbManager;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        dbManager = new DBManager(this);

        final EditText et_user = (EditText)findViewById(R.id.et_user);
        final EditText et_passwd = (EditText)findViewById(R.id.et_passwd);
        final EditText et_passwd2 = (EditText)findViewById(R.id.et_passwd2);
        Button button = (Button)findViewById(R.id.b_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(et_user.getEditableText()) ){
                    Toast.makeText(getApplicationContext(), "用户名不能为空",
                            Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(et_passwd.getEditableText()) ){
                    Toast.makeText(getApplicationContext(), "新密码不能为空",
                            Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(et_passwd2.getEditableText()) ) {
                    Toast.makeText(getApplicationContext(), "确认密码不能为空",
                            Toast.LENGTH_SHORT).show();
                }
                else if(et_passwd.getEditableText()== et_passwd2.getEditableText()) {
                    Toast.makeText(getApplicationContext(), "两次输入的密码不一致",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    User user = new User(et_user.getText().toString(),et_passwd.getText().toString());
                    dbManager.addUser(user);
                    Toast.makeText(getApplicationContext(), "注册成功",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);

            }
        }});
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        dbManager.closeDB();
        finish();
    }
}
