package com.udacity.timezones.service;

import com.udacity.timezones.client.WorldClient;

public class TimeZoneService {
    private final WorldClient worldTimeApiRestClient;

    public TimeZoneService(WorldClient worldTimeApiRestClient) {
        this.worldTimeApiRestClient = worldTimeApiRestClient;
    }

    public String getAvailableTimezoneText(String area) {
        return String.format(
                "Available timezones in %s are %s.",
                area,
                String.join(", ", worldTimeApiRestClient.getValidTimeZones(area))
        );
    }
}
