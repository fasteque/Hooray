package com.fasteque.model;

import com.fasteque.model.entities.Fixtures;

import rx.Observable;

/**
 * Created by danielealtomare on 27/04/15.
 */
public interface FootballDataSource {
    public Observable<Fixtures> getFixtures(String timeFrame);
}
