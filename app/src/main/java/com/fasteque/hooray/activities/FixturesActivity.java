package com.fasteque.hooray.activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fasteque.hooray.R;
import com.fasteque.hooray.adapters.FixturesAdapter;
import com.fasteque.hooray.presenters.FixturesPresenter;
import com.fasteque.hooray.views.FixturesView;
import com.fasteque.model.entities.Fixture;
import com.fasteque.model.entities.Fixtures;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.android.view.ViewObservable;
import rx.functions.Action1;
import rx.functions.Func1;


public class FixturesActivity extends BaseActivity implements FixturesView {
    private FixturesPresenter fixturesPresenter;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;

    private FixturesAdapter fixturesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);

        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

        fixturesAdapter = new FixturesAdapter();

        // Unsubscribe is automatically performed by bindView method.
        ViewObservable.bindView(recyclerView, fixturesAdapter.onClickFixture())
                .map(new Func1<View, Fixture>() {
                    @Override
                    public Fixture call(View view) {
                        return fixturesAdapter.getFixtureAtPosition(recyclerView.getChildLayoutPosition(view));
                    }
                })
                .map(new Func1<Fixture, String>() {
                    @Override
                    public String call(Fixture fixture) {
                        return fixture.get_links().getSelf().getHref().replaceFirst(".*/([^/?]+).*", "$1");
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        fixturesPresenter.displayFixture(s);
                    }
                });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fixturesAdapter);

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
            //noinspection unchecked
            startActivity(new Intent(this, AboutActivity.class), ActivityOptions
                    .makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(new Intent(this, AboutActivity.class));
        }
    }

    public void displayFixtures(Fixtures fixtures) {
        // FIXME
        fixturesAdapter.insertFixtures(fixtures.getFixtures());
    }
}
