package com.jeden.jappanappprogram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btDraw, btGuess, btCredits;
    private TextView tvTitle;
    ConstraintLayout mainLayout;
    private WordViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        getWindow().setFormat(PixelFormat.RGBA_8888);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);

        mainLayout = findViewById(R.id.mainLayout);
        btDraw = findViewById(R.id.btDraw);
        btGuess = findViewById(R.id.btGuess);
        btCredits = findViewById(R.id.btCredits);
        tvTitle = findViewById(R.id.tvTitle);

        mainLayout.getBackground().setDither(true);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "freeJapaneseFont.ttf");
        btCredits.setTypeface(typeface);
        btGuess.setTypeface(typeface);
        btDraw.setTypeface(typeface);
        tvTitle.setTypeface(typeface);


        btDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drawIntent = new Intent(MainActivity.this, com.jeden.jappanappprogram.SystemChoiceActivity.class);
                drawIntent.putExtra("mode", "draw");
                startActivity(drawIntent);
            }
        });
        btGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent guessIntent = new Intent(MainActivity.this, com.jeden.jappanappprogram.SystemChoiceActivity.class);
                guessIntent.putExtra("mode", "guess");
                startActivity(guessIntent);

            }
        });
        btCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creditsIntent = new Intent(MainActivity.this, com.jeden.jappanappprogram.CreditsActivity.class);
                startActivity(creditsIntent);

            }
        });
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
}
