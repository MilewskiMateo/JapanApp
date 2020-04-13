package com.example.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class GuessItActivity extends AppCompatActivity {
    ImageView imgSign;
    Button answer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_it);

        answer1= findViewById(R.id.btAnswer1);
        imgSign = findViewById(R.id.imgSign);
        imgSign.setImageResource(R.drawable.ba);
        imgSign.getLayoutParams().height = 500;
        imgSign.getLayoutParams().width = 500;

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


    }

}
