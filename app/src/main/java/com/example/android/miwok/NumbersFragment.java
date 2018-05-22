package com.example.android.miwok;


import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends CategoryFragment {

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getColorId() {
        return R.color.category_numbers;
    }

    @Override
    protected ArrayList<Word> getWords() {
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.number_one, R.string.miwok_number_one, R.drawable.number_one, R.raw.number_one));
        words.add(new Word(R.string.number_two, R.string.miwok_number_two, R.drawable.number_two, R.raw.number_two));
        words.add(new Word(R.string.number_three, R.string.miwok_number_three, R.drawable.number_three, R.raw.number_three));
        words.add(new Word(R.string.number_four, R.string.miwok_number_four, R.drawable.number_four, R.raw.number_four));
        words.add(new Word(R.string.number_five, R.string.miwok_number_five, R.drawable.number_five, R.raw.number_five));
        words.add(new Word(R.string.number_six, R.string.miwok_number_six, R.drawable.number_six, R.raw.number_six));
        words.add(new Word(R.string.number_seven, R.string.miwok_number_seven, R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word(R.string.number_eight, R.string.miwok_number_eight, R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word(R.string.number_nine, R.string.miwok_number_nine, R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word(R.string.number_ten, R.string.miwok_number_ten, R.drawable.number_ten, R.raw.number_ten));
        return words;
    }
}
