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

public class PhrasesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnCompletionListener {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    ArrayList<Word> words = new ArrayList<Word>(Arrays.asList(
            new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going),
            new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name),
            new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is),
            new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling),
            new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good),
            new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming),
            new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming),
            new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming),
            new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go),
            new Word("Come here.", "әnni'nem", R.raw.phrase_come_here)));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        ListView listView = (ListView) findViewById(R.id.list);

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);
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
