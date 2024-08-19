package com.firsttry.clothingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.firsttry.clothingapp.secondPages.KidsActivity;
import com.firsttry.clothingapp.secondPages.MenActivity;
import com.firsttry.clothingapp.secondPages.WomenActivity;

public class MainPageActivity extends AppCompatActivity {

    Button btwoman,btmen,btkids;
    Intent intentwoman,intentmen,intentkids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btwoman = findViewById(R.id.btWomen);
        btmen = findViewById(R.id.btMen);
        btkids = findViewById(R.id.btKids);

        intentwoman = new Intent(this, WomenActivity.class);
        intentmen = new Intent(this, MenActivity.class);
        intentkids = new Intent(this, KidsActivity.class);

        btwoman.setOnClickListener(v->{
            startActivity(intentwoman);
        });

        btmen.setOnClickListener(v->{
            startActivity(intentmen);
        });

        btkids.setOnClickListener(v->{
            startActivity(intentkids);
        });

    }
}