package com.shakil.tourdekuakata.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.shakil.tourdekuakata.R;

public class UX {
    private Context context;

    public UX(Context context) {
        this.context = context;
    }
    public void setToolbar(Toolbar toolbar, final Activity from, final Class to){
        ((AppCompatActivity) context).setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(from, to));
            }
        });
        ((AppCompatActivity) context).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left_arrow);
    }

}
