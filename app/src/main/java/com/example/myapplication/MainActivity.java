package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private Map<Integer, Fragment> fragmentMap;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        fragmentMap = new HashMap<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentMap.put(R.id.menu_item_movie, HeroFragment.newInstance());
        fragmentMap.put(R.id.menu_item_tvshow, TvShowFragment.newInstance());
        fragmentMap.put(R.id.menu_item_favorite, FavouriteFragment.newInstance());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_item_movie);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = fragmentMap.get(item.getItemId());
        assert fragment != null;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
        return true;
    }
}
