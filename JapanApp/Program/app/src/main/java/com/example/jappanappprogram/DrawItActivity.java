package com.example.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.jappanappprogram.GuessItActivity.getResId;

public class DrawItActivity extends AppCompatActivity {

    private TextView tvSign, tvDrawIt,dialogTvSimilar;
    private Button btDone,btAddPoints,btDontAddPoints;
    private PaintView paintView;
    private String signSystem;
    private Typeface typeface;

    private String actualWord;
    private Dialog popUpDialog;
    private int numberOfCyclesAlreadyDoneIt,desiredNumberOfCycles,points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_draw_it);
        popUpDialog = new Dialog(this);

        paintView = (PaintView) findViewById(R.id.paintView);
        tvSign=findViewById(R.id.tvSign);
        tvDrawIt=findViewById(R.id.tvDrawIt);
        btDone=findViewById(R.id.btDone);


        typeface = Typeface.createFromAsset(getAssets(), "freeJapaneseFont.ttf");
        tvSign.setTypeface(typeface);
        tvDrawIt.setTypeface(typeface);
        btDone.setTypeface(typeface);




        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);

        desiredNumberOfCycles = getIntent().getIntExtra("cycles", 10);
        signSystem = getIntent().getStringExtra("system");

        switch (signSystem) {
            case "hiragana":
                actualWord = RandomWordPicker.getOneRandomHiraKataWord();
                tvDrawIt.setText(R.string.hiraganadwukropek);
                tvSign.setText(actualWord);

                break;
            case "katakana":
                actualWord = RandomWordPicker.getOneRandomHiraKataWord();
                tvDrawIt.setText(R.string.katakanadwukropek);
                tvSign.setText(actualWord);
                break;
            case "kanji":
                actualWord = RandomWordPicker.getOneRandomKanjiWord();
                tvDrawIt.setText(R.string.kanjidwukorpek);
                tvSign.setText(actualWord);
                break;
        }


        btDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfCyclesAlreadyDoneIt++;


                showPopUpWindow();
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

                paintView.clear();



            }
        });

    }
    public void  showPopUpWindow(){
        popUpDialog.setContentView(R.layout.popup);
        btAddPoints= popUpDialog.findViewById(R.id.btAddPoints);
        LinearLayout  personDraw = popUpDialog.findViewById(R.id.signThatPersonDraw);
        btDontAddPoints = popUpDialog.findViewById(R.id.btDontAddPoints);
        ImageView rightImage = popUpDialog.findViewById(R.id.imgRightImage);
        dialogTvSimilar = popUpDialog.findViewById(R.id.tvSimilar);

        btDontAddPoints.setTypeface(typeface);
        btAddPoints.setTypeface(typeface);
        dialogTvSimilar.setTypeface(typeface);

        if (signSystem.equals("hiragana")) {
            rightImage.setImageResource(getResId("hira_" + actualWord, R.drawable.class));
        } else if (signSystem.equals("katakana")) {
            rightImage.setImageResource(getResId("kata_" + actualWord, R.drawable.class));
        } else if (signSystem.equals("kanji")) {
            rightImage.setImageResource(getResId("kanji_" + actualWord, R.drawable.class));
        }

        // Converts 120 dip into its equivalent px
        int dip = 140;
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dip,
                r.getDisplayMetrics()
        );

        PopUpPaintView testing = new PopUpPaintView(this);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        testing.addBitmapAndPaint(paintView.getmBitmap(),paintView.getmPaint(),px ,px);
        personDraw.addView(testing);




        btAddPoints.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(numberOfCyclesAlreadyDoneIt == desiredNumberOfCycles){
                    Intent guessIntent = new Intent(DrawItActivity.this, com.example.jappanappprogram.PointsActivity.class);
                    guessIntent.putExtra("points",points);
                    startActivity(guessIntent);
                }
                points++;
                popUpDialog.dismiss();
            }
        });
        btDontAddPoints.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(numberOfCyclesAlreadyDoneIt == desiredNumberOfCycles){
                    Intent guessIntent = new Intent(DrawItActivity.this, com.example.jappanappprogram.PointsActivity.class);
                    guessIntent.putExtra("points",points);
                    startActivity(guessIntent);
                }
                popUpDialog.dismiss();
            }
        });

        popUpDialog.show();
    }

}



