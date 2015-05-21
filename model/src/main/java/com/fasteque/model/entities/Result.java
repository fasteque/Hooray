package com.fasteque.model.entities;

/**
 * Created by danielealtomare on 26/04/15.
 * Project: Hooray
 */
public class Result {
    /*
        "result":{"goalsHomeTeam":-1,"goalsAwayTeam":-1}
     */
    private int goalsHomeTeam;
    private int goalsAwayTeam;

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(int goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(int goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }
}
