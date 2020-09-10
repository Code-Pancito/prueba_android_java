package com.example.peritowatcher.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BreedImageList {

    private String status;
    @SerializedName("message")
    private List<String> breedImageList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getBreedImageList() {
        return breedImageList;
    }

    public void setBreedImageList(List<String> breedImageList) {
        this.breedImageList = breedImageList;
    }
}
