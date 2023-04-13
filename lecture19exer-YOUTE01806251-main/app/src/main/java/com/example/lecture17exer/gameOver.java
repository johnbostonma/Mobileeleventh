package com.example.lecture17exer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lecture17exer.databinding.FragmentGameOverBinding;
import com.example.lecture17exer.databinding.FragmentGamelostBinding;

public class gameOver extends Fragment {

    private FragmentGameOverBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGameOverBinding.inflate(inflater, container, false);
        View view = binding.getRoot();



        String message = gameOverArgs.fromBundle(requireArguments()).getWord();

        ResultViewModelFactory viewModelFactory = new ResultViewModelFactory(message);
        ResultViewModel viewModel = new ViewModelProvider(this, viewModelFactory).get(ResultViewModel.class);

        binding.TheWord.setText(viewModel.result);
        binding.newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_gameOver_to_letterEntry);

            }
        });




        return view;
    }
}