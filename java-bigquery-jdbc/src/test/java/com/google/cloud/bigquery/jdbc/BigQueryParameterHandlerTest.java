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
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.BigQueryParameterHandler.BigQueryStatementParameterType;
import java.sql.Timestamp;
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
    Timestamp ts = Timestamp.valueOf("2024-01-01 12:34:56.123456789");

    // When enableTimestampPicos is true, full nanoseconds are preserved
    Object picosFormatted =
        BigQueryParameterHandler.formatValueForQueryParameter(
            ts, StandardSQLTypeName.TIMESTAMP, true);
    assertEquals("2024-01-01 12:34:56.123456789", picosFormatted);

    // When enableTimestampPicos is false, truncated to microseconds
    Object microsFormatted =
        BigQueryParameterHandler.formatValueForQueryParameter(
            ts, StandardSQLTypeName.TIMESTAMP, false);
    assertEquals("2024-01-01 12:34:56.123456", microsFormatted);
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
    Timestamp ts = Timestamp.valueOf("2024-01-01 12:34:56.123456789");
    String picosStr = "2024-01-01 12:34:56.123456789012";

    paramHandler.setParameter(1, ts, Timestamp.class);
    paramHandler.setParameter(2, picosStr, Timestamp.class);

    QueryJobConfiguration.Builder builder = QueryJobConfiguration.newBuilder("SELECT ?, ?");
    paramHandler.configureParameters(builder);

    QueryJobConfiguration config = builder.build();
    assertEquals(2, config.getPositionalParameters().size());
    assertEquals(
        "2024-01-01 12:34:56.123456789", config.getPositionalParameters().get(0).getValue());
    assertEquals(StandardSQLTypeName.TIMESTAMP, config.getPositionalParameters().get(0).getType());
    assertEquals(
        "2024-01-01 12:34:56.123456789012", config.getPositionalParameters().get(1).getValue());
    assertEquals(StandardSQLTypeName.TIMESTAMP, config.getPositionalParameters().get(1).getType());
  }
}
