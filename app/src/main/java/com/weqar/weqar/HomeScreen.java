package com.weqar.weqar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;

import com.weqar.weqar.Fragments.BotNav_DiscountsFragment;
import com.weqar.weqar.Fragments.BotNav_EventsFragment;
import com.weqar.weqar.Fragments.BotNav_JobsFragment;
import com.weqar.weqar.Fragments.BotNav_SettingsFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class HomeScreen extends AppCompatActivity {
    BottomBar bottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setDefaultTab(R.id.botnav_event);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                android.support.v4.app.Fragment selectedFragment = null;
                if (tabId == R.id.botnav_event) {
                    selectedFragment = BotNav_EventsFragment.newInstance();
                }
                else if (tabId == R.id.botnav_discount) {
                    selectedFragment = BotNav_DiscountsFragment.newInstance();

                }
                else if (tabId == R.id.botnav_jobs) {
                    selectedFragment = BotNav_JobsFragment.newInstance();

                }

                else if (tabId == R.id.botnav_settings) {
                    selectedFragment = BotNav_SettingsFragment.newInstance();

                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contentContainer, selectedFragment);
                transaction.commit();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
