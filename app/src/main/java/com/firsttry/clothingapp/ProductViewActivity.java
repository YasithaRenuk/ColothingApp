package com.firsttry.clothingapp;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ProductViewActivity extends AppCompatActivity {

    String name,price,description,rating,img;
    TextView tvname,tvprice,tvdescription,tvrating;
    ImageView ivImg;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        price = intent.getStringExtra("Price");
        description = intent.getStringExtra("Description");
        rating = intent.getStringExtra("Rating");
        img = intent.getStringExtra("Img");
        if(name.equals("") || name == null || img.equals("") || img == null){
            finish();
        }

        tvname = findViewById(R.id.tvTitle);
        tvprice = findViewById(R.id.tvPrice);
        tvdescription = findViewById(R.id.tvDital);
        tvrating = findViewById(R.id.tvRating);
        ivImg = findViewById(R.id.ivImage);
        progressBar = findViewById(R.id.progressBar);

        tvname.setText(name);
        tvrating.setText(rating);
        tvdescription.setText(description);
        tvprice.setText(price);
        progressBar.setVisibility(View.VISIBLE);
        ivImg.setVisibility(View.GONE);

        FirebaseStorage storageRef = FirebaseStorage.getInstance();

        StorageReference gsReference = storageRef.getReferenceFromUrl(img);
        // Load the image into the ImageView using Glide
        gsReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Load the image using Glide with the correct context
                Glide.with(ProductViewActivity.this)
                        .load(uri)
                        .into(ivImg);
                progressBar.setVisibility(View.GONE);
                ivImg.setVisibility(View.VISIBLE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Log.w(TAG, "Error loading image", exception);
                progressBar.setVisibility(View.GONE);
            }
        });


    }
}