package com.example.jappanappprogram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btDraw,btGuess,btCredits;
    private TextView tvTitle;

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private WordViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        btDraw=findViewById(R.id.btDraw);
        btGuess=findViewById(R.id.btGuess);
        btCredits=findViewById(R.id.btCredits);
        tvTitle=findViewById(R.id.tvTitle);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "freeJapaneseFont.ttf");
        btCredits.setTypeface(typeface);
        btGuess.setTypeface(typeface);
        btDraw.setTypeface(typeface);
        tvTitle.setTypeface(typeface);



        // Get a new or existing ViewModel from the ViewModelProvider.
        final WordViewModel mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                // Update the cached copy of the words in the adapter.
                

            }
        });



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
