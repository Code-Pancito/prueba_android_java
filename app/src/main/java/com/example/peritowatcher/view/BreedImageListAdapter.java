package com.example.peritowatcher.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peritowatcher.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BreedImageListAdapter extends RecyclerView.Adapter<BreedImageListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageViewBreedImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewBreedImage = itemView.findViewById(R.id.imageView_BreedImage);
        }
    }

    private List<String> breedImageList;

    public BreedImageListAdapter(List<String> breedImageList){
        this.breedImageList = breedImageList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_breed_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String data = breedImageList.get(position);

        Picasso.get().load(data).into(holder.imageViewBreedImage);
    }

    @Override
    public int getItemCount() {
        return breedImageList.size();
    }

}
