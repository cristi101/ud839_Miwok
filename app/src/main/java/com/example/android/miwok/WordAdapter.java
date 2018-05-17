package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        // get the current item
        Word word = getItem(position);

        if (listItemView == null) { // the view is new
            // create the view
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        LinearLayout textContainer = listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundResource(mColorResourceId);

        ImageView imageView = listItemView.findViewById(R.id.image);

        if (word.hasImage()) {
            imageView.setImageResource(word.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);

        miwokTextView.setText(word.getMiwokTranslationId());
        defaultTextView.setText(word.getDefaultTranslationId());

        return listItemView;
    }

}
