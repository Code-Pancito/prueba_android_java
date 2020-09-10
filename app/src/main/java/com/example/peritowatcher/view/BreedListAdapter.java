package com.example.peritowatcher.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peritowatcher.R;

import java.util.List;

public class BreedListAdapter extends RecyclerView.Adapter<BreedListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public Button buttonBreed;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            buttonBreed = itemView.findViewById(R.id.button_Breed);
        }
    }

    private List<String> breedList;

    public BreedListAdapter(List<String> breedList){
        this.breedList = breedList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_breed, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String data = breedList.get(position);
        holder.buttonBreed.setText(data);
    }

    @Override
    public int getItemCount() {
        return breedList.size();
    }

}