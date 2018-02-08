package com.example.rahulkapoor.fragmentpageradapterdummy.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rahulkapoor.fragmentpageradapterdummy.R;

/**
 * Created by rahulkapoor on 08/02/18.
 */

public class MyDialogFragment extends DialogFragment {

    private ImageView ivDot1, ivDot2, ivDot3;
    private TextView tvContent;
    private Button btnNext, btnPrev;
    private static int count = 1;

    public static MyDialogFragment newInstance(int myIndex) {
        MyDialogFragment dialogFragment = new MyDialogFragment();

        //example of passing args
        Bundle args = new Bundle();
        args.putInt("anIntToSend", myIndex);
        dialogFragment.setArguments(args);

        return dialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //read the int from args
        int myInteger = getArguments().getInt("anIntToSend");

        View v = inflater.inflate(R.layout.custom_dialog, null);

        init(v);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                count--;
                setData(count);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //to close this tutorial screen when next for last fragment is pressed;
                if (count == 3) {
                    Toast.makeText(getContext(), "Close this tutorial screen.", Toast.LENGTH_SHORT).show();

                } else {
                    count++;
                    setData(count);
                }
            }
        });

        return v;
    }


    /**
     * set data accordingly;//here we use one fragment with 3 instances for tutorial;
     *
     * @param count count ;
     */
    private void setData(final int count) {

        switch (count) {
            case 1:
                ivDot1.setImageResource(R.drawable.active_square);
                ivDot2.setImageResource(R.drawable.inactive);
                ivDot3.setImageResource(R.drawable.inactive);
                tvContent.setText("HIE THIS IS FRAGMENT 1.");
                btnPrev.setVisibility(View.GONE);
                break;
            case 2:
                ivDot1.setImageResource(R.drawable.inactive);
                ivDot2.setImageResource(R.drawable.active_square);
                ivDot3.setImageResource(R.drawable.inactive);
                tvContent.setText("HIE THIS IS FRAGMENT 2.");
                btnPrev.setVisibility(View.VISIBLE);
                break;
            case 3:
                ivDot1.setImageResource(R.drawable.inactive);
                ivDot2.setImageResource(R.drawable.inactive);
                ivDot3.setImageResource(R.drawable.active_square);
                tvContent.setText("HIE THIS IS FRAGMENT 3.");
                btnPrev.setVisibility(View.VISIBLE);
                break;

        }

    }


    private void init(final View v) {
        ivDot1 = (ImageView) v.findViewById(R.id.dot_1);
        ivDot2 = (ImageView) v.findViewById(R.id.dot_2);
        ivDot3 = (ImageView) v.findViewById(R.id.dot_3);

        btnNext = (Button) v.findViewById(R.id.btn_next);
        btnPrev = (Button) v.findViewById(R.id.btn_prev);
        btnPrev.setVisibility(View.GONE);
        tvContent = (TextView) v.findViewById(R.id.tv_content);


    }

}
