package com.jeden.jappanappprogram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.lang.reflect.Field;
import java.util.List;

public class GuessItActivity extends AppCompatActivity {
    private ImageView imgSign, katana1, katana2;
    private Button answer1, answer2, answer3, answer4;
    private TextView tvSystemSign;
    private LottieAnimationView redLottieAnimation;
    private WordViewModel mWordViewModel = null;

    private String rightAnswer;
    private Boolean isAnswerPicked = false;
    private Boolean blockRerol = false;
    private int numberOfCyclesAlreadyDoneIt, desiredNumberOfCycles, points;
    private String signSystem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guess_it);

        redLottieAnimation = findViewById(R.id.LottieRedAnimation);
        tvSystemSign = findViewById(R.id.tvSystemSign);
        answer1 = findViewById(R.id.btAnswer1);
        answer2 = findViewById(R.id.btAnswer2);
        answer3 = findViewById(R.id.btAnswer3);
        answer4 = findViewById(R.id.btAnswer4);
        imgSign = findViewById(R.id.imgSign);
        katana1 = findViewById(R.id.imageView3);
        katana2 = findViewById(R.id.imageView4);

        katana1.bringToFront();
        katana2.bringToFront();

        Typeface typeface = Typeface.createFromAsset(getAssets(), "freeJapaneseFont.ttf");
        answer1.setTypeface(typeface);
        answer2.setTypeface(typeface);
        answer3.setTypeface(typeface);
        answer4.setTypeface(typeface);
        tvSystemSign.setTypeface(typeface);


        signSystem = getIntent().getStringExtra("system");
        desiredNumberOfCycles = getIntent().getIntExtra("cycles", 20);

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);

        imgSign.getLayoutParams().height = 500;
        imgSign.getLayoutParams().width = 500;

        if (signSystem.equals("hiragana")) {
            tvSystemSign.setText(R.string.hiragana);
        } else if (signSystem.equals("katakana")) {
            tvSystemSign.setText(R.string.katakana);
        } else if (signSystem.equals("kanji")) {
            tvSystemSign.setText(R.string.kanji);
            answer1.setTextSize(20);
            answer1.setMinWidth(320);
            answer2.setTextSize(20);
            answer2.setMinWidth(320);
            answer3.setTextSize(20);
            answer3.setMinWidth(320);
            answer4.setTextSize(20);
            answer4.setMinWidth(320);
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
                        imgSign.setImageResource(getResId("ic_kanji_" + rightAnswer, R.drawable.class));
                    }
                    redLottieAnimation.playAnimation();
                }

            }
        });


        imgSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!blockRerol) {
                    if (numberOfCyclesAlreadyDoneIt == desiredNumberOfCycles) {
                        Intent guessIntent = new Intent(GuessItActivity.this, com.jeden.jappanappprogram.PointsActivity.class);
                        guessIntent.putExtra("points", points);
                        startActivity(guessIntent);
                        Animatoo.animateFade(GuessItActivity.this);
                    } else {


                        mWordViewModel.deleteAll();
                        if (signSystem.equals("hiragana") || signSystem.equals("katakana")) {
                            for (int i = 0; i < 7; i++) {

                                Word toInsert = new Word(RandomWordPicker.getOneRandomHiraKataWord());
                                mWordViewModel.insert(toInsert);

                            }
                        } else if (signSystem.equals("kanji")) {
                            for (int i = 0; i < 7; i++) {

                                Word toInsert = new Word(RandomWordPicker.getOneRandomKanjiWord());
                                mWordViewModel.insert(toInsert);
                            }
                        }

                        answer1.setBackground(getResources().getDrawable(R.drawable.button_shape));
                        answer2.setBackground(getResources().getDrawable(R.drawable.button_shape));
                        answer3.setBackground(getResources().getDrawable(R.drawable.button_shape));
                        answer4.setBackground(getResources().getDrawable(R.drawable.button_shape));
                        isAnswerPicked = false;
                    }
                }
                blockRerol = true;
            }
        });


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnswerPicked) {
                    if (answer1.getText() == rightAnswer) {
                        answer1.setBackground(getResources().getDrawable(R.drawable.yes_shape));
                        points++;
                    } else {
                        answer1.setBackground(getResources().getDrawable(R.drawable.no_shape));
                        makeGreenRightAnswer();
                    }
                    isAnswerPicked = true;
                    numberOfCyclesAlreadyDoneIt++;
                }
                blockRerol = false;
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnswerPicked) {

                    if (answer2.getText() == rightAnswer) {
                        answer2.setBackground(getResources().getDrawable(R.drawable.yes_shape));
                        points++;
                    } else {
                        answer2.setBackground(getResources().getDrawable(R.drawable.no_shape));
                        makeGreenRightAnswer();
                    }
                    isAnswerPicked = true;
                    numberOfCyclesAlreadyDoneIt++;
                }
                blockRerol = false;
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnswerPicked) {
                    if (answer3.getText() == rightAnswer) {
                        answer3.setBackground(getResources().getDrawable(R.drawable.yes_shape));
                        points++;
                    } else {
                        answer3.setBackground(getResources().getDrawable(R.drawable.no_shape));
                        makeGreenRightAnswer();
                    }
                    isAnswerPicked = true;
                    numberOfCyclesAlreadyDoneIt++;
                }
                blockRerol = false;
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnswerPicked) {
                    if (answer4.getText() == rightAnswer) {
                        answer4.setBackground(getResources().getDrawable(R.drawable.yes_shape));
                        points++;
                    } else {
                        answer4.setBackground(getResources().getDrawable(R.drawable.no_shape));
                        makeGreenRightAnswer();
                    }
                    isAnswerPicked = true;
                    numberOfCyclesAlreadyDoneIt++;
                }
                blockRerol = false;
            }
        });
        imgSign.performClick();

    }


    public void makeGreenRightAnswer() {

        if (answer1.getText() == rightAnswer) {
            answer1.setBackground(getResources().getDrawable(R.drawable.yes_shape));
        } else if (answer2.getText() == rightAnswer) {
            answer2.setBackground(getResources().getDrawable(R.drawable.yes_shape));
        } else if (answer3.getText() == rightAnswer) {
            answer3.setBackground(getResources().getDrawable(R.drawable.yes_shape));
        } else if (answer4.getText() == rightAnswer) {
            answer4.setBackground(getResources().getDrawable(R.drawable.yes_shape));
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











