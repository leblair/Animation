package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.atomic.AtomicBoolean;

public class Spaceship extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    ImageView imageView;
    Button buttonAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spaceship);

        imageView = findViewById(R.id.imageView3);
        buttonAnimation = findViewById(R.id.buttonspaceship);

        animationDrawable = new AnimationDrawable();
        //DecimalFormat df = new DecimalFormat("00");
        for (int i = 1; i <= 225; i++) {
            animationDrawable.addFrame(ResourcesCompat.getDrawable(getResources(), getResources().getIdentifier("spaceship" + i, "drawable", getPackageName()), null), 40);
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