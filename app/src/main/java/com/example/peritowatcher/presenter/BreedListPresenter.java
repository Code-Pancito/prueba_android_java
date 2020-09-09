package com.example.peritowatcher.presenter;

import android.util.Log;

import com.example.peritowatcher.contract.BreedListContract;
import com.example.peritowatcher.model.BreedListModel;

import java.util.List;

public class BreedListPresenter implements BreedListContract.Presenter, BreedListContract.Model.OnFinishedListener{

    private String tag = "BreedListPresenter";

    private BreedListContract.View view;
    private BreedListContract.Model model;

    public BreedListPresenter(BreedListContract.View view) {
        this.view = view;
        this.model = new BreedListModel();
    }

    @Override
    public void requestBreedList() {
        model.getBreedList(this);
    }

    @Override
    public void onFinished(List<String> breedList) {
        if(view != null)
            view.showBreedList(breedList);
    }

    @Override
    public void onFailure(Throwable t) {
        if(view != null)
            view.showFailure(t);
    }
}
