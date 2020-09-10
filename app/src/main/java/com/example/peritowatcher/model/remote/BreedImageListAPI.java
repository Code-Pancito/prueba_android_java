package com.example.peritowatcher.model.remote;

import com.example.peritowatcher.model.pojo.BreedImageList;
import com.example.peritowatcher.model.pojo.BreedList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BreedImageListAPI {
    @GET("breed/{breed}/images")
    Call<BreedImageList> getBreedImageList(@Path("breed") String breed);
}
