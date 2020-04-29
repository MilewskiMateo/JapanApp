package com.example.jappanappprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class PointsActivity extends AppCompatActivity {

    private TextView tvPointsText, tvPointsValue;
    private Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        tvPointsText=findViewById(R.id.tvPointsText);
        tvPointsValue=findViewById(R.id.tvPointsValue);
        btBack=findViewById(R.id.btBack);

        int points = getIntent().getIntExtra("points",0);
        tvPointsValue.setText(String.valueOf(points));
    }
}
