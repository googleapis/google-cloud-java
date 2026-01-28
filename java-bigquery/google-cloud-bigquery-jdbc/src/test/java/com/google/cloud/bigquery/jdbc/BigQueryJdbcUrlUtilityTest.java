/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.Test;

public class BigQueryJdbcUrlUtilityTest {

  @Test
  public void testParsePropertyWithNoDefault() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "OAuthType");
    assertThat(result).isNull();
  }

  @Test
  public void testParsePropertyWithDefault() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "OAuthType");
    assertThat(result).isEqualTo(null);
  }

  @Test
  public void testParsePropertyWithValue() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "ProjectId");
    assertThat(result).isEqualTo("MyBigQueryProject");
  }

  @Test
  public void testParsePropertyWithValueCaseInsensitive() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "PROJECTID=MyBigQueryProject;"
            + "OAuthAccessToken=RedactedToken";

    String result = BigQueryJdbcUrlUtility.parseUriProperty(url, "ProjectId");
    assertThat(result).isEqualTo("MyBigQueryProject");
  }

  @Test
  public void testAppendPropertiesToURL() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;"
            + "OAuthAccessToken=RedactedToken";
    Properties properties = new Properties();
    properties.setProperty("OAuthType", "3");

    String updatedUrl = BigQueryJdbcUrlUtility.appendPropertiesToURL(url, null, properties);
    assertThat(updatedUrl.contains("OAuthType=3"));
  }

  @Test
  public void testConnectionPropertiesFromURI() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID=testProject;OAUTHTYPE=3;DEFAULTDATASET=testDataset;LOCATION=us-central1";

    assertThat(BigQueryJdbcUrlUtility.parseUriProperty(connection_uri, "OAUTHTYPE")).isEqualTo("3");
    assertThat(BigQueryJdbcUrlUtility.parseUriProperty(connection_uri, "LOCATION"))
        .isEqualTo("us-central1");
  }

  @Test
  public void testConnectionPropertiesFromURIMultiline() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;Multiline=value1\nvalue2\n;";

    assertThat(BigQueryJdbcUrlUtility.parseUriProperty(connection_uri, "Multiline"))
        .isEqualTo("value1\nvalue2\n");
  }

  @Test
  public void testConnectionPropertiesFromURIMultilineNoSemicolon() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;Multiline=value1\nvalue2";

    assertThat(BigQueryJdbcUrlUtility.parseUriProperty(connection_uri, "Multiline"))
        .isEqualTo("value1\nvalue2");
  }

  @Test
  public void testOverridePropertiesFromURICompatibility() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID=testProject;PrivateServiceConnectUris="
            + "BIGQUERY=https://bigquery-myprivateserver.p.googleapis.com,"
            + "READ_API=https://bigquerystorage-myprivateserver.p.googleapis.com:443;";

    Map<String, String> parsedPSCProperties =
        BigQueryJdbcUrlUtility.parseOverrideProperties(connection_uri, null);

    assertThat(parsedPSCProperties.get("BIGQUERY"))
        .isEqualTo("https://bigquery-myprivateserver.p.googleapis.com");
    assertThat(parsedPSCProperties.get("READ_API"))
        .isEqualTo("https://bigquerystorage-myprivateserver.p.googleapis.com:443");
  }

  @Test
  public void testOverridePropertiesDoesNotAffectOriginalParsersAtEnd() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;PrivateServiceConnectUris="
            + "BIGQUERY=https://bigquery-myprivateserver.p.googleapis.com,"
            + "READ_API=https://bigquerystorage-myprivateserver.p.googleapis.com:443,"
            + "OAUTH2=https://oauth2-myprivateserver.p.googleapis.com;PROJECTID=testProject;";

    Map<String, String> parsedPSCProperties =
        BigQueryJdbcUrlUtility.parseOverrideProperties(connection_uri, null);

    assertThat(parsedPSCProperties.get("BIGQUERY"))
        .isEqualTo("https://bigquery-myprivateserver.p.googleapis.com");
    assertThat(parsedPSCProperties.get("READ_API"))
        .isEqualTo("https://bigquerystorage-myprivateserver.p.googleapis.com:443");
    assertThat(parsedPSCProperties.get("OAUTH2"))
        .isEqualTo("https://oauth2-myprivateserver.p.googleapis.com");
  }

  @Test
  public void testOverridePropertiesDoesNotParseOutsideOfPrivateServiceConnectUris() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;PrivateServiceConnectUris="
            + "BIGQUERY=https://bigquery-myprivateserver.p.googleapis.com,"
            + "READ_API=https://bigquerystorage-myprivateserver.p.googleapis.com:443;"
            // Hard to see but semicolon ends it here.
            + "OAUTH2=https://oauth2-myprivateserver.p.googleapis.com;PROJECTID=testProject;";

    Map<String, String> parsedPSCProperties =
        BigQueryJdbcUrlUtility.parseOverrideProperties(connection_uri, null);

    assertThat(parsedPSCProperties.get("BIGQUERY"))
        .isEqualTo("https://bigquery-myprivateserver.p.googleapis.com");
    assertThat(parsedPSCProperties.get("READ_API"))
        .isEqualTo("https://bigquerystorage-myprivateserver.p.googleapis.com:443");
    assertThat(parsedPSCProperties.get("OAUTH2")).isNull();
  }

  @Test
  public void testOverridePropertiesDoesNotParserPropertiesInMiddle() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;PrivateServiceConnectUris="
            + "BIGQUERY=https://bigquery-myprivateserver.p.googleapis.com,OAUTHTYPE=2,"
            + "READ_API=https://bigquerystorage-myprivateserver.p.googleapis.com:443,"
            + "OAUTH2=https://oauth2-myprivateserver.p.googleapis.com;";

    Map<String, String> parsedPSCProperties =
        BigQueryJdbcUrlUtility.parseOverrideProperties(connection_uri, null);

    assertThat(parsedPSCProperties.get("BIGQUERY"))
        .isEqualTo("https://bigquery-myprivateserver.p.googleapis.com");
    assertThat(parsedPSCProperties.get("READ_API"))
        .isEqualTo("https://bigquerystorage-myprivateserver.p.googleapis.com:443");
    assertThat(parsedPSCProperties.get("OAUTH2"))
        .isEqualTo("https://oauth2-myprivateserver.p.googleapis.com");
  }

  @Test
  public void testOverridePropertyBeforeProceedingOverrideParameterDoesNotParse() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;BIGQUERY=https://bigquery-myprivateserver.p.googleapis.com;"
            + "PrivateServiceConnectUris="
            + "READ_API=https://bigquerystorage-myprivateserver.p.googleapis.com:443,"
            + "OAUTH2=https://oauth2-myprivateserver.p.googleapis.com;";

    Map<String, String> parsedPSCProperties =
        BigQueryJdbcUrlUtility.parseOverrideProperties(connection_uri, null);

    assertNull(parsedPSCProperties.get("BIGQUERY"));
    assertThat(parsedPSCProperties.get("READ_API"))
        .isEqualTo("https://bigquerystorage-myprivateserver.p.googleapis.com:443");
    assertThat(parsedPSCProperties.get("OAUTH2"))
        .isEqualTo("https://oauth2-myprivateserver.p.googleapis.com");
  }

  @Test
  public void testOverridePropertiesFromURIGoogleExperience() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID=testProject;EndpointOverrides="
            + "BIGQUERY=https://bigquery-myprivateserver.p.googleapis.com,"
            + "READ_API=https://bigquerystorage-myprivateserver.p.googleapis.com:443;";

    Map<String, String> parsedPSCProperties =
        BigQueryJdbcUrlUtility.parseOverrideProperties(connection_uri, null);

    assertThat(parsedPSCProperties.get("BIGQUERY"))
        .isEqualTo("https://bigquery-myprivateserver.p.googleapis.com");
    assertThat(parsedPSCProperties.get("READ_API"))
        .isEqualTo("https://bigquerystorage-myprivateserver.p.googleapis.com:443");
  }

  @Test
  public void testAllOverridePropertiesFromURIGoogleExperience() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID=testProject;EndpointOverrides="
            + "BIGQUERY=https://bigquery-myprivateserver.p.googleapis.com,"
            + "READ_API=https://bigquerystorage-myprivateserver.p.googleapis.com:443,"
            + "OAUTH2=https://oauth2-myprivateserver.p.googleapis.com,"
            + "STS=https://sts-myprivateserver.p.googleapis.com;";

    Map<String, String> parsedPSCProperties =
        BigQueryJdbcUrlUtility.parseOverrideProperties(connection_uri, null);

    assertThat(parsedPSCProperties.get("BIGQUERY"))
        .isEqualTo("https://bigquery-myprivateserver.p.googleapis.com");
    assertThat(parsedPSCProperties.get("READ_API"))
        .isEqualTo("https://bigquerystorage-myprivateserver.p.googleapis.com:443");
    assertThat(parsedPSCProperties.get("OAUTH2"))
        .isEqualTo("https://oauth2-myprivateserver.p.googleapis.com");
    assertThat(parsedPSCProperties.get("STS"))
        .isEqualTo("https://sts-myprivateserver.p.googleapis.com");
  }

  @Test
  public void testCaseSensitivityOverridePropertiesFromURI() {
    String connection_uri =
        "bigquery://https://www.googleapis.com/bigquery/v2:443;PROJECTID=testProject;endpointOverrides="
            + "bigQuery=https://bigquery-myprivateserver.p.googleapis.com,"
            + "READ_API=https://bigquerystorage-myprivateserver.p.googleapis.com:443;";

    Map<String, String> parsedPSCProperties =
        BigQueryJdbcUrlUtility.parseOverrideProperties(connection_uri, null);

    assertThat(parsedPSCProperties.get("BIGQUERY"))
        .isEqualTo("https://bigquery-myprivateserver.p.googleapis.com");
    assertThat(parsedPSCProperties.get("READ_API"))
        .isEqualTo("https://bigquerystorage-myprivateserver.p.googleapis.com:443");
  }

  @Test
  public void testParseJobCreationModeDefault() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;";

    boolean jobCreationMode = BigQueryJdbcUrlUtility.parseJobCreationMode(connection_uri, null);
    assertTrue(jobCreationMode);
  }

  @Test
  public void testParseJobCreationMode() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "JobCreationMode=1";

    boolean jobCreationMode = BigQueryJdbcUrlUtility.parseJobCreationMode(connection_uri, null);
    assertFalse(jobCreationMode);

    connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "JobCreationMode=2";

    jobCreationMode = BigQueryJdbcUrlUtility.parseJobCreationMode(connection_uri, null);
    assertTrue(jobCreationMode);
  }

  @Test
  public void testParseJobCreationModeInvalidInteger() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "JobCreationMode=25";

    assertThrows(
        NumberFormatException.class,
        () -> BigQueryJdbcUrlUtility.parseJobCreationMode(connection_uri, null));
  }

  @Test
  public void testParseJobCreationModeInvalidString() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "JobCreationMode=JOB_CREATION_OPTIONAL";

    assertThrows(
        NumberFormatException.class,
        () -> BigQueryJdbcUrlUtility.parseJobCreationMode(connection_uri, null));
  }

  @Test
  public void testGetConnectionPropertyDefaultValue() {
    assertEquals(
        BigQueryJdbcUrlUtility.getConnectionPropertyDefaultValue("BYOID_TokenUri"),
        "https://sts.googleapis.com/v1/token");
  }

  @Test
  public void testParseRetryTimeoutInSecs() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "Timeout=10";

    long retryTimeoutInSeconds =
        BigQueryJdbcUrlUtility.parseRetryTimeoutInSecs(connection_uri, null);
    assertEquals(10, retryTimeoutInSeconds);

    connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "Timeout=20";

    retryTimeoutInSeconds = BigQueryJdbcUrlUtility.parseRetryTimeoutInSecs(connection_uri, null);
    assertEquals(20, retryTimeoutInSeconds);
  }

  @Test
  public void testParseRetryTimeoutInSecsDefault() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject";

    long retryTimeoutInSeconds =
        BigQueryJdbcUrlUtility.parseRetryTimeoutInSecs(connection_uri, null);
    assertEquals(0, retryTimeoutInSeconds);
  }

  @Test
  public void testParseRetryTimeoutSecondsInvalidLong() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "Timeout=invalid";

    assertThrows(
        NumberFormatException.class,
        () -> BigQueryJdbcUrlUtility.parseRetryTimeoutInSecs(connection_uri, null));
  }

  public void testParseJobTimeout() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "JobTimeout=10";

    long jobTimeout = BigQueryJdbcUrlUtility.parseJobTimeout(connection_uri, null);
    assertEquals(10, jobTimeout);

    connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "JobTimeout=20";

    jobTimeout = BigQueryJdbcUrlUtility.parseJobTimeout(connection_uri, null);
    assertEquals(20, jobTimeout);
  }

  @Test
  public void testParseJobTimeoutDefault() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject";

    long jobTimeout = BigQueryJdbcUrlUtility.parseJobTimeout(connection_uri, null);
    assertEquals(0L, jobTimeout);
  }

  @Test
  public void testParseJobTimeoutInvalid() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "JobTimeout=invalid";

    assertThrows(
        NumberFormatException.class,
        () -> BigQueryJdbcUrlUtility.parseJobTimeout(connection_uri, null));
  }

  @Test
  public void testParsePartnerTokenProperty() {
    // Case with partner name and environment
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "PartnerToken=(GPN:partner_company; dev);ProjectId=MyBigQueryProject;";
    String expected = " (GPN:partner_company; dev)";
    String result =
        BigQueryJdbcUrlUtility.parsePartnerTokenProperty(url, "testParsePartnerTokenProperty");
    assertThat(result).isEqualTo(expected);

    // Case with only partner name
    url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "PartnerToken=(GPN:another_partner);ProjectId=MyBigQueryProject;";
    expected = " (GPN:another_partner)";
    result = BigQueryJdbcUrlUtility.parsePartnerTokenProperty(url, "testParsePartnerTokenProperty");
    assertThat(result).isEqualTo(expected);

    // Case when PartnerToken property is not present
    url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;";
    result = BigQueryJdbcUrlUtility.parsePartnerTokenProperty(url, "testParsePartnerTokenProperty");
    assertNull(result);

    // Case when PartnerToken property is present but empty
    url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PartnerToken=();";
    result = BigQueryJdbcUrlUtility.parsePartnerTokenProperty(url, "testParsePartnerTokenProperty");
    assertNull(result);

    // Case when PartnerToken property is present but without partner name
    url = "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;PartnerToken=(env);";
    result = BigQueryJdbcUrlUtility.parsePartnerTokenProperty(url, "testParsePartnerTokenProperty");
    assertNull(result);

    // Case with extra spaces around the values
    url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "PartnerToken= ( GPN: partner_name ; test_env ) ;";
    expected = " (GPN: partner_name; test_env)";
    result = BigQueryJdbcUrlUtility.parsePartnerTokenProperty(url, "testParsePartnerTokenProperty");
    assertThat(result).isEqualTo(expected);
  }

  public void testParseRetryInitialDelayInSecs() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "RetryInitialDelay=10";

    long retryInitialDelaySeconds =
        BigQueryJdbcUrlUtility.parseRetryInitialDelayInSecs(connection_uri, null);
    assertEquals(10, retryInitialDelaySeconds);

    connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "RetryInitialDelay=20";

    retryInitialDelaySeconds =
        BigQueryJdbcUrlUtility.parseRetryInitialDelayInSecs(connection_uri, null);
    assertEquals(20, retryInitialDelaySeconds);
  }

  @Test
  public void testParseRetryInitialDelayInSecsDefault() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject";

    long retryInitialDelaySeconds =
        BigQueryJdbcUrlUtility.parseRetryInitialDelayInSecs(connection_uri, null);
    assertEquals(0, retryInitialDelaySeconds);
  }

  @Test
  public void testParseRetryInitialDelaySecondsInvalidLong() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "RetryInitialDelay=invalid";

    assertThrows(
        NumberFormatException.class,
        () -> BigQueryJdbcUrlUtility.parseRetryInitialDelayInSecs(connection_uri, null));
  }

  @Test
  public void testParseRetryMaxDelayInSecs() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "RetryMaxDelay=10";

    long retryMaxDelaySeconds =
        BigQueryJdbcUrlUtility.parseRetryMaxDelayInSecs(connection_uri, null);
    assertEquals(10, retryMaxDelaySeconds);

    connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "RetryMaxDelay=20";

    retryMaxDelaySeconds = BigQueryJdbcUrlUtility.parseRetryMaxDelayInSecs(connection_uri, null);
    assertEquals(20, retryMaxDelaySeconds);
  }

  @Test
  public void testParseRetryMaxDelayInSecsDefault() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject";

    long retryMaxDelaySeconds =
        BigQueryJdbcUrlUtility.parseRetryMaxDelayInSecs(connection_uri, null);
    assertEquals(0, retryMaxDelaySeconds);
  }

  @Test
  public void testParseRetryMaxDelaySecondsInvalidLong() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "RetryMaxDelay=invalid";

    assertThrows(
        NumberFormatException.class,
        () -> BigQueryJdbcUrlUtility.parseRetryMaxDelayInSecs(connection_uri, null));
  }

  @Test
  public void testParseRequestGoogleDriveScope_Default() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;";
    Integer value =
        BigQueryJdbcUrlUtility.parseIntProperty(
            url,
            BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME,
            BigQueryJdbcUrlUtility.DEFAULT_REQUEST_GOOGLE_DRIVE_SCOPE_VALUE,
            this.getClass().getName());
    assertEquals(
        Integer.valueOf(BigQueryJdbcUrlUtility.DEFAULT_REQUEST_GOOGLE_DRIVE_SCOPE_VALUE), value);
  }

  // Connection Pool Size

  @Test
  public void testParseConnectionPoolSize() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "ConnectionPoolSize=10";
    long connectionPoolSize = BigQueryJdbcUrlUtility.parseConnectionPoolSize(connection_uri, null);
    assertEquals(10, connectionPoolSize);

    connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "ConnectionPoolSize=20";

    connectionPoolSize = BigQueryJdbcUrlUtility.parseConnectionPoolSize(connection_uri, null);
    assertEquals(20, connectionPoolSize);
  }

  @Test
  public void testParseConnectionPoolSizeDefault() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject";

    long connectionPoolSize = BigQueryJdbcUrlUtility.parseConnectionPoolSize(connection_uri, null);
    assertEquals(10, connectionPoolSize);
  }

  @Test
  public void testParseConnectionPoolSizeDefaultNullConnectionUrl() {
    assertThrows(
        BigQueryJdbcRuntimeException.class,
        () -> BigQueryJdbcUrlUtility.parseConnectionPoolSize(null, null));
  }

  @Test
  public void testParseConnectionPoolSizeDefaultEmptyConnectionUrl() {
    assertThrows(
        BigQueryJdbcRuntimeException.class,
        () -> BigQueryJdbcUrlUtility.parseConnectionPoolSize("", null));
  }

  @Test
  public void testParseConnectionPoolSizeInvalidLong() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "ConnectionPoolSize=invalid";

    assertThrows(
        NumberFormatException.class,
        () -> BigQueryJdbcUrlUtility.parseConnectionPoolSize(connection_uri, null));
  }

  // Listener Pool Size

  @Test
  public void testParseListenerPoolSize() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "ListenerPoolSize=10";
    long listenerPoolSize = BigQueryJdbcUrlUtility.parseListenerPoolSize(connection_uri, null);
    assertEquals(10, listenerPoolSize);

    connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "ListenerPoolSize=20";

    listenerPoolSize = BigQueryJdbcUrlUtility.parseListenerPoolSize(connection_uri, null);
    assertEquals(20, listenerPoolSize);
  }

  @Test
  public void testParseListenerPoolSizeDefault() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject";

    long listenerPoolSize = BigQueryJdbcUrlUtility.parseListenerPoolSize(connection_uri, null);
    assertEquals(10, listenerPoolSize);
  }

  @Test
  public void testParseListenerPoolSizeDefaultNullConnectionUrl() {
    assertThrows(
        BigQueryJdbcRuntimeException.class,
        () -> BigQueryJdbcUrlUtility.parseListenerPoolSize(null, null));
  }

  @Test
  public void testParseListenerPoolSizeDefaultEmptyConnectionUrl() {
    assertThrows(
        BigQueryJdbcRuntimeException.class,
        () -> BigQueryJdbcUrlUtility.parseListenerPoolSize("", null));
  }

  @Test
  public void testParseListenerPoolSizeInvalidLong() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "ListenerPoolSize=invalid";

    assertThrows(
        NumberFormatException.class,
        () -> BigQueryJdbcUrlUtility.parseListenerPoolSize(connection_uri, null));
  }

  @Test
  public void testParseStringListProperty_NullOrEmpty() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;SomeProp=";
    List<String> result =
        BigQueryJdbcUrlUtility.parseStringListProperty(url, "NonExistentProp", "TestClass");
    assertEquals(Collections.emptyList(), result);

    result = BigQueryJdbcUrlUtility.parseStringListProperty(url, "SomeProp", "TestClass");
    assertEquals(Collections.emptyList(), result);

    String urlWithEmptyList =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;ListProp=,,";
    result =
        BigQueryJdbcUrlUtility.parseStringListProperty(urlWithEmptyList, "ListProp", "TestClass");
    assertEquals(Collections.emptyList(), result);
  }

  @Test
  public void testParseStringListProperty_SingleValue() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;ListProp=project1";
    List<String> result =
        BigQueryJdbcUrlUtility.parseStringListProperty(url, "ListProp", "TestClass");
    assertEquals(Collections.singletonList("project1"), result);
  }

  @Test
  public void testParseStringListProperty_MultipleValues() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;ListProp=project1,project2,project3";
    List<String> result =
        BigQueryJdbcUrlUtility.parseStringListProperty(url, "ListProp", "TestClass");
    assertEquals(Arrays.asList("project1", "project2", "project3"), result);
  }

  @Test
  public void testParseIntProperty_ValidInteger() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;SomeIntProp=123";
    Integer defaultValue = 0;
    Integer result =
        BigQueryJdbcUrlUtility.parseIntProperty(url, "SomeIntProp", defaultValue, "TestClass");
    assertEquals(Integer.valueOf(123), result);
  }

  @Test
  public void testParseIntProperty_PropertyNotPresent() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;SomeIntProp=123";
    Integer defaultValue = 42;
    Integer result =
        BigQueryJdbcUrlUtility.parseIntProperty(url, "MissingIntProp", defaultValue, "TestClass");
    assertEquals(defaultValue, result);
  }

  @Test
  public void testParseIntProperty_InvalidIntegerValue() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;InvalidIntProp=abc";
    Integer defaultValue = 77;
    assertThrows(
        IllegalArgumentException.class,
        () ->
            BigQueryJdbcUrlUtility.parseIntProperty(
                url, "InvalidIntProp", defaultValue, "TestClass"));
  }

  @Test
  public void testParseIntProperty_EmptyStringValue() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=2;ProjectId=MyBigQueryProject;EmptyIntProp=";
    Integer defaultValue = 88;
    assertThrows(
        IllegalArgumentException.class,
        () ->
            BigQueryJdbcUrlUtility.parseIntProperty(
                url, "EmptyIntProp", defaultValue, "TestClass"));
  }

  @Test
  public void testParseMaxBytesBilled() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "MaximumBytesBilled=10000";

    long maxBytesBilled = BigQueryJdbcUrlUtility.parseMaximumBytesBilled(connection_uri, null);
    assertEquals(10000, maxBytesBilled);
  }

  @Test
  public void testParseMaxBytesBilledDefault() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject";

    long maxBytesBilled = BigQueryJdbcUrlUtility.parseMaximumBytesBilled(connection_uri, null);
    assertEquals(0, maxBytesBilled);
  }

  @Test
  public void testParseMaxBytesBilledNullUrl() {
    assertThrows(
        BigQueryJdbcRuntimeException.class,
        () -> BigQueryJdbcUrlUtility.parseMaximumBytesBilled(null, null));
  }

  @Test
  public void testParseMaxBytesBilledEmptyUrl() {
    assertThrows(
        BigQueryJdbcRuntimeException.class,
        () -> BigQueryJdbcUrlUtility.parseMaximumBytesBilled("", null));
  }

  @Test
  public void testParseMaxBytesBilledInvalidLong() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "MaximumBytesBilled=invalid";

    assertThrows(
        NumberFormatException.class,
        () -> BigQueryJdbcUrlUtility.parseMaximumBytesBilled(connection_uri, null));
  }

  @Test
  public void testParseLabels() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;"
            + "Labels=k1=v1,k2=v2,k3=v3;";

    Map<String, String> labels = BigQueryJdbcUrlUtility.parseLabels(connection_uri, null);
    assertNotNull(labels);
    assertFalse(labels.isEmpty());
    assertEquals(3, labels.size());

    Map<String, String> expected =
        new HashMap<String, String>() {
          {
            put("k1", "v1");
            put("k2", "v2");
            put("k3", "v3");
          }
        };

    assertTrue(Maps.difference(expected, labels).areEqual());
  }

  @Test
  public void testParseLabelsEmpty() {
    String connection_uri =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=3;ProjectId=testProject;";

    Map<String, String> labels = BigQueryJdbcUrlUtility.parseLabels(connection_uri, null);
    assertNull(labels);
  }
}
