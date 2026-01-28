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
import static org.junit.Assert.assertNotNull;

import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.BigQueryParameterHandler.BigQueryStatementParameterType;
import org.junit.Test;

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
}
