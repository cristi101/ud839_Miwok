package com.example.android.miwok;


import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends CategoryFragment {

    public FamilyFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getColorId() {
        return R.color.category_family;
    }

    @Override
    protected ArrayList<Word> getWords() {
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.family_father, R.string.miwok_family_father, R.drawable.family_father, R.raw.family_father));
        words.add(new Word(R.string.family_mother, R.string.miwok_family_mother, R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word(R.string.family_son, R.string.miwok_family_son, R.drawable.family_son, R.raw.family_son));
        words.add(new Word(R.string.family_daughter, R.string.miwok_family_daughter, R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word(R.string.family_older_brother, R.string.miwok_family_older_brother, R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word(R.string.family_younger_brother, R.string.miwok_family_younger_brother, R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word(R.string.family_older_sister, R.string.miwok_family_older_sister, R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word(R.string.family_younger_sister, R.string.miwok_family_younger_sister, R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word(R.string.family_grandmother, R.string.miwok_family_grandmother, R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word(R.string.family_grandfather, R.string.miwok_family_grandfather, R.drawable.family_grandfather, R.raw.family_grandfather));
        return words;
    }

}
