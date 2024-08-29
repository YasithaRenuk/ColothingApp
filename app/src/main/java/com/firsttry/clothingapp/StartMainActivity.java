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

//Y.R. Widanapathirana AS2021913
//W.N.Thashenu Kularathna As2021983
//R K C C Thilakarathne AS2021910
//Nipun Samaranayaka AS2021923
//M.G. Sanoj vishwajith Kumara AS2021901

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