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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.rpc.Code;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
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

  @Test
  public void testPropertiesPrecedence() throws SQLException {
    JdbcDataSource dataSource = new JdbcDataSource();
    dataSource.setUrl(getBaseUrl() + ";autocommit=false");
    dataSource.setAutocommit(true);
    try (Connection connection = dataSource.getConnection()) {
      assertFalse(connection.getAutoCommit());
    }
  }

  @Test
  public void testCredentialsWithSemicolons() throws Exception {
    File tempKeyFile = File.createTempFile("key;with=semicolons", ".json");
    try {
      Files.copy(
          Paths.get(
              Objects.requireNonNull(JdbcDriverTest.class.getResource("test-key.json")).toURI()),
          tempKeyFile.toPath(),
          StandardCopyOption.REPLACE_EXISTING);

      JdbcDataSource dataSource = new JdbcDataSource();
      dataSource.setUrl(getBaseUrl());
      dataSource.setCredentials(tempKeyFile.getAbsolutePath());
      try (Connection connection = dataSource.getConnection()) {
        JdbcConnection jdbcConnection = connection.unwrap(JdbcConnection.class);
        assertEquals(
            tempKeyFile.getAbsolutePath(),
            jdbcConnection.getConnectionOptions().getCredentialsUrl());
      }
    } finally {
      Files.deleteIfExists(tempKeyFile.toPath());
    }
  }

  @Test
  public void testInvalidPropertyThrowsSQLException() {
    JdbcDataSource dataSource = new JdbcDataSource();
    dataSource.setUrl(getBaseUrl() + ";unknownProperty=value");
    SQLException sqlException = assertThrows(SQLException.class, dataSource::getConnection);
    assertEquals(Code.INVALID_ARGUMENT_VALUE, sqlException.getErrorCode());
  }
}
