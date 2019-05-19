package com.example.clubmanagement.Fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.clubmanagement.Adapter.TestPagerAdapter;
import com.example.clubmanagement.R;

public class FragmentStart extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestPagerAdapter mTestPagerAdapter = new TestPagerAdapter(getSupportFragmentManager());
        ViewPager mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mTestPagerAdapter);
        TabLayout mTab = (TabLayout) findViewById(R.id.tabs);
        mTab.setupWithViewPager(mViewPager);
    }
}