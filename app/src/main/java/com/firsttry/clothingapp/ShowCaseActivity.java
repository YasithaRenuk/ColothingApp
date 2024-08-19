package com.firsttry.clothingapp;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tvTitle = findViewById(R.id.tvTitle);
        Intent intent = getIntent();
        category = intent.getStringExtra("category");

        if(category == null || category == ""){
            finish();
        }

        tvTitle.setText(category);

        GetItems getItems = new GetItems();

        CompletableFuture<List<Item>> future = getItems.getData(category);

        future.thenAccept(itemList -> {
            adapter.setData(itemList);
        }).exceptionally(throwable -> {
            Log.w(TAG, "Error getting documents.");
            return null;
        });


    }
}