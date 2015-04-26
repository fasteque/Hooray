package com.fasteque.model.entities;

public class Fixture {
    /*
        {"_links":{"self":{"href":"http://api.football-data.org/alpha/fixtures/138374"},
        "soccerseason":{"href":"http://api.football-data.org/alpha/soccerseasons/358"},
        "homeTeam":{"href":"http://api.football-data.org/alpha/teams/84"},
        "awayTeam":{"href":"http://api.football-data.org/alpha/teams/560"}},
        "date":"2015-04-26T10:00:00Z",
        "status":"TIMED",
        "matchday":33,
        "homeTeamName":"FC Málaga",
        "awayTeamName":"Deportivo La Coruna",
        "result":{"goalsHomeTeam":-1,"goalsAwayTeam":-1}}
     */
    private String date;
    private String status;
    private int matchday;
    private String homeTeamName;
    private String awayTeamName;
    private Result result;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
