package com.example.android.miwok;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public abstract class CategoryFragment extends Fragment implements AdapterView.OnItemClickListener {
    private SoundPlayer soundPlayer;
    private ArrayList<Word> words;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        words = getWords();

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, getColorId());
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

    abstract protected int getColorId();

    abstract protected ArrayList<Word> getWords();

}
