package com.fasteque.hooray.activities;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.fasteque.hooray.fragments.AboutFragment;

/**
 * Created by danielealtomare on 30/04/15.
 */
public class AboutActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new AboutFragment())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                finishAfterTransition();
            } else {
                finish();
            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
