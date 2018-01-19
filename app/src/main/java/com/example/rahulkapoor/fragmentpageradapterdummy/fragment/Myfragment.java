package com.example.rahulkapoor.fragmentpageradapterdummy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahulkapoor.fragmentpageradapterdummy.R;

/**
 * Created by rahulkapoor on 19/01/18.
 */

public class Myfragment extends Fragment {

    private TextView tvData;

    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.my_fragment, container, false);


        tvData = (TextView) v.findViewById(R.id.my_data);
        return v;
    }

}
