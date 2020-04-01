package com.aby.day3project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    private Button btnNext;
    private EditText edtName;
    public static int REQUEST_UPPERCASE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        edtName = findViewById(R.id.edtName);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                Intent mIntent = new Intent(FirstActivity.this, OptionsActivity.class);
                mIntent.putExtra("Name", name);
                startActivityForResult(mIntent, REQUEST_UPPERCASE);
            }
        });
    }
}
