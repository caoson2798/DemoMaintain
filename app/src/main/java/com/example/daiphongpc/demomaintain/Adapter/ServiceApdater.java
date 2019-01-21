package com.example.daiphongpc.demomaintain.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.daiphongpc.demomaintain.fragment.tab.CurrentServiceFragment;
import com.example.daiphongpc.demomaintain.fragment.tab.ListServiceFragment;
import com.example.daiphongpc.demomaintain.fragment.tab.SuggestServiceFragment;

import java.util.ArrayList;

public class ServiceApdater extends FragmentStatePagerAdapter {
    String[] tabList=new String[]{"Danh sách d.vụ","D.vụ đề xuất","D.vụ đang dùng"};
    CurrentServiceFragment currentServiceFragment;
    ListServiceFragment listServiceFragment;
    SuggestServiceFragment suggestServiceFragment;


    public ServiceApdater(FragmentManager fm) {
        super(fm);
        currentServiceFragment=new CurrentServiceFragment();
        listServiceFragment=new ListServiceFragment();
        suggestServiceFragment=new SuggestServiceFragment();
    }

    @Override
    public Fragment getItem(int i) {
        if (i==0){
            return listServiceFragment;
        }else if (i==1){
            return suggestServiceFragment;
        }else if (i==2){
            return currentServiceFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabList.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabList[position];
    }
}
