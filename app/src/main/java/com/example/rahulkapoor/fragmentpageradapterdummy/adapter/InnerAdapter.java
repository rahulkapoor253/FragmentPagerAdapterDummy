package com.example.rahulkapoor.fragmentpageradapterdummy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahulkapoor.fragmentpageradapterdummy.R;

/**
 * Created by rahulkapoor on 19/01/18.
 */

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.InnerViewHolder> {


    @Override
    public InnerAdapter.InnerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inner_list_item, parent, false);
        return new InnerAdapter.InnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final InnerAdapter.InnerViewHolder holder, final int position) {


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class InnerViewHolder extends RecyclerView.ViewHolder {

        TextView tvInnerData;

        public InnerViewHolder(final View itemView) {
            super(itemView);
            tvInnerData = (TextView) itemView.findViewById(R.id.tv_inneritem);
        }
    }
}