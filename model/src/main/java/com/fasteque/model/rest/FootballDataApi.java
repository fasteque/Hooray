package com.fasteque.model.rest;

import com.fasteque.model.entities.Fixtures;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by danielealtomare on 27/04/15.
 */
public interface FootballDataApi {
    @GET("/fixtures")
    public Observable<Fixtures>
        getFixtures(@Query("timeFrame") String timeFrame);
}
