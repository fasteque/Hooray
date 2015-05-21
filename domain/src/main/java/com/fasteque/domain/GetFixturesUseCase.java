package com.fasteque.domain;

import com.fasteque.model.entities.Fixtures;

import rx.Observable;

/**
 * Created by danielealtomare on 28/04/15.
 * Project: Hooray
 */
public interface GetFixturesUseCase extends BaseUseCase {
    Observable<Fixtures> requestFixtures(String timeFrame);
}
