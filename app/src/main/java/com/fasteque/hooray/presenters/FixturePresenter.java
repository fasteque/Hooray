package com.fasteque.hooray.presenters;

import com.fasteque.domain.GetFixtureUseCase;
import com.fasteque.domain.GetFixtureUseCaseController;
import com.fasteque.hooray.views.FixtureView;

/**
 * Created by danielealtomare on 05/05/15.
 */
public class FixturePresenter implements Presenter {
    private final FixtureView fixtureView;
    private GetFixtureUseCase getFixtureUseCase;

    public FixturePresenter(FixtureView fixtureView) {
        this.fixtureView = fixtureView;
        getFixtureUseCase = new GetFixtureUseCaseController();
    }

    @Override
    public void onResume() {
        requestFixture(""); // FIXME
    }

    private void requestFixture(String id) {
        // TODO
    }
}
