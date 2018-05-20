package com.example.android.miwok;


import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends CategoryFragment {

    ArrayList<Word> words = new ArrayList<Word>(Arrays.asList(
            new Word(R.string.color_red, R.string.miwok_color_red, R.drawable.color_red, R.raw.color_red),
            new Word(R.string.color_mustard_yellow, R.string.miwok_color_mustard_yellow, R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow),
            new Word(R.string.color_dusty_yellow, R.string.miwok_color_dusty_yellow, R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow),
            new Word(R.string.color_green, R.string.miwok_color_green, R.drawable.color_green, R.raw.color_green),
            new Word(R.string.color_brown, R.string.miwok_color_brown, R.drawable.color_brown, R.raw.color_brown),
            new Word(R.string.color_gray, R.string.miwok_color_gray, R.drawable.color_gray, R.raw.color_gray),
            new Word(R.string.color_black, R.string.miwok_color_black, R.drawable.color_black, R.raw.color_black),
            new Word(R.string.color_white, R.string.miwok_color_white, R.drawable.color_white, R.raw.color_white)));

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getColorId() {
        return R.color.category_colors;
    }

    @Override
    protected ArrayList<Word> getWords() {
        return words;
    }
}
