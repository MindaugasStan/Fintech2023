package com.example.fintech2023;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvMain;
    Button btnChangeMainText;
    Button btnChangeMainTextColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvMain = findViewById(R.id.tvMain);
        this.btnChangeMainText = findViewById(R.id.btnChangeMainText);
        this.btnChangeMainTextColor = findViewById(R.id.btnChangeMainTextColor);

        btnChangeMainText.setOnClickListener(v -> tvMain.setText("Text was changed!"));
        btnChangeMainTextColor.setOnClickListener(v -> tvMain.setTextColor(Color.RED));
    }
}