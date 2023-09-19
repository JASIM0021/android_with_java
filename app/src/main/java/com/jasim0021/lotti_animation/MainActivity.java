package com.jasim0021.lotti_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lotView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Using java we can also implement and handle lottie animation conditionally
//        lotView = findViewById(R.id.lotti_animation_view);
//        lotView.setAnimation(R.raw.animation_lotte);
//        lotView.playAnimation();
//        lotView.loop(true);
    }
}