package com.example.tailoredtech.tecnovanza.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tailoredtech.tecnovanza.fragments.MusicFragment;
import com.example.tailoredtech.tecnovanza.fragments.NewsFragment;

/**
 * Created by Najneen on 12/24/2016.
 */

public class PagerAdapter extends FragmentStatePagerAdapter{

    private static final int NUMBER_OF_TABS = 2;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new MusicFragment();
            case 1:
                return new NewsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUMBER_OF_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //this is where you set the titles
        switch(position) {
            case 0:
                return "Music";
            case 1:
                return "News";
        }
        return null;
    }
}
