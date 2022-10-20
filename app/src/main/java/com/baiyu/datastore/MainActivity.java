package com.baiyu.datastore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText loginEditText;
    EditText passEditText;

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginEditText=findViewById(R.id.et_login);
        passEditText=findViewById(R.id.et_cancel);
        loginButton=findViewById(R.id.btn_login);

        loginButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                storeUserAndPassword();
                break;



        }
    }


    void storeUserAndPassword() {
        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("user", loginEditText.getText().toString());
        editor.putString("password", passEditText.getText().toString());

        editor.commit();
        Intent intent = new Intent(this, OtherActivity.class);
        intent.putExtra("zh",loginEditText.getText().toString());
        intent.putExtra("mm",passEditText.getText().toString());
        startActivity(intent);
    }

}