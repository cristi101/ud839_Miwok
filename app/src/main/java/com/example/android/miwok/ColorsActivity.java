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

public class ColorsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AudioManager.OnAudioFocusChangeListener {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    ArrayList<Word> words = new ArrayList<Word>(Arrays.asList(
            new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red),
            new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow),
            new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow),
            new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green),
            new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown),
            new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray),
            new Word("black", "kululli", R.drawable.color_black, R.raw.color_black),
            new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white)));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        ListView listView = (ListView) findViewById(R.id.list);
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(this);

    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(this);
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
        int result = audioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

            mediaPlayer = MediaPlayer.create(this, words.get(position).getAudioResourceId());
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    releaseMediaPlayer();
                }
            });
            mediaPlayer.start();
        }
    }
}
