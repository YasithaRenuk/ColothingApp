package com.firsttry.clothingapp.secondPages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.firsttry.clothingapp.R;
import com.firsttry.clothingapp.ShowCaseActivity;

public class WomenActivity extends AppCompatActivity {

    ImageButton btCasual,btFormal,btParty;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_women);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btCasual = findViewById(R.id.btcasual_wear);
        btFormal = findViewById(R.id.btformal_wear);
        btParty = findViewById(R.id.btparty_wear);

        intent = new Intent(this, ShowCaseActivity.class);

        btFormal.setOnClickListener(v->{
            intent.putExtra("category","Women_Formal_Wear");
            startActivity(intent);
        });

        btCasual.setOnClickListener(v->{
            intent.putExtra("category","Women_Casual_Wear");
            startActivity(intent);
        });

        btParty.setOnClickListener(v->{
            intent.putExtra("category","Women_Party_Wear");
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