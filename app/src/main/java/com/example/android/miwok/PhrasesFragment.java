package com.example.android.miwok;


import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends CategoryFragment {

    ArrayList<Word> words = new ArrayList<Word>(Arrays.asList(
            new Word(R.string.phrase_where_are_you_going, R.string.miwok_phrase_where_are_you_going, R.raw.phrase_where_are_you_going),
            new Word(R.string.phrase_what_is_your_name, R.string.miwok_phrase_what_is_your_name, R.raw.phrase_what_is_your_name),
            new Word(R.string.phrase_my_name_is, R.string.miwok_phrase_my_name_is, R.raw.phrase_my_name_is),
            new Word(R.string.phrase_how_are_you_feeling, R.string.miwok_phrase_how_are_you_feeling, R.raw.phrase_how_are_you_feeling),
            new Word(R.string.phrase_im_feeling_good, R.string.miwok_phrase_im_feeling_good, R.raw.phrase_im_feeling_good),
            new Word(R.string.phrase_are_you_coming, R.string.miwok_phrase_are_you_coming, R.raw.phrase_are_you_coming),
            new Word(R.string.phrase_yes_im_coming, R.string.miwok_phrase_yes_im_coming, R.raw.phrase_yes_im_coming),
            new Word(R.string.phrase_im_coming, R.string.miwok_phrase_im_coming, R.raw.phrase_im_coming),
            new Word(R.string.phrase_lets_go, R.string.miwok_phrase_lets_go, R.raw.phrase_lets_go),
            new Word(R.string.phrase_come_here, R.string.miwok_phrase_come_here, R.raw.phrase_come_here)));

    public PhrasesFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getColorId() {
        return R.color.category_phrases;
    }

    @Override
    protected ArrayList<Word> getWords() {
        return words;
    }
}
