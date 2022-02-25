package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    ImageView imageView;
    Button buttonAnimation, buttonNextAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        buttonAnimation = findViewById(R.id.buttonAnimation);
        animationDrawable = new AnimationDrawable();
        DecimalFormat df = new DecimalFormat("00");
        for (int i = 1; i < 30; i++) {
            animationDrawable.addFrame(ResourcesCompat.getDrawable(getResources(), getResources().getIdentifier("baymax" + df.format(i), "drawable", getPackageName()), null), 40);
        }
        animationDrawable.setOneShot(false);
        imageView.setImageDrawable(animationDrawable);
        AtomicBoolean var = new AtomicBoolean(true);
        buttonAnimation.setOnClickListener(v -> {
            if (var.get()) {
                var.set(false);
                animationDrawable.start();
            } else {
                var.set(true);
                animationDrawable.stop();
            }
        });

    }
}