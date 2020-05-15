package com.jeden.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.lukelorusso.verticalseekbar.VerticalSeekBar;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class SystemChoiceActivity extends AppCompatActivity {
    private Button btHiragana, btKatakana, btKanji;
    private VerticalSeekBar verticalSeekBar;
    private TextView tvCyclesNumber, tvTitle, tvChose, tvCyclesTxt;
    private final static int MAX_CYCLES_NUMBERS = 50;
    private int STARTING_SEEKBAR_VALUE = 10;
    private int currentSeekbarValue = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_system_choice);

        btHiragana = findViewById(R.id.btHiragana);
        btKatakana = findViewById(R.id.btKatakana);
        btKanji = findViewById(R.id.btKanji);
        tvCyclesNumber = findViewById(R.id.tvNumber);
        verticalSeekBar = findViewById(R.id.vskCyclesSwitcher);
        tvChose = findViewById(R.id.tvChose);
        tvTitle = findViewById(R.id.tvTitle);
        tvCyclesTxt = findViewById(R.id.tvCyclesTxt);


        verticalSeekBar.setMaxValue(MAX_CYCLES_NUMBERS);
        verticalSeekBar.setProgress(STARTING_SEEKBAR_VALUE);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "freeJapaneseFont.ttf");
        tvCyclesNumber.setTypeface(typeface);
        btHiragana.setTypeface(typeface);
        btKanji.setTypeface(typeface);
        btKatakana.setTypeface(typeface);
        tvChose.setTypeface(typeface);
        tvTitle.setTypeface(typeface);
        tvCyclesTxt.setTypeface(typeface);


        tvCyclesNumber.setText(String.valueOf(currentSeekbarValue));

        verticalSeekBar.setOnProgressChangeListener(
                new Function1<Integer, Unit>() {
                    @Override
                    public Unit invoke(Integer progressValue) {
                        tvCyclesNumber.setText(String.valueOf(progressValue));
                        currentSeekbarValue = progressValue;
                        return null;
                    }
                }
        );
        verticalSeekBar.setOnPressListener(
                new Function1<Integer, Unit>() {
                    @Override
                    public Unit invoke(Integer progressValue) {
                        tvCyclesNumber.setText(String.valueOf(progressValue));
                        currentSeekbarValue = progressValue;
                        return null;
                    }
                }
        );
        verticalSeekBar.setOnReleaseListener(
                new Function1<Integer, Unit>() {
                    @Override
                    public Unit invoke(Integer progressValue) {
                        tvCyclesNumber.setText(String.valueOf(progressValue));
                        currentSeekbarValue = progressValue;
                        return null;
                    }
                }
        );


        btHiragana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mode = getIntent().getStringExtra("mode");
                if (mode.equals("draw")) {
                    Intent hiragana = new Intent(SystemChoiceActivity.this, DrawItActivity.class);
                    hiragana.putExtra("system", "hiragana");
                    hiragana.putExtra("cycles", currentSeekbarValue);
                    startActivity(hiragana);
                } else if (mode.equals("guess")) {
                    Intent hiragana = new Intent(SystemChoiceActivity.this, GuessItActivity.class);
                    hiragana.putExtra("system", "hiragana");
                    hiragana.putExtra("cycles", currentSeekbarValue);
                    startActivity(hiragana);
                }
            }
        });

        btKatakana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mode = getIntent().getStringExtra("mode");
                if (mode.equals("draw")) {
                    Intent katakana = new Intent(SystemChoiceActivity.this, DrawItActivity.class);
                    katakana.putExtra("system", "katakana");
                    katakana.putExtra("cycles", currentSeekbarValue);
                    startActivity(katakana);
                } else if (mode.equals("guess")) {
                    Intent katakana = new Intent(SystemChoiceActivity.this, GuessItActivity.class);
                    katakana.putExtra("system", "katakana");
                    katakana.putExtra("cycles", currentSeekbarValue);
                    startActivity(katakana);
                }
            }
        });
        btKanji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mode = getIntent().getStringExtra("mode");
                if (mode.equals("draw")) {
                    Intent kanji = new Intent(SystemChoiceActivity.this, DrawItActivity.class);
                    kanji.putExtra("system", "kanji");
                    kanji.putExtra("cycles", currentSeekbarValue);
                    startActivity(kanji);
                } else if (mode.equals("guess")) {
                    Intent kanji = new Intent(SystemChoiceActivity.this, GuessItActivity.class);
                    kanji.putExtra("system", "kanji");
                    kanji.putExtra("cycles", currentSeekbarValue);
                    startActivity(kanji);
                }
            }
        });
    }
}
