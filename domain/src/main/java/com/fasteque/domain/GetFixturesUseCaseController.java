package com.fasteque.domain;

import com.fasteque.model.entities.Fixtures;
import com.fasteque.model.rest.FootballDataService;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by danielealtomare on 28/04/15.
 */
public class GetFixturesUseCaseController implements GetFixturesUseCase {
    private FootballDataService footballDataService = FootballDataService.getInstance();

    @Override
    public void requestFixtures(String timeFrame) {
        footballDataService.getFixtures(timeFrame)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Fixtures>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Fixtures fixtures) {

                    }
                });
    }
}
