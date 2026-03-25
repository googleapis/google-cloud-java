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

import com.google.api.client.util.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents the time duration as a combination of months, days and nanoseconds. Nanoseconds are
 * broken into two components microseconds and nanoFractions, where nanoFractions can range from
 * [-999, 999]. Internally, Spanner supports Interval value with the following range of individual
 * fields: months: [-120000, 120000] days: [-3660000, 3660000] nanoseconds: [-316224000000000000000,
 * 316224000000000000000]. Interval value created outside the specified domain will return error
 * when sent to Spanner backend.
 */
@Immutable
public class Interval implements Serializable {
  private final int months;
  private final int days;
  private final BigInteger nanos;

  private static final long MONTHS_PER_YEAR = 12;
  private static final long MINUTES_PER_HOUR = 60;
  private static final long SECONDS_PER_MINUTE = 60;
  private static final long SECONDS_PER_HOUR = MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
  private static final long MILLIS_PER_SECOND = 1000;
  private static final long MICROS_PER_MILLI = 1000;
  private static final long NANOS_PER_MICRO = 1000;
  private static final long MICROS_PER_SECOND = MICROS_PER_MILLI * MILLIS_PER_SECOND;
  private static final long MICROS_PER_MINUTE = SECONDS_PER_MINUTE * MICROS_PER_SECOND;
  private static final long MICROS_PER_HOUR = SECONDS_PER_HOUR * MICROS_PER_SECOND;
  private static final BigInteger NANOS_PER_MILLI =
      BigInteger.valueOf(MICROS_PER_MILLI * NANOS_PER_MICRO);
  private static final BigInteger NANOS_PER_SECOND =
      BigInteger.valueOf(MICROS_PER_SECOND * NANOS_PER_MICRO);
  private static final BigInteger NANOS_PER_MINUTE =
      BigInteger.valueOf(MICROS_PER_MINUTE * NANOS_PER_MICRO);
  private static final BigInteger NANOS_PER_HOUR =
      BigInteger.valueOf(MICROS_PER_HOUR * NANOS_PER_MICRO);
  private static final Interval ZERO = Interval.builder().build();

  /** Regex to parse ISO8601 interval format- `P[n]Y[n]M[n]DT[n]H[n]M[n([.,][fraction])]S` */
  private static final Pattern INTERVAL_PATTERN =
      Pattern.compile(
          "^P(?!$)(-?\\d+Y)?(-?\\d+M)?(-?\\d+D)?(T(?=-?[.,]?\\d)(-?\\d+H)?(-?\\d+M)?(-?((\\d+([.,]\\d{1,9})?)|([.,]\\d{1,9}))S)?)?$");

  private Interval(int months, int days, BigInteger nanos) {
    this.months = months;
    this.days = days;
    this.nanos = nanos;
  }

  /** Returns the months component of the interval. */
  public int getMonths() {
    return months;
  }

  /** Returns the days component of the interval. */
  public int getDays() {
    return days;
  }

  /** Returns the nanoseconds component of the interval. */
  public BigInteger getNanos() {
    return nanos;
  }

  public static Builder builder() {
    return new Builder();
  }

  /** Creates an interval with specified number of months. */
  public static Interval ofMonths(int months) {
    return builder().setMonths(months).build();
  }

  /** Creates an interval with specified number of days. */
  public static Interval ofDays(int days) {
    return builder().setDays(days).build();
  }

  /** Creates an interval with specified number of seconds. */
  public static Interval ofSeconds(long seconds) {
    return builder().setNanos(BigInteger.valueOf(seconds).multiply(NANOS_PER_SECOND)).build();
  }

  /** Creates an interval with specified number of milliseconds. */
  public static Interval ofMillis(long millis) {
    return builder().setNanos(BigInteger.valueOf(millis).multiply(NANOS_PER_MILLI)).build();
  }

  /** Creates an interval with specified number of microseconds. */
  public static Interval ofMicros(long micros) {
    return builder()
        .setNanos(BigInteger.valueOf(micros).multiply(BigInteger.valueOf(NANOS_PER_MICRO)))
        .build();
  }

  /** Creates an interval with specified number of nanoseconds. */
  public static Interval ofNanos(BigInteger nanos) {
    return builder().setNanos(nanos).build();
  }

  /** Creates an interval with specified number of months, days and nanoseconds. */
  public static Interval fromMonthsDaysNanos(int months, int days, BigInteger nanos) {
    return builder().setMonths(months).setDays(days).setNanos(nanos).build();
  }

  private static String getNullOrDefault(Matcher matcher, int groupIdx) {
    String value = matcher.group(groupIdx);
    return value == null ? "0" : value;
  }

