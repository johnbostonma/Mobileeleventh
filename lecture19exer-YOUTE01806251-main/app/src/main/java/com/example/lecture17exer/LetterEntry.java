package com.example.lecture17exer;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lecture17exer.databinding.FragmentLetterEntryBinding;
import java.util.ArrayList;
public class LetterEntry extends Fragment {
private FragmentLetterEntryBinding binding;

private String finalWord;
private String bars="_";
private GameViewModel viewModel;
NavDirections action;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game_board, container, false);
        binding = FragmentLetterEntryBinding.inflate(inflater, container, false);
        //setContentView(R.layout.activity_main);
        View view = binding.getRoot();
        viewModel=new ViewModelProvider(this).get(GameViewModel.class);
        //binding.lifeLeft.setText(viewModel.livesLeft);


        //this is too make the numbers fit the word being guessed.
        for (int i = 0; i < viewModel.LetterEntry.length(); i++) {
            viewModel.barsString+="_";
            viewModel.arrayListOfCharOne.add(bars);
        }
        binding.wordToGuess.setText(viewModel.barsString);
        updateScreen();


        //TextWatcher
        binding.primaryTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                finalWord=editable.toString();

            }
        });

        //Button click listener
        binding.primaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String finalWordNotCap = finalWord.toLowerCase();

                if ( viewModel.isVerifyGuessedWord(finalWordNotCap)){
                    binding.wordToGuess.setText(viewModel.barsString);
                }else {
                    viewModel.livesLeft--;
                }
                    if (viewModel.hasWon()){
                        action = LetterEntryDirections.actionLetterEntryToGameOver(viewModel.LetterEntry);
                        Navigation.findNavController(view).navigate(action);
                    }

                    if (viewModel.hasLost()){
                        action = LetterEntryDirections.actionLetterEntryToGamelost(viewModel.LetterEntry);
                        Navigation.findNavController(view).navigate(action);
                    }

            binding.primaryTextView.setText("");
                /*working around with string to set the life left dynamically*/
                updateScreen();

            }
        });



        return view;
    }



    void updateScreen() {
        String textString = "You have " + viewModel.livesLeft + " lives left.";
        binding.lifeLeft.setText(textString);

    }



}