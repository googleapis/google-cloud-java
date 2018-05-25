/*
 * Copyright 2017 Google LLC
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

package com.google.cloud;

import static com.google.common.testing.SerializableTester.reserializeAndAssert;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.testing.EqualsTester;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.Timestamp}. */
@RunWith(JUnit4.class)
public class TimestampTest {
  private static final String TEST_TIME_ISO = "2015-10-12T15:14:54Z";
  private static final long TEST_TIME_SECONDS = 1444662894L;
  private static final long TEST_TIME_MICROSECONDS = 10000100L;
  private static final long TEST_TIME_MILLISECONDS =
      TimeUnit.SECONDS.toMillis(1444662894L) + TimeUnit.MICROSECONDS.toMillis(1234);
  private static final Date TEST_DATE = new Date(TEST_TIME_MILLISECONDS);

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void minValue() {
    // MIN_VALUE is before the start of the Gregorian calendar... use magic value.
    assertThat(Timestamp.MIN_VALUE.getSeconds()).isEqualTo(-62135596800L);
    assertThat(Timestamp.MIN_VALUE.getNanos()).isEqualTo(0);
  }

  @Test
  public void maxValue() {
    TimeZone tz = TimeZone.getTimeZone("UTC");
    GregorianCalendar calendar = new GregorianCalendar(tz);
    calendar.set(9999, Calendar.DECEMBER, 31, 23, 59, 59);
    java.sql.Timestamp expectedMin = new java.sql.Timestamp(calendar.getTimeInMillis());
    expectedMin.setNanos(999999999);

    assertThat(Timestamp.MAX_VALUE.getSeconds()).isEqualTo(calendar.getTimeInMillis() / 1000L);
    assertThat(Timestamp.MAX_VALUE.getNanos()).isEqualTo(999999999);
  }

  @Test
  public void ofMicroseconds() {
    Timestamp timestamp = Timestamp.ofTimeMicroseconds(TEST_TIME_MICROSECONDS);
    assertThat(timestamp.getSeconds()).isEqualTo(TEST_TIME_MICROSECONDS / 1000000L);
    assertThat(timestamp.getNanos()).isEqualTo(TEST_TIME_MICROSECONDS % 1000000L * 1000);
  }

  @Test
  public void ofDate() {
    Timestamp timestamp = Timestamp.of(TEST_DATE);
    Long expectedSeconds = TimeUnit.MILLISECONDS.toSeconds(TEST_TIME_MILLISECONDS);
    Long expectedNanos =
        TimeUnit.MILLISECONDS.toNanos(TEST_TIME_MILLISECONDS)
            - TimeUnit.SECONDS.toNanos(expectedSeconds);
    assertThat(timestamp.getSeconds()).isEqualTo(expectedSeconds);
    assertThat(timestamp.getNanos()).isEqualTo(expectedNanos);
  }

  @Test
  public void toDate() {
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(TEST_TIME_SECONDS, 1234 * 1000);
    Date date = timestamp.toDate();
    assertThat(TEST_TIME_MILLISECONDS).isEqualTo(date.getTime());
  }

  @Test
  public void toFromSqlTimestamp() {
    long seconds = TEST_TIME_SECONDS;
    int nanos = 500000000;

    java.sql.Timestamp sqlTs = new java.sql.Timestamp(seconds * 1000);
    sqlTs.setNanos(nanos);

    Timestamp ts = Timestamp.of(sqlTs);
    assertThat(ts.getSeconds()).isEqualTo(seconds);
    assertThat(ts.getNanos()).isEqualTo(nanos);

    assertThat(ts.toSqlTimestamp()).isEqualTo(sqlTs);
  }

  @Test
  public void boundsSecondsMin() {
    expectedException.expect(IllegalArgumentException.class);
    Timestamp.ofTimeSecondsAndNanos(Timestamp.MIN_VALUE.getSeconds() - 1, 999999999);
  }

  @Test
  public void boundsSecondsMax() {
    expectedException.expect(IllegalArgumentException.class);
    Timestamp.ofTimeSecondsAndNanos(Timestamp.MAX_VALUE.getSeconds() + 1, 0);
  }

  @Test
  public void boundsNanosMin() {
    expectedException.expect(IllegalArgumentException.class);
    Timestamp.ofTimeSecondsAndNanos(TEST_TIME_SECONDS, -1);
  }

  @Test
  public void boundsNanosMax() {
    expectedException.expect(IllegalArgumentException.class);
    Timestamp.ofTimeSecondsAndNanos(TEST_TIME_SECONDS, 1000000000);
  }

