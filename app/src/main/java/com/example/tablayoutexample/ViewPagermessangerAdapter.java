package com.example.tablayoutexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagermessangerAdapter extends FragmentPagerAdapter {

    public ViewPagermessangerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
       if(position==0){
           return new ChartFragment();
       } else if (position==1) {
           return new StatusFragment();

       }
       else{
           return  new CallsFragment();
       }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       if(position==0){
           return "Chats";
       } else if (position==1) {
           return "Status";
       }else{
           return "Calls";
       }
    }

    @Override
    public int getCount() {
        return 3; // on of tabs
    }
}
