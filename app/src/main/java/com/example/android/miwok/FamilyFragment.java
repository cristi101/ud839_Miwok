package com.example.android.miwok;


import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends CategoryFragment {

    ArrayList<Word> words = new ArrayList<Word>(Arrays.asList(
            new Word(R.string.family_father, R.string.miwok_family_father, R.drawable.family_father, R.raw.family_father),
            new Word(R.string.family_mother, R.string.miwok_family_mother, R.drawable.family_mother, R.raw.family_mother),
            new Word(R.string.family_son, R.string.miwok_family_son, R.drawable.family_son, R.raw.family_son),
            new Word(R.string.family_daughter, R.string.miwok_family_daughter, R.drawable.family_daughter, R.raw.family_daughter),
            new Word(R.string.family_older_brother, R.string.miwok_family_older_brother, R.drawable.family_older_brother, R.raw.family_older_brother),
            new Word(R.string.family_younger_brother, R.string.miwok_family_younger_brother, R.drawable.family_younger_brother, R.raw.family_younger_brother),
            new Word(R.string.family_older_sister, R.string.miwok_family_older_sister, R.drawable.family_older_sister, R.raw.family_older_sister),
            new Word(R.string.family_younger_sister, R.string.miwok_family_younger_sister, R.drawable.family_younger_sister, R.raw.family_younger_sister),
            new Word(R.string.family_grandmother, R.string.miwok_family_grandmother, R.drawable.family_grandmother, R.raw.family_grandmother),
            new Word(R.string.family_grandfather, R.string.miwok_family_grandfather, R.drawable.family_grandfather, R.raw.family_grandfather)));

    public FamilyFragment() {
        // Required empty public constructor
    }



    @Override
    protected int getColorId() {
        return R.color.category_family;
    }

    @Override
    protected ArrayList<Word> getWords() {
        return words;
    }

}
