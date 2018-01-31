package com.example.rahulkapoor.fragmentpageradapterdummy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by rahulkapoor on 19/01/18.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> rooms = new ArrayList<>();
    private String data;
    private ArrayList<Fragment> arrayList = new ArrayList<>();

    public PagerAdapter(final FragmentManager fm, final ArrayList<String> roomData, final ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        this.rooms = roomData;
        this.arrayList = fragmentArrayList;
    }

    @Override
    public Fragment getItem(final int position) {
        return arrayList.get(position);
    }

    @Override
    public int getItemPosition(final Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public CharSequence getPageTitle(final int position) {

        return rooms.get(position);
    }


}
