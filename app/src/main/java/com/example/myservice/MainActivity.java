package com.example.myservice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
String[] i1={""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);
        Spinner spinner = (Spinner) findViewById(R.id.fu_hao);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String[] autoInfo = getResources().getStringArray(R.array.fu_hao);
                i1[0] = autoInfo[pos];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callbac
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText t1=findViewById(R.id.text1);
                EditText t2=findViewById(R.id.text2);
                String s1=t1.getText().toString();
                String s2=t2.getText().toString();
                String f=i1[0];
                Intent intent=new Intent(MainActivity.this,MyService.class);
                intent.putExtra("num1", s1);
                intent.putExtra("num2", s2);
                intent.putExtra("fu_hao",f);
                startService(intent);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MyService.class);
                stopService(intent);
            }
        });
    }
}