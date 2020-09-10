package com.example.peritowatcher.contract;

import java.util.List;

public class BreedImageListContract {

    public interface Model {

        interface OnFinishedListener {
            void onFinished(List<String> breedImageList);

            void onFailure(Throwable t);
        }

        void getBreedImageList(String breed, OnFinishedListener onFinishedListener);
    }

    public interface Presenter {
        void requestBreedImageList(String breed);
    }

    public interface View {
        void showBreedImageList(List<String> breedImageList);
    }

}
