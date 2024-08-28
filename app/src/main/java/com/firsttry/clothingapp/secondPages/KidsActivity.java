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

public class KidsActivity extends AppCompatActivity {

    ImageButton btbags,btwatches,btbooks;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kids);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btbags = findViewById(R.id.btBags);
        btwatches = findViewById(R.id.btWatches);
        btbooks = findViewById(R.id.btBook);

        intent = new Intent(this, ShowCaseActivity.class);

        btbags.setOnClickListener(v->{
            intent.putExtra("category","Kids_Bags");
            startActivity(intent);
        });

        btwatches.setOnClickListener(v->{
            intent.putExtra("category","Kids_Watches");
            startActivity(intent);
        });

        btbooks.setOnClickListener(v->{
            intent.putExtra("category","Kids_Books");
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