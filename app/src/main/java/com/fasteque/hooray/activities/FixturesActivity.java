package com.fasteque.hooray.activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fasteque.hooray.R;
import com.fasteque.hooray.presenters.FixturesPresenter;
import com.fasteque.hooray.views.FixturesView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class FixturesActivity extends BaseActivity implements FixturesView {
    private FixturesPresenter fixturesPresenter;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);

        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

        fixturesPresenter = new FixturesPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fixtures, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            showAbout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fixturesPresenter.onResume();
    }

    @Override
    public Context getContext() {
        return this;
    }

    private void showAbout() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(new Intent(this, AboutActivity.class), ActivityOptions
                    .makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(new Intent(this, AboutActivity.class));
        }
    }
}
