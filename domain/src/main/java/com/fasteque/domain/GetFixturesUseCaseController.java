package com.fasteque.domain;

import com.fasteque.model.entities.Fixtures;
import com.fasteque.model.rest.FootballDataService;

import rx.Observable;

/**
 * Created by danielealtomare on 28/04/15.
 * Project: Hooray
 */
public class GetFixturesUseCaseController implements GetFixturesUseCase {
    private FootballDataService footballDataService = FootballDataService.getInstance();

    @Override
    public Observable<Fixtures> requestFixtures(String timeFrame) {
        return footballDataService.getFixtures(timeFrame);
    }
}
