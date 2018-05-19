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
public class PhrasesFragment extends Fragment implements AdapterView.OnItemClickListener {
    private SoundPlayer soundPlayer;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_phrases);
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
