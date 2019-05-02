package com.example.clubmanagement.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.clubmanagement.R;

public class TestPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_NUMBER = 3;
    public TestPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return PageOneFragment.newInstance();
            case 1:
                return PageTwoFragment.newInstance();
            case 2:
                return PageThreeFragment.newInstance();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return PAGE_NUMBER;
    }
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "첫번째 탭";
            case 1:
                return "두번째 탭";
            case 2:
                return "세번째 탭";
            default:
                return null;
        }
    }
}