package com.example.peritowatcher.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.peritowatcher.R;
import com.example.peritowatcher.contract.BreedListContract;
import com.example.peritowatcher.presenter.BreedListPresenter;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BreedListContract.View{

    private String tag = "MainActivity";

    private BreedListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new BreedListPresenter(this);

        presenter.requestBreedList();
    }

    @Override
    public void showBreedList(List<String> breedList) {
        Log.d(tag, "BreedList - size: " + breedList.size() + " breed: " + breedList.get(0));
    }

    @Override
    public void showFailure(Throwable t) {
        Log.d(tag, Objects.requireNonNull(t.getMessage()));
    }

}