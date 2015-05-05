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
}
