/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static org.junit.Assert.*;

import java.math.BigInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link Interval} */
@RunWith(JUnit4.class)
public class IntervalTest {

  @Test
  public void testOfMonths() {
    Interval interval = Interval.ofMonths(10);
    assertEquals(10, interval.getMonths());
    assertEquals(0, interval.getDays());
    assertEquals(BigInteger.ZERO, interval.getNanos());
  }

  @Test
  public void testOfDays() {
    Interval interval = Interval.ofDays(10);
    assertEquals(0, interval.getMonths());
    assertEquals(10, interval.getDays());
    assertEquals(BigInteger.ZERO, interval.getNanos());
  }

  @Test
  public void testOfSeconds() {
    Interval interval = Interval.ofSeconds(10);
    assertEquals(0, interval.getMonths());
    assertEquals(0, interval.getDays());
    assertEquals(BigInteger.valueOf(10000000000L), interval.getNanos());
  }

  @Test
  public void testOfMillis() {
    Interval interval = Interval.ofMillis(10);
    assertEquals(0, interval.getMonths());
    assertEquals(0, interval.getDays());
    assertEquals(BigInteger.valueOf(10000000L), interval.getNanos());
  }

  @Test
  public void testOfMicros() {
    Interval interval = Interval.ofMicros(10);
    assertEquals(0, interval.getMonths());
    assertEquals(0, interval.getDays());
    assertEquals(BigInteger.valueOf(10000), interval.getNanos());
  }

  @Test
  public void testOfNanos() {
    Interval interval = Interval.ofNanos(BigInteger.valueOf(10));
    assertEquals(0, interval.getMonths());
    assertEquals(0, interval.getDays());
    assertEquals(10, interval.getNanos().longValueExact());
  }

  @Test
  public void testFromMonthsDaysNanoseconds() {
    Interval interval = Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(1030));
    assertEquals(10, interval.getMonths());
    assertEquals(20, interval.getDays());
    assertEquals(1030, interval.getNanos().longValueExact());

