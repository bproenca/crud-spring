package bcp;

import static java.time.temporal.ChronoUnit.HOURS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import org.junit.jupiter.api.Test;

public class SimpleDateTests {

    @Test
    public void currentTime() {
        final LocalDate now = LocalDate.now();
        System.out.println(now);
        // there is not much to test here
    }

    @Test
    public void specificTime() {
        LocalDate birthDay = LocalDate.of(1981, Month.FEBRUARY, 03);
        System.out.println(birthDay);
        // there is not much to test here
        birthDay = LocalDate.parse("1981-02-03");
        System.out.println(birthDay);
    }

    @Test
    public void plusDays() {
        LocalDate birthDay = LocalDate.of(1981, Month.FEBRUARY, 03);
        LocalDate dayAfter = birthDay.plusDays(1);
        System.out.println(birthDay + " >> " + dayAfter);
        assertEquals(LocalDate.parse("1981-02-04"), dayAfter);
    }

    @Test
    public void minusMonth() {
        LocalDate birthDay = LocalDate.of(1981, Month.FEBRUARY, 03);
        LocalDate previousMonthSameDay = birthDay.minus(1, ChronoUnit.MONTHS);
        System.out.println(birthDay + " >> " + previousMonthSameDay);
        assertEquals(LocalDate.parse("1981-01-03"), previousMonthSameDay);
    }

    @Test
    public void extractMonth() {
        Month month = LocalDate.of(1990, Month.DECEMBER, 15).getMonth();
        assertEquals(Month.DECEMBER, month);
    }

    @Test
    public void compareDate() {
        assertFalse(LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11")));
        assertTrue(LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11")));
    }

    @Test
    public void formatAndParse() {
        LocalDate someDate = LocalDate.of(2016, 12, 7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = someDate.format(formatter);
        LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);
        
        assertEquals("07/12/2016", formattedDate);
        assertEquals(someDate, parsedDate);
    }

    @Test
    public void boundariesDate() {
        LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
        assertEquals(LocalDateTime.parse("2016-06-12T00:00"), beginningOfDay);
        System.out.println(beginningOfDay);
        
        LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());
        assertEquals(LocalDate.parse("2016-06-01"), firstDayOfMonth);
        System.out.println(firstDayOfMonth);
    }

    @Test
    public void subtractTime() {
        LocalDateTime fiveHoursBefore = LocalDateTime.of(1990, Month.DECEMBER, 15, 16, 52).minusHours(5);
        assertEquals(11, fiveHoursBefore.getHour());
        assertEquals(LocalDateTime.parse("1990-12-15T11:52"), fiveHoursBefore);
        System.out.println(fiveHoursBefore);
    }

    @Test
    public void alterField() {
        LocalDateTime inJune = LocalDateTime.of(1990, Month.DECEMBER, 15, 15, 0).with(Month.JUNE);
        assertEquals(Month.JUNE, inJune.getMonth());
        assertEquals(LocalDateTime.parse("1990-06-15T15:00"), inJune);
        System.out.println(inJune);
    }
    
    @Test
    public void getTimeSpan() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime hourLater = now.plusHours(1);
        Duration span = Duration.between(now, hourLater);
        assertEquals(Duration.ofHours(1), span);
        System.out.println(span + " = '" + hourLater + "' - '" + now + "'");
    }
    
    @Test
    public void truncate() {
        LocalTime truncated = LocalTime.of(15, 12, 34).truncatedTo(ChronoUnit.HOURS);
        assertEquals(LocalTime.parse("15:00"), truncated);
        System.out.println(truncated);
    }

    @Test
    public void plus1h() {
        LocalTime sixThirty = LocalTime.parse("06:30");
        LocalTime sevenThirty = LocalTime.parse("07:30");
        assertEquals(sevenThirty, sixThirty.plus(1, ChronoUnit.HOURS));
        assertEquals(sevenThirty, sixThirty.plus(Duration.ofHours(1)));
        System.out.println(sixThirty + " (+1h) = " + sevenThirty);
    }

    @Test
    public void compareTime() {
        assertTrue(LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30")));
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.NOON);
        System.out.println(LocalTime.MIDNIGHT);
    }

    @Test
    public void daysInMonth() {
        int daysInMonth = YearMonth.of(1990, 2).lengthOfMonth();    
        System.out.println(YearMonth.of(1990, 2));
        assertEquals(28, daysInMonth);
        System.out.println(daysInMonth);
    }

    @Test
    void givenZonedDateTimes_whenIsSameHour_thenCompareTrue() {
        ZonedDateTime newYork = ZonedDateTime.of(2019, 8, 10, 8, 0, 0, 30, ZoneId.of("America/New_York"));
        ZonedDateTime berlin = ZonedDateTime.of(2019, 8, 10, 14, 0, 0, 0, ZoneId.of("Europe/Berlin"));

        System.out.println("'" + newYork + "' = '" + berlin + "'");
        assertTrue(newYork.truncatedTo(HOURS).isEqual(berlin.truncatedTo(HOURS)));
    }

    @Test
    void givenZonedDateTimeAndLocalDateTime_whenIsSameHour_thenCompareTrue() {
        ZonedDateTime newYork = ZonedDateTime.of(2019, 8, 10, 8, 15, 0, 0, ZoneId.of("America/New_York"));
        LocalDateTime local = LocalDateTime.of(2019, 8, 10, 14, 20, 0);
        ZoneId zoneBerlin = ZoneId.of("Europe/Berlin");

        assertTrue(newYork.truncatedTo(HOURS).isEqual(local.atZone(zoneBerlin).truncatedTo(HOURS)));
        System.out.println(newYork);
        System.out.println(local);
    }


    
    @Test
    public void givenZonedDateTimes_whenComparing_thenAssertsPass() {
        ZonedDateTime timeInNewYork = ZonedDateTime.of(2019, 8, 10, 8, 0, 0, 0, ZoneId.of("America/New_York"));
        ZonedDateTime timeInBerlin = ZonedDateTime.of(2019, 8, 10, 14, 0, 0, 0, ZoneId.of("Europe/Berlin"));

        assertFalse(timeInNewYork.isAfter(timeInBerlin));
        assertFalse(timeInNewYork.isBefore(timeInBerlin));

        assertTrue(timeInNewYork.isEqual(timeInBerlin));
        assertFalse(timeInNewYork.equals(timeInBerlin));

        assertEquals(-1, timeInNewYork.compareTo(timeInBerlin));

        System.out.println(timeInNewYork);
        System.out.println(timeInBerlin);
        System.out.println(ZonedDateTime.now());
    }
}
