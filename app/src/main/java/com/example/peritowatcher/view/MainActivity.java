package com.example.peritowatcher.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.peritowatcher.R;
import com.example.peritowatcher.contract.BreedListContract;
import com.example.peritowatcher.presenter.MainActivityPresenter;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BreedListContract.View{

    private String tag = "MainActivity";

    private MainActivityPresenter presenter;
    private Button buttonShowBreedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);
        buttonShowBreedList = findViewById(R.id.button_ShowBreedList);

        buttonShowBreedList.setOnClickListener(view -> presenter.requestBreedList());

    }

    @Override
    public void showBreedList(List<String> breedList) {
        Toast.makeText(this, "BreedList - size: " + breedList.size() + " breed: " + breedList.get(0), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailure(Throwable t) {
        Toast.makeText(this, Objects.requireNonNull(t.getMessage()), Toast.LENGTH_SHORT).show();
    }

}