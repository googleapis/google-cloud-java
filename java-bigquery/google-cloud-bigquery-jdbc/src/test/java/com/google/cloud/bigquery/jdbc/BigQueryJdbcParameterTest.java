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

import static org.junit.Assert.assertEquals;

import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.BigQueryParameterHandler.BigQueryStatementParameterType;
import org.junit.Test;

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
    parameter.setType(String.class);
    parameter.setSqlType(StandardSQLTypeName.STRING);
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
    parameter.setType(String.class);
    parameter.setSqlType(StandardSQLTypeName.STRING);

    BigQueryJdbcParameter copiedParameter = new BigQueryJdbcParameter(parameter);

    assertEquals(expectedIndex, copiedParameter.getIndex());
    assertEquals(expectedValue, copiedParameter.getValue());
    assertEquals(expectedType, copiedParameter.getType());
    assertEquals(expectedSqlType, copiedParameter.getSqlType());
  }
}
