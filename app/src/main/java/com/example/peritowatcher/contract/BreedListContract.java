package com.example.peritowatcher.contract;

import java.util.List;

public class BreedListContract {

    public interface Model {

        interface OnFinishedListener {
            void onFinished(List<String> breedList);

            void onFailure(Throwable t);
        }

        void getBreedList(OnFinishedListener onFinishedListener);
    }

    public interface Presenter {
        void requestBreedList();
    }

    public interface View {
        void showBreedList(List<String> breedList);
        void showFailure(Throwable t);
    }

}
