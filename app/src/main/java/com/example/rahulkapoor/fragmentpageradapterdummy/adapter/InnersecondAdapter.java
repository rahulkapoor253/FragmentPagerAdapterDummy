package com.example.rahulkapoor.fragmentpageradapterdummy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahulkapoor.fragmentpageradapterdummy.R;

/**
 * Created by rahulkapoor on 20/01/18.
 */

public class InnersecondAdapter extends RecyclerView.Adapter<InnersecondAdapter.InnerSecondViewHolder> {
    @Override
    public InnersecondAdapter.InnerSecondViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inner_list_item2, parent, false);
        return new InnersecondAdapter.InnerSecondViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final InnersecondAdapter.InnerSecondViewHolder holder, final int position) {



    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class InnerSecondViewHolder extends RecyclerView.ViewHolder {
        private TextView tvInnerLight, tvInnerDimLight, tvInnerFan, tvInnerSocket;

        public InnerSecondViewHolder(final View itemView) {
            super(itemView);
            tvInnerLight = (TextView) itemView.findViewById(R.id.tv_innerlight);
            tvInnerDimLight = (TextView) itemView.findViewById(R.id.tv_innerdimlight);
            tvInnerFan = (TextView) itemView.findViewById(R.id.tv_innerfan);
            tvInnerSocket = (TextView) itemView.findViewById(R.id.tv_innersocket);
        }
    }
}
