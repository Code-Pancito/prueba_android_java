package com.example.peritowatcher.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BreedList {

    private String status;
    @SerializedName("message")
    private List<String> breedList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getBreedList() {
        return breedList;
    }

    public void setBreedList(List<String> breedList) {
        this.breedList = breedList;
    }
}
