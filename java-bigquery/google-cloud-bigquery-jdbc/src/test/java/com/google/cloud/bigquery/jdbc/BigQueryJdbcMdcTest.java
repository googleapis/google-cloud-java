/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BigQueryJdbcMdcTest {

  private BigQueryConnection mockConnection1;
  private BigQueryConnection mockConnection2;

  @BeforeEach
  public void setUp() {
    mockConnection1 = Mockito.mock(BigQueryConnection.class);
    mockConnection2 = Mockito.mock(BigQueryConnection.class);
  }

  @AfterEach
  public void tearDown() {
    BigQueryJdbcMdc.clear();
  }

  @Test
  public void testRegisterAndRetrieveConnectionId() {
    BigQueryJdbcMdc.registerInstance(mockConnection1, "123");

    assertEquals("JdbcConnection-123", BigQueryJdbcMdc.getConnectionId(mockConnection1));
    assertEquals("JdbcConnection-123", BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testClearContext() {
    BigQueryJdbcMdc.registerInstance(mockConnection1, "456");
    assertEquals("JdbcConnection-456", BigQueryJdbcMdc.getConnectionId(mockConnection1));

    BigQueryJdbcMdc.clear();

    assertNull(BigQueryJdbcMdc.getConnectionId());
  }

  @Test
  public void testMultipleConnectionsSameThread() {
    BigQueryJdbcMdc.registerInstance(mockConnection1, "111");
    BigQueryJdbcMdc.registerInstance(mockConnection2, "222");

    assertEquals("JdbcConnection-111", BigQueryJdbcMdc.getConnectionId(mockConnection1));
    assertEquals("JdbcConnection-222", BigQueryJdbcMdc.getConnectionId(mockConnection2));
  }
}