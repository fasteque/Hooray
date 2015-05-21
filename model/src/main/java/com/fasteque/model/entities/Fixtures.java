package com.fasteque.model.entities;

import java.util.List;

/**
 * Created by danielealtomare on 26/04/15.
 * Project: Hooray
 */
public class Fixtures {
    /*
        {"timeFrameStart":"2015-04-26","timeFrameEnd":"2015-04-26","count":43,"fixtures":[...]}
     */

    private String timeFrameStart;
    private String timeFrameEnd;
    private int count;
    List<Fixture> fixtures;

    public String getTimeFrameStart() {
        return timeFrameStart;
    }

    public void setTimeFrameStart(String timeFrameStart) {
        this.timeFrameStart = timeFrameStart;
    }

    public String getTimeFrameEnd() {
        return timeFrameEnd;
    }

    public void setTimeFrameEnd(String timeFrameEnd) {
        this.timeFrameEnd = timeFrameEnd;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }
}
