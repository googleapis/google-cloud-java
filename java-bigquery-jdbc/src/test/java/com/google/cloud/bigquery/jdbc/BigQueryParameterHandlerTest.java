/*
 * Copyright 2025 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.BigQueryParameterHandler.BigQueryStatementParameterType;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import org.junit.jupiter.api.Test;

public class BigQueryParameterHandlerTest {

  @Test
  public void testGetSetParameterByName() throws Exception {
    BigQueryParameterHandler paramHandler = new BigQueryParameterHandler(2);
    // Add Param 1
    paramHandler.setParameter(
        "ParamKey1", "ParamValue1", String.class, BigQueryStatementParameterType.IN, -1);
    String paramValue = (String) paramHandler.getParameter("ParamKey1");
    assertNotNull(paramValue);
    assertEquals("ParamValue1", paramValue);
    BigQueryStatementParameterType paramType = paramHandler.getParameterType("ParamKey1");
    assertNotNull(paramType);
    assertEquals(BigQueryStatementParameterType.IN, paramType);
    int scale = paramHandler.getParameterScale("ParamKey1");
    assertEquals(-1, scale);
    assertEquals(String.class, paramHandler.getType("ParamKey1"));
    assertEquals(StandardSQLTypeName.STRING, paramHandler.getSqlType("ParamKey1"));

    // Add Param 2
    paramHandler.setParameter(
        "ParamKey2", "ParamValue2", String.class, BigQueryStatementParameterType.INOUT, 1);
    paramValue = (String) paramHandler.getParameter("ParamKey2");
    assertNotNull(paramValue);
    assertEquals("ParamValue2", paramValue);
    paramType = paramHandler.getParameterType("ParamKey2");
    assertNotNull(paramType);
    assertEquals(BigQueryStatementParameterType.INOUT, paramType);
    scale = paramHandler.getParameterScale("ParamKey2");
    assertEquals(1, scale);
    assertEquals(String.class, paramHandler.getType("ParamKey2"));
    assertEquals(StandardSQLTypeName.STRING, paramHandler.getSqlType("ParamKey2"));

    // Update Param 1
    paramHandler.setParameter(
        "ParamKey1", "ParamValue1-UPD", String.class, BigQueryStatementParameterType.OUT, 1);
    paramValue = (String) paramHandler.getParameter("ParamKey1");
    assertNotNull(paramValue);
    assertEquals("ParamValue1-UPD", paramValue);
    paramType = paramHandler.getParameterType("ParamKey1");
    assertNotNull(paramType);
    assertEquals(BigQueryStatementParameterType.OUT, paramType);
    scale = paramHandler.getParameterScale("ParamKey1");
    assertEquals(1, scale);
    assertEquals(String.class, paramHandler.getType("ParamKey1"));
    assertEquals(StandardSQLTypeName.STRING, paramHandler.getSqlType("ParamKey1"));

    // Update Param 2
    paramHandler.setParameter(
        "ParamKey2", "ParamValue2-UPD", String.class, BigQueryStatementParameterType.INOUT, 2);
    paramValue = (String) paramHandler.getParameter("ParamKey2");
    assertNotNull(paramValue);
    assertEquals("ParamValue2-UPD", paramValue);
    paramType = paramHandler.getParameterType("ParamKey2");
    assertNotNull(paramType);
    assertEquals(BigQueryStatementParameterType.INOUT, paramType);
    scale = paramHandler.getParameterScale("ParamKey2");
    assertEquals(2, scale);
    assertEquals(String.class, paramHandler.getType("ParamKey2"));
    assertEquals(StandardSQLTypeName.STRING, paramHandler.getSqlType("ParamKey2"));
  }

  @Test
  public void testGetSetParameterByIndex() throws Exception {
    BigQueryParameterHandler paramHandler = new BigQueryParameterHandler(2);

    // Add Param 1
    paramHandler.setParameter(1, "ParamValue1", String.class);
    String value = (String) paramHandler.getParameter(1);
    assertNotNull(value);
    assertEquals("ParamValue1", value);
    BigQueryStatementParameterType paramType = paramHandler.getParameterType(1);
    assertNotNull(paramType);
    assertEquals(BigQueryStatementParameterType.UNSPECIFIED, paramType);
    assertEquals(String.class, paramHandler.getType(1));
    assertEquals(StandardSQLTypeName.STRING, paramHandler.getSqlType(1));

    // Add Param 2
    paramHandler.setParameter(
        2, "ParamValue2", String.class, BigQueryStatementParameterType.IN, -1);
    value = (String) paramHandler.getParameter(2);
    assertNotNull(value);
    assertEquals("ParamValue2", value);
    paramType = paramHandler.getParameterType(2);
    assertNotNull(paramType);
    assertEquals(BigQueryStatementParameterType.IN, paramType);
    int scale = paramHandler.getParameterScale(2);
    assertEquals(-1, scale);
    assertEquals(String.class, paramHandler.getType(2));
    assertEquals(StandardSQLTypeName.STRING, paramHandler.getSqlType(2));

    // Update Param 1
    paramHandler.setParameter(1, "ParamValue1-UPD", String.class);
    value = (String) paramHandler.getParameter(1);
    assertNotNull(value);
    assertEquals("ParamValue1-UPD", value);
    paramType = paramHandler.getParameterType(1);
    assertNotNull(paramType);
    assertEquals(BigQueryStatementParameterType.UNSPECIFIED, paramType);
    assertEquals(String.class, paramHandler.getType(1));
    assertEquals(StandardSQLTypeName.STRING, paramHandler.getSqlType(1));

    // Update Param 2
    paramHandler.setParameter(
        2, "ParamValue2-UPD", String.class, BigQueryStatementParameterType.OUT, 2);
    value = (String) paramHandler.getParameter(2);
    assertNotNull(value);
    assertEquals("ParamValue2-UPD", value);
    paramType = paramHandler.getParameterType(2);
    assertNotNull(paramType);
    assertEquals(BigQueryStatementParameterType.OUT, paramType);
    scale = paramHandler.getParameterScale(2);
    assertEquals(2, scale);
    assertEquals(String.class, paramHandler.getType(2));
    assertEquals(StandardSQLTypeName.STRING, paramHandler.getSqlType(2));
  }

  @Test
  public void testConfigureParametersWidenNumericTypes() throws Exception {
    BigQueryParameterHandler paramHandler = new BigQueryParameterHandler(3);
    paramHandler.setParameter(1, (short) 5, Short.class);
    paramHandler.setParameter(2, (byte) 10, Byte.class);
    paramHandler.setParameter(3, 3.14f, Float.class);

    QueryJobConfiguration.Builder builder = QueryJobConfiguration.newBuilder("SELECT 1");
    paramHandler.configureParameters(builder);

    QueryJobConfiguration config = builder.build();
    assertEquals(3, config.getPositionalParameters().size());
    assertEquals("5", config.getPositionalParameters().get(0).getValue());
    assertEquals("10", config.getPositionalParameters().get(1).getValue());
  }

  @Test
  public void testFormatValueForQueryParameter_timestampPrecision() {
    // Built from an Instant so the expected UTC rendering does not depend on the JVM zone.
    Timestamp ts = Timestamp.from(Instant.parse("2024-01-01T12:34:56.123456789Z"));

    // When enableTimestampPicos is true, full nanoseconds are preserved
    Object picosFormatted =
        BigQueryParameterHandler.formatValueForQueryParameter(
            ts, StandardSQLTypeName.TIMESTAMP, true);
    assertEquals("2024-01-01 12:34:56.123456789Z", picosFormatted);

    // When enableTimestampPicos is false, truncated to microseconds
    Object microsFormatted =
        BigQueryParameterHandler.formatValueForQueryParameter(
            ts, StandardSQLTypeName.TIMESTAMP, false);
    assertEquals("2024-01-01 12:34:56.123456Z", microsFormatted);
  }

  @Test
  public void testFormatValueForQueryParameter_timestampPreservesInstantAcrossJvmZones() {
    // The core Model A invariant: the string we send must decode back to the exact instant that
    // was bound, regardless of the JVM default zone. Before the fix, a JVM in America/New_York
    // sent bare local digits that BigQuery read as UTC, shifting the instant by five hours.
    Instant original = Instant.parse("2024-01-01T17:34:56.123456Z");
    DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSXXX");
    TimeZone saved = TimeZone.getDefault();
    try {
      for (String zone : new String[] {"UTC", "America/New_York", "Asia/Kolkata"}) {
        TimeZone.setDefault(TimeZone.getTimeZone(zone));
        String out =
            (String)
                BigQueryParameterHandler.formatValueForQueryParameter(
                    Timestamp.from(original), StandardSQLTypeName.TIMESTAMP, false);
        assertEquals("2024-01-01 17:34:56.123456Z", out, "zone=" + zone);
        assertEquals(original, OffsetDateTime.parse(out, parser).toInstant(), "zone=" + zone);
      }
    } finally {
      TimeZone.setDefault(saved);
    }
  }

  @Test
  public void testFormatValueForQueryParameter_zoneAwareTypesCollapseToSameInstant() {
    // OffsetDateTime / ZonedDateTime / Instant / Timestamp for the same moment must all render
    // identically: the caller's offset is folded into the UTC digits, not dropped.
    Instant moment = Instant.parse("2024-01-01T17:34:56.123456Z");
    String expected = "2024-01-01 17:34:56.123456Z";
    assertEquals(
        expected,
        BigQueryParameterHandler.formatValueForQueryParameter(
            moment.atOffset(ZoneOffset.ofHoursMinutes(5, 30)),
            StandardSQLTypeName.TIMESTAMP,
            false));
    assertEquals(
        expected,
        BigQueryParameterHandler.formatValueForQueryParameter(
            ZonedDateTime.ofInstant(moment, ZoneId.of("America/New_York")),
            StandardSQLTypeName.TIMESTAMP,
            false));
    assertEquals(
        expected,
        BigQueryParameterHandler.formatValueForQueryParameter(
            moment, StandardSQLTypeName.TIMESTAMP, false));
    assertEquals(
        expected,
        BigQueryParameterHandler.formatValueForQueryParameter(
            Timestamp.from(moment), StandardSQLTypeName.TIMESTAMP, false));
  }

  @Test
  public void testFormatValueForQueryParameter_timestampAcceptedByClientLibraryValidator() {
    // QueryParameterValue's TIMESTAMP validator rejects non-zero colon offsets such as "-05:00".
    // Force a non-UTC JVM zone and prove the emitted string still passes validation; this is the
    // scenario that previously threw IllegalArgumentException from configureParameters.
    Timestamp ts = Timestamp.from(Instant.parse("2024-01-01T17:34:56.123456789Z"));
    TimeZone saved = TimeZone.getDefault();
    try {
      TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
      for (boolean picos : new boolean[] {false, true}) {
        String out =
            (String)
                BigQueryParameterHandler.formatValueForQueryParameter(
                    ts, StandardSQLTypeName.TIMESTAMP, picos);
        // Throws IllegalArgumentException if the format is not accepted.
        assertEquals(out, QueryParameterValue.timestamp(out).getValue());
      }
    } finally {
      TimeZone.setDefault(saved);
    }
  }

  @Test
  public void testFormatValueForQueryParameter_datetimeSlotEmitsWallClockWithoutOffset() {
    // A Timestamp bound into a non-TIMESTAMP (DATETIME) slot is a zone-less wall clock: JVM-local
    // digits, exactly six fraction digits, no offset. Sub-microsecond digits are truncated.
    Timestamp ts = Timestamp.valueOf("2024-01-01 12:34:56.123456789");
    Object out =
        BigQueryParameterHandler.formatValueForQueryParameter(
            ts, StandardSQLTypeName.DATETIME, true);
    assertEquals("2024-01-01 12:34:56.123456", out);
    // And the DATETIME validator accepts it.
    assertEquals(out, QueryParameterValue.dateTime((String) out).getValue());
  }

  @Test
  public void testFormatValueForQueryParameter_stringTimestampPrecision() {
    String picosString = "2024-01-01 12:34:56.123456789012";

    // When enableTimestampPicos is true, up to 12 digits are preserved
    Object picosFormatted =
        BigQueryParameterHandler.formatValueForQueryParameter(
            picosString, StandardSQLTypeName.TIMESTAMP, true);
    assertEquals("2024-01-01 12:34:56.123456789012", picosFormatted);

    // 15 digits truncated to 12 digits
    String excessString = "2024-01-01 12:34:56.123456789012345";
    Object truncatedPicos =
        BigQueryParameterHandler.formatValueForQueryParameter(
            excessString, StandardSQLTypeName.TIMESTAMP, true);
    assertEquals("2024-01-01 12:34:56.123456789012", truncatedPicos);

    // 'T' delimiter at index 10 is replaced with space and whitespace is trimmed
    String isoString = "  2024-01-01T12:34:56.123456789012  ";
    Object replacedT =
        BigQueryParameterHandler.formatValueForQueryParameter(
            isoString, StandardSQLTypeName.TIMESTAMP, true);
    assertEquals("2024-01-01 12:34:56.123456789012", replacedT);

    // Characters matching 'T' in timezone names are not replaced
    String timezoneWithT = "  2024-01-01T12:34:56.123456 America/Toronto  ";
    Object preservedTimezone =
        BigQueryParameterHandler.formatValueForQueryParameter(
            timezoneWithT, StandardSQLTypeName.TIMESTAMP, false);
    assertEquals("2024-01-01 12:34:56.123456 America/Toronto", preservedTimezone);

    String utcTimezone = "2024-01-01 12:34:56.123456 UTC";
    Object preservedUtc =
        BigQueryParameterHandler.formatValueForQueryParameter(
            utcTimezone, StandardSQLTypeName.TIMESTAMP, false);
    assertEquals("2024-01-01 12:34:56.123456 UTC", preservedUtc);

    // When enableTimestampPicos is false, truncated to 6 digits
    Object microsFormatted =
        BigQueryParameterHandler.formatValueForQueryParameter(
            picosString, StandardSQLTypeName.TIMESTAMP, false);
    assertEquals("2024-01-01 12:34:56.123456", microsFormatted);
  }

  @Test
  public void testConfigureParameters_withEnableTimestampPicos() throws Exception {
    BigQueryParameterHandler paramHandler = new BigQueryParameterHandler(2, true);
    Timestamp ts = Timestamp.from(Instant.parse("2024-01-01T12:34:56.123456789Z"));
    String picosStr = "2024-01-01 12:34:56.123456789012";

    paramHandler.setParameter(1, ts, Timestamp.class);
    paramHandler.setParameter(2, picosStr, Timestamp.class);

    QueryJobConfiguration.Builder builder = QueryJobConfiguration.newBuilder("SELECT ?, ?");
    paramHandler.configureParameters(builder);

    QueryJobConfiguration config = builder.build();
    assertEquals(2, config.getPositionalParameters().size());
    assertEquals(
        "2024-01-01 12:34:56.123456789Z", config.getPositionalParameters().get(0).getValue());
    assertEquals(StandardSQLTypeName.TIMESTAMP, config.getPositionalParameters().get(0).getType());
    assertEquals(
        "2024-01-01 12:34:56.123456789012", config.getPositionalParameters().get(1).getValue());
    assertEquals(StandardSQLTypeName.TIMESTAMP, config.getPositionalParameters().get(1).getType());
  }
}
