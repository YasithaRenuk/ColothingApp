package com.firsttry.clothingapp.secondPages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.firsttry.clothingapp.R;
import com.firsttry.clothingapp.ShowCaseActivity;

public class MenActivity extends AppCompatActivity {

    ImageButton btFormal,btSports,btShoes;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_men);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btFormal = findViewById(R.id.btformal_wear);
        btShoes = findViewById(R.id.btShoes);
        btSports = findViewById(R.id.btSports_wear);

        intent = new Intent(this, ShowCaseActivity.class);

        btFormal.setOnClickListener(v->{
            intent.putExtra("category","Men_Formal_Wear");
            startActivity(intent);
        });

        btSports.setOnClickListener(v->{
            intent.putExtra("category","Men_Sports_Wear");
            startActivity(intent);
        });

        btShoes.setOnClickListener(v->{
            intent.putExtra("category","Men_Shoes");
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