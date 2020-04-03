package com.example.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SystemChoiceActivity extends AppCompatActivity {
    Button btHiragana,btKatakana,btKanji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_choice);
        btHiragana=findViewById(R.id.btHiragana);
        btKatakana=findViewById(R.id.btKatakana);
        btKanji=findViewById(R.id.btKanji);

        btHiragana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mode= getIntent().getStringExtra("mode");
                if (mode.equals("draw")){
                    Intent hiragana= new Intent(SystemChoiceActivity.this, com.example.jappanappprogram.DrawItActivity.class);
                    hiragana.putExtra("system","hiragana");
                    startActivity(hiragana);
                }
                else if(mode.equals("guess")){
                    Intent hiragana = new Intent( SystemChoiceActivity.this, com.example.jappanappprogram.GuessItActivity.class);
                    hiragana.putExtra("system","hiragana");
                    startActivity(hiragana);
                }
            }
        });

        btKatakana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mode= getIntent().getStringExtra("mode");
                if (mode.equals("draw")){
                    Intent katakana= new Intent(SystemChoiceActivity.this, com.example.jappanappprogram.DrawItActivity.class);
                    katakana.putExtra("system","katakana");
                    startActivity(katakana);
                }
                else if(mode.equals("guess")){
                    Intent katakana = new Intent( SystemChoiceActivity.this, com.example.jappanappprogram.GuessItActivity.class);
                    katakana.putExtra("system","katakana");
                    startActivity(katakana);
                }
            }
        });
        btKanji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mode= getIntent().getStringExtra("mode");
                if (mode.equals("draw")){
                    Intent kanji= new Intent(SystemChoiceActivity.this, com.example.jappanappprogram.DrawItActivity.class);
                    kanji.putExtra("system","kanji");
                    startActivity(kanji);
                }
                else if(mode.equals("guess")){
                    Intent kanji = new Intent( SystemChoiceActivity.this, com.example.jappanappprogram.GuessItActivity.class);
                    kanji.putExtra("system","kanji");
                    startActivity(kanji);
                }
            }
        });
    }
}
