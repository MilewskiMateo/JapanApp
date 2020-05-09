package com.example.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrawItActivity extends AppCompatActivity {

    private TextView tvSign, tvDrawIt;
    private Button btDone,btAddPoints;
    private PaintView paintView;
    private LinearLayout personDraw;
    String actualWord;
    Dialog popUpDialog;
    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_it);
        popUpDialog = new Dialog(this);

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

                showPopUpWindow();
                System.out.println(points);
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
    public void  showPopUpWindow(){
        popUpDialog.setContentView(R.layout.popup);
        btAddPoints= popUpDialog.findViewById(R.id.btAddPoints);
        personDraw = popUpDialog.findViewById(R.id.signThatPersonDraw);


        LayoutInflater inflater = getLayoutInflater();
        PaintView testing = new PaintView(this);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        testing.init(metrics);
        personDraw.addView(testing);




        btAddPoints.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                points++;
                popUpDialog.dismiss();
            }
        });
        popUpDialog.show();
    }

}



