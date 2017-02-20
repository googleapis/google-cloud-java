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

import static com.google.cloud.spanner.TimestampBound.Mode;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.testing.EqualsTester;
import com.google.spanner.v1.TransactionOptions;
import java.util.concurrent.TimeUnit;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.TimestampBound}. */
@RunWith(JUnit4.class)
public class TimestampBoundTest {
  private static final long TEST_TIME_SECONDS = 1444662894L;
  private static final String TEST_TIME_ISO = "2015-10-12T15:14:54Z";
  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void strong() {
    TimestampBound bound = TimestampBound.strong();
    assertThat(bound.getMode()).isEqualTo(Mode.STRONG);
    assertThat(bound.toString()).isEqualTo("strong");
    assertProto(bound, "strong: true");
  }

  @Test
  public void readTimestamp() {
    Timestamp ts = Timestamp.ofTimeSecondsAndNanos(TEST_TIME_SECONDS, 0);
    TimestampBound bound = TimestampBound.ofReadTimestamp(ts);
    assertThat(bound.getMode()).isEqualTo(Mode.READ_TIMESTAMP);
    assertThat(bound.getReadTimestamp()).isEqualTo(ts);
    assertThat(bound.toString()).isEqualTo("exact_timestamp: " + TEST_TIME_ISO);
    assertProto(bound, "read_timestamp { seconds: " + TEST_TIME_SECONDS + " }");
  }

  @Test
  public void minReadTimestamp() {
    Timestamp ts = Timestamp.ofTimeSecondsAndNanos(TEST_TIME_SECONDS, 0);
    TimestampBound bound = TimestampBound.ofMinReadTimestamp(ts);
    assertThat(bound.getMode()).isEqualTo(Mode.MIN_READ_TIMESTAMP);
    assertThat(bound.getMinReadTimestamp()).isEqualTo(ts);
    assertThat(bound.toString()).isEqualTo("min_read_timestamp: " + TEST_TIME_ISO);
    assertProto(bound, "min_read_timestamp { seconds: " + TEST_TIME_SECONDS + " }");
  }

  @Test
  public void exactStaleness() {
    TimestampBound bound = TimestampBound.ofExactStaleness(3140, TimeUnit.MILLISECONDS);
    assertThat(bound.getMode()).isEqualTo(Mode.EXACT_STALENESS);
    assertThat(bound.getExactStaleness(TimeUnit.SECONDS)).isEqualTo(3);
    assertThat(bound.getExactStaleness(TimeUnit.MILLISECONDS)).isEqualTo(3140);
    assertThat(bound.getExactStaleness(TimeUnit.MICROSECONDS)).isEqualTo(3140000);
    assertThat(bound.getExactStaleness(TimeUnit.NANOSECONDS)).isEqualTo(3140000000L);
    assertThat(bound.toString()).isEqualTo("exact_staleness: 3.140s");
    assertProto(bound, "exact_staleness { seconds: 3 nanos: 140000000 }");
  }

  @Test
  public void exactStalenessNegative() {
    expectedException.expect(IllegalArgumentException.class);
    TimestampBound.ofExactStaleness(-1, TimeUnit.SECONDS);
  }

  @Test
  public void maxStaleness() {
    TimestampBound bound = TimestampBound.ofMaxStaleness(3140, TimeUnit.MILLISECONDS);
    assertThat(bound.getMode()).isEqualTo(Mode.MAX_STALENESS);
    assertThat(bound.getMaxStaleness(TimeUnit.SECONDS)).isEqualTo(3);
    assertThat(bound.getMaxStaleness(TimeUnit.MILLISECONDS)).isEqualTo(3140);
    assertThat(bound.getMaxStaleness(TimeUnit.MICROSECONDS)).isEqualTo(3140000);
    assertThat(bound.getMaxStaleness(TimeUnit.NANOSECONDS)).isEqualTo(3140000000L);
    assertThat(bound.toString()).isEqualTo("max_staleness: 3.140s");
    assertProto(bound, "max_staleness { seconds: 3 nanos: 140000000 }");
  }

  @Test
  public void stalenessSourceUnits() {
    long num = 7;
    for (TimeUnit units : TimeUnit.values()) {
      TimestampBound bound = TimestampBound.ofExactStaleness(num, units);
      assertThat(bound.getExactStaleness(TimeUnit.NANOSECONDS))
          .named(units.toString())
          .isEqualTo(units.toNanos(num));
    }
  }

  @Test
  public void maxStalenessNegative() {
    expectedException.expect(IllegalArgumentException.class);
    TimestampBound.ofMaxStaleness(-1, TimeUnit.SECONDS);
  }

  @Test
  public void equalsAndHashCode() {
    Timestamp ts = Timestamp.ofTimeSecondsAndNanos(1444662894L, 0);
    Timestamp ts2 = Timestamp.ofTimeSecondsAndNanos(1444662895L, 0);
    int staleness = 5;
    EqualsTester tester = new EqualsTester();
    tester.addEqualityGroup(TimestampBound.strong(), TimestampBound.strong());
    tester.addEqualityGroup(TimestampBound.ofReadTimestamp(ts), TimestampBound.ofReadTimestamp(ts));
    tester.addEqualityGroup(TimestampBound.ofReadTimestamp(ts2));
    tester.addEqualityGroup(
        TimestampBound.ofMinReadTimestamp(ts), TimestampBound.ofMinReadTimestamp(ts));
    tester.addEqualityGroup(TimestampBound.ofMinReadTimestamp(ts2));
    tester.addEqualityGroup(
        TimestampBound.ofExactStaleness(staleness, TimeUnit.SECONDS),
        TimestampBound.ofExactStaleness(staleness, TimeUnit.SECONDS));
    tester.addEqualityGroup(TimestampBound.ofExactStaleness(staleness, TimeUnit.MILLISECONDS));
    tester.addEqualityGroup(
        TimestampBound.ofMaxStaleness(staleness, TimeUnit.SECONDS),
        TimestampBound.ofMaxStaleness(staleness, TimeUnit.SECONDS));
    tester.addEqualityGroup(TimestampBound.ofMaxStaleness(staleness, TimeUnit.MILLISECONDS));
    tester.testEquals();
  }

  private static void assertProto(TimestampBound bound, String expectedProtoTextFormat) {
    MatcherAssert.assertThat(
        bound.toProto(),
        SpannerMatchers.matchesProto(TransactionOptions.ReadOnly.class, expectedProtoTextFormat));
  }
}
