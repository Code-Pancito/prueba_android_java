package com.example.peritowatcher.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peritowatcher.R;

import java.util.List;

public class BreedListAdapter extends RecyclerView.Adapter<BreedListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewBreed;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewBreed = itemView.findViewById(R.id.textView_Breed);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onBreedClickListener.onBreedClick(breedList.get(getAdapterPosition()));
        }
    }

    private List<String> breedList;
    private OnBreedClickListener onBreedClickListener;

    public BreedListAdapter(List<String> breedList, OnBreedClickListener onBreedClickListener) {
        this.breedList = breedList;
        this.onBreedClickListener = onBreedClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_breed, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String data = breedList.get(position);
        holder.textViewBreed.setText(data);
    }

    @Override
    public int getItemCount() {
        return breedList.size();
    }

    public interface OnBreedClickListener {
        void onBreedClick(String breed);
    }

}