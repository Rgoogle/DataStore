package com.baiyu.datastore;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditActivity extends AppCompatActivity implements View.OnClickListener{
    Button saveButton;
    Button cancelButton;
    File file;

    EditText editTextContext;
    EditText editTextTittle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_editor);

        saveButton=findViewById(R.id.btn_save);
        editTextContext=findViewById(R.id.et_content);
        editTextTittle=findViewById(R.id.et_title);
        saveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                saveContext();
                break;
        }
    }

    private void saveContext() {
        file=getExternalFilesDir("");
        File fileTxt=new File(file.toString()+"/text.txt");

        if (!fileTxt.exists() ) {
            try {
                fileTxt.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        try {
            FileWriter fileWriter=new FileWriter(fileTxt);

            fileWriter.write( editTextContext.getText().toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
