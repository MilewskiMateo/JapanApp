package com.example.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btDraw,btGuess,btCredits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btDraw=findViewById(R.id.btDraw);
        btGuess=findViewById(R.id.btGuess);
        btCredits=findViewById(R.id.btCredits);

        btDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drawIntent= new Intent(MainActivity.this,com.example.jappanappprogram.SystemChoiceActivity.class);
                drawIntent.putExtra("mode","draw");
                startActivity(drawIntent);
            }
        });
        btGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent guessIntent = new Intent(MainActivity.this, com.example.jappanappprogram.SystemChoiceActivity.class);
                guessIntent.putExtra("mode", "guess");
                startActivity(guessIntent);

            }
        });
        btCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creditsIntent = new Intent(MainActivity.this, com.example.jappanappprogram.CreditsActivity.class);
                startActivity(creditsIntent);
            }
        });
    }
}
