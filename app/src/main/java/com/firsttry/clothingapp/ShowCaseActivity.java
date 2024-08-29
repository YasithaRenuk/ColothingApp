package com.firsttry.clothingapp;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firsttry.clothingapp.adapters.ItemAdapter;
import com.firsttry.clothingapp.model.Item;
import com.firsttry.clothingapp.util.GetItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ShowCaseActivity extends AppCompatActivity {

    TextView tvTitle;
    String category;
    private ItemAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_case);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        adapter = new ItemAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.rvItems);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        tvTitle = findViewById(R.id.tvTitle);
        progressBar = findViewById(R.id.progressBar);

        Intent intent = getIntent();
        category = intent.getStringExtra("category");

        if(category == null || category == ""){
            finish();
        }

        tvTitle.setText(category.replace("_"," ").toUpperCase());

        GetItems getItems = new GetItems();

        progressBar.setVisibility(View.VISIBLE);

        CompletableFuture<List<Item>> future = getItems.getData(category);

        future.thenAccept(itemList -> {
            // Hide ProgressBar and show RecyclerView once data is loaded
            runOnUiThread(() -> {
                adapter.setData(itemList);
                progressBar.setVisibility(View.GONE);
            });
        }).exceptionally(throwable -> {
            Log.w(TAG, "Error getting documents.");
            runOnUiThread(() -> {
                progressBar.setVisibility(View.GONE);
            });
            return null;
        });

    }
}