/*
 * Copyright 2024 Google LLC
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Enclosed.class)
public class ITProxyBigQueryTest {
  static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  static final String PROXY_HOST = "34.94.167.18";
  static final String PROXY_PORT = "3128";
  static final String PROXY_UID = "fahmz";
  static final String PROXY_PWD = "fahmz";

  public static class NonParameterizedProxyTests {
    @Test
    public void testValidAuthenticatedProxy() throws SQLException {
      String connection_uri =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "ProjectId="
              + PROJECT_ID
              + ";OAuthType=3;"
              + "ProxyHost="
              + PROXY_HOST
              + ";ProxyPort="
              + PROXY_PORT
              + ";ProxyUid="
              + PROXY_UID
              + ";ProxyPwd="
              + PROXY_PWD
              + ";";

      Connection connection = DriverManager.getConnection(connection_uri);
      assertNotNull(connection);
      assertFalse(connection.isClosed());
      Statement statement = connection.createStatement();
      boolean result =
          statement.execute(
              "Select * FROM `bigquery-public-data.samples.github_timeline` LIMIT 180");
      assertTrue(result);
      connection.close();
    }

    @Test
    public void testAuthenticatedProxyWithOutAuthDetailsThrows() throws SQLException {
      String query = "Select * FROM `bigquery-public-data.samples.github_timeline` LIMIT 180";
      String connection_uri =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "ProjectId="
              + PROJECT_ID
              + ";OAuthType=3;"
              + "ProxyHost="
              + PROXY_HOST
              + ";ProxyPort="
              + PROXY_PORT
              + ";";
      Connection connection = DriverManager.getConnection(connection_uri);
      assertNotNull(connection);
      assertFalse(connection.isClosed());
      Statement statement = connection.createStatement();
      assertThrows(BigQueryJdbcException.class, () -> statement.execute(query));
    }

    @Test
    public void testNonExistingProxyTimesOut() throws SQLException {
      String query = "Select * FROM `bigquery-public-data.samples.github_timeline` LIMIT 180";
      String connection_uri =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "ProjectId="
              + PROJECT_ID
              + ";OAuthType=3;"
              + "ProxyHost=111.12.111.11;" // If the test fails you may have this ip address
              // assigned
              + "ProxyPort=1111;";
      Connection connection = DriverManager.getConnection(connection_uri);
      assertNotNull(connection);
      assertFalse(connection.isClosed());
      Statement statement = connection.createStatement();
      assertThrows(BigQueryJdbcException.class, () -> statement.execute(query));
    }

    @Test
    @Ignore // Run this when Proxy server has no authentication otherwise you'll get a "407 Proxy
    // Authentication Required".
    public void testNonAuthenticatedProxy() throws SQLException {
      String connection_uri =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "ProjectId="
              + PROJECT_ID
              + ";OAuthType=3;"
              + "ProxyHost="
              + PROXY_HOST
              + ";ProxyPort="
              + PROXY_PORT
              + ";";

      Connection connection = DriverManager.getConnection(connection_uri);
      assertNotNull(connection);
      assertFalse(connection.isClosed());
      Statement statement = connection.createStatement();
      boolean result =
          statement.execute(
              "Select * FROM `bigquery-public-data.samples.github_timeline` LIMIT 180");
      assertTrue(result);
      connection.close();
    }

    @Test
    public void testValidNonProxyConnectionQueries() throws SQLException {
      String connection_uri =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "ProjectId="
              + PROJECT_ID
              + ";OAuthType=3;";

      Connection connection = DriverManager.getConnection(connection_uri);
      assertNotNull(connection);
      assertFalse(connection.isClosed());
      Statement statement = connection.createStatement();
      boolean result =
          statement.execute(
              "Select * FROM `bigquery-public-data.samples.github_timeline` LIMIT 180");
      assertTrue(result);
      connection.close();
    }

    @Test
    public void testReadAPIEnabledWithProxySettings() throws SQLException {
      String connection_uri =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "ProjectId="
              + PROJECT_ID
              + ";OAuthType=3;"
              + "ProxyHost="
              + PROXY_HOST
              + ";ProxyPort="
              + PROXY_PORT
              + ";EnableHighThroughputAPI=1;"
              + "ProxyUid="
              + PROXY_UID
              + ";ProxyPwd="
              + PROXY_PWD
              + ";";

      Connection connection = DriverManager.getConnection(connection_uri);
      assertNotNull(connection);
      assertFalse(connection.isClosed());
      Statement statement = connection.createStatement();
      boolean result =
          statement.execute(
              "SELECT * FROM `bigquery-public-data.covid19_open_data_eu.covid19_open_data` LIMIT 200000");
      assertTrue(result);
      connection.close();
    }
  }

  @RunWith(Parameterized.class)
  public static class ParametrizedMissingPropertiesTest {
    private final String ProxyHost;
    private final String ProxyPort;
    private final String ProxyUid;
    private final String ProxyPwd;

    public ParametrizedMissingPropertiesTest(
        String ProxyHost, String ProxyPort, String ProxyUid, String ProxyPwd) {
      this.ProxyHost = ProxyHost;
      this.ProxyPort = ProxyPort;
      this.ProxyUid = ProxyUid;
      this.ProxyPwd = ProxyPwd;
    }

    @Parameterized.Parameters
    public static List<String[]> ProxyParameters() {
      String proxyHost = "ProxyHost=" + PROXY_HOST + ";";
      String proxyPort = "ProxyPort=" + PROXY_PORT + ";";
      String proxyUid = "ProxyUid=" + PROXY_UID + ";";
      String proxyPwd = "ProxyPwd=" + PROXY_PWD + ";";
      return Arrays.asList(
          new String[][] {
            {"", proxyPort, proxyUid, proxyPwd},
            {proxyHost, "", proxyUid, proxyPwd},
            {proxyHost, proxyPort, "", proxyPwd},
            {proxyHost, proxyPort, proxyUid, ""},
            {"", "", proxyUid, proxyPwd}
          });
    }

    @Test
    public void testMissingProxyParameterThrowsIllegalArgument() {
      String connection_uri =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "ProjectId="
              + PROJECT_ID
              + ";OAuthType=3;"
              + ProxyHost
              + ProxyPort
              + ProxyUid
              + ProxyPwd;
      assertThrows(
          IllegalArgumentException.class, () -> DriverManager.getConnection(connection_uri));
    }
  }
}
