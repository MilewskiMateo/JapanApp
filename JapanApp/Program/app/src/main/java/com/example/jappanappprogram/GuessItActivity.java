package com.example.jappanappprogram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.lang.reflect.Field;
import java.util.List;

public class GuessItActivity extends AppCompatActivity {
    private ImageView imgSign;
    private Button answer1, answer2, answer3, answer4;
    private TextView tvSystemSign;
    private LottieAnimationView redLottieAnimation;
    private WordViewModel mWordViewModel = null;

    private String rightAnswer;
    private Boolean isAnswerPicked = false;
    private int numberOfCyclesAlreadyDoneIt,desiredNumberOfCycles, points;
    private String signSystem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_it);

        redLottieAnimation= findViewById(R.id.LottieRedAnimation);
        tvSystemSign = findViewById(R.id.tvSystemSign);
        answer1 = findViewById(R.id.btAnswer1);
        answer2 = findViewById(R.id.btAnswer2);
        answer3 = findViewById(R.id.btAnswer3);
        answer4 = findViewById(R.id.btAnswer4);
        imgSign = findViewById(R.id.imgSign);


        signSystem = getIntent().getStringExtra("system");
        desiredNumberOfCycles = getIntent().getIntExtra("cycles",20);

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);

        imgSign.getLayoutParams().height = 500;
        imgSign.getLayoutParams().width = 500;

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

                    //System.out.println("rightAnswer=" + rightAnswer);


                    if (signSystem.equals("hiragana")) {
                        imgSign.setImageResource(getResId("hira_" + rightAnswer, R.drawable.class));
                    } else if (signSystem.equals("katakana")) {
                        imgSign.setImageResource(getResId("kata_" + rightAnswer, R.drawable.class));
                    } else if (signSystem.equals("kanji")) {
                        imgSign.setImageResource(getResId("kanji_" + rightAnswer, R.drawable.class));
                    }
                    redLottieAnimation.playAnimation();
                }

            }
        });


        imgSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOfCyclesAlreadyDoneIt == desiredNumberOfCycles){
                    Intent guessIntent = new Intent(GuessItActivity.this, com.example.jappanappprogram.PointsActivity.class);
                    guessIntent.putExtra("points",points);
                    startActivity(guessIntent);
                }else {


                    mWordViewModel.deleteAll();
                    if (signSystem.equals("hiragana") || signSystem.equals("katakana")) {
                        for (int i = 0; i < 7; i++) {

                            Word toInsert = new Word(RandomWordPicker.getOneRandomHiraKataWord());
                            //System.out.println(toInsert.getWord());
                            mWordViewModel.insert(toInsert);

                        }
                    } else if (signSystem.equals("kanji")) {
                        for (int i = 0; i < 7; i++) {

                            Word toInsert = new Word(RandomWordPicker.getOneRandomKanjiWord());
                           // System.out.println(toInsert.getWord());
                            mWordViewModel.insert(toInsert);
                        }
                    }

                    answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    isAnswerPicked = false;
                }
            }
        });


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAnswerPicked) {
                    if (answer1.getText() == rightAnswer) {
                        answer1.setBackgroundColor(getResources().getColor(R.color.colorRightAnswer));
                        points++;
                    } else {
                        answer1.setBackgroundColor(getResources().getColor(R.color.colorWrongAnswer));
                        makeGreenRightAnswer();
                    }
                    isAnswerPicked=true;
                    numberOfCyclesAlreadyDoneIt++;
                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAnswerPicked) {

                    if (answer2.getText() == rightAnswer) {
                        answer2.setBackgroundColor(getResources().getColor(R.color.colorRightAnswer));
                        points++;
                    } else {
                        answer2.setBackgroundColor(getResources().getColor(R.color.colorWrongAnswer));
                        makeGreenRightAnswer();
                    }
                    isAnswerPicked=true;
                    numberOfCyclesAlreadyDoneIt++;
                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAnswerPicked) {
                    if (answer3.getText() == rightAnswer) {
                        answer3.setBackgroundColor(getResources().getColor(R.color.colorRightAnswer));
                        points++;
                    } else {
                        answer3.setBackgroundColor(getResources().getColor(R.color.colorWrongAnswer));
                        makeGreenRightAnswer();
                    }
                    isAnswerPicked = true;
                    numberOfCyclesAlreadyDoneIt++;
                }
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAnswerPicked) {
                    if (answer4.getText() == rightAnswer) {
                        answer4.setBackgroundColor(getResources().getColor(R.color.colorRightAnswer));
                        points++;
                    } else {
                        answer4.setBackgroundColor(getResources().getColor(R.color.colorWrongAnswer));
                        makeGreenRightAnswer();
                    }
                    isAnswerPicked = true;
                    numberOfCyclesAlreadyDoneIt++;
                }
            }
        });
    }



    public void makeGreenRightAnswer(){

        if (answer1.getText()==rightAnswer){
            answer1.setBackgroundColor(getResources().getColor(R.color.colorRightAnswer));
        }else if(answer2.getText()==rightAnswer) {
            answer2.setBackgroundColor(getResources().getColor(R.color.colorRightAnswer));
        }else if(answer3.getText()==rightAnswer){
            answer3.setBackgroundColor(getResources().getColor(R.color.colorRightAnswer));
        }else if(answer4.getText()==rightAnswer){
            answer4.setBackgroundColor(getResources().getColor(R.color.colorRightAnswer));
        }
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











