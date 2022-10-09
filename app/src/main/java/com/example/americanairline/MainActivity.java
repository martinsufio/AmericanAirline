package com.example.americanairline;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.americanairline.fragments.FlightStatusFragment;
import com.example.americanairline.fragments.HomeFragment;
import com.example.americanairline.fragments.ProfileFragment;
import com.example.americanairline.fragments.TripsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private static final int NUM_PAGES = 4;
    private ViewPager2 viewPager2;
    private FragmentStateAdapter pageAdapter;
    HashMap<Integer, Integer> positionOfPages = new HashMap<>();
    HashMap<Integer, Fragment> fragments = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        positionOfPages.put(0, R.id.menuhome);
        positionOfPages.put(1, R.id.menuFlightStatus);
        positionOfPages.put(2, R.id.menuTrip);
        positionOfPages.put(3, R.id.menuProfile);
        fragments.put(0, new HomeFragment());
        fragments.put(1, new FlightStatusFragment());
        fragments.put(2, new TripsFragment());
        fragments.put(3, new ProfileFragment());
        viewPager2 = findViewById(R.id.VP);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        pageAdapter = new ScreenSlidePageAdapter(this);
        viewPager2.setAdapter(pageAdapter);
        viewPager2.setPageTransformer(new DepthPageTransformer());
        setBottomNavigation();
        setViewPagerListener();
//        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem item) {
//                HomeFragment;
//            }
//        });
    }


    private void setViewPagerListener() {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                int selectedPage = positionOfPages.get(position);
                bottomNavigationView.setSelectedItemId(selectedPage);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void setBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                for (Entry<Integer, Integer> entry : positionOfPages.entrySet()) {
                    if (entry.getValue() == item.getItemId()) {
                        viewPager2.setCurrentItem(entry.getKey());
                        return true;
                    }
                }
                return true;
            }
        });
    }

    private class ScreenSlidePageAdapter extends FragmentStateAdapter {
        public ScreenSlidePageAdapter(MainActivity mainActivity) {
            super(mainActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragments.get(position);
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

    @RequiresApi(21)
    public class DepthPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) {
                view.setAlpha(0f);

            } else if (position <= 0) {
                view.setAlpha(1f);
                view.setTranslationX(0f);
                view.setTranslationZ(0f);
                view.setScaleX(1f);
                view.setScaleY(1f);

            } else if (position <= 1) {
                view.setAlpha(1 - position);

                view.setTranslationX(pageWidth * -position);
                view.setTranslationZ(-1f);

                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else {
                view.setAlpha(0f);
            }
        }
    }
}