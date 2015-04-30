package com.fasteque.model.rest;

import com.fasteque.model.FootballDataSource;
import com.fasteque.model.entities.Fixtures;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import rx.Observable;

/**
 * Created by danielealtomare on 27/04/15.
 */
public class FootballDataService implements FootballDataSource {
    private static final String FOOTBALL_DATA_ENDPOINT = "http://api.football-data.org/alpha";

    public static FootballDataService instance;
    private final FootballDataApi footballDataApi;

    private FootballDataService() {
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
                request.addHeader("X-Auth-Token", "e0c65de08585455193067369c08d4fdc");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(FOOTBALL_DATA_ENDPOINT)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();


        footballDataApi = restAdapter.create(FootballDataApi.class);
    }

    public static FootballDataService getInstance() {
        if (instance == null) {
            instance = new FootballDataService();
        }

        return instance;
    }

    @Override
    public Observable<Fixtures> getFixtures(String timeFrame) {
        return footballDataApi.getFixtures(timeFrame);
    }
}
