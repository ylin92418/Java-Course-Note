package com.udacity.timezones.client;

import java.util.List;

public class FakeWorldTimeClient implements WorldClient {
    private List<String> fakeList;

    public FakeWorldTimeClient(List<String> fakeList) {
        this.fakeList = fakeList;
    }


    @Override
    public List<String> getValidTimeZones(String area) {
        return fakeList;
    }

}
