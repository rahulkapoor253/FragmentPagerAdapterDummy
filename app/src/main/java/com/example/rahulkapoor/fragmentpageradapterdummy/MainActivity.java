package com.example.rahulkapoor.fragmentpageradapterdummy;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.rahulkapoor.fragmentpageradapterdummy.fragment.Fragment1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private FrameLayout frame;
    // private Button btnSubmit;
    private String res = "";
    private ImageView ivMenu;
    private Button btnChangeData;
    private DrawerLayout drawerLayout;
    private ArrayList<String> rooms = new ArrayList<>();
    private ArrayList<String> fragData = new ArrayList<>();
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ivMenu = (ImageView) findViewById(R.id.iv_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        btnChangeData = (Button) findViewById(R.id.btn_change_data);
        //frame = (FrameLayout) findViewById(R.id.frame);
        //btnSubmit = (Button) findViewById(R.id.btnsubmit);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.closeDrawer(Gravity.END);
                } else {
                    drawerLayout.openDrawer(Gravity.START);
                }
            }
        });

        //setFragment();

        btnChangeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                setData(1);

            }
        });

        viewPager.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.VISIBLE);
        //frame.setVisibility(View.GONE);
        //btnSubmit.setVisibility(View.GONE);


        setData(0);

    }

    private void setData(final int mode) {
        fragmentArrayList.clear();

        for (int i = 0; i < 10; i++) {
            //multiple instances of fragment1;
            fragData.clear();
            res = "";
            Fragment1 fragment1 = new Fragment1();
            Bundle bundle = new Bundle();
            bundle.putString("text", "HIE THERE " + i);
            if (mode == 1) {
                Log.i("mode", "new data added");
                fragData.add("new data");
            } else {
                fragData.add("fragment data1 : " + i);
                fragData.add("fragment data2 : " + i);
            }
            for (int j = 0; j < fragData.size(); j++) {
                res = res + fragData.get(j) + ",";
            }
            res = res.substring(0, res.length() - 1);
            bundle.putString("fragData", res);
            fragment1.setArguments(bundle);
            fragmentArrayList.add(fragment1);
        }


        for (int i = 0; i < 10; i++) {
            rooms.add("hie there : " + i);
        }

        pagerAdapter = new com.example.rahulkapoor.fragmentpageradapterdummy.adapter.PagerAdapter(getSupportFragmentManager(), rooms, fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }


}
