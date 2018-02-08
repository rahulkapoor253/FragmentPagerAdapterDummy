package com.example.rahulkapoor.fragmentpageradapterdummy;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.rahulkapoor.fragmentpageradapterdummy.fragment.MyDialogFragment;

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
    private FrameLayout frameLayout;
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
        frameLayout = (FrameLayout) findViewById(R.id.frame);
        //frame = (FrameLayout) findViewById(R.id.frame);
        //btnSubmit = (Button) findViewById(R.id.btnsubmit);


//        viewPager.setVisibility(View.VISIBLE);
//        tabLayout.setVisibility(View.VISIBLE);
        //frame.setVisibility(View.GONE);
        //btnSubmit.setVisibility(View.GONE);

//        Fragment1 fragment1 = new Fragment1();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.frame, fragment1).commit();

        showEditDialog();

    }


    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        MyDialogFragment dialogFragment = MyDialogFragment.newInstance(0);
        dialogFragment.show(fm, "fragment_edit_name");
    }


}
