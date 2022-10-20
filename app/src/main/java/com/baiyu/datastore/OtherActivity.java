package com.baiyu.datastore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OtherActivity extends AppCompatActivity implements View.OnClickListener{
    Button addButton;
    TextView textViewContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);

        addButton=findViewById(R.id.btn_add);
        addButton.setOnClickListener(this);
        textViewContext=findViewById(R.id.context);


        showContext();
    }

    private void showContext() {
        File file=getExternalFilesDir("");
        File fileTxt=new File(file.toString()+"/text.txt");
        try {
            FileReader fr = new FileReader(fileTxt);
            char[] buff=new char[1024];
            fr.read(buff);
            textViewContext.setText(buff.toString());
            System.out.println("hello:"+buff.toString());
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                writeToFile();
                break;
        }
    }



    void writeToFile(){


        startActivity(new Intent(this,EditActivity.class));



    }


}
