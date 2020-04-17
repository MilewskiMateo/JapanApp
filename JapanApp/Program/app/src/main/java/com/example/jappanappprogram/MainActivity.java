package com.example.jappanappprogram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btDraw,btGuess,btCredits;

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private WordViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        // Get a new or existing ViewModel from the ViewModelProvider.
        final WordViewModel mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                // Update the cached copy of the words in the adapter.
                

            }
        });





        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.





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
