package com.udacity.timezones.service;

import com.udacity.timezones.client.FakeWorldTimeClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorldTimeApiHttpClientTest {

    @Test
    public void getAvailableTimeZoneText_givenWorldTimeZones_returnListOfString() {

        List<String> validTimeZones = List.of("Amsterdam", "Andorra", "Astrakhan", "Athens");
        TimeZoneService timeZoneService = new TimeZoneService(new FakeWorldTimeClient(validTimeZones));

        String expectedReturn = "Amsterdam, Andorra, Astrakhan, Athens";

        String timeZoneText = timeZoneService.getAvailableTimezoneText("Europe");

        assertTrue(timeZoneText.contains(expectedReturn));

    }


}
