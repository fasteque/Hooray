package com.fasteque.hooray.presenters;

import com.fasteque.domain.GetFixturesUseCase;
import com.fasteque.domain.GetFixturesUseCaseController;
import com.fasteque.hooray.activities.FixturesActivity;
import com.fasteque.hooray.views.FixturesView;
import com.fasteque.model.entities.Fixtures;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by danielealtomare on 29/04/15.
 */
public class FixturesPresenter implements Presenter {
    private final FixturesView fixturesView;
    private GetFixturesUseCase getFixturesUseCase;

    public FixturesPresenter(FixturesView fixturesView) {
        this.fixturesView = fixturesView;
        this.getFixturesUseCase = new GetFixturesUseCaseController();
    }


    @Override
    public void onResume() {
        requestFixtures("n1");
    }

    private void requestFixtures(String timeFrame) {
        getFixturesUseCase.requestFixtures(timeFrame)
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
                        // FIXME
                        ((FixturesActivity) fixturesView).displayFixtures(fixtures);
                    }
                });
    }
}
