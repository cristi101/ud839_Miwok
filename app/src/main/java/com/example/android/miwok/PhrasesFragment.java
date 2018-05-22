package com.example.android.miwok;


import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends CategoryFragment {

    public PhrasesFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getColorId() {
        return R.color.category_phrases;
    }

    @Override
    protected ArrayList<Word> getWords() {
        ArrayList<Word> words;
        words = new ArrayList<Word>();
        words.add(new Word(R.string.phrase_where_are_you_going, R.string.miwok_phrase_where_are_you_going, R.raw.phrase_where_are_you_going));
        words.add(new Word(R.string.phrase_what_is_your_name, R.string.miwok_phrase_what_is_your_name, R.raw.phrase_what_is_your_name));
        words.add(new Word(R.string.phrase_my_name_is, R.string.miwok_phrase_my_name_is, R.raw.phrase_my_name_is));
        words.add(new Word(R.string.phrase_how_are_you_feeling, R.string.miwok_phrase_how_are_you_feeling, R.raw.phrase_how_are_you_feeling));
        words.add(new Word(R.string.phrase_im_feeling_good, R.string.miwok_phrase_im_feeling_good, R.raw.phrase_im_feeling_good));
        words.add(new Word(R.string.phrase_are_you_coming, R.string.miwok_phrase_are_you_coming, R.raw.phrase_are_you_coming));
        words.add(new Word(R.string.phrase_yes_im_coming, R.string.miwok_phrase_yes_im_coming, R.raw.phrase_yes_im_coming));
        words.add(new Word(R.string.phrase_im_coming, R.string.miwok_phrase_im_coming, R.raw.phrase_im_coming));
        words.add(new Word(R.string.phrase_lets_go, R.string.miwok_phrase_lets_go, R.raw.phrase_lets_go));
        words.add(new Word(R.string.phrase_come_here, R.string.miwok_phrase_come_here, R.raw.phrase_come_here));
        return words;
    }
}
