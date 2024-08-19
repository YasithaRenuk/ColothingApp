package com.firsttry.clothingapp.adapters;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.firsttry.clothingapp.R;
import com.firsttry.clothingapp.model.Item;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> data;
    private Context context;
    FirebaseStorage storageRef;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle,tvPrice;
        public ImageView ivImg;

        public ViewHolder(View view) {
            super(view);
            ivImg = view.findViewById(R.id.ivImg);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvPrice = view.findViewById(R.id.tvPrice);
        }
    }

    public ItemAdapter(Context context) {
        this.context = context;
        storageRef = FirebaseStorage.getInstance();
    }

    public void setData(List<Item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvTitle.setText(data.get(position).getName());
        holder.tvPrice.setText(data.get(position).getPrice());
        StorageReference gsReference = storageRef.getReferenceFromUrl(data.get(position).getImg());
        // Load the image into the ImageView using Glide
        gsReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Load the image using
                Glide.with(context)
                        .load(uri)
                        .into(holder.ivImg);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Log.w(TAG, "Error loading image", exception);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }
}
