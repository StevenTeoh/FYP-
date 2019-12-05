package com.example.proto2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        BottomNavigationView btmNav = findViewById(R.id.btm_nav);
        btmNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()) {
                case R.id.Fraghome:
                    selectedFragment = new HomeFragment();
                    break;

                case R.id.FragProfile:
                    selectedFragment = new ProfileFragment();
                    break;

                case R.id.FragOthers:
                    selectedFragment = new OthersFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, selectedFragment).commit();

            return true;
        }
    };

}
