package com.example.peritowatcher.model;

import com.example.peritowatcher.contract.BreedImageListContract;
import com.example.peritowatcher.model.pojo.BreedImageList;
import com.example.peritowatcher.model.pojo.BreedList;
import com.example.peritowatcher.model.remote.BreedImageListAPI;
import com.example.peritowatcher.model.remote.BreedListAPI;
import com.example.peritowatcher.model.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("ALL")
public class BreedImageListModel implements BreedImageListContract.Model {

    @Override
    public void getBreedImageList(String breed, OnFinishedListener onFinishedListener) {
        BreedImageListAPI service = RetrofitClient.getRetrofitInstance().create(BreedImageListAPI.class);
        Call<BreedImageList> call = service.getBreedImageList(breed);

        call.enqueue(new Callback<BreedImageList>() {
            @Override
            public void onResponse(Call<BreedImageList> call, Response<BreedImageList> response) {
                List<String> breedImageList;
                if(response.body() != null)
                    breedImageList = response.body().getBreedImageList();
                else
                    breedImageList = new ArrayList<String>();

                onFinishedListener.onFinished(breedImageList);
            }

            @Override
            public void onFailure(Call<BreedImageList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
