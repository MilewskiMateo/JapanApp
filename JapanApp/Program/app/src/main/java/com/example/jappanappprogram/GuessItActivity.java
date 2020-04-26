package com.example.jappanappprogram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class GuessItActivity extends AppCompatActivity {
    ImageView imgSign;
    Button answer1, answer2, answer3, answer4;
    TextView tvSystemSign;

    String rightAnswer;
    String signSystem;
    WordViewModel mWordViewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_it);

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);

        signSystem = getIntent().getStringExtra("system");
        answer1 = findViewById(R.id.btAnswer1);
        answer2 = findViewById(R.id.btAnswer2);
        answer3 = findViewById(R.id.btAnswer3);
        answer4 = findViewById(R.id.btAnswer4);

        imgSign = findViewById(R.id.imgSign);
        imgSign.getLayoutParams().height = 500;
        imgSign.getLayoutParams().width = 500;

        tvSystemSign = findViewById(R.id.tvSystemSign);

        if (signSystem.equals("hiragana")) {
            tvSystemSign.setText(R.string.hiragana);
        } else if (signSystem.equals("katakana")) {
            tvSystemSign.setText(R.string.katakana);
        } else if (signSystem.equals("kanji")) {
            tvSystemSign.setText(R.string.kanji);
        }


        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                if (words.size() > 3) {
                    answer1.setText(words.get(0).getWord());
                    answer2.setText(words.get(1).getWord());
                    answer3.setText(words.get(2).getWord());
                    answer4.setText(words.get(3).getWord());

                    int rand = (int) (Math.random() * 3 + 2) - 1;
                    rightAnswer = words.get(rand).getWord();

                    System.out.println("rightAnswer=" + rightAnswer);


                    if (signSystem.equals("hiragana")) {
                        imgSign.setImageResource(getResId("hira_" + rightAnswer, R.drawable.class));
                    } else if (signSystem.equals("katakana")) {
                        imgSign.setImageResource(getResId("kata_" + rightAnswer, R.drawable.class));
                    } else if (signSystem.equals("kanji")) {
                        imgSign.setImageResource(getResId("kanji_" + rightAnswer, R.drawable.class));

                    }
                }

            }
        });


        imgSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWordViewModel.deleteAll();
                if (signSystem.equals("hiragana") || signSystem.equals("katakana")) {
                    for (int i = 0; i < 9; i++) {

                        Word toInsert = new Word(getOneRandomHiraKataWord());
                        System.out.println(toInsert.getWord());
                        mWordViewModel.insert(toInsert);
                    }
                } else if (signSystem.equals("kanji")) {
                    for (int i = 0; i < 9; i++) {

                        Word toInsert = new Word(getOneRandomKanjiWord());
                        System.out.println(toInsert.getWord());
                        mWordViewModel.insert(toInsert);
                    }
                }

            }
        });


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText() == rightAnswer) {
                    System.out.println("eureka");
                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer2.getText() == rightAnswer) {
                    System.out.println("eureka");
                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer3.getText() == rightAnswer) {
                    System.out.println("eureka");
                }
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer4.getText() == rightAnswer) {
                    System.out.println("eureka");
                }
            }
        });
    }

    public String getOneRandomHiraKataWord() {

        List<String> hiragana = Arrays.asList("a", "i", "u", "e", "o", "ka", "ki", "ku", "ke", "ko");
        int max = 10;
        int min = 0;
        int rand = (int) (Math.random() * max - min + 1) + min - 1;
        return hiragana.get(rand);
    }

    public String getOneRandomKanjiWord() {

        List<String> hiragana = Arrays.asList("a", "i", "u", "e", "o", "ka", "ki", "ku", "ke", "ko");
        int max = 10;
        int min = 0;
        int rand = (int) (Math.random() * max - min + 1) + min - 1;
        return hiragana.get(rand);
    }


    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWordViewModel != null && mWordViewModel.getAllWords().hasObservers()) {
            mWordViewModel.getAllWords().removeObservers(this);
        }
        mWordViewModel.deleteAll();

    }
}











