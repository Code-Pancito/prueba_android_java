package com.example.peritowatcher.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.peritowatcher.R;
import com.example.peritowatcher.contract.BreedImageListContract;
import com.example.peritowatcher.presenter.BreedListFragmentPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreedListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreedListFragment extends Fragment implements BreedListAdapter.OnBreedClickListener, BreedImageListContract.View {

    private String tag = "BreedListFragment";
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "breedList";

    private RecyclerView recyclerViewBreedList;
    private List<String> breedList;
    private BreedListFragmentPresenter presenter;

    public BreedListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BreedListFragment.
     */
    public static BreedListFragment newInstance(List<String> breedList) {
        BreedListFragment fragment = new BreedListFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, (ArrayList<String>) breedList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            breedList = getArguments().getStringArrayList(ARG_PARAM1);
        }
        presenter = new BreedListFragmentPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewBreedList = view.findViewById(R.id.recyclerView_BreedList);
        recyclerViewBreedList.setAdapter(new BreedListAdapter(breedList, this));
        recyclerViewBreedList.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    @Override
    public void onBreedClick(String breed) {
        presenter.requestBreedImageList(breed);
    }

    @Override
    public void showBreedImageList(List<String> breedImageList) {
        Log.d(tag, Integer.toString(breedImageList.size()));
        Objects.requireNonNull(getActivity()).getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout_BreedList, BreedImageListFragment.newInstance(breedImageList), "BreedImageList")
                .addToBackStack(null)
                .commit();
    }
}