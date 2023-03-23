package com.act.moneytransferapi.utils;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

    public static Integer calculateDifference(LocalDate dateOfBirth, LocalDate currentDate) {

        if (dateOfBirth == null || currentDate == null) {
            return null; //"Date of Birth cannot be null";
        }

        return Period.between(dateOfBirth, currentDate).getYears();
    }
}
