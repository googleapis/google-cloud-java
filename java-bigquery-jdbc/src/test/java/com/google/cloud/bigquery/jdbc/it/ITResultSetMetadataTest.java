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

import com.google.cloud.ServiceOptions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ITResultSetMetadataTest {

  private static final String DEFAULT_CATALOG = ServiceOptions.getDefaultProjectId();
  static Random random = new Random();
  static int randomNumber = random.nextInt(999);
  private static final String TABLE_NAME = "JDBC_RSMETADATA_TEST_TABLE" + randomNumber;
  private static String DATASET;
  private static ResultSetMetaData metaData;

  @BeforeAll
  public static void beforeClass() throws InterruptedException {
    DATASET = ITBase.getSharedDataset();
    ITBase.setUpTable(DATASET, TABLE_NAME);
  }

  @AfterAll
  public static void afterClass() throws InterruptedException {
    // Shared dataset cleanup is handled by shutdown hook
  }

  @Disabled
  @Test
  public void testResultSetMetadata() throws SQLException {
    String selectData = "SELECT * FROM " + DATASET + "." + TABLE_NAME + ";";
    Connection connection = DriverManager.getConnection(ITBase.connectionUrl);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(selectData);
    metaData = resultSet.getMetaData();
    try {
      assertEquals(DEFAULT_CATALOG, metaData.getCatalogName(1));

      assertEquals(14, metaData.getColumnCount());

      assertEquals("StringField", metaData.getColumnName(1));
      assertEquals("StringField", metaData.getColumnLabel(1));
      assertEquals("java.lang.String", metaData.getColumnClassName(1));
      assertEquals(65535, metaData.getColumnDisplaySize(1));
      assertEquals("STRING", metaData.getColumnTypeName(1));
      assertEquals(12, metaData.getColumnType(1));

      assertEquals(26, metaData.getColumnDisplaySize(8));
      assertEquals("TIMESTAMP", metaData.getColumnTypeName(8));
      assertEquals(93, metaData.getColumnType(8));

    } catch (SQLException e) {
      e.printStackTrace();
    }
    connection.close();
  }
}
