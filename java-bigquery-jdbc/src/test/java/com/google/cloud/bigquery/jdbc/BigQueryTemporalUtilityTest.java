/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;

import java.time.Instant;
import org.junit.jupiter.api.Test;

public class BigQueryTemporalUtilityTest {

  @Test
  public void testFormatTimestampString() {
    assertThat(BigQueryTemporalUtility.formatTimestampString("1775642400.123456789", false))
        .isEqualTo("2026-04-08 10:00:00.123456");
    assertThat(BigQueryTemporalUtility.formatTimestampString("1775642400.123456789", true))
        .isEqualTo("2026-04-08 10:00:00.123456789");
    assertThat(BigQueryTemporalUtility.formatTimestampString("1775642400", false))
        .isEqualTo("2026-04-08 10:00:00.000000");
    assertThat(BigQueryTemporalUtility.formatTimestampString("0.123", false))
        .isEqualTo("1970-01-01 00:00:00.123000");
    assertThat(BigQueryTemporalUtility.formatTimestampString("-0.123456", false))
        .isEqualTo("1969-12-31 23:59:59.876544");
    assertThat(BigQueryTemporalUtility.formatTimestampString("-1.500000", false))
        .isEqualTo("1969-12-31 23:59:58.500000");
    assertThat(BigQueryTemporalUtility.formatTimestampString("-1.000000", false))
        .isEqualTo("1969-12-31 23:59:59.000000");
    assertThat(BigQueryTemporalUtility.formatTimestampString("-0.123456789123", true))
        .isEqualTo("1969-12-31 23:59:59.876543210877");
    assertThat(BigQueryTemporalUtility.formatTimestampString("1.6905474E9", false))
        .isEqualTo("2023-07-28 12:30:00.000000");
    assertThat(BigQueryTemporalUtility.formatTimestampString("1.690547400123456E9", true))
        .isEqualTo("2023-07-28 12:30:00.123456");
  }

  @Test
  public void testFormatTimestampStringFromMicroseconds() {
    assertThat(BigQueryTemporalUtility.formatTimestampStringFromMicroseconds(1775642400123456L))
        .isEqualTo("2026-04-08 10:00:00.123456");
    assertThat(BigQueryTemporalUtility.formatTimestampStringFromMicroseconds(-123456L))
        .isEqualTo("1969-12-31 23:59:59.876544");
  }

  @Test
  public void testFormatTimestampStringFromIso() {
    assertThat(
            BigQueryTemporalUtility.formatTimestampStringFromIso(
                "2026-04-08T10:00:00.123456789123Z", false))
        .isEqualTo("2026-04-08 10:00:00.123456");
    assertThat(
            BigQueryTemporalUtility.formatTimestampStringFromIso(
                "2026-04-08T10:00:00.123456789123Z", true))
        .isEqualTo("2026-04-08 10:00:00.123456789123");
    assertThat(BigQueryTemporalUtility.formatTimestampStringFromIso("2026-04-08T10:00:00Z", false))
        .isEqualTo("2026-04-08 10:00:00.000000");
  }

  @Test
  public void testBoxTimestamp() {
    // ISO format with UTC suffix and 12-digit picoseconds
    java.sql.Timestamp tsUtc =
        BigQueryTemporalUtility.boxTimestamp("2026-04-08 10:00:00.123456789123 UTC");
    assertThat(tsUtc.getNanos()).isEqualTo(123456789);

    // Fallback format (no timezone) with 12-digit picoseconds triggers Timestamp.valueOf fallback
    java.sql.Timestamp tsFallback =
        BigQueryTemporalUtility.boxTimestamp("2026-04-08 10:00:00.123456789123");
    assertThat(tsFallback.getNanos()).isEqualTo(123456789);
  }

  @Test
  public void testParseEpochDecimalToInstant() {
    // Standard decimal
    Instant i1 = BigQueryTemporalUtility.parseEpochDecimalToInstant("1775642400.123456789123");
    assertThat(i1).isEqualTo(Instant.ofEpochSecond(1775642400, 123456789));

    // Scientific notation
    Instant i2 = BigQueryTemporalUtility.parseEpochDecimalToInstant("1.6905474E9");
    assertThat(i2).isEqualTo(Instant.parse("2023-07-28T12:30:00Z"));

    // Pre-1970 negative decimal
    Instant i3 = BigQueryTemporalUtility.parseEpochDecimalToInstant("-0.123456");
    assertThat(i3).isEqualTo(Instant.ofEpochSecond(-1, 876544000));

    // Null
    assertThat(BigQueryTemporalUtility.parseEpochDecimalToInstant(null)).isNull();
  }
}
