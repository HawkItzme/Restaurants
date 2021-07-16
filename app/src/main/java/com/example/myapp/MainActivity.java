package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView restrologo;
EditText  etmail, etpass;
Button button;
    String mail;
    String pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restrologo = findViewById(R.id.restrologo);
        etmail = findViewById(R.id.etmail);
        etpass = findViewById(R.id.etpass);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail = etmail.getText().toString();
                pass = etpass.getText().toString();
                if (mail.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "PLEASE, ENTER THE CREDENTIALS!!", Toast.LENGTH_SHORT).show();
                }else {
                    if (mail.contains("@")) {
                        int indexOfAt = mail.indexOf('@');
                        String domain = mail.substring(indexOfAt+1);
                        String restOfString = mail.substring(0, indexOfAt);

                        if (restOfString.length() > 0 &&
                                (domain.equals("gmail.com") || domain.equals("yahoo.com") || domain.equals("yahoo.in"))) {
                    Intent intent = new Intent(MainActivity.this,  Secondscrn.class);
                    intent.putExtra("user_name", restOfString);
                    startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Check the order of the string!", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(MainActivity.this, "Please enter a valid email!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}