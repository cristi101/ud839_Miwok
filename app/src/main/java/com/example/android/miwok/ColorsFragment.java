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
public class ColorsFragment extends Fragment implements AdapterView.OnItemClickListener {
    private SoundPlayer soundPlayer;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_colors);
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
