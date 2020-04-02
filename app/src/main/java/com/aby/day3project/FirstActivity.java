package com.aby.day3project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private Button btnNext;
    private EditText edtName;
    private TextView txtResult;
    private ImageButton imageButton;
    public static int REQUEST_FEATURE = 100;

    @Override
    protected void onStart() {
        super.onStart();
        btnNext.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.background));

        btnNext = findViewById(R.id.btnNext);
        edtName = findViewById(R.id.edtName);
        txtResult = findViewById(R.id.txtResult);
        imageButton = findViewById(R.id.imgbtnVerify);
        btnNext.setVisibility(View.INVISIBLE);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String verification = edtName.getText().toString().trim();
            if (verification.contains(" ")){
                txtResult.setText(R.string.valid_entry);
                btnNext.setVisibility(View.VISIBLE);
            }
            else {
                txtResult.setText(R.string.invalid_entry);
                btnNext.setVisibility(View.INVISIBLE);
            }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtName.getText().toString().isEmpty())
                {
                    edtName.setError("Enter Name");
                }
                else {
                    String name = edtName.getText().toString();
                    Intent mIntent = new Intent(FirstActivity.this, OptionsActivity.class);
                    mIntent.putExtra("Name", name);
                    startActivityForResult(mIntent, REQUEST_FEATURE);
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            if(requestCode == REQUEST_FEATURE && data != null)
            {
                String finalString = data.getStringExtra("finalString");
                txtResult.setText(finalString);
            }
            else {
                txtResult.setText(R.string.no_val_received);
            }
        }
    }
}
