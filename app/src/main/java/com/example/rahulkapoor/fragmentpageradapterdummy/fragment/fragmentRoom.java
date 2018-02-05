package com.example.rahulkapoor.fragmentpageradapterdummy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rahulkapoor.fragmentpageradapterdummy.R;

/**
 * Created by rahulkapoor on 01/02/18.
 */

public class fragmentRoom extends Fragment {

    private FloatingActionButton fabAdd;
    private FrameLayout frameAdd;
    private EditText etPanelText;
    private Button btnSubmit;
    private LinearLayout llRooms;
    private String panelid;

    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_name, container, false);

        init(v);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                fabAdd.setVisibility(View.GONE);
                llRooms.addView(createNewTextView("Room"));
                frameAdd.setVisibility(View.VISIBLE);

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                panelid = etPanelText.getText().toString();
            }
        });

        return v;
    }


    /**
     * it will add a textview to linear layout;
     *
     * @param room room string to add to textview;
     * @return return created view;
     */
    private View createNewTextView(final String room) {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(8, 8, 8, 8);
        final TextView textView = new TextView(getContext());
        textView.setLayoutParams(params);
        textView.setText(room);
        textView.setPadding(8, 8, 8, 8);
        textView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        textView.setTextColor(getResources().getColor(R.color.colorAccent));
        return textView;

    }

    /**
     * to init data;
     *
     * @param v view of fragment;
     */
    private void init(final View v) {

        fabAdd = (FloatingActionButton) v.findViewById(R.id.btn_fab);
        llRooms = (LinearLayout) v.findViewById(R.id.ll_rooms);
        frameAdd = (FrameLayout) v.findViewById(R.id.frameadd);
        etPanelText = (EditText) v.findViewById(R.id.et_panelid);
        btnSubmit = (Button) v.findViewById(R.id.btnSubmit);
    }

}
