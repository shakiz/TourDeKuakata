package com.shakil.tourdekuakata.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.shakil.tourdekuakata.R;
import in.codeshuffle.typewriterview.TypeWriterView;

public class SplashActivity extends AppCompatActivity {
    private RelativeLayout mainLayout;
    private TypeWriterView Welcome;

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

        Typeface typeface = ResourcesCompat.getFont(this, R.font.angelica);

        Welcome.setTypeface(typeface);
        Welcome.setDelay(4);
        Welcome.setWithMusic(false);
        Welcome.animateText(getResources().getString(R.string.welcome));


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                Welcome.removeAnimation();
            }
        }, 1400);
    }

    private void createInstances() {
    }

    private void init() {
        mainLayout = findViewById(R.id.Splash_Layout);
        Welcome = findViewById(R.id.Welcome);
    }
}
