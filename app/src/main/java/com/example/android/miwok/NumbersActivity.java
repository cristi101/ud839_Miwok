/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnCompletionListener {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        ListView listView = (ListView) findViewById(R.id.list);

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(this);
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            audioManager.abandonAudioFocus(this);
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    public void onAudioFocusChange(int focusChange) {
        Toast.makeText(this, "Audio focus", Toast.LENGTH_LONG).show();
        switch (focusChange) {
            case AudioManager.AUDIOFOCUS_GAIN:
                mediaPlayer.start();
                break;
            case AudioManager.AUDIOFOCUS_LOSS:
                releaseMediaPlayer();
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(this, words.get(position).getAudioResourceId());
        int result = audioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.start();
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        releaseMediaPlayer();
    }
}
