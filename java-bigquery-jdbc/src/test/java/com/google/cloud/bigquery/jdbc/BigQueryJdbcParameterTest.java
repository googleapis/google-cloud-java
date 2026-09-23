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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.BigQueryParameterHandler.BigQueryStatementParameterType;
import org.junit.jupiter.api.Test;

public class BigQueryJdbcParameterTest {

  @Test
  public void testSettersAndGetters() {
    int expectedIndex = 3;
    Object expectedValue = "String Object";
    Class expectedType = String.class;
    StandardSQLTypeName expectedSqlType = StandardSQLTypeName.STRING;
    String expectedParamName = "StringParameter";
    BigQueryStatementParameterType expectedParamType = BigQueryStatementParameterType.IN;
    int expectedScale = -1;

    BigQueryJdbcParameter parameter = new BigQueryJdbcParameter();
    parameter.setIndex(3);
    parameter.setValue("String Object");
    parameter.bindType(String.class, StandardSQLTypeName.STRING);
    parameter.setParamName("StringParameter");
    parameter.setParamType(BigQueryStatementParameterType.IN);
    parameter.setScale(-1);

    assertEquals(expectedIndex, parameter.getIndex());
    assertEquals(expectedValue, parameter.getValue());
    assertEquals(expectedType, parameter.getType());
    assertEquals(expectedSqlType, parameter.getSqlType());
    assertEquals(expectedParamName, parameter.getParamName());
    assertEquals(expectedParamType, parameter.getParamType());
    assertEquals(expectedScale, parameter.getScale());
    assertTrue(parameter.isBound());
  }

  @Test
  public void testCopyConstructor() {
    int expectedIndex = 3;
    Object expectedValue = "String Object";
    Class expectedType = String.class;
    StandardSQLTypeName expectedSqlType = StandardSQLTypeName.STRING;

    BigQueryJdbcParameter parameter = new BigQueryJdbcParameter();
    parameter.setIndex(3);
    parameter.setValue("String Object");
    parameter.bindType(String.class, StandardSQLTypeName.STRING);

    BigQueryJdbcParameter copiedParameter = new BigQueryJdbcParameter(parameter);

    assertEquals(expectedIndex, copiedParameter.getIndex());
    assertEquals(expectedValue, copiedParameter.getValue());
    assertEquals(expectedType, copiedParameter.getType());
    assertEquals(expectedSqlType, copiedParameter.getSqlType());
    // A batched copy must carry its provenance, or inference could overwrite a caller's value.
    assertTrue(copiedParameter.isBound());
  }

  @Test
  public void testSuggestTypeYieldsToABoundParameter() {
    BigQueryJdbcParameter parameter = new BigQueryJdbcParameter();
    parameter.bindType(String.class, StandardSQLTypeName.STRING);

    assertFalse(parameter.suggestType(Long.class, StandardSQLTypeName.INT64));
    assertEquals(String.class, parameter.getType());
    assertEquals(StandardSQLTypeName.STRING, parameter.getSqlType());
  }

  @Test
  public void testSuggestTypeAppliesToAnUnboundParameter() {
    BigQueryJdbcParameter parameter = new BigQueryJdbcParameter();

    assertTrue(parameter.suggestType(Long.class, StandardSQLTypeName.INT64));
    assertEquals(Long.class, parameter.getType());
    assertEquals(StandardSQLTypeName.INT64, parameter.getSqlType());
    assertFalse(parameter.isBound());
  }

  @Test
  public void testClearValueKeepsTheTypeAndDemotesTheBinding() {
    BigQueryJdbcParameter parameter = new BigQueryJdbcParameter();
    parameter.setValue("String Object");
    parameter.bindType(String.class, StandardSQLTypeName.STRING);

    parameter.clearValue();

    // The type survives so a later setNull on the same slot stays typed, but the slot is no longer
    // bound, so the caller must supply a value again before execution.
    assertNull(parameter.getValue());
    assertEquals(StandardSQLTypeName.STRING, parameter.getSqlType());
    assertFalse(parameter.isBound());
  }
}
