package com.aby.day3project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {

    private EditText edtName;
    private Button btnUppercase;
    private Button btnLowercase;
    private Button btnReverse;
    private Button btnFirst;
    private Button btnFirstName;
    private Button btnCount;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itemAdd:
                Toast.makeText(getApplicationContext(), "Item Add Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemCancel:
                Toast.makeText(getApplicationContext(), "Item Cancel", Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemGoback:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
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
        btnFirstName = findViewById(R.id.btnFirstName);
        btnCount = findViewById(R.id.btnCount);

        edtName = findViewById(R.id.edtName);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("Name");
            edtName.setText(value);
        }

        btnUppercase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Are you sure?");
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
                builder.setTitle("Are you sure?");
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
                builder.setTitle("Are you sure?");
                builder.setMessage("CONFIRM ACTION: GET LENGTH?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int finalString = edtName.getText().toString().length();
                        Intent mIntent = new Intent();
                        mIntent.putExtra("finalString", "NAME LENGTH: " +  finalString);
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
                builder.setTitle("Are you sure?");
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
        btnFirstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Are you sure?");
                builder.setMessage("CONFIRM ACTION: GET FIRST NAME?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String finalString = getFirstName(edtName.getText().toString());
                        Intent mIntent = new Intent();
                        mIntent.putExtra("finalString", "FIRST NAME IS: " + finalString);
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
            btnCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    builder.setTitle("Are you sure?");
                    builder.setMessage("CONFIRM ACTION: GET NUMBER OF WORDS?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Integer finalString = getCount(edtName.getText().toString());
                            Intent mIntent = new Intent();
                            mIntent.putExtra("finalString", "NUMBER OF WORDS: " + finalString);
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

    private String getFirstName(String name){
        if(name.contains(" ")) {
            int firstSpace = name.indexOf(" ");
            return name.substring(0, firstSpace);
        }
        else {
            return name;
        }
    }

    private String reverseString(String someText) {
        String output = "";
        for (int i = someText.length() - 1; i >= 0; i--) {
            output = output + someText.charAt(i);
        }
        return output;
    }
     private Integer getCount(String name){
        int count = 0;
        String[] splitString = name.split(" ");
        count = splitString.length;
        return count;
     }
}
