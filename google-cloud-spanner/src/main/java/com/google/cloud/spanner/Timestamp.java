/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Strings;
import com.google.protobuf.util.Timestamps;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * Represents a Cloud Spanner timestamp. Timestamps have nanosecond precision and cover the range
 * [0001-01-01, 9999-12-31].
 *
 * <p>{@code Timestamp} instances are immutable.
 */
public final class Timestamp implements Comparable<Timestamp> {
  /** The smallest legal timestamp ("0001-01-01T00:00:00Z"). */
  public static final Timestamp MIN_VALUE = new Timestamp(-62135596800L, 0);

  /** The largest legal timestamp ("9999-12-31T23:59:59Z"). */
  public static final Timestamp MAX_VALUE =
      new Timestamp(253402300799L, (int) TimeUnit.SECONDS.toNanos(1) - 1);

  /** Regexp to split timestamps into date-hour-minute-second and fractional second components. */
  private static final Pattern FORMAT_REGEXP = Pattern.compile("([^\\.]*)(\\.\\d{0,9})?Z");

  private static final long NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1);

  private static final DateTimeFormatter format =
      ISODateTimeFormat.dateHourMinuteSecond().withChronology(GregorianChronology.getInstanceUTC());

  private final long seconds;
  private final int nanos;

  private Timestamp(long seconds, int nanos) {
    this.seconds = seconds;
    this.nanos = nanos;
  }

  /**
   * Creates an instance representing the value of {@code seconds} and {@code nanos} since January
   * 1, 1970, 00:00:00 UTC.
   *
   * @param seconds seconds since January 1, 1970, 00:00:00 UTC. A negative value is the number of
   *     seconds before January 1, 1970, 00:00:00 UTC.
   * @param nanos the fractional seconds component, in the range 0..999999999.
   * @throws IllegalArgumentException if the timestamp is outside the representable range
   */
  public static Timestamp ofTimeSecondsAndNanos(long seconds, int nanos) {
    checkArgument(
        Timestamps.isValid(seconds, nanos), "timestamp out of range: %s, %s", seconds, nanos);
    return new Timestamp(seconds, nanos);
  }

  /**
   * Creates an instance representing the value of {@code timestamp}.
   *
   * @throws IllegalArgumentException if the timestamp is outside the representable range
   */
  public static Timestamp of(java.sql.Timestamp timestamp) {
    return ofTimeSecondsAndNanos(timestamp.getTime() / 1000, timestamp.getNanos());
  }

  /**
   * Returns the number of seconds since January 1, 1970, 00:00:00 UTC. A negative value is the
   * number of seconds before January 1, 1970, 00:00:00 UTC.
   */
  public long getSeconds() {
    return seconds;
  }

  /** Returns the fractional seconds component, in nanoseconds. */
  public int getNanos() {
    return nanos;
  }

  /** Returns a JDBC timestamp initialized to the same point in time as {@code this}. */
  public java.sql.Timestamp toSqlTimestamp() {
    java.sql.Timestamp ts = new java.sql.Timestamp(seconds * 1000);
    ts.setNanos(nanos);
    return ts;
  }

  @Override
  public int compareTo(Timestamp other) {
    int r = Long.compare(seconds, other.seconds);
    if (r == 0) {
      r = Integer.compare(nanos, other.nanos);
    }
    return r;
  }

  static Timestamp fromProto(com.google.protobuf.Timestamp proto) {
    return new Timestamp(proto.getSeconds(), proto.getNanos());
  }

  com.google.protobuf.Timestamp toProto() {
    return com.google.protobuf.Timestamp.newBuilder().setSeconds(seconds).setNanos(nanos).build();
  }

  /**
   * Creates a Timestamp instance from the given string. String is in the RFC 3339 format without
   * the timezone offset (always ends in "Z").
   */
  public static Timestamp parseTimestamp(String timestamp) {
    Matcher matcher = FORMAT_REGEXP.matcher(timestamp);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Cannot parse input: " + timestamp);
    }
    String secondsPart = matcher.group(1);
    String nanosPart = matcher.group(2);
    long seconds;
    seconds = format.parseMillis(secondsPart) / 1000;
    int nanos = 0;
    if (nanosPart != null) {
      String padded = Strings.padEnd(nanosPart.substring(1), 9, '0');
      nanos = Integer.parseInt(padded);
      if (nanos >= TimeUnit.SECONDS.toNanos(1)) {
        throw new IllegalArgumentException(
            "Cannot parse input: " + timestamp + " (nanos out of range)");
      }
    }
    return ofTimeSecondsAndNanos(seconds, nanos);
  }

  StringBuilder toString(StringBuilder b) {
    format.printTo(b, seconds * 1000);
    if (nanos != 0) {
      b.append(String.format(".%09d", nanos));
    }
    b.append('Z');
    return b;
  }

  @Override
  public String toString() {
    return toString(new StringBuilder()).toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Timestamp that = (Timestamp) o;
    return seconds == that.seconds && nanos == that.nanos;
  }

  @Override
  public int hashCode() {
    return Objects.hash(seconds, nanos);
  }

  // TODO(user): Consider adding math operations.
}
