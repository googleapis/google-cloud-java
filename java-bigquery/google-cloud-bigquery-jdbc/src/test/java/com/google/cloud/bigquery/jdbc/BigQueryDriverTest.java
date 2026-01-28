/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;

public class BigQueryDriverTest {

  static BigQueryDriver bigQueryDriver;

  @Before
  public void setUp() {
    bigQueryDriver = BigQueryDriver.getRegisteredDriver();
  }

  @Test
  public void testInvalidURLDoesNotConnect() {
    assertThrows(IllegalArgumentException.class, () -> bigQueryDriver.connect("badURL.com", null));
  }

  @Test
  public void testValidURLDoesConnect() throws SQLException {
    Connection connection =
        bigQueryDriver.connect(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "OAuthType=2;ProjectId=MyBigQueryProject;"
                + "OAuthAccessToken=redactedToken;OAuthClientId=redactedToken;"
                + "OAuthClientSecret=redactedToken;",
            new Properties());
    assertThat(connection.isClosed()).isFalse();
  }

  @Test
  public void testInvalidURLInAcceptsURLReturnsFalse() throws SQLException {
    assertThat(bigQueryDriver.acceptsURL("badURL.com")).isFalse();
  }

  @Test
  public void testValidURLInAcceptsURLReturnsTrue() throws SQLException {
    assertThat(bigQueryDriver.acceptsURL("jdbc:bigquery:https://google.com:8080;projectId=123456"))
        .isTrue();
  }

  @Test
  public void testGetPropertyInfoReturnsValidProperties() {
    DriverPropertyInfo[] res =
        bigQueryDriver.getPropertyInfo(
            "jdbc:bigquery:https://google.com:8080;projectId=123456;OAuthType=3", new Properties());
    int i = 0;
    for (BigQueryConnectionProperty prop : BigQueryJdbcUrlUtility.VALID_PROPERTIES) {
      assertThat(res[i].name).isEqualTo(prop.getName());
      i++;
    }
  }

  @Test
  public void testGetMajorVersionMatchesDriverMajorVersion() {
    assertThat(bigQueryDriver.getMajorVersion()).isEqualTo(0);
  }

  @Test
  public void testGetMinorVersionMatchesDriverMinorVersion() {
    assertThat(bigQueryDriver.getMinorVersion()).isEqualTo(1);
  }

  @Test
  public void testGetParentLoggerReturnsLogger() {
    assertThat(bigQueryDriver.getParentLogger()).isInstanceOf(Logger.class);
  }

  @Test
  public void testJDBCCompliantReturnsFalse() {
    assertThat(bigQueryDriver.jdbcCompliant()).isFalse();
  }
}
