package com.example.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class GuessItActivity extends AppCompatActivity {
    ImageView imgSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_it);

        imgSign = findViewById(R.id.imgSign);
        imgSign.setImageResource(R.drawable.ba);
        imgSign.getLayoutParams().height = 500;
        imgSign.getLayoutParams().width = 500;
    }
}
