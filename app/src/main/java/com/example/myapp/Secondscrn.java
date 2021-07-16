package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Secondscrn extends AppCompatActivity {
    String res;
    Spinner spinner;
    Button button;
    TextView textview;
    TextView user;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondscrn);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        textview = findViewById(R.id.textView);
        Intent i = getIntent();
        username = i.getStringExtra("user_name");
        user.setText(username);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = "";
                String tastes = spinner.getSelectedItem().toString();

                switch (tastes) {
                    case "Mexican":
                        res = res + "Dominos\n" + "Pablo Escobar\n" + "Netflix";
                        break;
                    case "Italian":
                        res = res + "Alvi\n" + "Rome Palace\n" + "Rome Oberai\n" + "Julius Caesar Foods";
                        break;
                    case "Chinese":
                        res = res + "China Town\n" + "Ching Chang\n" + "Soupy Time";
                        break;
                    case "South Indian":
                        res = res + "Bawarchi\n" + "Mom's Dosa\n" + "Mandi House";
                        break;
                    case "North Indian":
                        res = res + "Moorthal\n" + "Kailash Da Dhaba\n" + "Parathe Wali Gali";
                        break;
                    case "Sea Food":
                        res = res + "Crab Town\n" + "Fish Fun\n" + "Whale Stadium";
                        break;
                    default:
                        Toast.makeText(Secondscrn.this, "No Restro Found!!", Toast.LENGTH_SHORT).show();
                        res = res + "That's right!";
                        break;
                }
                textview.setText(res);
            }
        });
    }


}