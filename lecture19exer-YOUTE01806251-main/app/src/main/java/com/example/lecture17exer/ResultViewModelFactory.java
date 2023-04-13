package com.example.lecture17exer;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ResultViewModelFactory implements ViewModelProvider.Factory {
    private final String finalResult;

    public ResultViewModelFactory(String finalResult) {
        this.finalResult = finalResult;
    }

    @Override
    public <T extends ViewModel> T create(@NonNull Class <T> modelClass) {
        if (modelClass == ResultViewModel.class) {
            return (T) new ResultViewModel(finalResult);
        }
        return null;
    }


}
