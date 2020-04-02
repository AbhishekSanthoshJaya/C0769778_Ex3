package com.aby.day3project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    private Button btnFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        final AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);

        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.background));

        btnUppercase = findViewById(R.id.btnUppercase);
        btnLowercase = findViewById(R.id.btnLowercase);
        btnFirst = findViewById(R.id.btnFirst);
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
                builder.setMessage("CONFIRM ACTION: UPPERCASE?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String finalString = edtName.getText().toString().trim().toUpperCase();
                        Intent mIntent = new Intent();
                        mIntent.putExtra("finalString","UPPERCASE: " + finalString);
                        setResult(RESULT_OK, mIntent);
                        finish();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        btnLowercase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("CONFIRM ACTION: LOWERCASE?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String finalString = edtName.getText().toString().trim().toLowerCase();
                        Intent mIntent = new Intent();
                        mIntent.putExtra("finalString", "LOWERCASE: " + finalString);
                        setResult(RESULT_OK, mIntent);
                        finish();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("CONFIRM ACTION: GET LENGTH?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int finalString = edtName.getText().toString().length();
                        Intent mIntent = new Intent();
                        mIntent.putExtra("finalString", "NAME LENGTH " +  finalString);
                        setResult(RESULT_OK, mIntent);
                        finish();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
        btnReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("CONFIRM ACTION: REVERSE?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String finalString = reverseString(edtName.getText().toString());
                        Intent mIntent = new Intent();
                        mIntent.putExtra("finalString", "REVERSED: " + finalString);
                        setResult(RESULT_OK, mIntent);
                        finish();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
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
