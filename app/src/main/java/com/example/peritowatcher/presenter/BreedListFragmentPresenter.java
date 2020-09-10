package com.example.peritowatcher.presenter;

import android.widget.Toast;

import com.example.peritowatcher.contract.BreedImageListContract;
import com.example.peritowatcher.model.BreedImageListModel;
import com.example.peritowatcher.view.BreedListFragment;

import java.util.List;

public class BreedListFragmentPresenter implements BreedImageListContract.Presenter, BreedImageListContract.Model.OnFinishedListener {

    private BreedImageListContract.Model model;
    private BreedListFragment view;

    public BreedListFragmentPresenter(BreedListFragment view) {
        this.view = view;
        this.model = new BreedImageListModel();
    }

    @Override
    public void requestBreedImageList(String breed) {
        model.getBreedImageList(breed, this);
    }

    @Override
    public void onFinished(List<String> breedImageList) {
        view.showBreedImageList(breedImageList);
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(view.getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
