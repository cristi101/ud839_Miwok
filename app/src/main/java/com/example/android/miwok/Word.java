package com.example.android.miwok;

public class Word {
    private int mMiwokTranslationId;
    private int mDefaultTranslationId;
    private int mAudioResourceId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(int defaultTranslationId, int miwokTranslationId, int imageResourceId, int audioResourceId) {
        mMiwokTranslationId = miwokTranslationId;
        mDefaultTranslationId = defaultTranslationId;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public Word(int defaultTranslationId, int miwokTranslationId, int audioResourceId) {
        mMiwokTranslationId = miwokTranslationId;
        mDefaultTranslationId = defaultTranslationId;
        mAudioResourceId = audioResourceId;
    }

    public void setMiwokTranslationId(int miwokTranslationId) {
        mMiwokTranslationId = miwokTranslationId;
    }

    public int getMiwokTranslationId() {
        return mMiwokTranslationId;
    }


    public int getDefaultTranslationId() {
        return mDefaultTranslationId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
