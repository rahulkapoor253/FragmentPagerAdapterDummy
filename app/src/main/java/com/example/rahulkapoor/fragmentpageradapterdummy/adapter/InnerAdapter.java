package com.example.rahulkapoor.fragmentpageradapterdummy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahulkapoor.fragmentpageradapterdummy.R;

import java.util.ArrayList;

/**
 * Created by rahulkapoor on 19/01/18.
 */

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.InnerViewHolder> {

    private Context mContext;
    private ArrayList<String> textList = new ArrayList<>();

    public InnerAdapter(final Context context, final ArrayList<String> text) {
        this.mContext = context;
        this.textList = text;

    }

    @Override
    public InnerAdapter.InnerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inner_list_item, parent, false);
        return new InnerAdapter.InnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final InnerAdapter.InnerViewHolder holder, final int position) {
        holder.tvInnerLight.setText(textList.get(position));
//        holder.tvInnerDimLight.setText(textList.get(position));
//        holder.tvInnerFan.setText(textList.get(position));
//        holder.tvInnerSocket.setText(textList.get(position));

    }

    @Override
    public int getItemCount() {
        return textList.size();
    }

    public class InnerViewHolder extends RecyclerView.ViewHolder {

        TextView tvInnerLight, tvInnerDimLight, tvInnerFan, tvInnerSocket;

        public InnerViewHolder(final View itemView) {
            super(itemView);
            tvInnerLight = (TextView) itemView.findViewById(R.id.tv_inneritem);

        }
    }
}
