package com.fasteque.hooray.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;

import com.fasteque.hooray.R;

/**
 * Created by danielealtomare on 30/04/15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if(getSupportActionBar() != null) {
                getSupportActionBar().setElevation(0);
            }


            getWindow().setNavigationBarColor(getResources().getColor(R.color.primary_dark));
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Fade());
            getWindow().setAllowEnterTransitionOverlap(true);
        }
    }
}
