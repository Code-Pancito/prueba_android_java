package com.example.peritowatcher.model;

import com.example.peritowatcher.contract.BreedListContract;
import com.example.peritowatcher.model.pojo.BreedList;
import com.example.peritowatcher.model.remote.BreedListAPI;
import com.example.peritowatcher.model.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("ALL")
public class BreedListModel implements BreedListContract.Model {

    @Override
    public void getBreedList(OnFinishedListener onFinishedListener) {
        BreedListAPI service = RetrofitClient.getRetrofitInstance().create(BreedListAPI.class);
        Call<BreedList> call = service.getBreedList();

        call.enqueue(new Callback<BreedList>() {
            @SuppressWarnings("NullableProblems")
            @Override
            public void onResponse(Call<BreedList> call, Response<BreedList> response) {
                List<String> breedList;
                if(response.body() != null)
                    breedList = response.body().getBreedList();
                else
                    breedList = new ArrayList<String>();
                onFinishedListener.onFinished(breedList);
            }

            @Override
            public void onFailure(Call<BreedList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
