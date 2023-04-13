package com.example.lecture17exer;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModel;

public class GameViewModel extends androidx.lifecycle.ViewModel {
    int livesLeft = 8;
    String LetterEntry="walking";
    String tempLetterEntry=LetterEntry;
    String barsString="";
    ArrayList<String> arrayListOfCharOne=new ArrayList<>(LetterEntry.length());


    public boolean isVerifyGuessedWord(String finalWord) {
        String finalWordNotCap = finalWord.toLowerCase();
        if (tempLetterEntry.contains(finalWordNotCap)){
            barsString="";
            int indexFinalWord=tempLetterEntry.indexOf(finalWordNotCap);
            arrayListOfCharOne.set(indexFinalWord,finalWordNotCap);
            Log.i("phanor",arrayListOfCharOne.size()+"");
            for (int i = 0; i < arrayListOfCharOne.size(); i++) {
                barsString+=arrayListOfCharOne.get(i);
            }
            tempLetterEntry=tempLetterEntry.replaceFirst(finalWordNotCap,"1");
            return true;
        }
        return false;
    }

    public boolean hasWon() {
        return !arrayListOfCharOne.contains("_");
    }

    public boolean hasLost() {
        //need the word
        if (livesLeft == 0) {
            return true;
        }
        return false;
    }

}
