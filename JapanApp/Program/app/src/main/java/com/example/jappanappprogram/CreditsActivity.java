package com.example.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class CreditsActivity extends AppCompatActivity {
    private TextView tvAuthor, tvMoreInfo,tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        tvAuthor = findViewById(R.id.tvAuthor);
        tvMoreInfo = findViewById(R.id.tvMoreInfo);
        tvTitle = findViewById(R.id.tvTitle);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "freeJapaneseFont.ttf");
        tvMoreInfo.setTypeface(typeface);
        tvAuthor.setTypeface(typeface);
        tvTitle.setTypeface(typeface);
    }
}
