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

import static com.google.cloud.spanner.jdbc.ReadOnlyStalenessUtil.durationToString;
import static com.google.cloud.spanner.jdbc.ReadOnlyStalenessUtil.getTimeUnitAbbreviation;
import static com.google.cloud.spanner.jdbc.ReadOnlyStalenessUtil.parseRfc3339;
import static com.google.cloud.spanner.jdbc.ReadOnlyStalenessUtil.parseTimeUnit;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.TimestampBound;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadOnlyStalenessUtilTest {

  @Test
  public void testParseRfc3339() {
    Map<String, Timestamp> timestamps = new HashMap<>();
    timestamps.put(
        "2018-03-01T10:11:12.999Z", Timestamp.ofTimeSecondsAndNanos(1519899072L, 999000000));
    timestamps.put("2018-10-28T02:00:00+02:00", Timestamp.ofTimeSecondsAndNanos(1540684800L, 0));
    timestamps.put("2018-10-28T03:00:00+01:00", Timestamp.ofTimeSecondsAndNanos(1540692000L, 0));
    timestamps.put(
        "2018-01-01T00:00:00.000000001Z", Timestamp.ofTimeSecondsAndNanos(1514764800L, 1));
    timestamps.put("2018-10-28T02:00:00Z", Timestamp.ofTimeSecondsAndNanos(1540692000L, 0));
    timestamps.put(
        "2018-12-31T23:59:59.999999999Z", Timestamp.ofTimeSecondsAndNanos(1546300799L, 999999999));
    timestamps.put(
        "2018-03-01T10:11:12.9999Z", Timestamp.ofTimeSecondsAndNanos(1519899072L, 999900000));
    timestamps.put(
        "2018-03-01T10:11:12.000000001Z", Timestamp.ofTimeSecondsAndNanos(1519899072L, 1));
    timestamps.put(
        "2018-03-01T10:11:12.100000000Z", Timestamp.ofTimeSecondsAndNanos(1519899072L, 100000000));
    timestamps.put(
        "2018-03-01T10:11:12.100000001Z", Timestamp.ofTimeSecondsAndNanos(1519899072L, 100000001));
    timestamps.put("2018-03-01T10:11:12-10:00", Timestamp.ofTimeSecondsAndNanos(1519935072L, 0));
    timestamps.put(
        "2018-03-01T10:11:12.999999999Z", Timestamp.ofTimeSecondsAndNanos(1519899072L, 999999999));
    timestamps.put("2018-03-01T10:11:12-12:00", Timestamp.ofTimeSecondsAndNanos(1519942272L, 0));
    timestamps.put("2018-10-28T03:00:00Z", Timestamp.ofTimeSecondsAndNanos(1540695600L, 0));
    timestamps.put("2018-10-28T02:30:00Z", Timestamp.ofTimeSecondsAndNanos(1540693800L, 0));
    timestamps.put(
        "2018-03-01T10:11:12.123Z", Timestamp.ofTimeSecondsAndNanos(1519899072L, 123000000));
    timestamps.put("2018-10-28T02:30:00+02:00", Timestamp.ofTimeSecondsAndNanos(1540686600L, 0));
    timestamps.put(
        "2018-03-01T10:11:12.123456789Z", Timestamp.ofTimeSecondsAndNanos(1519899072L, 123456789));
    timestamps.put(
        "2018-03-01T10:11:12.1000Z", Timestamp.ofTimeSecondsAndNanos(1519899072L, 100000000));

    for (Entry<String, Timestamp> ts : timestamps.entrySet()) {
      Timestamp gTimestamp = parseRfc3339(ts.getKey());
      assertThat(
          "Seconds for timestamp " + ts + " do not match",
          gTimestamp.getSeconds(),
          is(equalTo(ts.getValue().getSeconds())));
      assertThat(
          "Nanos for timestamp " + ts + " do not match",
          gTimestamp.getNanos(),
          is(equalTo(ts.getValue().getNanos())));
    }
  }

  @Test
  public void testParseTimeUnit() {
    assertThat(parseTimeUnit("s"), is(equalTo(TimeUnit.SECONDS)));
    assertThat(parseTimeUnit("ms"), is(equalTo(TimeUnit.MILLISECONDS)));
    assertThat(parseTimeUnit("us"), is(equalTo(TimeUnit.MICROSECONDS)));
    assertThat(parseTimeUnit("ns"), is(equalTo(TimeUnit.NANOSECONDS)));
  }

  @Test
  public void testGetTimeUnitAbbreviation() {
    assertThat(getTimeUnitAbbreviation(TimeUnit.SECONDS), is(equalTo("s")));
    assertThat(getTimeUnitAbbreviation(TimeUnit.MILLISECONDS), is(equalTo("ms")));
    assertThat(getTimeUnitAbbreviation(TimeUnit.MICROSECONDS), is(equalTo("us")));
    assertThat(getTimeUnitAbbreviation(TimeUnit.NANOSECONDS), is(equalTo("ns")));

    List<TimeUnit> supportedTimeUnits =
        Arrays.asList(
            TimeUnit.SECONDS, TimeUnit.MILLISECONDS, TimeUnit.MICROSECONDS, TimeUnit.NANOSECONDS);
    for (TimeUnit unit : TimeUnit.values()) {
      if (supportedTimeUnits.contains(unit)) {
        assertThat(getTimeUnitAbbreviation(unit), is(notNullValue()));
      } else {
        String value = null;
        try {
          value = getTimeUnitAbbreviation(unit);
        } catch (SpannerException e) {
          if (e.getErrorCode() == ErrorCode.INVALID_ARGUMENT) {
            value = "unsupported";
          }
        }
        assertThat(value, is(equalTo("unsupported")));
      }
    }
  }

  @Test
  public void testStalenessToString() {
    assertThat(
        durationToString(
            new ReadOnlyStalenessUtil.MaxStalenessGetter(
                TimestampBound.ofMaxStaleness(10L, TimeUnit.NANOSECONDS))),
        is(equalTo("10ns")));
    assertThat(
        durationToString(
            new ReadOnlyStalenessUtil.MaxStalenessGetter(
                TimestampBound.ofMaxStaleness(1000L, TimeUnit.NANOSECONDS))),
        is(equalTo("1us")));
    assertThat(
        durationToString(
            new ReadOnlyStalenessUtil.MaxStalenessGetter(
                TimestampBound.ofMaxStaleness(100000L, TimeUnit.NANOSECONDS))),
        is(equalTo("100us")));
    assertThat(
        durationToString(
            new ReadOnlyStalenessUtil.MaxStalenessGetter(
                TimestampBound.ofMaxStaleness(999999L, TimeUnit.NANOSECONDS))),
        is(equalTo("999999ns")));
    assertThat(
        durationToString(
            new ReadOnlyStalenessUtil.MaxStalenessGetter(
                TimestampBound.ofMaxStaleness(1L, TimeUnit.SECONDS))),
        is(equalTo("1s")));
    assertThat(
        durationToString(
            new ReadOnlyStalenessUtil.MaxStalenessGetter(
                TimestampBound.ofMaxStaleness(1000L, TimeUnit.MILLISECONDS))),
        is(equalTo("1s")));
    assertThat(
        durationToString(
            new ReadOnlyStalenessUtil.MaxStalenessGetter(
                TimestampBound.ofMaxStaleness(1001L, TimeUnit.MILLISECONDS))),
        is(equalTo("1001ms")));
    assertThat(
        durationToString(
            new ReadOnlyStalenessUtil.MaxStalenessGetter(
                TimestampBound.ofMaxStaleness(1000000000L, TimeUnit.NANOSECONDS))),
        is(equalTo("1s")));
  }
}
