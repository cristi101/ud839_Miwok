package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CathegorAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments = {new NumbersFragment(), new FamilyFragment(), new ColorsFragment(), new PhrasesFragment()};
    private int[] categories = {R.string.category_numbers, R.string.category_family, R.string.category_colors, R.string.category_phrases};

    private Context mContext;

    public CathegorAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return (position < 4) ? fragments[position] : null;
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return position < 4 ? mContext.getString(categories[position]) : null;
    }
}
