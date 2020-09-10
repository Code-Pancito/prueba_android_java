package com.example.peritowatcher.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.peritowatcher.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreedImageListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreedImageListFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_BREEDIMAGELIST = "breedImageList";

    private List<String> breedImageList;
    private RecyclerView recyclerViewBreedImageList;

    public BreedImageListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BreedImageListFragment.
     */
    public static BreedImageListFragment newInstance(List<String> breedImageList) {
        BreedImageListFragment fragment = new BreedImageListFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_BREEDIMAGELIST, (ArrayList<String>) breedImageList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            breedImageList = getArguments().getStringArrayList(ARG_BREEDIMAGELIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed_image_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewBreedImageList = view.findViewById(R.id.recyclerView_BreedImageList);
        recyclerViewBreedImageList.setAdapter(new BreedImageListAdapter(breedImageList));
        recyclerViewBreedImageList.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }
}