  @Test
  public void boundsSqlTimestampMin() {
    expectedException.expect(IllegalArgumentException.class);
    Timestamp.of(new java.sql.Timestamp((Timestamp.MIN_VALUE.getSeconds() - 1) * 1000));
  }

  @Test
  public void boundsSqlTimestampMax() {
    expectedException.expect(IllegalArgumentException.class);
    Timestamp.of(new java.sql.Timestamp((Timestamp.MAX_VALUE.getSeconds() + 1) * 1000));
  }

  @Test
  public void equalsAndHashCode() {
    EqualsTester tester = new EqualsTester();
    tester.addEqualityGroup(
        Timestamp.ofTimeSecondsAndNanos(TEST_TIME_SECONDS, 0),
        Timestamp.ofTimeSecondsAndNanos(TEST_TIME_SECONDS, 0),
        Timestamp.of(new java.sql.Timestamp(TEST_TIME_SECONDS * 1000)));
    tester.addEqualityGroup(Timestamp.ofTimeSecondsAndNanos(TEST_TIME_SECONDS + 1, 0));
    tester.addEqualityGroup(Timestamp.ofTimeSecondsAndNanos(TEST_TIME_SECONDS, 1));
    tester.testEquals();
  }

  @Test
  public void testToString() {
    assertThat(Timestamp.MIN_VALUE.toString()).isEqualTo("0001-01-01T00:00:00Z");
    assertThat(Timestamp.MAX_VALUE.toString()).isEqualTo("9999-12-31T23:59:59.999999999Z");
    assertThat(Timestamp.ofTimeSecondsAndNanos(0, 0).toString()).isEqualTo("1970-01-01T00:00:00Z");
    assertThat(Timestamp.ofTimeSecondsAndNanos(0, 100).toString())
        .isEqualTo("1970-01-01T00:00:00.000000100Z");
    assertThat(Timestamp.ofTimeSecondsAndNanos(TEST_TIME_SECONDS, 0).toString())
        .isEqualTo(TEST_TIME_ISO);
  }

  @Test
  public void parseTimestamp() {
    assertThat(Timestamp.parseTimestamp("0001-01-01T00:00:00Z")).isEqualTo(Timestamp.MIN_VALUE);
    assertThat(Timestamp.parseTimestamp("9999-12-31T23:59:59.999999999Z"))
        .isEqualTo(Timestamp.MAX_VALUE);
    assertThat(Timestamp.parseTimestamp(TEST_TIME_ISO))
        .isEqualTo(Timestamp.ofTimeSecondsAndNanos(TEST_TIME_SECONDS, 0));
  }

  @Test
  public void fromProto() {
    com.google.protobuf.Timestamp proto =
        com.google.protobuf.Timestamp.newBuilder().setSeconds(1234).setNanos(567).build();
    Timestamp timestamp = Timestamp.fromProto(proto);
    assertThat(timestamp.getSeconds()).isEqualTo(1234);
    assertThat(timestamp.getNanos()).isEqualTo(567);
  }

  @Test
  public void comparable() {
    assertThat(Timestamp.MIN_VALUE).isLessThan(Timestamp.MAX_VALUE);
    assertThat(Timestamp.MAX_VALUE).isGreaterThan(Timestamp.MIN_VALUE);

    assertThat(Timestamp.ofTimeSecondsAndNanos(100, 0))
        .isAtLeast(Timestamp.ofTimeSecondsAndNanos(100, 0));
    assertThat(Timestamp.ofTimeSecondsAndNanos(100, 0))
        .isAtMost(Timestamp.ofTimeSecondsAndNanos(100, 0));

    assertThat(Timestamp.ofTimeSecondsAndNanos(100, 1000))
        .isLessThan(Timestamp.ofTimeSecondsAndNanos(101, 0));
    assertThat(Timestamp.ofTimeSecondsAndNanos(100, 1000))
        .isAtMost(Timestamp.ofTimeSecondsAndNanos(101, 0));

    assertThat(Timestamp.ofTimeSecondsAndNanos(101, 0))
        .isGreaterThan(Timestamp.ofTimeSecondsAndNanos(100, 1000));
    assertThat(Timestamp.ofTimeSecondsAndNanos(101, 0))
        .isAtLeast(Timestamp.ofTimeSecondsAndNanos(100, 1000));
  }

  @Test
  public void serialization() throws Exception {
    reserializeAndAssert(Timestamp.parseTimestamp("9999-12-31T23:59:59.999999999Z"));
  }
}
