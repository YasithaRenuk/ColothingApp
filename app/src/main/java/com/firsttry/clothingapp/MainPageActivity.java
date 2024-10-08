package com.firsttry.clothingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.firsttry.clothingapp.secondPages.KidsActivity;
import com.firsttry.clothingapp.secondPages.MenActivity;
import com.firsttry.clothingapp.secondPages.WomenActivity;

public class MainPageActivity extends AppCompatActivity {

    ImageButton btwoman,btmen,btkids;
    Intent intentwoman,intentmen,intentkids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);

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
    public void animateButton(View view) {
        view.animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .alpha(0.5f)
                .setDuration(100)
                .withEndAction(() -> view.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .alpha(1f)
                        .setDuration(100));
    }
}