package com.weqar.weqar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.weqar.weqar.Fragments.BotNav_DiscountsFragment_Vendor;
import com.weqar.weqar.Fragments.BotNav_EventsFragment_Vendor;
import com.weqar.weqar.Fragments.BotNav_JobsFragment_Vendor;
import com.weqar.weqar.Fragments.BotNav_SettingsFragment_Vendor;


public class HomeScreen_vendor extends AppCompatActivity {
    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_vendor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomBar = findViewById(R.id.bottomBar_vendor);
        bottomBar.setDefaultTab(R.id.botnav_event_vendor);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                android.support.v4.app.Fragment selectedFragment = null;
                if (tabId == R.id.botnav_event_vendor) {
                    selectedFragment = BotNav_EventsFragment_Vendor.newInstance();
                } else if (tabId == R.id.botnav_discount_vendor) {
                    selectedFragment = BotNav_DiscountsFragment_Vendor.newInstance();

                } else if (tabId == R.id.botnav_jobs_vendor) {
                    selectedFragment = BotNav_JobsFragment_Vendor.newInstance();

                } else if (tabId == R.id.botnav_settings_vendor) {
                    selectedFragment = BotNav_SettingsFragment_Vendor.newInstance();

                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contentContainer, selectedFragment);
                transaction.commit();
            }
        });
    }
    @Override
    public void onBackPressed() {

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

}