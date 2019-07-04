package com.example.mordeshop;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mordeshop.adapters.ViewPagerAdapter;
import com.example.mordeshop.clases.Utilidad;


public class FragmentContenedor extends Fragment {
    // TODO: Rename parameter arguments, choose names that match


    View vista;
    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_contenedor, container, false);

        if(Utilidad.rotacion==0){
            View parent = (View) container.getParent();
            if (appBar == null) {
                appBar = (AppBarLayout) parent.findViewById(R.id.appBar);
                tabs = new TabLayout(getActivity());
                tabs.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
                appBar.addView(tabs);
                viewPager = vista.findViewById(R.id.viewpagerInformacion);
                LlenarViewPager(viewPager);
                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });
                tabs.setupWithViewPager(viewPager);
            }
            tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        }
        else{
            Utilidad.rotacion=1;
        }

        return vista;
    }

    private void LlenarViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.AddFragment(new FragmentTabPopular(), "POPULAR");
        adapter.AddFragment(new FragmentTabNuevos(), "NUEVO");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(Utilidad.rotacion==0){
            appBar.removeView(tabs);
        }

    }
}