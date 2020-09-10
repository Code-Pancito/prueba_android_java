package com.example.peritowatcher.presenter;

import com.example.peritowatcher.contract.BreedListContract;
import com.example.peritowatcher.model.BreedListModel;

import java.util.List;

public class MainActivityPresenter implements BreedListContract.Presenter, BreedListContract.Model.OnFinishedListener{

    private String tag = "MainActivityPresenter";

    private BreedListContract.View view;
    private BreedListContract.Model model;

    public MainActivityPresenter(BreedListContract.View view) {
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
