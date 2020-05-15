package com.jeden.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class CreditsActivity extends AppCompatActivity {
    private TextView tvAuthor, tvMoreInfo, tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_credits);

        tvAuthor = findViewById(R.id.tvAuthor);
        tvMoreInfo = findViewById(R.id.tvMoreInfo);
        tvTitle = findViewById(R.id.tvTitle);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "freeJapaneseFont.ttf");
        tvMoreInfo.setTypeface(typeface);
        tvAuthor.setTypeface(typeface);
        tvTitle.setTypeface(typeface);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
}
