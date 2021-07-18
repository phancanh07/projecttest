package com.example.projecttest.adapter;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.projecttest.view.CatFragment;
import com.example.projecttest.view.ConanFragment;
import com.example.projecttest.view.DoremonFragment;
import com.example.projecttest.view.DragonFragment;

import org.jetbrains.annotations.NotNull;

public class ViewPager extends FragmentStatePagerAdapter {


    public ViewPager(@NonNull @NotNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String index = "";
        switch (position) {
            case 0:
                index = "0";
                break;
            case 1:
                index = "1";
                break;
            case 2:
                index = "2";
                break;
            default:
                index = "3";
        }
        return index;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ConanFragment();
            case 1:
                return new DoremonFragment();
            case 2:
                return new DragonFragment();
            default:
                return new CatFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
