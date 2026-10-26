/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("disable_tpc")
public class ITPcntTest extends ITBase {

  private static final Random random = new Random();
  private static final int randomNumber = random.nextInt(9999);
  private static final String PCNT_TABLE_NAME = "PCNT_TEST_TABLE_" + randomNumber;

  @BeforeAll
  public static void beforeClass() throws InterruptedException {
    ITBase.setUpPcntTable(ITBase.PCNT_SCHEMA, PCNT_TABLE_NAME);
  }

  @AfterAll
  public static void afterClass() throws InterruptedException {
    ITBase.cleanUpPcntTable(ITBase.PCNT_SCHEMA, PCNT_TABLE_NAME);
  }

  @Test
  public void testPcntDefaultDataset2TierNamespace() throws SQLException {
    String urlWithPcnt = ITBase.connectionUrl + ";DefaultDataset=" + ITBase.PCNT_SCHEMA + ";";
    try (Connection connection = DriverManager.getConnection(urlWithPcnt)) {
      assertNotNull(connection);
      assertFalse(connection.isClosed());
      try (Statement stmt = connection.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT * FROM " + PCNT_TABLE_NAME + " ORDER BY id")) {
        assertTrue(rs.next());
        assertEquals(1, rs.getInt("id"));
        assertEquals("Alice", rs.getString("name"));
        assertTrue(rs.next());
        assertEquals(2, rs.getInt("id"));
        assertEquals("Bob", rs.getString("name"));
      }
    }
  }

  @Test
  public void testPcntDefaultDataset3TierNamespace() throws SQLException {
    String urlWithPcnt =
        ITBase.connectionUrl
            + ";DefaultDataset="
            + DEFAULT_CATALOG
            + ":"
            + ITBase.PCNT_SCHEMA
            + ";";
    try (Connection connection = DriverManager.getConnection(urlWithPcnt)) {
      assertNotNull(connection);
      assertFalse(connection.isClosed());
      try (Statement stmt = connection.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT * FROM " + PCNT_TABLE_NAME + " ORDER BY id")) {
        assertTrue(rs.next());
        assertEquals(1, rs.getInt("id"));
        assertEquals("Alice", rs.getString("name"));
        assertTrue(rs.next());
        assertEquals(2, rs.getInt("id"));
        assertEquals("Bob", rs.getString("name"));
      }
    }
  }

  @Test
  public void testDatabaseMetadataGetSchemasPcnt() throws SQLException {
    try (Connection connection = DriverManager.getConnection(ITBase.connectionUrl)) {
      DatabaseMetaData metaData = connection.getMetaData();
      try (ResultSet rs = metaData.getSchemas(DEFAULT_CATALOG, PCNT_SCHEMA)) {
        assertNotNull(rs, "ResultSet from getSchemas() should not be null");
        assertTrue(
            rs.next(), "Expected PCNT schema " + PCNT_SCHEMA + " in catalog " + DEFAULT_CATALOG);
        assertEquals(PCNT_SCHEMA, rs.getString("TABLE_SCHEM"));
        assertEquals(DEFAULT_CATALOG, rs.getString("TABLE_CATALOG"));
      }
    }
  }

  @Test
  public void testDatabaseMetadataGetTablesPcnt() throws SQLException {
    try (Connection connection = DriverManager.getConnection(ITBase.connectionUrl)) {
      DatabaseMetaData metaData = connection.getMetaData();
      try (ResultSet rs = metaData.getTables(DEFAULT_CATALOG, PCNT_SCHEMA, PCNT_TABLE_NAME, null)) {
        assertNotNull(rs, "ResultSet from getTables() should not be null");
        assertTrue(
            rs.next(), "Expected PCNT table " + PCNT_TABLE_NAME + " under schema " + PCNT_SCHEMA);
        assertEquals(DEFAULT_CATALOG, rs.getString("TABLE_CAT"));
        assertEquals(PCNT_SCHEMA, rs.getString("TABLE_SCHEM"));
        assertEquals(PCNT_TABLE_NAME, rs.getString("TABLE_NAME"));
        assertEquals("TABLE", rs.getString("TABLE_TYPE"));
      }
    }
  }

  @Test
  public void testDatabaseMetadataGetColumnsPcnt() throws SQLException {
    try (Connection connection = DriverManager.getConnection(ITBase.connectionUrl)) {
      DatabaseMetaData metaData = connection.getMetaData();
      try (ResultSet rs = metaData.getColumns(DEFAULT_CATALOG, PCNT_SCHEMA, PCNT_TABLE_NAME, "%")) {
        assertNotNull(rs, "ResultSet from getColumns() should not be null");
        int columnCount = 0;
        boolean foundId = false;
        boolean foundName = false;
        while (rs.next()) {
          columnCount++;
          assertEquals(DEFAULT_CATALOG, rs.getString("TABLE_CAT"));
          assertEquals(PCNT_SCHEMA, rs.getString("TABLE_SCHEM"));
          assertEquals(PCNT_TABLE_NAME, rs.getString("TABLE_NAME"));
          String colName = rs.getString("COLUMN_NAME");
          String typeName = rs.getString("TYPE_NAME");
          if ("id".equals(colName)) {
            foundId = true;
            assertEquals(1, rs.getInt("ORDINAL_POSITION"));
            assertTrue(
                typeName.equalsIgnoreCase("INT64")
                    || typeName.equalsIgnoreCase("INTEGER")
                    || typeName.equalsIgnoreCase("BIGINT"));
          } else if ("name".equals(colName)) {
            foundName = true;
            assertEquals(2, rs.getInt("ORDINAL_POSITION"));
            assertTrue(
                typeName.equalsIgnoreCase("STRING")
                    || typeName.equalsIgnoreCase("NVARCHAR")
                    || typeName.equalsIgnoreCase("VARCHAR"));
          }
        }
        assertEquals(2, columnCount, "Expected 2 columns in PCNT table " + PCNT_TABLE_NAME);
        assertTrue(foundId, "Expected column 'id' in PCNT table");
        assertTrue(foundName, "Expected column 'name' in PCNT table");
      }
    }
  }
}