    Interval interval2 = Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(-1030));
    assertEquals(10, interval2.getMonths());
    assertEquals(20, interval2.getDays());
    assertEquals(-1030, interval2.getNanos().longValueExact());
  }

  @Test
  public void testParseFromString() {
    TestCase[] testCases =
        new TestCase[] {
          // Regular cases
          new TestCase("P1Y2M3DT12H12M6.789000123S", 14, 3, 43926789000123L),
          new TestCase("P1Y2M3DT13H-48M6S", 14, 3, 43926000000000L),
          new TestCase("P1Y2M3D", 14, 3, 0L),
          new TestCase("P1Y2M", 14, 0, 0L),
          new TestCase("P1Y", 12, 0, 0L),
          new TestCase("P2M", 2, 0, 0L),
          new TestCase("P3D", 0, 3, 0L),
          new TestCase("PT4H25M6.7890001S", 0, 0, 15906789000100L),
          new TestCase("PT4H25M6S", 0, 0, 15906000000000L),
          new TestCase("PT4H30S", 0, 0, 14430000000000L),
          new TestCase("PT4H1M", 0, 0, 14460000000000L),
          new TestCase("PT5M", 0, 0, 300000000000L),
          new TestCase("PT6.789S", 0, 0, 6789000000L),
          new TestCase("PT0.123S", 0, 0, 123000000L),
          new TestCase("PT.000000123S", 0, 0, 123L),
          new TestCase("P0Y", 0, 0, 0L),
          new TestCase("P-1Y-2M-3DT-12H-12M-6.789000123S", -14, -3, -43926789000123L),
          new TestCase("P1Y-2M3DT13H-51M6.789S", 10, 3, 43746789000000L),
          new TestCase("P-1Y2M-3DT-13H49M-6.789S", -10, -3, -43866789000000L),
          new TestCase("P1Y2M3DT-4H25M-6.7890001S", 14, 3, -12906789000100L),
          new TestCase("PT100H100M100.5S", 0, 0, 366100500000000L),
          new TestCase("P0Y", 0, 0, 0L), // Zero value
          new TestCase("PT12H30M1S", 0, 0, 45001000000000L), // Only time components, with seconds
          new TestCase("P1Y2M3D", 14, 3, 0L), // Only date components
          new TestCase("P1Y2M3DT12H30M", 14, 3, 45000000000000L), // Date and time, no seconds
          new TestCase("PT0.123456789S", 0, 0, 123456789L), // Fractional seconds with max digits
          new TestCase("PT1H0.5S", 0, 0, 3600500000000L), // Hours and fractional seconds
          new TestCase(
              "P1Y2M3DT12H30M1.23456789S", 14, 3, 45001234567890L), // Years and months to months
          new TestCase(
              "P1Y2M3DT12H30M1,23456789S", 14, 3, 45001234567890L), // Comma as decimal point
          new TestCase("PT.5S", 0, 0, 500000000L), // Fractional seconds without 0 before decimal
          new TestCase("P-1Y2M3DT12H-30M1.234S", -10, 3, 41401234000000L), // Mixed signs
          new TestCase("P1Y-2M3DT-12H30M-1.234S", 10, 3, -41401234000000L), // More mixed signs
          new TestCase("PT1.234000S", 0, 0, 1234000000L), // Trailing zeros after decimal
          new TestCase("PT1.000S", 0, 0, 1000000000L), // All zeros after decimal

          // Large values
          new TestCase("PT87840000H", 0, 0, new BigInteger("316224000000000000000")),
          new TestCase("PT-87840000H", 0, 0, new BigInteger("-316224000000000000000")),
          new TestCase(
              "P2Y1M15DT87839999H59M59.999999999S",
              25,
              15,
              new BigInteger("316223999999999999999")),
          new TestCase(
              "P2Y1M15DT-87839999H-59M-59.999999999S",
              25,
              15,
              new BigInteger("-316223999999999999999")),
        };

    for (TestCase testCase : testCases) {
      Interval interval = Interval.parseFromString(testCase.intervalString);
      assertEquals(testCase.months, interval.getMonths());
      assertEquals(testCase.days, interval.getDays());
      assertEquals(testCase.nanoseconds, interval.getNanos());
    }
  }

  @Test
  public void testParseFromString_InvalidString() {
    String[] invalidStrings =
        new String[] {
          "invalid",
          "P",
          "PT",
          "P1YM",
          "P1Y2M3D4H5M6S", // Missing T
          "P1Y2M3DT4H5M6.S", // Missing decimal value
          "P1Y2M3DT4H5M6.789SS", // Extra S
          "P1Y2M3DT4H5M6.", // Missing value after decimal point
          "P1Y2M3DT4H5M6.ABC", // Non-digit characters after decimal point
          "P1Y2M3", // Missing unit specifier
          "P1Y2M3DT", // Missing time components
          "P-T1H", // Invalid negative sign position
          "PT1H-", // Invalid negative sign position
          "P1Y2M3DT4H5M6.789123456789S", // Too many digits after decimal
          "P1Y2M3DT4H5M6.123.456S", // Multiple decimal points
          "P1Y2M3DT4H5M6.,789S", // Dot and comma both for decimal
        };

    for (String invalidString : invalidStrings) {
      assertThrows(SpannerException.class, () -> Interval.parseFromString(invalidString));
    }
  }

  @Test
  public void testToISO8601() {
    TestCase[] testCases =
        new TestCase[] {
          // Regular cases
          new TestCase(14, 3, 43926789000123L, "P1Y2M3DT12H12M6.789000123S"),
          new TestCase(14, 3, 14706789000000L, "P1Y2M3DT4H5M6.789S"),
          new TestCase(14, 3, 0L, "P1Y2M3D"),
          new TestCase(14, 0, 0L, "P1Y2M"),
          new TestCase(12, 0, 0L, "P1Y"),
          new TestCase(2, 0, 0L, "P2M"),
          new TestCase(0, 3, 0L, "P3D"),
          new TestCase(0, 0, 15906789000000L, "PT4H25M6.789S"),
          new TestCase(0, 0, 14430000000000L, "PT4H30S"),
          new TestCase(0, 0, 300000000000L, "PT5M"),
          new TestCase(0, 0, 6789000000L, "PT6.789S"),
          new TestCase(0, 0, 123000000L, "PT0.123S"),
          new TestCase(0, 0, 123L, "PT0.000000123S"),

          // digits after decimal in multiple of 3s
          new TestCase(0, 0, 100000000L, "PT0.100S"),
          new TestCase(0, 0, 100100000L, "PT0.100100S"),
          new TestCase(0, 0, 100100100L, "PT0.100100100S"),
          new TestCase(0, 0, 9L, "PT0.000000009S"),
          new TestCase(0, 0, 9000L, "PT0.000009S"),
          new TestCase(0, 0, 9000000L, "PT0.009S"),

          // Zero value cases
          new TestCase(0, 0, 0L, "P0Y"),
          new TestCase(0, 0, 0L, "P0Y"), // All zero
          new TestCase(1, 0, 0L, "P1M"), // Only month
          new TestCase(0, 1, 0L, "P1D"), // Only day
          new TestCase(0, 0, 10010L, "PT0.000010010S"), // Only nanoseconds

          // Negative value cases
          new TestCase(-14, -3, -43926789000123L, "P-1Y-2M-3DT-12H-12M-6.789000123S"),
          new TestCase(10, 3, 43746789100000L, "P10M3DT12H9M6.789100S"),
          new TestCase(-10, -3, -43866789010000L, "P-10M-3DT-12H-11M-6.789010S"),
          new TestCase(14, 3, -12906662400000L, "P1Y2M3DT-3H-35M-6.662400S"),

          // Fractional seconds cases
          new TestCase(0, 0, 500000000L, "PT0.500S"), // Fractional seconds
          new TestCase(0, 0, -500000000L, "PT-0.500S"), // Negative fractional seconds

          // Large values
          new TestCase(0, 0, new BigInteger("316224000000000000000"), "PT87840000H"),
          new TestCase(0, 0, new BigInteger("-316224000000000000000"), "PT-87840000H"),
          new TestCase(
              25,
              15,
              new BigInteger("316223999999999999999"),
              "P2Y1M15DT87839999H59M59.999999999S"),
          new TestCase(
              25,
              15,
              new BigInteger("-316223999999999999999"),
              "P2Y1M15DT-87839999H-59M-59.999999999S"),
          new TestCase(13, 0, 0L, "P1Y1M"), // Months normalized to years
          new TestCase(0, 0, 86400000000000L, "PT24H"), // 24 hours
          new TestCase(0, 31, 0L, "P31D"), // 31 days
          new TestCase(-12, 0, 0L, "P-1Y"), // Negative year
        };

    for (TestCase testCase : testCases) {
      Interval interval =
          Interval.builder()
              .setMonths(testCase.months)
              .setDays(testCase.days)
              .setNanos(testCase.nanoseconds)
              .build();

      assertEquals(testCase.intervalString, interval.toISO8601());
    }
  }

  @Test
  public void testGetNanoseconds() {
    Interval interval1 = Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(30040));
    assertEquals(30040, interval1.getNanos().longValueExact());

    Interval interval2 = Interval.fromMonthsDaysNanos(0, 0, BigInteger.valueOf(123456789));
    assertEquals(123456789, interval2.getNanos().longValueExact());

    Interval interval3 = Interval.fromMonthsDaysNanos(-10, -20, BigInteger.valueOf(-123456789));
    assertEquals(-123456789, interval3.getNanos().longValueExact());
  }

  @Test
  public void testEquals() {
    Interval interval1 = Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(30));
    Interval interval2 = Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(30));
    Interval interval3 = Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(31));
    Interval interval4 = Interval.fromMonthsDaysNanos(10, 21, BigInteger.valueOf(30));
    Interval interval5 = Interval.fromMonthsDaysNanos(11, 20, BigInteger.valueOf(30));
    Interval interval6 = Interval.fromMonthsDaysNanos(-10, -20, BigInteger.valueOf(-30));
    Interval interval7 = Interval.fromMonthsDaysNanos(-10, -20, BigInteger.valueOf(-30));

    // Test with identical intervals
    assertEquals(interval1, interval2);
    assertEquals(interval2, interval1); // Check symmetry

    // Test with different intervals
    assertNotEquals(interval1, interval3);
    assertNotEquals(interval1, interval4);
    assertNotEquals(interval1, interval5);

    // Test with negative values
    assertEquals(interval6, interval7);
    assertEquals(interval7, interval6); // Check symmetry

    // Test with different values for each field (including negative)
    assertNotEquals(interval1, Interval.fromMonthsDaysNanos(1, 2, BigInteger.valueOf(3)));
    assertNotEquals(interval1, Interval.fromMonthsDaysNanos(-10, 20, BigInteger.valueOf(30)));
    assertNotEquals(interval1, Interval.fromMonthsDaysNanos(10, -20, BigInteger.valueOf(30)));
    assertNotEquals(interval1, Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(-30)));

    // Test with null and an object that is not an Interval
    assertNotEquals(interval1, null);
    assertNotEquals(interval1, new Object());
  }

  @Test
  public void testHashCode() {
    // Test cases with different combinations of months, days, and nanoseconds
    Interval interval1 = Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(30));
    Interval interval2 = Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(30));
    Interval interval3 = Interval.fromMonthsDaysNanos(11, 20, BigInteger.valueOf(30));
    Interval interval4 = Interval.fromMonthsDaysNanos(10, 21, BigInteger.valueOf(30));
    Interval interval5 = Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(31));
    Interval interval6 = Interval.fromMonthsDaysNanos(-10, -20, BigInteger.valueOf(-30));
    Interval interval7 = Interval.fromMonthsDaysNanos(-10, -20, BigInteger.valueOf(-30));
    Interval interval8 = Interval.fromMonthsDaysNanos(0, 0, BigInteger.ZERO); // Zero values
    Interval interval9 =
        Interval.fromMonthsDaysNanos(1000, 1000, BigInteger.valueOf(1234567890)); // Large values

    // Test with identical intervals
    assertEquals(interval1.hashCode(), interval2.hashCode());
    assertEquals(interval6.hashCode(), interval7.hashCode());

    // Test with different months
    assertNotEquals(interval1.hashCode(), interval3.hashCode());

    // Test with different days
    assertNotEquals(interval1.hashCode(), interval4.hashCode());

    // Test with different nanoseconds
    assertNotEquals(interval1.hashCode(), interval5.hashCode());

    // Test with zero values
    assertNotEquals(interval1.hashCode(), interval8.hashCode());

    // Test with large values
    assertNotEquals(interval1.hashCode(), interval9.hashCode());

    // Test for collision.
    Interval interval10 = Interval.fromMonthsDaysNanos(20, 10, BigInteger.valueOf(50));
    Interval interval11 = Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(50));
    assertNotEquals(interval10.hashCode(), interval11.hashCode());
  }

  private static class TestCase {
    private final String intervalString;
    private final int months;
    private final int days;
    private final BigInteger nanoseconds;

    private TestCase(String intervalString, int months, int days, long nanoseconds) {
      this.intervalString = intervalString;
      this.months = months;
      this.days = days;
      this.nanoseconds = BigInteger.valueOf(nanoseconds);
    }

    private TestCase(String intervalString, int months, int days, BigInteger nanoseconds) {
      this.intervalString = intervalString;
      this.months = months;
      this.days = days;
      this.nanoseconds = nanoseconds;
    }

    private TestCase(int months, int days, long nanoseconds, String intervalString) {
      this.intervalString = intervalString;
      this.months = months;
      this.days = days;
      this.nanoseconds = BigInteger.valueOf(nanoseconds);
    }

    private TestCase(int months, int days, BigInteger nanoseconds, String intervalString) {
      this.intervalString = intervalString;
      this.months = months;
      this.days = days;
      this.nanoseconds = nanoseconds;
    }
  }
}
