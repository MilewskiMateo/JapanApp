package com.example.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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


    }
}
