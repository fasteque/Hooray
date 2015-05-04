package com.fasteque.hooray.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fasteque.hooray.R;
import com.fasteque.model.entities.Fixture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielealtomare on 04/05/15.
 */
public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.ViewHolder> {
    ArrayList<Fixture> fixtures = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.fixtures_row, parent, false);

        return new ViewHolder(view);
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

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView homeTeam;
        private TextView awayTeam;

        public ViewHolder(View v) {
            super(v);
            homeTeam = (TextView) v.findViewById(R.id.home_team);
            awayTeam = (TextView) v.findViewById(R.id.away_team);

            v.setOnClickListener(this);
        }

        public void bindFixture(Fixture fixture) {
            homeTeam.setText(fixture.getHomeTeamName());
            awayTeam.setText(fixture.getAwayTeamName());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
