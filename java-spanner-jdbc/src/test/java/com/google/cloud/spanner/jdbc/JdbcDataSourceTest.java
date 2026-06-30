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

package com.google.cloud.spanner.jdbc;

import static org.junit.Assert.assertEquals;

import com.google.cloud.spanner.connection.AbstractMockServerTest;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcDataSourceTest extends AbstractMockServerTest {

  @Override
  protected String getBaseUrl() {
    return String.format(
        "jdbc:cloudspanner://localhost:%d/projects/p/instances/i/databases/d?usePlainText=true",
        getPort());
  }

  @Test
  public void testGetConnectionFromNewDataSource() throws SQLException {
    for (boolean autoCommit : new boolean[] {true, false}) {
      JdbcDataSource dataSource = new JdbcDataSource();
      dataSource.setUrl(getBaseUrl());
      dataSource.setAutocommit(autoCommit);
      try (Connection connection = dataSource.getConnection()) {
        assertEquals(autoCommit, connection.getAutoCommit());
      }
    }
  }

  @Test
  public void testGetConnectionFromCachedDataSource() throws SQLException {
    JdbcDataSource dataSource = new JdbcDataSource();
    dataSource.setUrl(getBaseUrl());
    for (boolean autoCommit : new boolean[] {true, false}) {
      // Changing a property on the DataSource should invalidate the internally cached
      // ConnectionOptions.
      dataSource.setAutocommit(autoCommit);
      try (Connection connection = dataSource.getConnection()) {
        assertEquals(autoCommit, connection.getAutoCommit());
      }
    }
  }
}
