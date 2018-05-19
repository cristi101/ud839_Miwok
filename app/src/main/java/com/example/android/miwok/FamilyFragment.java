package com.example.android.miwok;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment implements AdapterView.OnItemClickListener {
    private SoundPlayer soundPlayer;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_family);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(this);
        return rootView;
    }

    private void releaseMediaPlayer() {
        if (soundPlayer != null) {
            soundPlayer.releaseMediaPlayer();
            soundPlayer = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        releaseMediaPlayer();
        soundPlayer = new SoundPlayer(getActivity(), words.get(position).getAudioResourceId());
    }

}
