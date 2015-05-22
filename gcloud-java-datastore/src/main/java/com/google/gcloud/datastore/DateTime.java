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

package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.DatastoreV1.Value;
import com.google.protobuf.InvalidProtocolBufferException;

import org.joda.time.format.ISODateTimeFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * A Google Cloud Datastore timestamp (represented in micro-seconds).
 * This class is immutable.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore Entities, Properties, and Keys</a>
 */
public final class DateTime extends Serializable<DatastoreV1.Value>
    implements Comparable<DateTime> {

  private static final long serialVersionUID = 7343324797621228378L;

  private final transient long timestampMicroseconds;

  DateTime(long timestampMicroseconds) {
    this.timestampMicroseconds = timestampMicroseconds;
  }

  @Override
  public String toString() {
    return ISODateTimeFormat.dateTime().print(timestampMillis());
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
    return obj == this || obj instanceof DateTime
        && timestampMicroseconds == ((DateTime) obj).timestampMicroseconds;
  }

  public long timestampMicroseconds() {
    return timestampMicroseconds;
  }

  public long timestampMillis() {
    return timestampMicroseconds / 1000L;
  }

  public Date toDate() {
    return new Date(timestampMillis());
  }

  public Calendar toCalendar() {
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(timestampMillis());
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

  @Override
  protected Value toPb() {
    return DatastoreV1.Value.newBuilder().setIntegerValue(timestampMicroseconds).build();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return new DateTime(DatastoreV1.Value.parseFrom(bytesPb).getIntegerValue());
  }
}
