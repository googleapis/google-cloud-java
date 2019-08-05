/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc.it;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.jdbc.CloudSpannerJdbcConnection;
import com.google.cloud.spanner.jdbc.ITAbstractJdbcTest;
import com.google.cloud.spanner.jdbc.JdbcDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * There are three different possibilities to specify the properties of a jdbc connection:
 *
 * <ol>
 *   <li>Specify properties in the connection URL
 *   <li>Pass a {@link Properties} object to the {@link DriverManager}
 *   <li>Set the properties on a {@link DataSource}
 * </ol>
 *
 * This class tests all three possibilities.
 */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITJdbcConnectTest extends ITAbstractJdbcTest {

  private String createBaseUrl() {
    StringBuilder url =
        new StringBuilder("jdbc:cloudspanner:/").append(getDatabase().getId().getName());
    return url.toString();
  }

  private void testDefaultConnection(Connection connection) throws SQLException {
    assertThat(connection.isWrapperFor(CloudSpannerJdbcConnection.class), is(true));
    CloudSpannerJdbcConnection cs = connection.unwrap(CloudSpannerJdbcConnection.class);
    assertThat(cs.getAutoCommit(), is(true));
    assertThat(cs.isReadOnly(), is(false));
    try (ResultSet rs = connection.createStatement().executeQuery("SELECT 1")) {
      assertThat(rs.next(), is(true));
      assertThat(rs.getInt(1), is(equalTo(1)));
    }
    cs.setAutoCommit(false);
    assertThat(cs.isRetryAbortsInternally(), is(true));
  }

  private void testNonDefaultConnection(Connection connection) throws SQLException {
    assertThat(connection.isWrapperFor(CloudSpannerJdbcConnection.class), is(true));
    CloudSpannerJdbcConnection cs = connection.unwrap(CloudSpannerJdbcConnection.class);
    assertThat(cs.getAutoCommit(), is(false));
    assertThat(cs.isReadOnly(), is(true));
    try (ResultSet rs = connection.createStatement().executeQuery("SELECT 1")) {
      assertThat(rs.next(), is(true));
      assertThat(rs.getInt(1), is(equalTo(1)));
    }
    connection.commit();
    cs.setReadOnly(false);
    assertThat(cs.isRetryAbortsInternally(), is(false));
  }

  @Test
  public void testConnectWithURLWithDefaultValues() throws SQLException {
    String url = createBaseUrl();
    if (hasValidKeyFile()) {
      url = url + "?credentials=" + getKeyFile();
    }
    try (Connection connection = DriverManager.getConnection(url)) {
      testDefaultConnection(connection);
    }
  }

  @Test
  public void testConnectWithURLWithNonDefaultValues() throws SQLException {
    String url = createBaseUrl();
    url = url + "?autocommit=false;readonly=true;retryAbortsInternally=false";
    if (hasValidKeyFile()) {
      url = url + ";credentials=" + getKeyFile();
    }
    try (Connection connection = DriverManager.getConnection(url)) {
      testNonDefaultConnection(connection);
    }
  }

  @Test
  public void testConnectWithPropertiesWithDefaultValues() throws SQLException {
    String url = createBaseUrl();
    Properties properties = new Properties();
    if (hasValidKeyFile()) {
      properties.setProperty("credentials", getKeyFile());
    }
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      testDefaultConnection(connection);
    }
  }

  @Test
  public void testConnectWithPropertiesWithNonDefaultValues() throws SQLException {
    String url = createBaseUrl();
    Properties properties = new Properties();
    if (hasValidKeyFile()) {
      properties.setProperty("credentials", getKeyFile());
    }
    properties.setProperty("autocommit", "false");
    properties.setProperty("readonly", "true");
    properties.setProperty("retryAbortsInternally", "false");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      testNonDefaultConnection(connection);
    }
  }

  @Test
  public void testConnectWithPropertiesWithConflictingValues() throws SQLException {
    String url = createBaseUrl();
    url = url + "?autocommit=false;readonly=true;retryAbortsInternally=false";
    if (hasValidKeyFile()) {
      url = url + ";credentials=" + getKeyFile();
    }
    Properties properties = new Properties();
    properties.setProperty("autocommit", "true");
    properties.setProperty("readonly", "false");
    properties.setProperty("retryAbortsInternally", "true");
    try (Connection connection = DriverManager.getConnection(url, properties)) {
      testNonDefaultConnection(connection);
    }
  }

  @Test
  public void testConnectWithDataSourceWithDefaultValues() throws SQLException {
    JdbcDataSource ds = new JdbcDataSource();
    ds.setUrl(createBaseUrl());
    if (hasValidKeyFile()) {
      ds.setCredentials(getKeyFile());
    }
    try (Connection connection = ds.getConnection()) {
      testDefaultConnection(connection);
    }
  }

  @Test
  public void testConnectWithDataSourceWithNonDefaultValues() throws SQLException {
    JdbcDataSource ds = new JdbcDataSource();
    ds.setUrl(createBaseUrl());
    if (hasValidKeyFile()) {
      ds.setCredentials(getKeyFile());
    }
    ds.setAutocommit(false);
    ds.setReadonly(true);
    ds.setRetryAbortsInternally(false);
    try (Connection connection = ds.getConnection()) {
      testNonDefaultConnection(connection);
    }
  }

  @Test
  public void testConnectWithDataSourceWithConflictingValues() throws SQLException {
    // Try with non-default values in URL and default values in data source. The values in the URL
    // should take precedent.
    String url = createBaseUrl();
    url = url + "?autocommit=false;readonly=true;retryAbortsInternally=false";
    if (hasValidKeyFile()) {
      url = url + ";credentials=" + getKeyFile();
    }
    JdbcDataSource ds = new JdbcDataSource();
    ds.setUrl(url);
    ds.setAutocommit(true);
    ds.setReadonly(false);
    ds.setRetryAbortsInternally(true);
    try (Connection connection = ds.getConnection()) {
      testNonDefaultConnection(connection);
    }
  }
}
