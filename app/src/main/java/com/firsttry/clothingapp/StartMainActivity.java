package com.firsttry.clothingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartMainActivity extends AppCompatActivity {

    ImageButton BtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_main);

        BtnStart = findViewById(R.id.btnstart);
        BtnStart.setOnClickListener((v)->{
            Intent intent = new Intent(this, MainPageActivity.class);
            startActivity(intent);
        });
    }
}