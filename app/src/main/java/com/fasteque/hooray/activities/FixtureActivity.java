package com.fasteque.hooray.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.fasteque.hooray.R;
import com.fasteque.hooray.presenters.FixturePresenter;
import com.fasteque.hooray.views.FixtureView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by danielealtomare on 05/05/15.
 * Project: Hooray
 */
public class FixtureActivity extends BaseActivity implements FixtureView {
    private FixturePresenter fixturePresenter;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture);

        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

        fixturePresenter = new FixturePresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fixturePresenter.onResume();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
