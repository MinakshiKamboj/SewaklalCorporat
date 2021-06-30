package com.example.sewaklalcorporate.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.sewaklalcorporate.R;

public class SplashActivity extends AppCompatActivity {
    private static int SPALASH_TIME_OUT=3000;
    LinearLayout anm_linear;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        anm_linear=findViewById(R.id.anm_linear);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_layout);
        anm_linear.startAnimation(animation);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
             /*   if (MyPreferences.getActiveInstance(SplashActivity.this).getIsLoggedIn() == true) {
                    Intent intent=new Intent(SplashActivity.this, MainHomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {*/
                    Intent i1 = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i1);
                    finish();
           //     }

            }
        }, SPALASH_TIME_OUT);

    }

}

