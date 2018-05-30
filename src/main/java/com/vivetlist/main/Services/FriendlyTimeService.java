package com.vivetlist.main.Services;

import com.vivetlist.main.models.User;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Set;
import java.time.Instant;

@Service
public class FriendlyTimeService {
    // in this service, we will convert instants from local values to those that can
    // be stored in our database

    public Instant apptIntoDB(LocalDateTime time, User user) {
        System.out.println("Running the time now, this is what was entered: " + time);
        System.out.println("Result: " + time.atZone(ZoneId.of(user.getTime_zone())).toLocalDateTime());
        return time.atZone(ZoneId.of(user.getTime_zone())).toInstant();
    }

    public String convertApptTime(Instant time, User user) {
        return new SimpleDateFormat("EEE, MMM d yyyy 'at' hh:mma")
    .format(time.atZone(ZoneId.of(user.getTime_zone())));
    }

    public String convertRefillDate(Instant date, User user) {
        return new SimpleDateFormat("EEE, MMM d yyyy").format(date.atZone(ZoneId.of(user.getTime_zone())));
    }

    public ArrayList<String> listTimeZones() {
        ArrayList<String> zones = new ArrayList<>();
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for (String zone : zoneIds) {
            if (zone.contains("US")) {
                zones.add(zone);
            }
        }
        return zones;
    }
}
