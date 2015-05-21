package com.fasteque.domain;

import com.fasteque.model.entities.Fixture;

import rx.Observable;

/**
 * Created by danielealtomare on 05/05/15.
 * Project: Hooray
 */
public interface GetFixtureUseCase extends BaseUseCase {
    Observable<Fixture> requestFixture(String id);
}
