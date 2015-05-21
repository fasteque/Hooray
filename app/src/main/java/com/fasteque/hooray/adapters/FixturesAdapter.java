package com.fasteque.hooray.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fasteque.hooray.R;
import com.fasteque.hooray.common.utils.DateUtils;
import com.fasteque.model.entities.Fixture;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.view.OnClickEvent;
import rx.android.view.ViewObservable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

/**
 * Created by danielealtomare on 04/05/15.
 * Project: Hooray
 */
public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.ViewHolder> {
    private PublishSubject<View> fixtureId = PublishSubject.create();
    ArrayList<Fixture> fixtures = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.fixtures_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        // Unsubscribe is automatically performed by bindView method.
        ViewObservable.bindView(parent, ViewObservable.clicks(view))
                .map(new Func1<OnClickEvent, View>() {
                    @Override
                    public View call(OnClickEvent onClickEvent) {
                        return onClickEvent.view();
                    }
                })
                .subscribe(fixtureId);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindFixture(fixtures.get(position));
    }

    @Override
    public int getItemCount() {
        return fixtures.size();
    }

    public void appendFixtures(List<Fixture> fixtures) {
        this.fixtures.addAll(fixtures);
        notifyDataSetChanged();
    }

    public void insertFixtures(List<Fixture> fixtures) {
        this.fixtures.clear();
        appendFixtures(fixtures);
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fixtureDate;
        private TextView homeTeam;
        private TextView awayTeam;

        public ViewHolder(View v) {
            super(v);
            fixtureDate = (TextView) v.findViewById(R.id.fixture_date);
            homeTeam = (TextView) v.findViewById(R.id.home_team);
            awayTeam = (TextView) v.findViewById(R.id.away_team);
        }

        public void bindFixture(Fixture fixture) {
            fixtureDate.setText(DateUtils.getFormattedDateTime(fixture.getDate(), "h:mm a"));
            homeTeam.setText(fixture.getHomeTeamName());
            awayTeam.setText(fixture.getAwayTeamName());
        }
    }

    public Observable<View> onClickFixture() {
        return fixtureId;
    }

    public Fixture getFixtureAtPosition(int position) {
        if(fixtures.size() > 0 && position < fixtures.size()) {
            return fixtures.get(position);
        } else {
            return null;
        }
    }
}
