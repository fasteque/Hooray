package com.fasteque.domain;

import com.fasteque.model.entities.Fixture;
import com.fasteque.model.rest.FootballDataService;

import rx.Observable;

/**
 * Created by danielealtomare on 05/05/15.
 * Project: Hooray
 */
public class GetFixtureUseCaseController implements GetFixtureUseCase {
    private FootballDataService footballDataService = FootballDataService.getInstance();

    @Override
    public Observable<Fixture> requestFixture(String id) {
        return footballDataService.getFixture(id);
    }
}
