package com.fasteque.model;

import com.fasteque.model.entities.Fixture;
import com.fasteque.model.entities.Fixtures;

import rx.Observable;

/**
 * Created by danielealtomare on 27/04/15.
 * Project: Hooray
 */
public interface FootballDataSource {
    Observable<Fixtures> getFixtures(String timeFrame);
    Observable<Fixture> getFixture(String fixtureId);
}
