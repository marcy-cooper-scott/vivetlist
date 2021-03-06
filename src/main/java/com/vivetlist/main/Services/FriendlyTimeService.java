package com.vivetlist.main.Services;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FriendlyTimeService {
    public String convertApptTime(Date date) {
        return new SimpleDateFormat("EEE, MMM d yyyy 'at' hh:mma")
    .format(date);
    }

    public String convertRefillDate(Date date) {
        return new SimpleDateFormat("EEE, MMM d yyyy").format(date);
    }
}
