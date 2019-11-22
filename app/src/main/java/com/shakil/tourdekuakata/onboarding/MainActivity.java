package com.shakil.tourdekuakata.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.fxn.BubbleTabBar;
import com.fxn.OnBubbleClickListener;
import com.shakil.tourdekuakata.R;
import com.shakil.tourdekuakata.fragments.HotelsFragment;
import com.shakil.tourdekuakata.fragments.PlacesFragment;
import com.shakil.tourdekuakata.utils.Tools;
public class MainActivity extends AppCompatActivity {
//    private Toolbar toolbar;
    private Tools tools;
    private BubbleTabBar bubbleTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
        createInstances();
        bindUIWithComponents();

    }

    private void init() {
        bubbleTabBar = findViewById(R.id.bubbleTabBar);
    }

    private void createInstances() {
        tools = new Tools(this);
    }

    private void bindUIWithComponents() {

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, PlacesFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();
        bubbleTabBar.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int id) {
                switch (id){
                    case R.id.places:
                        navigateFragment(PlacesFragment.newInstance());
                        return;
                    case R.id.hotels:
                        navigateFragment(HotelsFragment.newInstance());
                        return;
                }
            }
        });

    }

    private void navigateFragment(Fragment newInstance) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, newInstance);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
