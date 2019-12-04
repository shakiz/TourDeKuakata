package com.shakil.tourdekuakata.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.shakil.tourdekuakata.R;

public class SplashActivity extends AppCompatActivity {
    private RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mainLayout.startAnimation(a);

        createInstances();
        bindUIWithComponents();
    }

    private void bindUIWithComponents() {
    }

    private void createInstances() {
    }

    private void init() {
        mainLayout = findViewById(R.id.Splash_Layout);
    }
}
