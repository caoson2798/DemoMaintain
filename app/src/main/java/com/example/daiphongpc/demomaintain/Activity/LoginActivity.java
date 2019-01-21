package com.example.daiphongpc.demomaintain.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.daiphongpc.demomaintain.MainActivity;
import com.example.daiphongpc.demomaintain.R;

public class LoginActivity extends AppCompatActivity {
    EditText editUserNumber,editPass;
    Button btnLogin;
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        adđControls();
        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void adđControls() {
        btnLogin=findViewById(R.id.btn_lgin);
        editUserNumber=findViewById(R.id.edit_user_number);
        editPass=findViewById(R.id.edit_pass);
        txtRegister=findViewById(R.id.txt_register);
    }
}
