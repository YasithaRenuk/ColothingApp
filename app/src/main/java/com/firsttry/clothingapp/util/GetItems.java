package com.firsttry.clothingapp.util;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.firsttry.clothingapp.model.Item;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class GetItems {

    private FirebaseFirestore firestore;

    public GetItems() {
        firestore = FirebaseFirestore.getInstance();
    }

    public CompletableFuture<List<Item>> getData(String category) {
        CompletableFuture<List<Item>> future = new CompletableFuture<>();
        List<Item> data = new ArrayList<>();

        firestore.collection(category) // Update this based on your Firestore structure
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map<String, Object> itemMap = document.getData();
                                String color, description, img, material, name, price;

                                color = itemMap.get("Color").toString();
                                description = itemMap.get("Description").toString();
                                img = itemMap.get("Img").toString();
                                material = itemMap.get("Material").toString();
                                name = itemMap.get("Name").toString();
                                price = itemMap.get("Price").toString();

                                data.add(new Item(color, description, img, material, name, price));
                            }
                            future.complete(data);
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                            future.completeExceptionally(task.getException());
                        }
                    }
                });

        return future;
    }
}
