package com.example.rahulkapoor.fragmentpageradapterdummy;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.rahulkapoor.fragmentpageradapterdummy.fragment.Fragment1;
import com.example.rahulkapoor.fragmentpageradapterdummy.fragment.Myfragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private FrameLayout frame;
    private Button btnSubmit;
    private String[] rooms = {"ab", "cd", "ef"};
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        frame = (FrameLayout) findViewById(R.id.frame);
        btnSubmit = (Button) findViewById(R.id.btnsubmit);


        setFragment();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                FragmentManager fm = getSupportFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    Log.i("fragpop", fm.getBackStackEntryCount() + "");
                    fm.popBackStack();
                }

                viewPager.setVisibility(View.VISIBLE);
                tabLayout.setVisibility(View.VISIBLE);
                frame.setVisibility(View.GONE);
                btnSubmit.setVisibility(View.GONE);
                for (int i = 0; i < 3; i++) {
                    //multiple instances of fragment1;
                    Fragment1 fragment1 = new Fragment1();
                    Bundle bundle = new Bundle();
                    bundle.putString("text", "HIE THERE " + i);
                    fragment1.setArguments(bundle);
                    fragmentArrayList.add(fragment1);
                }


                pagerAdapter = new com.example.rahulkapoor.fragmentpageradapterdummy.adapter.PagerAdapter(getSupportFragmentManager(), rooms, fragmentArrayList);
                viewPager.setAdapter(pagerAdapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        });


    }

    /**
     * to set Myfragment;
     */
    private void setFragment() {
        Myfragment myfragment = new Myfragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, myfragment);
        fragmentTransaction.addToBackStack(null).commit();
    }


}
