package com.fasteque.domain;

/**
 * Created by danielealtomare on 28/04/15.
 */
public interface GetFixturesUseCase extends BaseUseCase {
    void requestFixtures(String timeFrame);
}