  /* Parses ISO8601 duration format string to Interval. */
  public static Interval parseFromString(String interval) {
    Matcher matcher = INTERVAL_PATTERN.matcher(interval);
    if (!matcher.matches()) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, "Invalid Interval String: " + interval);
    }

    long years = Long.parseLong(getNullOrDefault(matcher, 1).replace("Y", ""));
    long months = Long.parseLong(getNullOrDefault(matcher, 2).replace("M", ""));
    long days = Long.parseLong(getNullOrDefault(matcher, 3).replace("D", ""));
    long hours = Long.parseLong(getNullOrDefault(matcher, 5).replace("H", ""));
    long minutes = Long.parseLong(getNullOrDefault(matcher, 6).replace("M", ""));
    BigDecimal seconds =
        new BigDecimal(getNullOrDefault(matcher, 7).replace("S", "").replace(",", "."));

    long totalMonths = Math.addExact(Math.multiplyExact(years, MONTHS_PER_YEAR), months);
    BigInteger totalNanos = seconds.movePointRight(9).toBigInteger();
    totalNanos =
        totalNanos.add(BigInteger.valueOf(minutes * SECONDS_PER_MINUTE).multiply(NANOS_PER_SECOND));
    totalNanos =
        totalNanos.add(BigInteger.valueOf(hours * SECONDS_PER_HOUR).multiply(NANOS_PER_SECOND));

    return Interval.builder()
        .setMonths(Math.toIntExact(totalMonths))
        .setDays(Math.toIntExact(days))
        .setNanos(totalNanos)
        .build();
  }

  /** Converts Interval to ISO8601 duration format string. */
  public String toISO8601() {
    if (this.equals(ZERO)) {
      return "P0Y";
    }

    StringBuilder result = new StringBuilder();
    result.append("P");

    long monthsPart = this.getMonths();
    long yearsPart = monthsPart / MONTHS_PER_YEAR;
    monthsPart = monthsPart - yearsPart * MONTHS_PER_YEAR;

    if (yearsPart != 0) {
      result.append(String.format("%dY", yearsPart));
    }

    if (monthsPart != 0) {
      result.append(String.format("%dM", monthsPart));
    }

    if (this.getDays() != 0) {
      result.append(String.format("%dD", this.getDays()));
    }

    BigInteger nanos = this.getNanos();
    BigInteger zero = BigInteger.valueOf(0);
    if (nanos.compareTo(zero) != 0) {
      result.append("T");
      BigInteger hoursPart = nanos.divide(NANOS_PER_HOUR);
      nanos = nanos.subtract(hoursPart.multiply(NANOS_PER_HOUR));
      if (hoursPart.compareTo(zero) != 0) {
        result.append(String.format("%sH", hoursPart));
      }

      BigInteger minutesPart = nanos.divide(NANOS_PER_MINUTE);
      nanos = nanos.subtract(minutesPart.multiply(NANOS_PER_MINUTE));
      if (minutesPart.compareTo(zero) != 0) {
        result.append(String.format("%sM", minutesPart));
      }

      if (!nanos.equals(zero)) {
        String secondsSign = "";
        if (nanos.signum() == -1) {
          secondsSign = "-";
          nanos = nanos.negate();
        }

        BigInteger seconds_part = nanos.divide(NANOS_PER_SECOND);
        nanos = nanos.subtract(seconds_part.multiply(NANOS_PER_SECOND));
        result.append(String.format("%s%s", secondsSign, seconds_part));

        if (!nanos.equals(zero)) {
          result.append(String.format(".%09d", nanos).replaceAll("(0{3})+$", ""));
        }
        result.append("S");
      }
    }

    return result.toString();
  }

  @Override
  public String toString() {
    return toISO8601();
  }

  @Override
  public boolean equals(Object rhs) {
    if (!(rhs instanceof Interval)) {
      return false;
    }

    Interval anotherInterval = (Interval) rhs;
    return getMonths() == anotherInterval.getMonths()
        && getDays() == anotherInterval.getDays()
        && getNanos().equals(anotherInterval.getNanos());
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + Integer.valueOf(getMonths()).hashCode();
    result = 31 * result + Integer.valueOf(getDays()).hashCode();
    result = 31 * result + getNanos().hashCode();
    return result;
  }

  public static class Builder {
    private int months = 0;
    private int days = 0;
    private BigInteger nanos = BigInteger.ZERO;

    Builder setMonths(int months) {
      this.months = months;
      return this;
    }

    Builder setDays(int days) {
      this.days = days;
      return this;
    }

    Builder setNanos(BigInteger nanos) {
      this.nanos = Preconditions.checkNotNull(nanos);
      return this;
    }

    public Interval build() {
      return new Interval(months, days, nanos);
    }
  }
}
