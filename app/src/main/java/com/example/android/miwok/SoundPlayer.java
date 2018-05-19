package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;


public class SoundPlayer implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnCompletionListener {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    SoundPlayer(Activity activity, int audioResourceId) {
        audioManager = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);

        mediaPlayer = MediaPlayer.create(activity, audioResourceId);
        int result = audioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.start();
        }
    }

    public void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            audioManager.abandonAudioFocus(this);
            mediaPlayer = null;
        }
    }

    public void onAudioFocusChange(int focusChange) {
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

    public void onCompletion(MediaPlayer mp) {
        releaseMediaPlayer();
    }

}
