/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import org.joda.time.format.ISODateTimeFormat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * A Google Cloud Datastore timestamp (represented in micro-seconds).
 * This class is immutable.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore
 *     Entities, Properties, and Keys</a>
 */
public final class DateTime implements Comparable<DateTime>, Serializable {

  private static final long serialVersionUID = 5152143600571559844L;

  private final long timestampMicroseconds;

  DateTime(long timestampMicroseconds) {
    this.timestampMicroseconds = timestampMicroseconds;
  }

  @Override
  public String toString() {
    return ISODateTimeFormat.dateTime().print(getTimestampMillis());
  }

  @Override
  public int hashCode() {
    return (int) timestampMicroseconds;
  }

  @Override
  public int compareTo(DateTime other) {
    return toDate().compareTo(other.toDate());
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || (obj instanceof DateTime
            && timestampMicroseconds == ((DateTime) obj).timestampMicroseconds);
  }

  /**
   * Returns the value of this timestamp in microseconds.
   */
  @Deprecated
  public long timestampMicroseconds() {
    return getTimestampMicroseconds();
  }

  /**
   * Returns the value of this timestamp in microseconds.
   */
  public long getTimestampMicroseconds() {
    return timestampMicroseconds;
  }

  /**
   * Returns the value of this timestamp in milliseconds.
   */
  @Deprecated
  public long timestampMillis() {
    return getTimestampMillis();
  }

  /**
   * Returns the value of this timestamp in milliseconds.
   */
  public long getTimestampMillis() {
    return timestampMicroseconds / 1000L;
  }

  public Date toDate() {
    return new Date(getTimestampMillis());
  }

  public Calendar toCalendar() {
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(getTimestampMillis());
    return cal;
  }

  public static DateTime now() {
    return copyFrom(new Date());
  }

  public static DateTime copyFrom(Date date) {
    return new DateTime(checkNotNull(date).getTime() * 1000L);
  }

  public static DateTime copyFrom(Calendar calendar) {
    return copyFrom(calendar.getTime());
  }

  com.google.protobuf.Timestamp toPb() {
    return microsecondsToTimestampPb(timestampMicroseconds);
  }

  static long timestampPbToMicroseconds(com.google.protobuf.Timestamp timestampPb) {
    return timestampPb.getSeconds() * 1000000 + timestampPb.getNanos() / 1000;
  }

  static com.google.protobuf.Timestamp microsecondsToTimestampPb(long microseconds) {
    long seconds = microseconds / 1000000;
    int nanos = (int) (microseconds % 1000000) * 1000;
    return com.google.protobuf.Timestamp.newBuilder().setSeconds(seconds).setNanos(nanos).build();
  }
}
