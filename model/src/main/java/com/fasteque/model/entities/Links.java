package com.fasteque.model.entities;

/**
 * Created by danielealtomare on 05/05/15.
 */
public class Links {
    /*
        "_links":{"self":{"href":"http://api.football-data.org/alpha/fixtures/138374"},
        "soccerseason":{"href":"http://api.football-data.org/alpha/soccerseasons/358"},
        "homeTeam":{"href":"http://api.football-data.org/alpha/teams/84"},
        "awayTeam":{"href":"http://api.football-data.org/alpha/teams/560"}}
     */
    private Self self;
    private SoccerSeason soccerseason;
    private HomeTeam homeTeam;
    private AwayTeam awayTeam;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public SoccerSeason getSoccerseason() {
        return soccerseason;
    }

    public void setSoccerseason(SoccerSeason soccerseason) {
        this.soccerseason = soccerseason;
    }

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }
}
