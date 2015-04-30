package com.fasteque.hooray.presenters;

import com.fasteque.domain.GetFixturesUseCase;
import com.fasteque.domain.GetFixturesUseCaseController;
import com.fasteque.hooray.views.FixturesView;

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
        getFixturesUseCase.requestFixtures("n1");
    }
}
