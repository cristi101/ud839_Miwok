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
public class NumbersFragment extends Fragment implements AdapterView.OnItemClickListener {
    private SoundPlayer soundPlayer;
    private ArrayList<Word> words = new ArrayList<Word>(Arrays.asList(
            new Word(R.string.number_one, R.string.miwok_number_one, R.drawable.number_one, R.raw.number_one),
            new Word(R.string.number_two, R.string.miwok_number_two, R.drawable.number_two, R.raw.number_two),
            new Word(R.string.number_three, R.string.miwok_number_three, R.drawable.number_three, R.raw.number_three),
            new Word(R.string.number_four, R.string.miwok_number_four, R.drawable.number_four, R.raw.number_four),
            new Word(R.string.number_five, R.string.miwok_number_five, R.drawable.number_five, R.raw.number_five),
            new Word(R.string.number_six, R.string.miwok_number_six, R.drawable.number_six, R.raw.number_six),
            new Word(R.string.number_seven, R.string.miwok_number_seven, R.drawable.number_seven, R.raw.number_seven),
            new Word(R.string.number_eight, R.string.miwok_number_eight, R.drawable.number_eight, R.raw.number_eight),
            new Word(R.string.number_nine, R.string.miwok_number_nine, R.drawable.number_nine, R.raw.number_nine),
            new Word(R.string.number_ten, R.string.miwok_number_ten, R.drawable.number_ten, R.raw.number_ten)));


    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_numbers);
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
