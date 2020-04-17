package com.example.jappanappprogram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

public class GuessItActivity extends AppCompatActivity {
    ImageView imgSign;
    Button answer1,answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_it);

        answer1= findViewById(R.id.btAnswer1);
        answer4= findViewById(R.id.btAnswer4);
        imgSign = findViewById(R.id.imgSign);
        imgSign.setImageResource(R.drawable.ba);
        imgSign.getLayoutParams().height = 500;
        imgSign.getLayoutParams().width = 500;

        final WordViewModel mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                answer4.setText(words.get(words.size()-1).getWord());


            }
        });

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word slowo = new Word("slowo");
                mWordViewModel.insert(slowo);


            }
        });


    }

}
