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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        btnUppercase = findViewById(R.id.btnUppercase);

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
                if(finalString.isEmpty())
                {
                    edtName.setError("Enter Country Name");
                }
                else
                {
                    Intent mIntent = new Intent();
                    mIntent.putExtra("finalString", finalString);
                    setResult(RESULT_OK, mIntent);
                    finish();
                }
            }
        });
    }
}
