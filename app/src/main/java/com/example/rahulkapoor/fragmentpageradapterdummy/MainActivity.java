package com.example.rahulkapoor.fragmentpageradapterdummy;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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

    private AudioManager audioManager;

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

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        Log.i("audio", audioManager.isWiredHeadsetOn() + "");
        if (audioManager.isWiredHeadsetOn()) {
            byte[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100,10, 20, 30, 40,
                    50, 60, 70, 80, 90, 100,10, 20, 30, 40, 50, 60, 70, 80, 90, 100,10, 20, 30, 40,
                    50, 60, 70, 80, 90, 100,10, 20, 30, 40, 50, 60, 70, 80, 90, 100,10, 20, 30,
                    40, 50, 60, 70, 80, 90, 100,10, 20, 30, 40, 50, 60, 70, 80, 90, 100,10, 20,
                    30, 40, 50, 60, 70, 80, 90, 100,10, 20, 30, 40, 50, 60, 70, 80, 90, 100,10,
                    10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
                    20, 30, 40, 50, 60, 70, 80, 90, 100,10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
            send(arr);
        }


//        viewPager.setVisibility(View.VISIBLE);
//        tabLayout.setVisibility(View.VISIBLE);
        //frame.setVisibility(View.GONE);
        //btnSubmit.setVisibility(View.GONE);

//        Fragment1 fragment1 = new Fragment1();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.frame, fragment1).commit();

        btnChangeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                showEditDialog();
            }
        });


    }

    private void send(byte[] bytes_pkg) {
        int bufsize = AudioTrack.getMinBufferSize(8000,
                AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_16BIT);
        AudioTrack trackplayer = new AudioTrack(AudioManager.STREAM_MUSIC,
                8000, AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_16BIT, bufsize,
                AudioTrack.MODE_STREAM);
        trackplayer.play();
        trackplayer.write(bytes_pkg, 0, bytes_pkg.length);
    }


    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        MyDialogFragment dialogFragment = MyDialogFragment.newInstance(0);
        dialogFragment.show(fm, "fragment_edit_name");
    }


}
