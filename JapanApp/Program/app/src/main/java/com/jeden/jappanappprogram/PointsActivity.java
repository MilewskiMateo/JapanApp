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


public class PointsActivity extends AppCompatActivity {

    private TextView tvPointsText, tvPointsValue, tvCongratulations;
    private Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_points);

        tvPointsText = findViewById(R.id.tvPointsText);
        tvPointsValue = findViewById(R.id.tvPointsValue);
        tvCongratulations = findViewById(R.id.tvCongratulation);
        btBack = findViewById(R.id.btBack);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "freeJapaneseFont.ttf");
        tvCongratulations.setTypeface(typeface);
        tvPointsValue.setTypeface(typeface);
        tvPointsText.setTypeface(typeface);
        btBack.setTypeface(typeface);


        int points = getIntent().getIntExtra("points", 0);
        tvPointsValue.setText(String.valueOf(points));

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(PointsActivity.this, com.jeden.jappanappprogram.MainActivity.class);
                startActivity(goBack);
            }
        });
    }
}
