package com.example.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DrawItActivity extends AppCompatActivity {

    private TextView tvSign, tvDrawIt;
    private Button btDone;
    private PaintView paintView;
    String actualWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_it);

        paintView = (PaintView) findViewById(R.id.paintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);

        tvSign=findViewById(R.id.tvSign);
        tvDrawIt=findViewById(R.id.tvDrawIt);
        btDone=findViewById(R.id.btDone);

        String signSystem = getIntent().getStringExtra("system");

        switch (signSystem) {
            case "hiragana":
                actualWord = RandomWordPicker.getOneRandomHiraKataWord();
                tvDrawIt.setText(R.string.hiragana );
                tvSign.setText(actualWord);
                break;
            case "katakana":
                actualWord = RandomWordPicker.getOneRandomHiraKataWord();
                tvDrawIt.setText(R.string.katakana);
                tvSign.setText(actualWord);
                break;
            case "kanji":
                actualWord = RandomWordPicker.getOneRandomKanjiWord();
                tvDrawIt.setText(R.string.kanji);
                tvSign.setText(actualWord);
                break;
        }


        btDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.clear();

                switch (signSystem) {
                    case "hiragana":
                        actualWord = RandomWordPicker.getOneRandomHiraKataWord();
                        tvSign.setText(actualWord);

                        break;
                    case "katakana":

                        actualWord = RandomWordPicker.getOneRandomHiraKataWord();
                        tvSign.setText(actualWord);
                        break;
                    case "kanji":

                        actualWord = RandomWordPicker.getOneRandomKanjiWord();
                        tvSign.setText(actualWord);
                        break;
                }
            }
        });
    }
}
