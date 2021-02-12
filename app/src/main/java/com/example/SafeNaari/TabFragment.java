package com.example.SafeNaari;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.SafeNaari.CorruptionFragment;
import com.example.SafeNaari.DomesticViolenceFragment;
import com.example.SafeNaari.EveTeasingFragment;
import com.example.SafeNaari.R;
import com.example.SafeNaari.TheftAttemptFragment;
import com.example.SafeNaari.ThreatFragment;


public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 5 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
            View x =  inflater.inflate(R.layout.tab_layout,null);
            tabLayout = (TabLayout) x.findViewById(R.id.tabs);
            viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                    tabLayout.setupWithViewPager(viewPager);
                   }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position)
        {
          switch (position){
              case 0 : return new DomesticViolenceFragment();
              case 1 : return new ThreatFragment();
              case 2 : return new CorruptionFragment();
              case 3 : return new EveTeasingFragment();
              case 4 : return new TheftAttemptFragment();
          }
        return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }


        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Domestic Violence";
                case 1 :
                    return "Threat";
                case 2 :
                    return "Corruption";
                case 3 :
                    return "Eve Teasing";
                case 4 :
                    return "Theft Attempt";
            }
                return null;
        }
    }

}
