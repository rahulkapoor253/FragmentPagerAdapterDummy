package com.example.rahulkapoor.fragmentpageradapterdummy.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahulkapoor.fragmentpageradapterdummy.R;

/**
 * Created by rahulkapoor on 19/01/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private String text;

    public MyAdapter(final Context context, final String data) {
        this.mContext = context;
        this.text = data;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.MyViewHolder holder, final int position) {

        holder.tvItem.setText(text);
        InnerAdapter innerAdapter = new InnerAdapter();
        holder.rvInside.setLayoutManager(new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false));
        holder.rvInside.setAdapter(innerAdapter);

        InnersecondAdapter adapter = new InnersecondAdapter();
        holder.rvInsidenext.setLayoutManager(new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false));
        holder.rvInsidenext.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItem;
        private RecyclerView rvInside, rvInsidenext;

        public MyViewHolder(final View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tv_item);
            rvInside = (RecyclerView) itemView.findViewById(R.id.rv_inside);
            rvInsidenext = (RecyclerView) itemView.findViewById(R.id.rv_inside2);
        }
    }
}
