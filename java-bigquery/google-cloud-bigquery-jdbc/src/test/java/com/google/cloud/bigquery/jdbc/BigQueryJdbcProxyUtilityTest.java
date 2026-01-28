/*
 * Copyright 2024 Google LLC
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.cloud.http.HttpTransportOptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class BigQueryJdbcProxyUtilityTest {
  @Test
  public void testParsingAllProxyProperties() {
    Map<String, String> result =
        BigQueryJdbcProxyUtility.parseProxyProperties(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "ProjectId=MyBigQueryProject;OAuthType=3;"
                + "ProxyHost=34.94.167.18;"
                + "ProxyPort=3128;"
                + "ProxyUid=fahmz;"
                + "ProxyPwd=pass;",
            null);

    assertThat(result.get("ProxyHost")).isEqualTo("34.94.167.18");
    assertThat(result.get("ProxyPort")).isEqualTo("3128");
    assertThat(result.get("ProxyUid")).isEqualTo("fahmz");
    assertThat(result.get("ProxyPwd")).isEqualTo("pass");
  }

  @Test
  public void testParsingInvalidPortThrowsIllegalArgument() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            BigQueryJdbcProxyUtility.parseProxyProperties(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyBigQueryProject;OAuthType=3;"
                    + "ProxyHost=34.94.167.18;"
                    + "ProxyPort=portnumber;"
                    + "ProxyUid=fahmz;"
                    + "ProxyPwd=pass;",
                null));
  }

  @Test
  public void testMissingHostThrowsIllegalArgument() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            BigQueryJdbcProxyUtility.parseProxyProperties(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyBigQueryProject;OAuthType=3;"
                    + "ProxyPort=3128;"
                    + "ProxyUid=fahmz;"
                    + "ProxyPwd=pass;",
                null));
  }

  @Test
  public void testMissingPortThrowsIllegalArgument() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            BigQueryJdbcProxyUtility.parseProxyProperties(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyBigQueryProject;OAuthType=3;"
                    + "ProxyHost=34.94.167.18;"
                    + "ProxyUid=fahmz;"
                    + "ProxyPwd=pass;",
                null));
  }

  @Test
  public void testMissingUidWithPwdThrowsIllegalArgument() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            BigQueryJdbcProxyUtility.parseProxyProperties(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyBigQueryProject;OAuthType=3;"
                    + "ProxyHost=34.94.167.18;"
                    + "ProxyPort=3128;"
                    + "ProxyPwd=pass;",
                null));
  }

  @Test
  public void testMissingPwdWithUidThrowsIllegalArgument() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            BigQueryJdbcProxyUtility.parseProxyProperties(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyBigQueryProject;OAuthType=3;"
                    + "ProxyHost=34.94.167.18;"
                    + "ProxyPort=3128;"
                    + "ProxyUid=fahmz;",
                null));
  }

  @Test
  public void testGetHttpTransportOptionsWithAuthenticatedProxy() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=TestProject"
            + ";OAuthType=3;"
            + "ProxyHost=34.94.167.18;"
            + "ProxyPort=3128;"
            + "ProxyUid=fahmz;"
            + "ProxyPwd=pass;";

    Map<String, String> proxyProperties =
        BigQueryJdbcProxyUtility.parseProxyProperties(connection_uri, null);
    HttpTransportOptions result =
        BigQueryJdbcProxyUtility.getHttpTransportOptions(proxyProperties, null, null, null);
    assertNotNull(result);
  }

  @Test
  public void testGetHttpTransportOptionsWithNonAuthenticatedProxy() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=TestProject"
            + ";OAuthType=3;"
            + "ProxyHost=34.94.167.18;"
            + "ProxyPort=3128;";

    Map<String, String> proxyProperties =
        BigQueryJdbcProxyUtility.parseProxyProperties(connection_uri, null);
    HttpTransportOptions result =
        BigQueryJdbcProxyUtility.getHttpTransportOptions(proxyProperties, null, null, null);
    assertNotNull(result);
  }

  @Test
  public void testGetHttpTransportOptionsWithNoProxySettingsReturnsNull() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=TestProject"
            + ";OAuthType=3;";

    Map<String, String> proxyProperties =
        BigQueryJdbcProxyUtility.parseProxyProperties(connection_uri, null);
    HttpTransportOptions result =
        BigQueryJdbcProxyUtility.getHttpTransportOptions(proxyProperties, null, null, null);
    assertNull(result);
  }

  private String getTestResourcePath(String resourceName) throws URISyntaxException {
    URL resourceUrl = getClass().getClassLoader().getResource(resourceName);
    if (resourceUrl == null) {
      throw new RuntimeException("Test resource not found: " + resourceName);
    }
    return new File(resourceUrl.toURI()).getAbsolutePath();
  }

  @Test
  public void testGetHttpTransportOptions_withSslTrustStore_noPassword() throws Exception {
    String trustStorePath = getTestResourcePath("test_truststore_nopass.jks");
    HttpTransportOptions options =
        BigQueryJdbcProxyUtility.getHttpTransportOptions(
            Collections.<String, String>emptyMap(), trustStorePath, null, "TestClass");
    assertNotNull(options);
    assertNotNull(options.getHttpTransportFactory());
  }

  @Test
  public void testGetHttpTransportOptions_withSslTrustStore_withCorrectPassword() throws Exception {
    String trustStorePath = getTestResourcePath("test_truststore_withpass.jks");
    HttpTransportOptions options =
        BigQueryJdbcProxyUtility.getHttpTransportOptions(
            Collections.<String, String>emptyMap(), trustStorePath, "testpassword", "TestClass");
    assertNotNull(options);
    assertNotNull(options.getHttpTransportFactory());
  }

  @Test
  public void testGetHttpTransportOptions_withSslTrustStore_withIncorrectPassword()
      throws Exception {
    String trustStorePath = getTestResourcePath("test_truststore_withpass.jks");
    BigQueryJdbcRuntimeException exception =
        assertThrows(
            BigQueryJdbcRuntimeException.class,
            () ->
                BigQueryJdbcProxyUtility.getHttpTransportOptions(
                    Collections.<String, String>emptyMap(),
                    trustStorePath,
                    "wrongpassword",
                    "TestClass"));
    assertThat(exception.getCause()).isInstanceOf(IOException.class);
  }

  @Test
  public void testGetHttpTransportOptions_withInvalidSslTrustStorePath() {
    String invalidPath = "/path/to/nonexistent/truststore.jks";
    BigQueryJdbcRuntimeException exception =
        assertThrows(
            BigQueryJdbcRuntimeException.class,
            () ->
                BigQueryJdbcProxyUtility.getHttpTransportOptions(
                    Collections.<String, String>emptyMap(), invalidPath, null, "TestClass"));

    assertThat(exception.getCause()).isInstanceOf(FileNotFoundException.class);
  }

  @Test
  public void testGetHttpTransportOptions_withSslAndProxy() throws Exception {
    String trustStorePath = getTestResourcePath("test_truststore_nopass.jks");
    Map<String, String> proxyProperties = new HashMap<>();
    proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME, "proxy.example.com");
    proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_PORT_PROPERTY_NAME, "8080");

    HttpTransportOptions options =
        BigQueryJdbcProxyUtility.getHttpTransportOptions(
            proxyProperties, trustStorePath, null, "TestClass");
    assertNotNull(options);
    assertNotNull(options.getHttpTransportFactory());
  }

  @Test
  public void testGetTransportChannelProvider_withSslTrustStore_noPassword() throws Exception {
    String trustStorePath = getTestResourcePath("test_truststore_nopass.jks");
    TransportChannelProvider provider =
        BigQueryJdbcProxyUtility.getTransportChannelProvider(
            Collections.<String, String>emptyMap(), trustStorePath, null, "TestClass");
    assertNotNull(provider);
  }

  @Test
  public void testGetTransportChannelProvider_withSslTrustStore_withCorrectPassword()
      throws Exception {
    String trustStorePath = getTestResourcePath("test_truststore_withpass.jks");
    TransportChannelProvider provider =
        BigQueryJdbcProxyUtility.getTransportChannelProvider(
            Collections.<String, String>emptyMap(), trustStorePath, "testpassword", "TestClass");
    assertNotNull(provider);
  }

  @Test
  public void testGetTransportChannelProvider_withSslAndProxy() throws Exception {
    String trustStorePath = getTestResourcePath("test_truststore_nopass.jks");
    Map<String, String> proxyProperties = new HashMap<>();
    proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME, "proxy.example.com");
    proxyProperties.put(BigQueryJdbcUrlUtility.PROXY_PORT_PROPERTY_NAME, "8080");

    TransportChannelProvider provider =
        BigQueryJdbcProxyUtility.getTransportChannelProvider(
            proxyProperties, trustStorePath, null, "TestClass");
    assertNotNull(provider);
  }

  @Test
  public void testGetTransportChannelProvider_noProxyNoSsl_returnsNull() {
    TransportChannelProvider provider =
        BigQueryJdbcProxyUtility.getTransportChannelProvider(
            Collections.<String, String>emptyMap(), null, null, "TestClass");
    assertNull(provider);
  }

  @Test
  public void testGetHttpTransportOptions_noProxyNoSsl_returnsNull() {
    HttpTransportOptions options =
        BigQueryJdbcProxyUtility.getHttpTransportOptions(
            Collections.<String, String>emptyMap(), null, null, "TestClass");
    assertNull(options);
  }
}
