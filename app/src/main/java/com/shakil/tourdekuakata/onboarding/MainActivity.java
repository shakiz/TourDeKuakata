package com.shakil.tourdekuakata.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import com.shakil.tourdekuakata.R;
import com.shakil.tourdekuakata.fragments.GalleryFragment;
import com.shakil.tourdekuakata.fragments.HotelsFragment;
import com.shakil.tourdekuakata.fragments.PlacesFragment;
import github.com.st235.lib_expandablebottombar.ExpandableBottomBar;
import github.com.st235.lib_expandablebottombar.ExpandableBottomBarMenuItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class MainActivity extends AppCompatActivity {
    private ExpandableBottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
        bindUIWithComponents();

    }

    private void init() {
        bottomBar = findViewById(R.id.bottomNavigationView);
    }

    private void bindUIWithComponents() {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, PlacesFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();

        bottomBar.addItems(new ExpandableBottomBarMenuItem.Builder(this)
                .addItem(R.id.places, R.drawable.ic_places, R.string.places,  Color.DKGRAY)
                .addItem(R.id.hotels, R.drawable.ic_hotel, R.string.hotels, Color.GRAY)
                .addItem(R.id.gallery, R.drawable.ic_gallery, R.string.gallery, Color.GRAY)
                .build());

        bottomBar.setOnItemSelectedListener(new Function2<View, ExpandableBottomBarMenuItem, Unit>() {
            @Override
            public Unit invoke(View view, ExpandableBottomBarMenuItem expandableBottomBarMenuItem) {
                int id = expandableBottomBarMenuItem.getItemId();
                switch (id){
                    case R.id.places:
                        navigateFragment(PlacesFragment.newInstance());
                        break;
                    case R.id.hotels:
                        navigateFragment(HotelsFragment.newInstance());
                        break;
                    case R.id.gallery:
                        navigateFragment(GalleryFragment.newInstance());
                        break;
                }
                return null;
            }
        });

    }

    private void navigateFragment(Fragment newInstance) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, newInstance);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        exitApp();
    }

    public void exitApp(){
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(exitIntent);
    }
}
