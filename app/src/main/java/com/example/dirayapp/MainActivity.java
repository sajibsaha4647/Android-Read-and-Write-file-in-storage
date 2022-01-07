package com.example.dirayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editText = findViewById(R.id.editid);
        button = findViewById(R.id.buttonId);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text =editText.getText().toString();

                if (text.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Please enter some data",Toast.LENGTH_LONG).show();
                } else {
                    WriteFile(text);
                }
            }
        });

        readFromfile();

    }

    public  void WriteFile(String text){
        try {
            FileOutputStream fileOutputStream = openFileOutput("diry.text", Context.MODE_PRIVATE); //passing file mode and file name
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"Data seve successfull",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Log.d("Memory exceptions","exceptions"+e);
        }
    }

    public  void  readFromfile(){
        try {
            FileInputStream fileInputStream = openFileInput("diry.text");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuffer stringBuffer = new StringBuffer();

            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            editText.setText(stringBuffer.toString());

        }catch (Exception e){
            Log.d("Memory exceptions","exceptions"+e);
        }
    }
}