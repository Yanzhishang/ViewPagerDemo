package com.yzs.viewpagerdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.yzs.viewpagerdemo.CustomSlidingViewpager;
import com.yzs.viewpagerdemo.R;
import com.yzs.viewpagerdemo.adapter.AppViewPagerAdapter;
import com.yzs.viewpagerdemo.fragment.FragmentFocus;
import com.yzs.viewpagerdemo.fragment.FragmentHome;
import com.yzs.viewpagerdemo.fragment.FragmentMsg;
import com.yzs.viewpagerdemo.fragment.FragmentUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout tabMain;
    private FragmentHome home;
    private FragmentFocus focus;
    private CustomSlidingViewpager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);

        tabMain = findViewById(R.id.ll_ac_tab);
        List<Fragment> fragments = new ArrayList<>();
        home = new FragmentHome();

        FragmentUser user = new FragmentUser();
        FragmentMsg msg = new FragmentMsg();
        focus = new FragmentFocus();
        fragments.add(home);
        fragments.add(user);
        fragments.add(msg);
        fragments.add(focus);

        AppViewPagerAdapter adapter = new AppViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setScrollble(true);
        viewPager.setScrollbleAll(true);
        viewPager.setOffscreenPageLimit(4);

        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickHome();
            }
        });
        findViewById(R.id.btn_msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickMsg();
            }
        });
        findViewById(R.id.btn_focus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFocus();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 0) {
                    viewPager.setScrollble(true);
                    viewPager.setScrollbleAll(true);
                } else if (position == 1) {
                    viewPager.setScrollble(false);
                    viewPager.setScrollbleAll(true);
                } else {
                    viewPager.setScrollbleAll(false);
                }
            }
        });
    }


    public void clickHome() {
        home.setVisible();
        tabMain.setVisibility(View.INVISIBLE);
        viewPager.setCurrentItem(0, false);
    }

    public void clickMsg() {
        tabMain.setVisibility(View.VISIBLE);
        focus.setGone();
        viewPager.setCurrentItem(2, false);
    }

    public void clickFocus() {
        focus.setVisible();
        tabMain.setVisibility(View.INVISIBLE);
        viewPager.setCurrentItem(3, false);
    }
}


