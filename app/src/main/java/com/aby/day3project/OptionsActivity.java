package com.aby.day3project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OptionsActivity extends AppCompatActivity {

    private EditText edtName;
    private Button btnUppercase;
    private Button btnLowercase;
    private Button btnReverse;
    private Button btnLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        btnUppercase = findViewById(R.id.btnUppercase);
        btnLowercase = findViewById(R.id.btnLowercase);
        btnLength = findViewById(R.id.btnLength);
        btnReverse = findViewById(R.id.btnReverse);

        edtName = findViewById(R.id.edtName);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("Name");
            edtName.setText(value);
        }

        btnUppercase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalString = edtName.getText().toString().trim().toUpperCase();
                Intent mIntent = new Intent();
                mIntent.putExtra("finalString", finalString);
                setResult(RESULT_OK, mIntent);
                finish();

            }
        });

        btnLowercase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalString = edtName.getText().toString().trim().toLowerCase();
                Intent mIntent = new Intent();
                mIntent.putExtra("finalString", finalString);
                setResult(RESULT_OK, mIntent);
                finish();
            }
        });

        btnLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int finalString = edtName.getText().toString().length();
                Intent mIntent = new Intent();
                mIntent.putExtra("finalString", finalString);
                setResult(RESULT_OK, mIntent);
                finish();
            }
        });
        btnReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalString = reverseString(edtName.getText().toString());
                Intent mIntent = new Intent();
                mIntent.putExtra("finalString", finalString);
                setResult(RESULT_OK, mIntent);
                finish();
            }
        });

    }

    private String reverseString(String someText){
        String output = "";
        for (int i = someText.length() - 1; i >= 0; i--) {
            output = output + someText.charAt(i);
        }
        return output;
    }
}
