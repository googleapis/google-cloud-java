/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.api.client.util.DateTime;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TimestampBound.Mode;
import com.google.common.base.Strings;
import com.google.protobuf.Duration;
import com.google.protobuf.util.Durations;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Util class for parsing and converting ReadOnlyStaleness values to/from strings. */
class ReadOnlyStalenessUtil {
  private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  /** Regular expression for parsing RFC3339 times. */
  private static final String RFC3339_REGEX =
      "(\\d{4})-(\\d{2})-(\\d{2})" // yyyy-MM-dd
          + "([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d{1,9})?)" // 'T'HH:mm:ss.milliseconds
          + "([Zz]|([+-])(\\d{2}):(\\d{2}))"; // 'Z' or time zone shift HH:mm following '+' or '-'

  private static final Pattern RFC3339_PATTERN = Pattern.compile(RFC3339_REGEX);

  /**
   * Parses an RFC3339 date/time value. This method is largely based on the method {@link
   * DateTime#parseRfc3339(String)}, but with some alterations as Spanner requires nanoseconds
   * precision.
   *
   * @param str Date/time string in RFC3339 format.
   * @throws SpannerException with code {@link ErrorCode#INVALID_ARGUMENT} if {@code str} doesn't
   *     match the RFC3339 standard format; an exception is thrown if {@code str} doesn't match
   *     {@code RFC3339_REGEX} or if it contains a time zone shift but no time.
   */
  static Timestamp parseRfc3339(String str) throws NumberFormatException {
    Matcher matcher = RFC3339_PATTERN.matcher(str);
    if (!matcher.matches()) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, "Invalid date/time format: " + str);
    }

    int year = Integer.parseInt(matcher.group(1)); // yyyy
    int month = Integer.parseInt(matcher.group(2)) - 1; // MM
    int day = Integer.parseInt(matcher.group(3)); // dd
    boolean isTimeGiven = matcher.group(4) != null; // 'T'HH:mm:ss.milliseconds
    String tzShiftRegexGroup = matcher.group(9); // 'Z', or time zone shift HH:mm following '+'/'-'
    boolean isTzShiftGiven = tzShiftRegexGroup != null;
    int hourOfDay = 0;
    int minute = 0;
    int second = 0;
    int nanoseconds = 0;

    if (isTzShiftGiven && !isTimeGiven) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT,
          "Invalid date/time format, cannot specify time zone shift without specifying time: "
              + str);
    }

    if (isTimeGiven) {
      hourOfDay = Integer.parseInt(matcher.group(5)); // HH
      minute = Integer.parseInt(matcher.group(6)); // mm
      second = Integer.parseInt(matcher.group(7)); // ss
      if (matcher.group(8) != null) { // contains .nanoseconds?
        String fraction = Strings.padEnd(matcher.group(8).substring(1), 9, '0');
        nanoseconds = Integer.parseInt(fraction);
      }
    }
    Calendar dateTime = new GregorianCalendar(GMT);
    dateTime.set(year, month, day, hourOfDay, minute, second);
    long value = dateTime.getTimeInMillis();

    if (isTimeGiven && isTzShiftGiven) {
      if (Character.toUpperCase(tzShiftRegexGroup.charAt(0)) != 'Z') {
        int tzShift =
            Integer.parseInt(matcher.group(11)) * 60 // time zone shift HH
                + Integer.parseInt(matcher.group(12)); // time zone shift mm
        if (matcher.group(10).charAt(0) == '-') { // time zone shift + or -
          tzShift = -tzShift;
        }
        value -= tzShift * 60000L; // e.g. if 1 hour ahead of UTC, subtract an hour to get UTC time
      }
    }
    // convert to seconds and nanoseconds
    long secondsSinceEpoch = value / 1000L;
    return Timestamp.ofTimeSecondsAndNanos(secondsSinceEpoch, nanoseconds);
  }

  enum TimeUnitAbbreviation {
    NANOSECONDS("ns", TimeUnit.NANOSECONDS),
    MICROSECONDS("us", TimeUnit.MICROSECONDS),
    MILLISECONDS("ms", TimeUnit.MILLISECONDS),
    SECONDS("s", TimeUnit.SECONDS);

    private final String abbreviation;
    private final TimeUnit unit;

    private TimeUnitAbbreviation(String abbreviation, TimeUnit unit) {
      this.abbreviation = abbreviation;
      this.unit = unit;
    }

    String getAbbreviation() {
      return abbreviation;
    }

    TimeUnit getUnit() {
      return unit;
    }
  }

  static String getTimeUnitAbbreviation(TimeUnit unit) {
    for (TimeUnitAbbreviation abb : TimeUnitAbbreviation.values()) {
      if (abb.unit == unit) return abb.abbreviation;
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT, "Invalid option for time unit: " + unit);
  }

  static TimeUnit parseTimeUnit(String unit) {
    for (TimeUnitAbbreviation abb : TimeUnitAbbreviation.values()) {
      if (abb.abbreviation.equalsIgnoreCase(unit)) return abb.unit;
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT, "Invalid option for time unit: " + unit);
  }

  static interface DurationValueGetter {
    long getDuration(TimeUnit unit);

    boolean hasDuration();
  }

  static final class GetExactStaleness implements DurationValueGetter {
    private final TimestampBound staleness;

    public GetExactStaleness(TimestampBound staleness) {
      this.staleness = staleness;
    }

    @Override
    public long getDuration(TimeUnit unit) {
      return staleness.getExactStaleness(unit);
    }

    @Override
    public boolean hasDuration() {
      return staleness.getMode() == Mode.EXACT_STALENESS;
    }
  }

  static final class GetMaxStaleness implements DurationValueGetter {
    private final TimestampBound staleness;

    public GetMaxStaleness(TimestampBound staleness) {
      this.staleness = staleness;
    }

    @Override
    public long getDuration(TimeUnit unit) {
      return staleness.getMaxStaleness(unit);
    }

    @Override
    public boolean hasDuration() {
      return staleness.getMode() == Mode.MAX_STALENESS;
    }
  }

  static final class DurationGetter implements DurationValueGetter {
    private final Duration duration;

    public DurationGetter(Duration duration) {
      this.duration = duration;
    }

    @Override
    public long getDuration(TimeUnit unit) {
      return durationToUnits(duration, unit);
    }

    @Override
    public boolean hasDuration() {
      return duration.getNanos() > 0 || duration.getSeconds() > 0L;
    }
  }

  /**
   * Converts a {@link TimestampBound} to a human readable string representation.
   *
   * @param staleness The staleness to convert
   * @return a human readable representation of the staleness.
   */
  static String timestampBoundToString(TimestampBound staleness) {
    switch (staleness.getMode()) {
      case STRONG:
        return "STRONG";
      case READ_TIMESTAMP:
        return "READ_TIMESTAMP " + staleness.getReadTimestamp().toString();
      case MIN_READ_TIMESTAMP:
        return "MIN_READ_TIMESTAMP " + staleness.getMinReadTimestamp().toString();
      case EXACT_STALENESS:
        return "EXACT_STALENESS " + durationToString(new GetExactStaleness(staleness));
      case MAX_STALENESS:
        return "MAX_STALENESS " + durationToString(new GetMaxStaleness(staleness));
      default:
        throw new IllegalStateException("Unknown mode: " + staleness.getMode());
    }
  }

  /** The {@link TimeUnit}s that are supported for timeout and staleness durations. */
  static final TimeUnit[] SUPPORTED_UNITS =
      new TimeUnit[] {
        TimeUnit.SECONDS, TimeUnit.MILLISECONDS, TimeUnit.MICROSECONDS, TimeUnit.NANOSECONDS
      };

  /**
   * Converts a duration value to a human readable string. The method will search for the most
   * appropriate {@link TimeUnit} to use to represent the value.
   *
   * @param function The function that should be called to get the duration in a specific {@link
   *     TimeUnit}.
   * @return a human readable value of the duration.
   */
  static String durationToString(DurationValueGetter function) {
    TimeUnit unit = getAppropriateTimeUnit(function);
    return String.valueOf(function.getDuration(unit)) + getTimeUnitAbbreviation(unit);
  }

  /**
   * Calculates the most appropriate {@link TimeUnit} to use to represent the duration that is
   * returned by the given function.
   *
   * @param durationGetter The function that will return the duration in different {@link
   *     TimeUnit}s.
   * @return the most appropriate {@link TimeUnit} to represent the duration.
   */
  static TimeUnit getAppropriateTimeUnit(DurationValueGetter durationGetter) {
    int index = 0;
    if (durationGetter.hasDuration()) {
      for (TimeUnit unit : SUPPORTED_UNITS) {
        long duration = durationGetter.getDuration(unit);
        if (index + 1 < SUPPORTED_UNITS.length) {
          if (duration > 0L
              && duration * 1000 == durationGetter.getDuration(SUPPORTED_UNITS[index + 1])) {
            return unit;
          }
        } else {
          // last unit, we have to use this one
          return unit;
        }
        index++;
      }
      throw new IllegalStateException("Unsupported duration");
    }
    return TimeUnit.NANOSECONDS;
  }

  /** Converts a value into a duration using the specified {@link TimeUnit}. */
  static Duration createDuration(long num, TimeUnit units) {
    switch (units) {
      case NANOSECONDS:
        return Durations.fromNanos(num);
      case MICROSECONDS:
        return Durations.fromMicros(num);
      case MILLISECONDS:
        return Durations.fromMillis(num);
      case SECONDS:
        return Durations.fromSeconds(num);
      default:
        return Durations.fromMillis(units.toMillis(num));
    }
  }

  /** Converts a duration to a number using the specified {@link TimeUnit}. */
  static long durationToUnits(Duration duration, TimeUnit units) {
    switch (units) {
      case NANOSECONDS:
        return Durations.toNanos(duration);
      case MICROSECONDS:
        return Durations.toMicros(duration);
      case MILLISECONDS:
        return Durations.toMillis(duration);
      case SECONDS:
        return Durations.toSeconds(duration);
      default:
        throw new IllegalArgumentException();
    }
  }
}
