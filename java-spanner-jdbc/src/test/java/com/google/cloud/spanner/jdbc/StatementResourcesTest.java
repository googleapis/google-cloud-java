/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.spanner.connection.AbstractMockServerTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StatementResourcesTest extends AbstractMockServerTest {
  private static final int MIN_SESSIONS = 1;
  private static final int MAX_SESSIONS = 2;

  private String createUrl() {
    return String.format(
        "jdbc:cloudspanner://localhost:%d/projects/%s/instances/%s/databases/%s"
            + "?usePlainText=true;minSessions=%d;maxSessions=%d",
        getPort(), "proj", "inst", "db", MIN_SESSIONS, MAX_SESSIONS);
  }

  @Test
  public void testMultipleQueriesOnOneStatement() throws SQLException {
    try (Connection connection = DriverManager.getConnection(createUrl())) {
      try (Statement statement = connection.createStatement()) {
        for (int i = 0; i < MAX_SESSIONS + 1; i++) {
          // Execute a query without reading or closing the result.
          statement.execute("SELECT 1");
        }
      }
    }
  }

  @Test
  public void testMultipleStatementsWithOneQuery() throws SQLException {
    try (Connection connection = DriverManager.getConnection(createUrl())) {
      for (int i = 0; i < MAX_SESSIONS + 1; i++) {
        try (Statement statement = connection.createStatement()) {
          // Execute a query without reading or closing the result.
          statement.execute("SELECT 1");
        }
      }
    }
  }

  @Test
  public void testMultipleQueriesOnOnePreparedStatement() throws SQLException {
    try (Connection connection = DriverManager.getConnection(createUrl())) {
      try (PreparedStatement statement = connection.prepareStatement("SELECT 1")) {
        for (int i = 0; i < MAX_SESSIONS + 1; i++) {
          // Execute a query without reading or closing the result.
          statement.execute();
        }
      }
    }
  }

  @Test
  public void testMultiplePreparedStatementsWithOneQuery() throws SQLException {
    try (Connection connection = DriverManager.getConnection(createUrl())) {
      for (int i = 0; i < MAX_SESSIONS + 1; i++) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT 1")) {
          // Execute a query without reading or closing the result.
          statement.execute();
        }
      }
    }
  }
}
