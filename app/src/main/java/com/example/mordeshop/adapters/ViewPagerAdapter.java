package com.example.mordeshop.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> listaFragmentos=new ArrayList<>();
    private final List<String> listaTitulos= new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public void AddFragment(Fragment fragment, String titulo){
        listaFragmentos.add(fragment);
        listaTitulos.add(titulo);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaTitulos.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return listaFragmentos.get(i);
    }

    @Override
    public int getCount() {
        return listaFragmentos.size();
    }
}
