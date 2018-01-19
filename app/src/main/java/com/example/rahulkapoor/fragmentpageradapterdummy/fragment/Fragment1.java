package com.example.rahulkapoor.fragmentpageradapterdummy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahulkapoor.fragmentpageradapterdummy.R;
import com.example.rahulkapoor.fragmentpageradapterdummy.adapter.MyAdapter;

/**
 * Created by rahulkapoor on 19/01/18.
 */

public class Fragment1 extends Fragment {

    private TextView tvData;
    private String data;
    private RecyclerView recyclerView;


    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container, false);

        tvData = (TextView) v.findViewById(R.id.tv_data);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv);

        data = getArguments().getString("text");
        tvData.setText(data);

        MyAdapter myAdapter = new MyAdapter(getContext(), data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myAdapter);

        return v;
    }


}
