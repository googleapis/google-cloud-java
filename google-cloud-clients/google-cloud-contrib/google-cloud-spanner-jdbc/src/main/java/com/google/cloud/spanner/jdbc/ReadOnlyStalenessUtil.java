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
import com.google.api.client.util.DateTime.SecondsAndNanos;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TimestampBound.Mode;
import com.google.protobuf.Duration;
import com.google.protobuf.util.Durations;
import java.util.concurrent.TimeUnit;

/**
 * Util class for parsing and converting ReadOnlyStaleness values to/from strings. This util is used
 * to parse client side statements and values for read only staleness for read-only transactions on
 * Cloud Spanner.
 */
class ReadOnlyStalenessUtil {
  /**
   * Parses an RFC3339 date/time value with nanosecond precision and returns this as a {@link
   * Timestamp}.
   */
  static Timestamp parseRfc3339(String str) throws SpannerException {
    try {
      SecondsAndNanos secondsAndNanos = DateTime.parseRfc3339ToSecondsAndNanos(str);
      return Timestamp.ofTimeSecondsAndNanos(
          secondsAndNanos.getSeconds(), secondsAndNanos.getNanos());
    } catch (NumberFormatException e) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, String.format("Invalid timestamp: %s", str), e);
    }
  }

  /** The abbreviations for time units that may be used for client side statements. */
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

  /** Get the abbreviation for the given {@link TimeUnit}. */
  static String getTimeUnitAbbreviation(TimeUnit unit) {
    for (TimeUnitAbbreviation abb : TimeUnitAbbreviation.values()) {
      if (abb.unit == unit) return abb.abbreviation;
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT, "Invalid option for time unit: " + unit);
  }

  /** Get the {@link TimeUnit} corresponding with the given abbreviation. */
  static TimeUnit parseTimeUnit(String unit) {
    for (TimeUnitAbbreviation abb : TimeUnitAbbreviation.values()) {
      if (abb.abbreviation.equalsIgnoreCase(unit)) return abb.unit;
    }
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.INVALID_ARGUMENT, "Invalid option for time unit: " + unit);
  }

  /**
   * Internal interface that is used to generalize getting a time duration from Cloud Spanner
   * read-only staleness settings.
   */
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

  static final class MaxStalenessGetter implements DurationValueGetter {
    private final TimestampBound staleness;

    public MaxStalenessGetter(TimestampBound staleness) {
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
        return "MAX_STALENESS " + durationToString(new MaxStalenessGetter(staleness));
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
   * returned by the given function. The most appropriate {@link TimeUnit} is the unit with the
   * least precision that still retains all information of the given input.
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
