package com.act.moneytransferapi;

import com.act.moneytransferapi.utils.AgeCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AgeCalculatorTest {

    //void should_return_true_if_age_is_greater_than_16()
    @Test
    void shouldReturnErrorIfDateOfBirthIsNull() {

        LocalDate dateOfBirth = null;
        LocalDate currentDate = LocalDate.of(2023, 3, 23);

//        AgeCalculator ageCalculator = new AgeCalculator();
        Integer result = AgeCalculator.calculateDifference(dateOfBirth, currentDate);

        assertNull(result);
    }

    @Test
    void shouldReturnErrorIfCurrentDateIsNull() {

        LocalDate dateOfBirth = LocalDate.of(2000, 3, 23);
        LocalDate currentDate = null;

//        AgeCalculator ageCalculator = new AgeCalculator();
        Integer result = AgeCalculator.calculateDifference(dateOfBirth, currentDate);

        assertNull(result);
    }

    @Test
    void shouldReturnTheCorrectDifferenceBetweenCurrentDateAndDateOfBirth() {

        LocalDate dateOfBirth = LocalDate.of(1990, 1, 1);
        LocalDate currentDate = LocalDate.of(2023, 3, 23);

//        AgeCalculator ageCalculator = new AgeCalculator();
        Integer result = AgeCalculator.calculateDifference(dateOfBirth, currentDate);

        assertEquals(33, result);
    }
}
