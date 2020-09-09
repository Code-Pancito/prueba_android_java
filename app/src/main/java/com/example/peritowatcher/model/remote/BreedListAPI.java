package com.example.peritowatcher.model.remote;

import com.example.peritowatcher.model.pojo.BreedList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BreedListAPI {
    @GET("breeds/list")
    Call<BreedList> getBreedList();
}
